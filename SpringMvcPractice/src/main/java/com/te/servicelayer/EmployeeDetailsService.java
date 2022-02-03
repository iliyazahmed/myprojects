package com.te.servicelayer;

import java.util.List;

import com.te.dtolayer.EmployeeDetails;

public interface EmployeeDetailsService {

	public boolean addEmployee(EmployeeDetails details);
	
	public EmployeeDetails getEmployeeDetails(int empId);
	
	public EmployeeDetails serviceAuthentication(int userId,String password);
	
	public boolean deleteEmployee(int id);
	
	public boolean updateEmployee(EmployeeDetails employeeDetails);
	
	public List<EmployeeDetails> getAllTrainees();
	
}
