package system.restaurant.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import system.restaurant.dao.ReservationDAO;
import system.restaurant.exception.AppException;
import system.restaurant.model.Reservation;

@Path("/reservation")
public class ReservationController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Reservation> getAllReservations() {
		List<Reservation> reservations = null;
		try {
			ReservationDAO reservationDAO = new ReservationDAO();
			reservations = reservationDAO.getAllReservations();
		} catch (AppException e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
		return reservations;
	}

	@GET
	@Path("/{reservation_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Reservation getOneReservation(@PathParam("reservation_id") int reservation_id) {
		Reservation reservation = null;
		try {
			ReservationDAO reservationDAO = new ReservationDAO();
			reservation = reservationDAO.getOneReservation(reservation_id);
		} catch (AppException e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
		return reservation;
	}

	@GET
	@Path("/code/{confirmation_code}")
	@Produces(MediaType.APPLICATION_JSON)
	public Reservation getReservationByConfirmationCode(@PathParam("confirmation_code") String confirmation_code) {
		Reservation reservation = null;
		try {
			ReservationDAO reservationDAO = new ReservationDAO();
			reservation = reservationDAO.getReservationByConfirmationCode(confirmation_code);
		} catch (AppException e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
		return reservation;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Reservation createReservation(Reservation reservation) {

		try {
			ReservationDAO reservationDAO = new ReservationDAO();
			reservation = reservationDAO.createReservation(reservation);
		} catch (AppException e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
		return reservation;

	}

	@PUT
	@Path("/{reservation_id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String updateReservation(@PathParam("reservation_id") int reservation_id, Reservation reservation) {
		int rowsAffected = 0;
		String updateStatus;
		try {
			ReservationDAO reservationDAO = new ReservationDAO();
			rowsAffected = reservationDAO.updateReservation(reservation_id, reservation);
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

	@PUT
	@Path("/updateStatus")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String updateReservationStatus(Reservation reservation) {
		int rowsAffected = 0;
		String updateStatus;
		try {
			ReservationDAO reservationDAO = new ReservationDAO();
			rowsAffected = reservationDAO.updateReservationStatus(reservation);
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
