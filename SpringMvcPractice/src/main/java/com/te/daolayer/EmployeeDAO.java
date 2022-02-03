package com.te.daolayer;

import java.util.List;

import com.te.dtolayer.EmployeeDetails;

public interface EmployeeDAO {
 
	public boolean insertEmployee(EmployeeDetails employeeDetails);
	
	public EmployeeDetails fetchDetails(int empId);
	
	public EmployeeDetails authentication(int userId,String password);
	
	public boolean deleteEmployee(int empId);
	
	public boolean updateEmployee(int empId);
	
   public List<EmployeeDetails> getAllEmployees();
	
}
