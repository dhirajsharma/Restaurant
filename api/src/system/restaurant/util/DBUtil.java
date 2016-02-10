package system.restaurant.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/EgenRestaurant";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "whocares";

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("MySQL JDBC Driver loaded");
		} catch (ClassNotFoundException e) {
			System.err.println("Error loading JDBC Driver");
			e.printStackTrace();
		}
	}

	public static Connection connect() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

		} catch (SQLException e) {
			System.err.println("Error getting connection");
			e.printStackTrace();
		}

		return connection;
	}

}
