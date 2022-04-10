package com.example.crudoperations.controllerlayer;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crudoperations.MyFirstTaskApplication;
import com.example.crudoperations.dtolayer.EmployeeDto;
import com.example.crudoperations.servicelayer.EmployeeServiceLayer;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	private static final Logger logger = LoggerFactory.getLogger(MyFirstTaskApplication.class);

	@Autowired
	private EmployeeServiceLayer employeeServiceLayer;
	
	@PostMapping("/add")
	@ApiOperation(value="Enter Employee Details",
	               notes="Provide Employee Info to store in database",
	               response=EmployeeDto.class)
	public ResponseEntity<EmployeeDto> addEmployeeInfo(@RequestBody EmployeeDto dto){
		if(employeeServiceLayer.addEmployee(dto)!=null) {
			logger.info("Employee Details Added Successfully");
			return new ResponseEntity<EmployeeDto>(dto,HttpStatus.CREATED);
		}
		else {
			logger.debug("Employee Details not added Successfully");
			return new ResponseEntity<EmployeeDto>(HttpStatus.BAD_REQUEST);
		}
	}
     
	@GetMapping("/get/{empId}")
	@ApiOperation(value="Enter Employee Id to fetch Details",
                  notes="Below you can find Employee Details",
                  response=EmployeeDto.class)
	public ResponseEntity<EmployeeDto> getEmpInfo(@ApiParam(name="get employee",value="Enter empId to retrieve info",required = true) @PathVariable("empId") int empId){
		EmployeeDto employeeDto=employeeServiceLayer.getDetails(empId);
		if(employeeDto!=null) {
			logger.info("Employee id with "+ empId+" Data is Successfully Fetched ");
			return new ResponseEntity<EmployeeDto>(employeeDto,HttpStatus.OK);
		}
		else {
			logger.debug("Employee id with "+ empId+" Data is unsuccessfull");
			return new ResponseEntity<EmployeeDto>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PutMapping("/update")
	@ApiOperation(value="Enter Employee id to update details",
    			  notes="Provide Employee id to update details",
    			  response=EmployeeDto.class)
	public ResponseEntity<EmployeeDto> updateDetails(@RequestBody EmployeeDto employeeDto){
		EmployeeDto updatedData = employeeServiceLayer.updateDetails(employeeDto);
		if(updatedData!=null) {
			logger.info("Employee Details Updated Successfully ");
			return new ResponseEntity<EmployeeDto>(updatedData,HttpStatus.OK);
		}
		else {
			logger.warn("Employee Details not Updated Successfully ");
			return new ResponseEntity<EmployeeDto>(HttpStatus.BAD_REQUEST);
		}
	}
    
	@DeleteMapping("delete/{empId}")
	@ApiOperation(value="Enter Employee id to delete details",
    			 notes="Provide Employee Details To delete details",
    			 response=EmployeeDto.class)
	public ResponseEntity<EmployeeDto> deleteDetails(@ApiParam(name="delete employee",value="Enter empId to delete info",required = true) @PathVariable("empId") int empId){
		if(employeeServiceLayer.deleteEmployee(empId)) {
			logger.warn("Employee id with "+empId+"Details are Successfully deleted");
			return new ResponseEntity<EmployeeDto>(HttpStatus.OK);
		}
		else {
			logger.warn("Employee id with "+empId+"Details are not Successfully deleted");
			return new ResponseEntity<EmployeeDto>(HttpStatus.BAD_REQUEST);
		}
		
		
	}
	
	@GetMapping("/all")
	@ApiOperation(value="Find All Employees",notes="${EmployeeController.getAllEmployee}")
	public ResponseEntity<List<EmployeeDto>> getAllEmployeeInfo(){
		logger.info("All Employee Details are fetched ");
		return new ResponseEntity<List<EmployeeDto>>(employeeServiceLayer.getAllEmployee(),HttpStatus.OK);
	}
	
}
