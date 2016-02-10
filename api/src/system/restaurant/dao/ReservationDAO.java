package system.restaurant.dao;

import static org.bitbucket.dollar.Dollar.$;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.NotFoundException;

import system.restaurant.exception.AppException;
import system.restaurant.model.Reservation;
import system.restaurant.util.DBUtil;

public class ReservationDAO {
	Connection connection = DBUtil.connect();
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	String query;
	private int rowsAffected;

	public List<Reservation> getAllReservations() throws AppException {
		List<Reservation> reservations = new ArrayList<Reservation>();

		query = "SELECT * FROM reservation "
				+ "JOIN customer_detail ON reservation.customer_id = customer_detail.customer_id "
				+ "JOIN reservation_codes ON reservation.reservation_id = reservation_codes.reservation_id "
				+ "JOIN reservation_status ON reservation.reservation_id = reservation_status.reservation_id "
				+ "JOIN table_status ON reservation.reservation_id=table_status.reservation_id";

		try {
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Reservation reservation = new Reservation();
				reservation.setReservation_id(resultSet.getInt("RESERVATION_ID"));
				reservation.setCustomer_id(resultSet.getInt("CUSTOMER_ID"));
				reservation.setReservation_occasion(resultSet.getString("RESERVATION_OCCASION"));
				reservation.setReservation_party_size(resultSet.getInt("RESERVATION_PARTY_SIZE"));
				reservation.setReservation_start_date(resultSet.getDate("RESERVATION_START_DATE"));
				reservation.setReservation_end_date(resultSet.getDate("RESERVATION_END_DATE"));
				reservation.setReservation_start_time(resultSet.getTime("RESERVATION_START_TIME"));
				reservation.setReservation_end_time(resultSet.getTime("RESERVATION_END_TIME"));
				reservation.setReservation_additional_details(resultSet.getString("RESERVATION_ADDITIONAL_DETAILS"));
				reservation.setReservation_bookedBy(resultSet.getString("RESERVATION_BOOKEDBY"));
				reservation.setCustomer_firstname(resultSet.getString("CUSTOMER_FIRSTNAME"));
				reservation.setCustomer_lastname(resultSet.getString("CUSTOMER_LASTNAME"));
				reservation.setCustomer_phone(resultSet.getLong("CUSTOMER_PHONE"));
				reservation.setCustomer_email(resultSet.getString("CUSTOMER_EMAIL"));
				reservation.setCustomer_streetAddress(resultSet.getString("CUSTOMER_STREETADDRESS"));
				reservation.setCustomer_suiteAddress(resultSet.getString("CUSTOMER_SUITEADDRESS"));
				reservation.setCustomer_city(resultSet.getString("CUSTOMER_CITY"));
				reservation.setCustomer_state(resultSet.getString("CUSTOMER_STATE"));
				reservation.setConfirmation_code(resultSet.getString("CONFIRMATION_CODE"));
				reservation.setReservation_status(resultSet.getString("RESERVATION_STATUS"));
				reservation.setTable_number(resultSet.getInt("TABLE_NUMBER"));

				reservations.add(reservation);
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

		return reservations;
	}

	public Reservation getOneReservation(int reservation_id) throws AppException, NotFoundException {
		Reservation reservation = null;
		query = "SELECT * FROM reservation "
				+ "JOIN customer_detail ON reservation.customer_id = customer_detail.customer_id "
				+ "JOIN reservation_codes ON reservation.reservation_id = reservation_codes.reservation_id "
				+ "JOIN reservation_status ON reservation.reservation_id = reservation_status.reservation_id "
				+ "JOIN table_status ON reservation.reservation_id=table_status.reservation_id "
				+ "WHERE reservation.reservation_id = ?";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, reservation_id);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				reservation = new Reservation();

				reservation.setReservation_id(resultSet.getInt("RESERVATION_ID"));
				reservation.setCustomer_id(resultSet.getInt("CUSTOMER_ID"));
				reservation.setReservation_occasion(resultSet.getString("RESERVATION_OCCASION"));
				reservation.setReservation_party_size(resultSet.getInt("RESERVATION_PARTY_SIZE"));
				reservation.setReservation_start_date(resultSet.getDate("RESERVATION_START_DATE"));
				reservation.setReservation_end_date(resultSet.getDate("RESERVATION_END_DATE"));
				reservation.setReservation_start_time(resultSet.getTime("RESERVATION_START_TIME"));
				reservation.setReservation_end_time(resultSet.getTime("RESERVATION_END_TIME"));
				reservation.setReservation_additional_details(resultSet.getString("RESERVATION_ADDITIONAL_DETAILS"));
				reservation.setReservation_bookedBy(resultSet.getString("RESERVATION_BOOKEDBY"));
				reservation.setCustomer_firstname(resultSet.getString("CUSTOMER_FIRSTNAME"));
				reservation.setCustomer_lastname(resultSet.getString("CUSTOMER_LASTNAME"));
				reservation.setCustomer_phone(resultSet.getLong("CUSTOMER_PHONE"));
				reservation.setCustomer_email(resultSet.getString("CUSTOMER_EMAIL"));
				reservation.setCustomer_streetAddress(resultSet.getString("CUSTOMER_STREETADDRESS"));
				reservation.setCustomer_suiteAddress(resultSet.getString("CUSTOMER_SUITEADDRESS"));
				reservation.setCustomer_city(resultSet.getString("CUSTOMER_CITY"));
				reservation.setCustomer_state(resultSet.getString("CUSTOMER_STATE"));
				reservation.setCustomer_zip(resultSet.getInt("CUSTOMER_ZIP"));
				reservation.setConfirmation_code(resultSet.getString("CONFIRMATION_CODE"));
				reservation.setReservation_status(resultSet.getString("RESERVATION_STATUS"));
				reservation.setTable_number(resultSet.getInt("TABLE_NUMBER"));
			} else {
				throw new NotFoundException("Reservation with this VALUE not found");
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

		return reservation;
	}

