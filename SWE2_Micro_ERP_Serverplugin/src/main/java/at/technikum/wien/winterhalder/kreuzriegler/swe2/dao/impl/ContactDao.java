/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.impl;

import static at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.AbstractEntity.ID;
import static at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.Contact.BIRTHDAY;
import static at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.Contact.COMPANYNAME;
import static at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.Contact.FIRSTNAME;
import static at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.Contact.FK_CONTACT_ID;
import static at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.Contact.LASTNAME;
import static at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.Contact.SUFFIX;
import static at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.Contact.TABLE;
import static at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.Contact.TITLE;
import static at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.Contact.UID;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.IContactDao;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.Contact;

/**
 * @author Matthias
 * 
 */
public class ContactDao extends AbstractDao implements IContactDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.IContactDao#create
	 * (at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.Contact)
	 */
	@Override
	public void create(Contact c) {
		if (c.getId() != 0) {
			throw new IllegalArgumentException(
					"Entity already persisted!!! ContactId: " + c.getId());
		}

		Connection con = getConnection();
		try {
			PreparedStatement stmt = con.prepareStatement("INSERT INTO "
					+ TABLE + " (" + COMPANYNAME + ", " + UID + ", " + TITLE
					+ ", " + FIRSTNAME + ", " + LASTNAME + ", " + SUFFIX + ", "
					+ BIRTHDAY + ", " + FK_CONTACT_ID
					+ ") VALUES (?, ?, ?, ?, ?, ?, ?, ?);",
					Statement.RETURN_GENERATED_KEYS);
			executeStatement(stmt, c);
			stmt.close();
		} catch (SQLException e) {
			throw new IllegalStateException(e);
		} finally {
			closeConnection();
		}
	}

	private void executeStatement(PreparedStatement stmt, Contact c)
			throws SQLException {
		stmt.setString(1, c.getCompanyname());
		stmt.setString(2, c.getUid());
		stmt.setString(3, c.getTitle());
		stmt.setString(4, c.getFirstname());
		stmt.setString(5, c.getLastname());
		stmt.setString(6, c.getSuffix());
		stmt.setTimestamp(7, c.getBirthday());
		if (c.getCompanyId() != null) {
			stmt.setLong(8, c.getCompanyId());
		} else {
			stmt.setNull(8, Types.INTEGER);
		}
		stmt.executeUpdate();

		ResultSet rs = stmt.getGeneratedKeys();
		if (rs.next()) {
			int newId = rs.getInt(1);
			c.setId(newId);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.IContactDao#update
	 * (at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.Contact)
	 */
	@Override
	public void update(Contact c) {
		if (c.getId() == 0) {
			throw new IllegalArgumentException("Entity not persisted!!!");
		}

		Connection con = getConnection();
		try {
			PreparedStatement stmt = con.prepareStatement("UPDATE " + TABLE
					+ " SET " + COMPANYNAME + " = ?, " + UID + " = ?, " + TITLE
					+ " = ?, " + FIRSTNAME + " = ?, " + LASTNAME + " = ?, "
					+ SUFFIX + "= ?, " + BIRTHDAY + " = ?, " + FK_CONTACT_ID
					+ " = ? WHERE " + ID + " = " + c.getId() + ";",
					Statement.RETURN_GENERATED_KEYS);
			executeStatement(stmt, c);
			stmt.close();
		} catch (SQLException e) {
			throw new IllegalStateException(e);
		} finally {
			closeConnection();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.IContactDao#read
	 * (long)
	 */
	@Override
	public Contact read(long id) {
		Connection con = getConnection();
		try {
			PreparedStatement stmt = con.prepareStatement("SELECT " + ID + ", "
					+ COMPANYNAME + "," + UID + "," + TITLE + "," + FIRSTNAME
					+ "," + LASTNAME + "," + SUFFIX + "," + BIRTHDAY + ","
					+ FK_CONTACT_ID + " FROM " + TABLE + " WHERE " + ID
					+ " = ?;");

			stmt.setLong(1, id);

			ResultSet rs = stmt.executeQuery();

			Contact c = null;
			if (rs.next()) {
				c = mapContact(rs);
			}

			stmt.close();
			return c;
		} catch (SQLException e) {
			throw new IllegalStateException(e);
		} finally {
			closeConnection();
		}
	}

	private Contact mapContact(ResultSet rs) throws SQLException {
		Contact c = new Contact();
		c.setId(rs.getLong(ID));
		c.setCompanyname(rs.getString(COMPANYNAME));
		c.setUid(rs.getString(UID));
		c.setFirstname(rs.getString(FIRSTNAME));
		c.setLastname(rs.getString(LASTNAME));
		c.setTitle(rs.getString(TITLE));
		c.setSuffix(rs.getString(SUFFIX));
		c.setBirthday(rs.getTimestamp(BIRTHDAY));
		c.setCompanyId(rs.getLong(FK_CONTACT_ID));
		return c;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.IContactDao#delete
	 * (long)
	 */
	@Override
	public void delete(long id) {
		Connection con = getConnection();
		try {
			PreparedStatement stmt = con.prepareStatement("DELETE FROM "
					+ TABLE + " WHERE " + ID + " = ?;");

			stmt.setLong(1, id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new IllegalStateException(e);
		} finally {
			closeConnection();
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.IContactDao#
	 * loadAllContacts()
	 */
	@Override
	public List<Contact> loadAllContacts() {
		Connection con = getConnection();
		try {
			PreparedStatement stmt = con.prepareStatement("SELECT " + ID + ","
					+ COMPANYNAME + "," + UID + "," + TITLE + "," + FIRSTNAME
					+ "," + LASTNAME + "," + SUFFIX + "," + BIRTHDAY + ","
					+ FK_CONTACT_ID + " FROM " + TABLE + ";");

			ResultSet rs = stmt.executeQuery();

			List<Contact> result = new ArrayList<Contact>();
			while (rs.next()) {
				result.add(mapContact(rs));
			}

			stmt.close();
			return result;
		} catch (SQLException e) {
			throw new IllegalStateException(e);
		} finally {
			closeConnection();
		}
	}

}
