package system.restaurant.dao;

import system.restaurant.exception.AppException;
import system.restaurant.model.Employee;
import system.restaurant.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.NotFoundException;

public class EmployeeDAO {

	public List<Employee> findAll() throws AppException {
		List<Employee> employees = new ArrayList<Employee>();
		Connection con = DBUtil.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = con.prepareStatement("SELECT * FROM employee");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Employee emp = new Employee();
				emp.setId(rs.getInt("ID"));
				emp.setFirstName(rs.getString("FIRST_NAME"));
				emp.setLastName(rs.getString("LAST_NAME"));
				emp.setEmail(rs.getString("EMAIL"));
				emp.setAddress1(rs.getString("ADDRESS1"));
				emp.setAddress2(rs.getString("ADDRESS2"));
				emp.setCity(rs.getString("CITY"));
				emp.setZip(rs.getInt("ZIP"));
				emp.setState(rs.getString("STATE"));
				emp.setPhone(rs.getString("PHONE"));
				
				employees.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException(e.getMessage());
		}
		finally {
			
			try {
				if (ps != null) {
					ps.close();
				}

				if (rs != null) {
					rs.close();
				}

				if (con != null) {
					con.close();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return employees;
	}

	public Employee findOne(int id) throws AppException, NotFoundException {
		Employee emp = null;
		Connection con = DBUtil.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = con.prepareStatement("SELECT * FROM employee WHERE ID=?");
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				emp = new Employee();
				emp.setId(rs.getInt("ID"));
				emp.setFirstName(rs.getString("FIRST_NAME"));
				emp.setLastName(rs.getString("LAST_NAME"));
				emp.setEmail(rs.getString("EMAIL"));
				emp.setAddress1(rs.getString("ADDRESS1"));
				emp.setAddress2(rs.getString("ADDRESS2"));
				emp.setCity(rs.getString("CITY"));
				emp.setZip(rs.getInt("ZIP"));
				emp.setState(rs.getString("STATE"));
				emp.setPhone(rs.getString("PHONE"));
			}
			else {
				throw new NotFoundException("Employee with this id not found");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException(e.getMessage());
		}
		finally {
			
			try {
				if (ps != null) {
					ps.close();
				}

				if (rs != null) {
					rs.close();
				}

				if (con != null) {
					con.close();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return emp;
	}

	public Employee create (Employee emp) throws AppException {
		Connection con = DBUtil.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = con.prepareStatement("INSERT INTO employee (FIRST_NAME, LAST_NAME, EMAIL, ADDRESS1, ADDRESS2, CITY, ZIP, PHONE, STATE) VALUES (?,?,?,?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, emp.getFirstName());
			ps.setString(2, emp.getLastName());
			ps.setString(3, emp.getEmail());
			ps.setString(4, emp.getAddress1());
			ps.setString(5, emp.getAddress2());
			ps.setString(6, emp.getCity());
			ps.setInt(7, emp.getZip());
			ps.setString(8, emp.getPhone());
			ps.setString(9, emp.getState());
			
			ps.executeUpdate();
			
			rs = ps.getGeneratedKeys();
			
			if(rs.next()) {
				emp.setId(rs.getInt(1));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException(e.getMessage());
		}
		finally {
			
			try {
				if (ps != null) {
					ps.close();
				}

				if (rs != null) {
					rs.close();
				}

				if (con != null) {
					con.close();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return emp;
	}

	public Employee update(int id, Employee emp) throws AppException {
		return null;
	}

	public void delete(int id) throws AppException {
		
	}

	
}
