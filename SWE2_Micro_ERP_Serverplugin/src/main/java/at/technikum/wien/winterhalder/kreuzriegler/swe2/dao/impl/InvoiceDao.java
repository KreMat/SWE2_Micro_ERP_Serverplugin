/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.impl;

import static at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.AbstractEntity.ID;
import static at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.Invoice.COMMENT;
import static at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.Invoice.CREATIONDATE;
import static at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.Invoice.DUEDATE;
import static at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.Invoice.FK_CONTACT_ID;
import static at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.Invoice.INFORMATION;
import static at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.Invoice.NR;
import static at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.Invoice.TABLE;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.IInvoiceDao;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.Invoice;

/**
 * @author Matthias
 * 
 */
public class InvoiceDao extends AbstractDao implements IInvoiceDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.IInvoiceDao#create
	 * (at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.Invoice)
	 */
	@Override
	public void create(Invoice i) {
		if (i.getId() != 0) {
			throw new IllegalArgumentException(
					"Entity already persisted!!! InvoiceId: " + i.getId());
		}

		Connection con = getConnection();
		try {
			PreparedStatement stmt = con.prepareStatement("INSERT INTO "
					+ TABLE + " (" + NR + ", " + CREATIONDATE + ", " + DUEDATE
					+ ", " + COMMENT + ", " + INFORMATION + ", "
					+ FK_CONTACT_ID + ") VALUES (?, ?, ?, ?, ?, ?);",
					Statement.RETURN_GENERATED_KEYS);
			executeStatement(stmt, i);
			stmt.close();
		} catch (SQLException e) {
			throw new IllegalStateException(e);
		} finally {
			closeConnection();
		}
	}

	private void executeStatement(PreparedStatement stmt, Invoice i)
			throws SQLException {
		stmt.setString(1, i.getNr());
		stmt.setLong(2, i.getCreationdate());
		stmt.setLong(3, i.getDuedate());
		stmt.setString(4, i.getComment());
		stmt.setString(5, i.getInformation());
		stmt.setLong(6, i.getContactId());
		stmt.executeUpdate();

		ResultSet rs = stmt.getGeneratedKeys();
		if (rs.next()) {
			int newId = rs.getInt(1);
			i.setId(newId);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.IInvoiceDao#update
	 * (at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.Invoice)
	 */
	@Override
	public void update(Invoice i) {
		if (i.getId() == 0) {
			throw new IllegalArgumentException("Entity not persisted!!!");
		}

		Connection con = getConnection();
		try {
			PreparedStatement stmt = con.prepareStatement("UPDATE "
					+ Invoice.TABLE + " SET " + NR + " = ?, " + CREATIONDATE
					+ " = ?, " + DUEDATE + " = ?, " + COMMENT + " = ?, "
					+ INFORMATION + " = ?, " + FK_CONTACT_ID + " = ? WHERE "
					+ ID + " = " + i.getId() + ";",
					Statement.RETURN_GENERATED_KEYS);
			executeStatement(stmt, i);
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
	 * at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.IInvoiceDao#read
	 * (long)
	 */
	@Override
	public Invoice read(long id) {
		Connection con = getConnection();
		try {
			PreparedStatement stmt = con.prepareStatement("SELECT " + ID + ", "
					+ NR + "," + CREATIONDATE + "," + DUEDATE + "," + COMMENT
					+ "," + INFORMATION + "," + FK_CONTACT_ID + " FROM "
					+ TABLE + " WHERE " + ID + " = ?;");

			stmt.setLong(1, id);

			ResultSet rs = stmt.executeQuery();

			Invoice i = null;
			if (rs.next()) {
				i = mapInvoice(rs);
			}
			stmt.close();
			return i;
		} catch (SQLException e) {
			throw new IllegalStateException(e);
		} finally {
			closeConnection();
		}
	}

	private Invoice mapInvoice(ResultSet rs) throws SQLException {
		Invoice i = new Invoice();
		i.setId(rs.getLong(ID));
		i.setNr(rs.getString(NR));
		i.setCreationdate(rs.getLong(CREATIONDATE));
		i.setDuedate(rs.getLong(DUEDATE));
		i.setComment(rs.getString(COMMENT));
		i.setInformation(rs.getString(INFORMATION));
		i.setContactId(rs.getLong(FK_CONTACT_ID));
		return i;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.IInvoiceDao#delete
	 * (long)
	 */
	@Override
	public void delete(long id) {
		delete(TABLE, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.IInvoiceDao#
	 * loadAllInvoices()
	 */
	@Override
	public List<Invoice> loadInvoicesByContactId(long contactId) {
		Connection con = getConnection();
		try {
			PreparedStatement stmt = con.prepareStatement("SELECT " + ID + ", "
					+ NR + "," + CREATIONDATE + "," + DUEDATE + "," + COMMENT
					+ "," + INFORMATION + "," + FK_CONTACT_ID + " FROM "
					+ TABLE + " WHERE " + FK_CONTACT_ID + " = ?;");

			stmt.setLong(1, contactId);

			ResultSet rs = stmt.executeQuery();

			List<Invoice> result = new ArrayList<Invoice>();
			while (rs.next()) {
				result.add(mapInvoice(rs));
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
