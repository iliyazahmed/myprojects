package com.example.crudoperations.servicelayer;

import java.util.List;

import com.example.crudoperations.dtolayer.EmployeeDto;

public interface EmployeeServiceLayer {
	
	public EmployeeDto addEmployee(EmployeeDto employeeDto);
	
	public EmployeeDto getDetails(int empId);

	public EmployeeDto updateDetails(EmployeeDto employeeDto);
	
	public boolean deleteEmployee(int empId);

	public List<EmployeeDto> getAllEmployee();


	
}
