package com.tns.springbootkeycloak.controlleer;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tns.springbootkeycloak.SpringBootKeycloakApplication;
import com.tns.springbootkeycloak.entity.EmployeeDTO;
import com.tns.springbootkeycloak.service.EmployeeService;



@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	private static final Logger logger = LoggerFactory.getLogger(SpringBootKeycloakApplication.class);

	@PostMapping("/add")
	//@RolesAllowed({"user","admin"})
	@RolesAllowed("user")
	public ResponseEntity<EmployeeDTO> addEmployeeInfo(@RequestBody EmployeeDTO dto){
	if(employeeService.addEmployee(dto)!=null) {
			logger.info("Employee Details Added Successfully");
			return new ResponseEntity<EmployeeDTO>(dto,HttpStatus.CREATED);
		}
		else {
			logger.debug("Employee Details not added Successfully");
			return new ResponseEntity<EmployeeDTO>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/get/{empId}")
	@RolesAllowed("user")
	public ResponseEntity<EmployeeDTO> getEmpInfo(@PathVariable("empId") int empId){
		EmployeeDTO employeeDto=employeeService.getEmployee(empId);
		if(employeeDto!=null) {
			logger.info("Employee id with "+ empId+" Data is Successfully Fetched ");
			return new ResponseEntity<EmployeeDTO>(employeeDto,HttpStatus.OK);
		}
		else {
			logger.debug("Employee id with "+ empId+" Data is unsuccessfull");
			return new ResponseEntity<EmployeeDTO>(HttpStatus.BAD_REQUEST);
		}
	
	}
	@GetMapping("/all")
	@RolesAllowed("admin")
	public ResponseEntity<List<EmployeeDTO>> getAllEmployeeInfo(){
		logger.info("All Employee Details are fetched ");
		return new ResponseEntity<List<EmployeeDTO>>(employeeService.getAllEmployees(),HttpStatus.OK);
	}
}
