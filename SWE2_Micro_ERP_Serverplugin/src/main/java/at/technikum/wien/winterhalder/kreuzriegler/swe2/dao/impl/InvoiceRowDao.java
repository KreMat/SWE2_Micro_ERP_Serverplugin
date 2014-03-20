/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.impl;

import static at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.AbstractEntity.ID;
import static at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.InvoiceRow.AMOUNT;
import static at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.InvoiceRow.FK_INVOICE_ID;
import static at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.InvoiceRow.NAME;
import static at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.InvoiceRow.PRICE;
import static at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.InvoiceRow.TABLE;
import static at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.InvoiceRow.UST;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.IInvoiceRowDao;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.InvoiceRow;

/**
 * @author Matthias
 * 
 */
public class InvoiceRowDao extends AbstractDao implements IInvoiceRowDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.IInvoiceRowDao#create
	 * (at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.InvoiceRow)
	 */
	@Override
	public void create(InvoiceRow r) {
		if (r.getId() != 0) {
			throw new IllegalArgumentException(
					"Entity already persisted!!! InvoiceRowId: " + r.getId());
		}

		Connection con = getConnection();
		try {
			PreparedStatement stmt = con.prepareStatement("INSERT INTO "
					+ TABLE + " (" + AMOUNT + ", " + NAME + ", " + PRICE + ", "
					+ UST + ", " + FK_INVOICE_ID + ") VALUES (?, ?, ?, ?, ?);",
					Statement.RETURN_GENERATED_KEYS);
			executeStatement(stmt, r);
			stmt.close();
		} catch (SQLException e) {
			throw new IllegalStateException(e);
		} finally {
			closeConnection();
		}

	}

	private void executeStatement(PreparedStatement stmt, InvoiceRow r)
			throws SQLException {
		stmt.setDouble(1, r.getAmount());
		stmt.setString(2, r.getName());
		stmt.setDouble(3, r.getPrice());
		stmt.setDouble(4, r.getUst());
		stmt.setLong(5, r.getInvoiceId());
		stmt.executeUpdate();

		ResultSet rs = stmt.getGeneratedKeys();
		if (rs.next()) {
			int newId = rs.getInt(1);
			r.setId(newId);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.IInvoiceRowDao#update
	 * (at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.InvoiceRow)
	 */
	@Override
	public void update(InvoiceRow r) {
		if (r.getId() == 0) {
			throw new IllegalArgumentException("Entity not persisted!!!");
		}

		Connection con = getConnection();
		try {
			PreparedStatement stmt = con.prepareStatement("UPDATE " + TABLE
					+ " SET " + AMOUNT + " = ?, " + NAME + " = ?, " + PRICE
					+ " = ?, " + UST + " = ?, " + FK_INVOICE_ID + " = ? WHERE "
					+ ID + " = " + r.getId() + ";",
					Statement.RETURN_GENERATED_KEYS);
			executeStatement(stmt, r);
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
	 * at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.IInvoiceRowDao#read
	 * (long)
	 */
	@Override
	public InvoiceRow read(long id) {
		Connection con = getConnection();
		try {
			PreparedStatement stmt = con.prepareStatement("SELECT " + ID + ", "
					+ NAME + "," + AMOUNT + "," + PRICE + "," + UST + ","
					+ FK_INVOICE_ID + " FROM " + TABLE + " WHERE " + ID
					+ " = ?;");

			stmt.setLong(1, id);

			ResultSet rs = stmt.executeQuery();

			InvoiceRow r = null;
			if (rs.next()) {
				r = mapInvoiceRow(rs);
			}
			stmt.close();
			return r;
		} catch (SQLException e) {
			throw new IllegalStateException(e);
		} finally {
			closeConnection();
		}
	}

	private InvoiceRow mapInvoiceRow(ResultSet rs) throws SQLException {
		InvoiceRow a = new InvoiceRow();
		a.setId(rs.getLong(ID));
		a.setName(rs.getString(NAME));
		a.setAmount(rs.getDouble(AMOUNT));
		a.setPrice(rs.getDouble(PRICE));
		a.setUst(rs.getDouble(UST));
		a.setInvoiceId(rs.getLong(FK_INVOICE_ID));
		return a;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.IInvoiceRowDao#delete
	 * (long)
	 */
	@Override
	public void delete(long id) {
		delete(TABLE, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.IInvoiceRowDao#
	 * loadRowsByInvoiceId(long)
	 */
	@Override
	public List<InvoiceRow> loadRowsByInvoiceId(long id) {
		Connection con = getConnection();
		try {
			PreparedStatement stmt = con.prepareStatement("SELECT " + ID + ", "
					+ NAME + "," + AMOUNT + "," + PRICE + "," + UST + ","
					+ FK_INVOICE_ID + " FROM " + TABLE + " WHERE "
					+ FK_INVOICE_ID + " = ?;");

			stmt.setLong(1, id);

			ResultSet rs = stmt.executeQuery();

			List<InvoiceRow> result = new ArrayList<InvoiceRow>();
			while (rs.next()) {
				result.add(mapInvoiceRow(rs));
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
