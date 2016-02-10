package system.restaurant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import system.restaurant.exception.AppException;
import system.restaurant.model.Customer;
import system.restaurant.util.DBUtil;

public class CustomerDAO {
	Connection connection = DBUtil.connect();
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	String query;

	public List<Customer> getAllCustomers() throws AppException {
		List<Customer> customers = new ArrayList<Customer>();

		query = "SELECT * FROM customer_detail";

		try {
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Customer customer = new Customer();
				customer.setCustomer_id(resultSet.getInt("CUSTOMER_ID"));
				customer.setCustomer_firstname(resultSet.getString("CUSTOMER_FIRSTNAME"));
				customer.setCustomer_lastname(resultSet.getString("CUSTOMER_LASTNAME"));
				customer.setCustomer_phone(resultSet.getLong("CUSTOMER_PHONE"));
				customer.setCustomer_email(resultSet.getString("CUSTOMER_EMAIL"));
				customer.setCustomer_streetAddress(resultSet.getString("CUSTOMER_STREETADDRESS"));
				customer.setCustomer_suiteAddress(resultSet.getString("CUSTOMER_SUITEADDRESS"));
				customer.setCustomer_city(resultSet.getString("CUSTOMER_CITY"));
				customer.setCustomer_state(resultSet.getString("CUSTOMER_STATE"));
				customer.setCustomer_zip(resultSet.getInt("CUSTOMER_ZIP"));

				customers.add(customer);
			}
		} catch (SQLException e) {
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

		return customers;
	}
}
