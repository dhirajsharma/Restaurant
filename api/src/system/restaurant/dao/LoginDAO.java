package system.restaurant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import system.restaurant.exception.AppException;
import system.restaurant.util.DBUtil;

public class LoginDAO {
	Connection connection = DBUtil.connect();
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	String query;
	
	public boolean login(String username, String password) throws AppException {
		query = "SELECT * FROM users WHERE user_name = ? and user_password = ?";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException(e.getMessage());
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}

				if (resultSet != null) {
					resultSet.close();
				}

				if (connection != null) {
					connection.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
