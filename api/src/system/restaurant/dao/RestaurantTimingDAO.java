package system.restaurant.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.NotFoundException;

import system.restaurant.exception.AppException;
import system.restaurant.model.RestaurantTiming;
import system.restaurant.util.DBUtil;

public class RestaurantTimingDAO {
	Connection connection = DBUtil.connect();
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	String query;
	private int rowsAffected;

	public List<RestaurantTiming> getAllTimings() throws AppException {
		List<RestaurantTiming> timings = new ArrayList<RestaurantTiming>();

		query = "SELECT * FROM restaurant_timings";

		try {
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				RestaurantTiming timing = new RestaurantTiming();
				timing.setRestaurant_workingDate(resultSet.getDate("restaurant_workingDate"));
				timing.setRestaurant_openingTime(resultSet.getTime("restaurant_openingTime"));
				timing.setRestaurant_closingTime(resultSet.getTime("restaurant_closingTime"));
				
				timings.add(timing);
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

		return timings;
	}

	public RestaurantTiming getOneTiming(Date restaurant_workingDate) throws AppException, NotFoundException {
		RestaurantTiming timing = null;
		query = "SELECT * FROM restaurant_timings WHERE restaurant_workingDate=?";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setDate(1, restaurant_workingDate);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				timing = new RestaurantTiming();
				
				timing.setRestaurant_workingDate(resultSet.getDate("restaurant_workingDate"));
				timing.setRestaurant_openingTime(resultSet.getTime("restaurant_openingTime"));
				timing.setRestaurant_closingTime(resultSet.getTime("restaurant_closingTime"));
			} else {
				throw new NotFoundException("Timing with this Date not found");
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

		return timing;
	}

	public RestaurantTiming createRestaurantTiming(RestaurantTiming restaurantTiming) throws AppException {
		query = "INSERT INTO restaurant_timings(restaurant_workingDate, restaurant_openingTime, restaurant_closingTime)VALUES(?,?,?)";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setDate(1, restaurantTiming.getRestaurant_workingDate());
			preparedStatement.setTime(2, restaurantTiming.getRestaurant_openingTime());
			preparedStatement.setTime(3, restaurantTiming.getRestaurant_closingTime());

			preparedStatement.executeUpdate();
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
		return restaurantTiming;
	}

	public int updateRestaurantTiming(int timingId, RestaurantTiming restaurantTiming)
			throws AppException, NotFoundException {
		query = "UPDATE restaurant_timings SET restaurant_workingDate = ?, restaurant_openingTime = ?, restaurant_closingTime =? HWERE srno = ?";

		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setDate(1, restaurantTiming.getRestaurant_workingDate());
			preparedStatement.setTime(2, restaurantTiming.getRestaurant_openingTime());
			preparedStatement.setTime(3, restaurantTiming.getRestaurant_closingTime());

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

	public int deleteRestaurantTiming(int timingId) throws AppException {
		query = "DELETE FROM restaurant_timings WHERE srno = ?";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, timingId);

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
