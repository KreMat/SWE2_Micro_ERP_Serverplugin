/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author Matthias
 * 
 */
public abstract class AbstractDao {

	private static final String KEY_DRIVERNAME = "driver";
	private static final String KEY_URL = "url";
	private static final String KEY_USER = "user";
	private static final String KEY_PASSWORD = "password";
	private static final String CONFIG_FILE_PATH = "/mysql.properties";
	protected static final Properties properties;

	static {
		properties = new Properties();
		try {
			properties.load(AbstractDao.class
					.getResourceAsStream(CONFIG_FILE_PATH));
		} catch (IOException e) {
			throw new IllegalStateException(
					"Error loading Propertiesfile - Path: " + CONFIG_FILE_PATH,
					e);
		}
	}
	private Connection conn;

	protected Connection getConnection() {
		if (conn == null) {
			try {
				Class.forName(properties.getProperty(KEY_DRIVERNAME));
				conn = DriverManager.getConnection(
						properties.getProperty(KEY_URL),
						properties.getProperty(KEY_USER),
						properties.getProperty(KEY_PASSWORD));
				return conn;
			} catch (ClassNotFoundException e) {
				throw new IllegalStateException("Driver: "
						+ properties.getProperty(KEY_DRIVERNAME)
						+ " not found!", e);
			} catch (SQLException e) {
				throw new IllegalStateException(
						"Error getting Connection - URL: "
								+ properties.getProperty(KEY_URL) + " - USER: "
								+ properties.getProperty(KEY_USER)
								+ " PASSWORD: "
								+ properties.getProperty(KEY_PASSWORD), e);
			}
		}
		return conn;
	}

	protected void closeConnection() {
		if (conn != null) {
			try {

				conn.close();
			} catch (SQLException e) {
				throw new IllegalStateException(e);
			}
			conn = null;
		}
	}

}
