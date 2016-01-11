package system.restaurant.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import system.restaurant.dao.LoginDAO;
import system.restaurant.exception.AppException;

@Path("/login")
public class LoginController {
	@GET
	@Path("/{username}/{password}")
	@Produces(MediaType.APPLICATION_JSON)
	public String login(@PathParam ("username") String username, @PathParam("password") String password) {
		String loginResult;
		boolean loginStatus;
		try {
			LoginDAO loginDao = new LoginDAO();
			loginStatus = loginDao.login(username, password);
		} catch (AppException e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
		String status = String.valueOf(loginStatus);
		loginResult = "{\"status\":\""+status+"\"}";
		return loginResult;
	}
}