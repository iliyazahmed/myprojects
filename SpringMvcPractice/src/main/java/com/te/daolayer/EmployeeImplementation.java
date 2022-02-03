package com.te.daolayer;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import com.te.dtolayer.EmployeeDetails;


@Repository
public class EmployeeImplementation implements EmployeeDAO {
   
	@PersistenceUnit
	private EntityManagerFactory factory;
	
	@Override
	public boolean insertEmployee(EmployeeDetails employeeDetails) {
		boolean isInserted=false;
		EntityManager entityManager = factory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		try {
		entityTransaction.begin();
		entityManager.persist(employeeDetails);
		entityTransaction.commit();
		isInserted=true;
		}
		catch(Exception e) {
			entityTransaction.rollback();
			e.printStackTrace();
		}
		return isInserted;
	}

	@Override
	public EmployeeDetails fetchDetails(int empId) {
		EntityManager entityManager = factory.createEntityManager();
		EmployeeDetails details = entityManager.find(EmployeeDetails.class, empId);
		return details;
	}

	@Override
	public EmployeeDetails authentication(int userId, String password) {
		
		EntityManager manager = factory.createEntityManager();
		EmployeeDetails details = manager.find(EmployeeDetails.class, userId);
		if(password.equals(details.getPassword())) {
			  return details;
		}
		return null;
	}

	@Override
	public boolean deleteEmployee(int empId) {
		
		return false;
	}

	@Override
	public boolean updateEmployee(int empId) {
		
		return false;
	}

	@Override
	public List<EmployeeDetails> getAllEmployees() {
		
		return null;
	}

}
