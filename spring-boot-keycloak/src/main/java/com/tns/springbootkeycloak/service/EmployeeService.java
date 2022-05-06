package com.tns.springbootkeycloak.service;

import java.util.List;

import com.tns.springbootkeycloak.entity.EmployeeDTO;


public interface EmployeeService {

	public EmployeeDTO addEmployee(EmployeeDTO employee);
	
	public EmployeeDTO getEmployee(int empId);
	
	public List<EmployeeDTO> getAllEmployees();
}
