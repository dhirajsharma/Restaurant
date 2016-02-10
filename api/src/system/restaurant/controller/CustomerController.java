package system.restaurant.controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import system.restaurant.dao.CustomerDAO;
import system.restaurant.exception.AppException;
import system.restaurant.model.Customer;

@Path("/customer")
public class CustomerController {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Customer> getAllCustomers() {
		List<Customer> customers = null;
		try {
			CustomerDAO customerDAO = new CustomerDAO();
			customers = customerDAO.getAllCustomers();
		} catch (AppException e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
		return customers;
	}
}
