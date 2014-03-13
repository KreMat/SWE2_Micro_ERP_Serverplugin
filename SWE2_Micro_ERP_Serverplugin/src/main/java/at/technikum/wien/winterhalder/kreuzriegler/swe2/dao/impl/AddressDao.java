package at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.impl;

import static at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.AbstractEntity.ID;
import static at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.Address.CITY;
import static at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.Address.FK_CONTACT_ID;
import static at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.Address.STREET;
import static at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.Address.TABLE;
import static at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.Address.TYPE;
import static at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.Address.ZIP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.IAddressDao;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.Address;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.AddressType;

public class AddressDao extends AbstractDao implements IAddressDao {

	@Override
	public void create(Address a) {
		if (a.getId() != 0) {
			throw new IllegalArgumentException(
					"Entity already persisted!!! AddressId: " + a.getId());
		}

		Connection con = getConnection();
		try {
			PreparedStatement stmt = con.prepareStatement(
					"INSERT INTO " + TABLE + " (" + STREET + ", " + CITY + ", "
							+ ZIP + ", " + TYPE + ", " + FK_CONTACT_ID
							+ ") VALUES (?, ?, ?, ?, ?);",
					Statement.RETURN_GENERATED_KEYS);
			executeStatement(stmt, a);
			stmt.close();
		} catch (SQLException e) {
			throw new IllegalStateException(e);
		} finally {
			closeConnection();
		}

	}

	private void executeStatement(PreparedStatement stmt, Address a)
			throws SQLException {
		stmt.setString(1, a.getStreet());
		stmt.setString(2, a.getCity());
		stmt.setString(3, a.getZip());
		stmt.setString(4, a.getType().name());
		stmt.setLong(5, a.getContactId());
		stmt.executeUpdate();

		ResultSet rs = stmt.getGeneratedKeys();
		if (rs.next()) {
			int newId = rs.getInt(1);
			a.setId(newId);
		}
	}

	@Override
	public void update(Address a) {
		if (a.getId() == 0) {
			throw new IllegalArgumentException("Entity not persisted!!!");
		}

		Connection con = getConnection();
		try {
			PreparedStatement stmt = con.prepareStatement("UPDATE " + TABLE
					+ " SET " + STREET + " = ?, " + CITY + " = ?, " + ZIP
					+ " = ?, " + TYPE + " = ?, " + FK_CONTACT_ID
					+ " = ? WHERE " + ID + " = " + a.getId() + ";",
					Statement.RETURN_GENERATED_KEYS);
			executeStatement(stmt, a);
			stmt.close();
		} catch (SQLException e) {
			throw new IllegalStateException(e);
		} finally {
			closeConnection();
		}

	}

	@Override
	public Address read(long id) {
		Connection con = getConnection();
		try {
			PreparedStatement stmt = con.prepareStatement("SELECT " + ID + ", "
					+ STREET + "," + CITY + "," + ZIP + "," + TYPE + ","
					+ FK_CONTACT_ID + " FROM " + TABLE + " WHERE " + ID
					+ " = ?;");

			stmt.setLong(1, id);

			ResultSet rs = stmt.executeQuery();

			Address a = null;
			if (rs.next()) {
				a = mapAddress(rs);
			}

			stmt.close();
			return a;
		} catch (SQLException e) {
			throw new IllegalStateException(e);
		} finally {
			closeConnection();
		}
	}

	private Address mapAddress(ResultSet rs) throws SQLException {
		Address a = new Address();
		a.setId(rs.getLong(ID));
		a.setCity(rs.getString(CITY));
		a.setStreet(rs.getString(STREET));
		a.setZip(rs.getString(ZIP));
		a.setType(AddressType.valueOf(rs.getString(TYPE)));
		a.setContactId(rs.getLong(FK_CONTACT_ID));
		return a;
	}

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

	@Override
	public List<Address> loadAddressesByContactId(long contactId) {
		Connection con = getConnection();
		try {
			PreparedStatement stmt = con.prepareStatement("SELECT " + ID + ", "
					+ STREET + "," + CITY + "," + ZIP + "," + TYPE + ","
					+ FK_CONTACT_ID + " FROM " + TABLE + " WHERE "
					+ FK_CONTACT_ID + " = ?;");

			stmt.setLong(1, contactId);

			ResultSet rs = stmt.executeQuery();

			List<Address> result = new ArrayList<Address>();
			while (rs.next()) {
				result.add(mapAddress(rs));
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
