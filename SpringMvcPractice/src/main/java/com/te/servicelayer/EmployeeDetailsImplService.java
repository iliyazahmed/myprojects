package com.te.servicelayer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.daolayer.EmployeeDAO;
import com.te.dtolayer.EmployeeDetails;
import com.te.mycustomexception.InvalidPasswordException;

@Service
public class EmployeeDetailsImplService implements EmployeeDetailsService{
    
	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Override
	public boolean addEmployee(EmployeeDetails details) {
		if(details.getPassword().equals(details.getEmpName())) {
			throw new InvalidPasswordException("userName and Password cannot be same");
		}
		return employeeDAO.insertEmployee(details);
	}

	@Override
	public EmployeeDetails getEmployeeDetails(int empId) {
		
		return employeeDAO.fetchDetails(empId);
	}

	@Override
	public EmployeeDetails serviceAuthentication(int userId, String password) {
		
		return employeeDAO.authentication(userId, password);
	}

	@Override
	public boolean deleteEmployee(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateEmployee(EmployeeDetails employeeDetails) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<EmployeeDetails> getAllTrainees() {
		// TODO Auto-generated method stub
		return null;
	}
    
	
}
