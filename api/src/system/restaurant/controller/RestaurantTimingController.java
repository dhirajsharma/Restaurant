package system.restaurant.controller;

import java.sql.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import system.restaurant.dao.RestaurantTimingDAO;
import system.restaurant.exception.AppException;
import system.restaurant.model.RestaurantTiming;

@Path("/timings")
public class RestaurantTimingController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<RestaurantTiming> getAllTimings() {
		List<RestaurantTiming> timings = null;
		try {
			RestaurantTimingDAO restaurantTimingsDAO = new RestaurantTimingDAO();
			timings = restaurantTimingsDAO.getAllTimings();
		} catch (AppException e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
		return timings;
	}

	@GET
	@Path("/{restaurant_date}")
	@Produces(MediaType.APPLICATION_JSON)
	public RestaurantTiming getOneTiming(@PathParam("restaurant_date") Date restaurant_date) {
		RestaurantTiming restaurantTiming = null;
		try {
			RestaurantTimingDAO restaurantTimingDAO = new RestaurantTimingDAO();
			restaurantTiming = restaurantTimingDAO.getOneTiming(restaurant_date);
		} catch (AppException e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
		return restaurantTiming;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public RestaurantTiming createRestaurantTiming(RestaurantTiming restaurantTiming) {
		try {
			RestaurantTimingDAO restaurantTimingDAO = new RestaurantTimingDAO();
			restaurantTiming = restaurantTimingDAO.createRestaurantTiming(restaurantTiming);
		} catch (AppException e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
		return restaurantTiming;
	}

	@PUT
	@Path("/{timing_id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String updateRestaurantTiming(@PathParam("timing_id") int timing_id, RestaurantTiming restaurantTiming) {
		int rowsAffected = 0;
		String updateStatus;
		try {
			RestaurantTimingDAO restaurantTimingDAO = new RestaurantTimingDAO();
			rowsAffected = restaurantTimingDAO.updateRestaurantTiming(timing_id, restaurantTiming);
		} catch (AppException e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
		if (rowsAffected > 0) {
			updateStatus = "{\"status\":\"success\"}";
		} else {
			updateStatus = "{\"status\":\"failed\"}";
		}
		return updateStatus;
	}

	@DELETE
	@Path("/{timing_id}")
	public String delete(@PathParam("timing_id") int timing_id) {
		int rowsAffected = 0;
		String updateStatus;
		try {
			RestaurantTimingDAO restaurantTimingDAO = new RestaurantTimingDAO();
			rowsAffected = restaurantTimingDAO.deleteRestaurantTiming(timing_id);
		} catch (AppException e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
		if (rowsAffected > 0) {
			updateStatus = "{\"status\":\"success\"}";
		} else {
			updateStatus = "{\"status\":\"failed\"}";
		}
		return updateStatus;
	}

}
