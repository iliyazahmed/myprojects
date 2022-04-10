package com.example.crudoperations.servicelayer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crudoperations.daolayer.EmployeeDao;
import com.example.crudoperations.dtolayer.EmployeeDto;
import com.example.crudoperations.errrohandling.ResourceNotFoundException;



@Service
public class EmployeeServiceImpl implements EmployeeServiceLayer {
   
	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public EmployeeDto addEmployee(EmployeeDto employeeDto) {
     		return employeeDao.save(employeeDto);	
		
	}

	@Override
	public EmployeeDto getDetails(int empId) {
	 Optional<EmployeeDto> optional = Optional.of(employeeDao.findById(empId).
				orElseThrow(()->new ResourceNotFoundException("User Not found with id : "+empId)));
		EmployeeDto getData = optional.get();
		return getData;
	}

	@Override
	public EmployeeDto updateDetails(EmployeeDto employeeDto) {
	 Optional<EmployeeDto> optionalEmployee=Optional.of(employeeDao.findById(employeeDto.getEmpId()).
				orElseThrow(()->new ResourceNotFoundException("User Not found with id : "+employeeDto)));
		
	 EmployeeDto previousData = optionalEmployee.get();
		if(employeeDto.getEName()!=null && employeeDto.getEName()!=" ") {
			 previousData.setEName(employeeDto.getEName());
		}
	    if(employeeDto.getSalary()!=0) {
	    	previousData.setSalary(employeeDto.getSalary());
	    }
	    EmployeeDto updatedData=employeeDao.save(previousData);
	    
		return updatedData;
	}

	@Override
	public boolean deleteEmployee(int empId) {
		boolean isDeleted=false;
		try {
		employeeDao.deleteById(empId);
		isDeleted=true;
		}
		catch(ResourceNotFoundException e) {
			//throw new ResourceNotFoundException("user id "+empId+" is not found !!");
			e.printStackTrace();
		}
		return isDeleted;
	}
	
//	public boolean deleteEmployee(int empId) {
//		boolean isDeleted=false;
//		try {
//		EmployeeDto employeeDto = employeeDao.findById(empId).
//				    orElseThrow(()->new ResourceNotFoundException("User Not found with id : "+empId));
//		employeeDao.delete(employeeDto);
//		isDeleted=true;
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//		return isDeleted;
//		
//	}
    @Override
	public List<EmployeeDto> getAllEmployee(){
		return (List<EmployeeDto>) employeeDao.findAll();
	}
}
