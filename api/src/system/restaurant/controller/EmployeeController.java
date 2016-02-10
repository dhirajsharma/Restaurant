package system.restaurant.controller;

import system.restaurant.dao.EmployeeDAO;
import system.restaurant.exception.AppException;
import system.restaurant.model.Employee;

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
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/employees")
public class EmployeeController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> findAll() {
		List<Employee> employees = null;
		try {
			EmployeeDAO dao = new EmployeeDAO();
			employees = dao.findAll();
		} catch (AppException e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
		return employees;
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Employee findOne(@PathParam ("id") int id) {
		Employee employee = null;
		try {
			EmployeeDAO dao = new EmployeeDAO();
			employee = dao.findOne(id);
		} catch (AppException e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
		return employee;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Employee create (Employee emp) {
		
		try {
			EmployeeDAO dao = new EmployeeDAO();
			emp = dao.create(emp);
		} catch (AppException e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
		return emp;
	}
	
	// PUT /api/employees/1020 
	//{}
		
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Employee update (@PathParam("id") int id, Employee emp) {
		
		try {
			EmployeeDAO dao = new EmployeeDAO();
			emp = dao.update(id, emp);
		} catch (AppException e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
		return emp;
	}
	
	
	// DELETE /api/employee/1002
	@DELETE
	@Path("/{id}")
	public Response delete (@PathParam("id") int id) {

		try {
			EmployeeDAO dao = new EmployeeDAO();
			dao.delete(id);
		} catch (AppException e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
		
		return Response.ok().build();
	}
}
