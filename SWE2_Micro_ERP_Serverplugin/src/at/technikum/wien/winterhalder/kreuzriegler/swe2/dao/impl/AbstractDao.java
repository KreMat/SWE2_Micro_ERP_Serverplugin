/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Matthias
 * 
 */
public abstract class AbstractDao {

	// TODO define variables
	private static final String DRIVERNAME = null;
	private static final String URL = null;
	private static final String USER = null;
	private static final String PASSWORD = null;
	private Connection conn;

	protected Connection getConnection() {
		if (conn == null) {
			try {
				Class.forName(DRIVERNAME);
				conn = DriverManager.getConnection(URL, USER, PASSWORD);
				return conn;
			} catch (ClassNotFoundException e) {
				throw new IllegalStateException("Driver: " + DRIVERNAME
						+ " not found!", e);
			} catch (SQLException e) {
				throw new IllegalStateException(
						"Error getting Connection - URL: " + URL + " - USER: "
								+ USER + " PASSWORD: " + PASSWORD, e);
			}
		}
		return conn;
	}

}