	public Reservation getReservationByConfirmationCode(String confirmation_code)
			throws AppException, NotFoundException {
		Reservation reservation = null;
		query = "SELECT * FROM reservation "
				+ "JOIN customer_detail ON reservation.customer_id = customer_detail.customer_id "
				+ "JOIN reservation_codes ON reservation.reservation_id = reservation_codes.reservation_id "
				+ "JOIN reservation_status ON reservation.reservation_id = reservation_status.reservation_id "
				+ "JOIN table_status ON reservation.reservation_id=table_status.reservation_id "
				+ "WHERE reservation_codes.confirmation_code = ?";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, confirmation_code);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				reservation = new Reservation();

				reservation.setReservation_id(resultSet.getInt("RESERVATION_ID"));
				reservation.setCustomer_id(resultSet.getInt("CUSTOMER_ID"));
				reservation.setReservation_occasion(resultSet.getString("RESERVATION_OCCASION"));
				reservation.setReservation_party_size(resultSet.getInt("RESERVATION_PARTY_SIZE"));
				reservation.setReservation_start_date(resultSet.getDate("RESERVATION_START_DATE"));
				reservation.setReservation_end_date(resultSet.getDate("RESERVATION_END_DATE"));
				reservation.setReservation_start_time(resultSet.getTime("RESERVATION_START_TIME"));
				reservation.setReservation_end_time(resultSet.getTime("RESERVATION_END_TIME"));
				reservation.setReservation_additional_details(resultSet.getString("RESERVATION_ADDITIONAL_DETAILS"));
				reservation.setReservation_bookedBy(resultSet.getString("RESERVATION_BOOKEDBY"));
				reservation.setCustomer_firstname(resultSet.getString("CUSTOMER_FIRSTNAME"));
				reservation.setCustomer_lastname(resultSet.getString("CUSTOMER_LASTNAME"));
				reservation.setCustomer_phone(resultSet.getLong("CUSTOMER_PHONE"));
				reservation.setCustomer_email(resultSet.getString("CUSTOMER_EMAIL"));
				reservation.setCustomer_streetAddress(resultSet.getString("CUSTOMER_STREETADDRESS"));
				reservation.setCustomer_suiteAddress(resultSet.getString("CUSTOMER_SUITEADDRESS"));
				reservation.setCustomer_city(resultSet.getString("CUSTOMER_CITY"));
				reservation.setCustomer_state(resultSet.getString("CUSTOMER_STATE"));
				reservation.setCustomer_zip(resultSet.getInt("CUSTOMER_ZIP"));
				reservation.setConfirmation_code(resultSet.getString("CONFIRMATION_CODE"));
				reservation.setReservation_status(resultSet.getString("RESERVATION_STATUS"));
				reservation.setTable_number(resultSet.getInt("TABLE_NUMBER"));
			} else {
				throw new NotFoundException("Reservation with this VALUE not found");
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

		return reservation;
	}

	public Reservation createReservation(Reservation reservation) throws AppException {

		try {
			int customerId = insertCustomerDetails(reservation);
			if (customerId > 0) {
				int reservationId = insertReservation(reservation);
				if (reservationId > 0) {
					insertReservationCode(reservation);
					insertReservationStatus(reservationId);
				}
			}
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

		return reservation;
	}

	public int updateReservation(int reservation_id, Reservation reservation) throws AppException, NotFoundException {
		query = "UPDATE reservation INNER JOIN customer_detail ON reservation.customer_id = customer_detail.customer_id SET "
				+ "reservation.reservation_occasion = ?," + "reservation.reservation_start_date = ?,"
				+ "reservation.reservation_end_date = ?," + "reservation.reservation_start_time = ?,"
				+ "reservation.reservation_end_time = ?," + "reservation.reservation_party_size = ?,"
				+ "reservation.reservation_additional_details = ?," + "customer_detail.customer_firstname = ?,"
				+ "customer_detail.customer_lastname = ?," + "customer_detail.customer_phone = ?,"
				+ "customer_detail.customer_email = ?," + "customer_detail.customer_streetAddress = ?,"
				+ "customer_detail.customer_suiteAddress = ?," + "customer_detail.customer_city = ?,"
				+ "customer_detail.customer_state = ?," + "customer_detail.customer_zip = ? "
				+ "WHERE reservation.reservation_id = ?";

		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, reservation.getReservation_occasion());
			preparedStatement.setDate(2, reservation.getReservation_start_date());
			preparedStatement.setDate(3, reservation.getReservation_end_date());
			preparedStatement.setTime(4, reservation.getReservation_start_time());
			preparedStatement.setTime(5, reservation.getReservation_end_time());
			preparedStatement.setInt(6, reservation.getReservation_party_size());
			preparedStatement.setString(7, reservation.getReservation_additional_details());
			preparedStatement.setString(8, reservation.getCustomer_firstname());
			preparedStatement.setString(9, reservation.getCustomer_lastname());
			preparedStatement.setLong(10, reservation.getCustomer_phone());
			preparedStatement.setString(11, reservation.getCustomer_email());
			preparedStatement.setString(12, reservation.getCustomer_streetAddress());
			preparedStatement.setString(13, reservation.getCustomer_suiteAddress());
			preparedStatement.setString(14, reservation.getCustomer_city());
			preparedStatement.setString(15, reservation.getCustomer_state());
			preparedStatement.setInt(16, reservation.getCustomer_zip());
			preparedStatement.setInt(17, reservation_id);

			rowsAffected = preparedStatement.executeUpdate();
			return rowsAffected;
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
		// return 0;
	}

	private void insertReservationStatus(int reservationId) throws AppException {
		String defaultStatus = "WAITING";
		query = "INSERT INTO reservation_status(RESERVATION_ID, RESERVATION_STATUS) VALUES(?,?)";

		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, reservationId);
			preparedStatement.setString(2, defaultStatus);

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException(e.getMessage());
		}
	}

	private void insertReservationCode(Reservation reservation) throws AppException {
		query = "INSERT INTO reservation_codes(RESERVATION_ID, CUSTOMER_ID, CONFIRMATION_CODE) VALUES(?,?,?)";

		try {
			preparedStatement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, reservation.getReservation_id());
			preparedStatement.setInt(2, reservation.getCustomer_id());
			preparedStatement.setString(3, generateConfirmationCode());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException(e.getMessage());
		}
	}

	private String generateConfirmationCode() {
		String confirmationCode = "DEFAULT";
		int codeLength = 12;
		String validCharacters = $('0', '9').join() + $('A', 'Z').join();
		confirmationCode = $(validCharacters).shuffle().slice(codeLength).toString();
		return confirmationCode;
	}

	private int insertCustomerDetails(Reservation reservation) throws AppException {
		int customerId = 0;

		query = "INSERT INTO customer_detail(CUSTOMER_FIRSTNAME, CUSTOMER_LASTNAME, CUSTOMER_PHONE, "
				+ "CUSTOMER_EMAIL, CUSTOMER_STREETADDRESS, CUSTOMER_SUITEADDRESS, CUSTOMER_CITY, "
				+ "CUSTOMER_STATE, CUSTOMER_ZIP) VALUES(?,?,?,?,?,?,?,?,?)";

		try {
			preparedStatement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, reservation.getCustomer_firstname());
			preparedStatement.setString(2, reservation.getCustomer_lastname());
			preparedStatement.setLong(3, reservation.getCustomer_phone());
			preparedStatement.setString(4, reservation.getCustomer_email());
			preparedStatement.setString(5, reservation.getCustomer_streetAddress());
			preparedStatement.setString(6, reservation.getCustomer_suiteAddress());
			preparedStatement.setString(7, reservation.getCustomer_city());
			preparedStatement.setString(8, reservation.getCustomer_state());
			preparedStatement.setInt(9, reservation.getCustomer_zip());

			preparedStatement.executeUpdate();
			resultSet = preparedStatement.getGeneratedKeys();
			if (resultSet.next()) {
				reservation.setCustomer_id(resultSet.getInt(1));

			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException(e.getMessage());
		}
		customerId = reservation.getCustomer_id();
		return customerId;
	}

	private int insertReservation(Reservation reservation) throws AppException {
		int reservationId = 0;

		query = "INSERT INTO reservation (RESERVATION_OCCASION, RESERVATION_START_DATE, "
				+ "RESERVATION_END_DATE, RESERVATION_START_TIME, RESERVATION_END_TIME, RESERVATION_PARTY_SIZE, "
				+ "RESERVATION_ADDITIONAL_DETAILS, CUSTOMER_ID, RESERVATION_BOOKEDBY)" + "VALUES (?,?,?,?,?,?,?,?,?)";

		try {
			preparedStatement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, reservation.getReservation_occasion());
			preparedStatement.setDate(2, reservation.getReservation_start_date());
			preparedStatement.setDate(3, reservation.getReservation_end_date());
			preparedStatement.setTime(4, reservation.getReservation_start_time());
			preparedStatement.setTime(5, reservation.getReservation_end_time());
			preparedStatement.setInt(6, reservation.getReservation_party_size());
			preparedStatement.setString(7, reservation.getReservation_additional_details());
			preparedStatement.setInt(8, reservation.getCustomer_id());
			preparedStatement.setString(9, reservation.getReservation_bookedBy());

			preparedStatement.executeUpdate();
			resultSet = preparedStatement.getGeneratedKeys();

			if (resultSet.next()) {
				reservation.setReservation_id(resultSet.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException(e.getMessage());
		}
		reservationId = reservation.getReservation_id();
		return reservationId;
	}

	public int updateReservationStatus(Reservation reservation) throws AppException, NotFoundException {
		query = "UPDATE  reservation_status SET  reservation_status = ? WHERE  reservation_id = ?";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, reservation.getReservation_status());
			preparedStatement.setInt(2, reservation.getReservation_id());
			rowsAffected = preparedStatement.executeUpdate();
			return rowsAffected;
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
	}
}
