package com.tns.springbootkeycloak.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tns.springbootkeycloak.entity.EmployeeDTO;
import com.tns.springbootkeycloak.repository.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Override
	public EmployeeDTO addEmployee(EmployeeDTO employee) {
		
		return employeeRepo.save(employee);
	}

	@Override
	public EmployeeDTO getEmployee(int empId) {
		Optional<EmployeeDTO> optional = Optional.of(employeeRepo.findById(empId).
				orElseThrow(()->new ResourceNotFoundException("User Not found with id : "+empId)));
		EmployeeDTO getData = optional.get();
		return getData;
	}
	@Override
	public List<EmployeeDTO> getAllEmployees() {
		return (List<EmployeeDTO>)employeeRepo.findAll();
	}

}
