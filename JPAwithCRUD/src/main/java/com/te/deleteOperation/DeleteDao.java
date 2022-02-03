package com.te.deleteOperation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DeleteDao {
 
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Ravinder");
	
     public void addDetails(EmployeeDetails details) {
    	 EntityManager entityManager = entityManagerFactory.createEntityManager();
    	 entityManager.getTransaction().begin();
    	 entityManager.persist(details);
    	 entityManager.getTransaction().commit();
    	 entityManager.close();
     }
     
     public void deleteDetails(int empId) {
    	 EntityManager entityManager = entityManagerFactory.createEntityManager();
    	 entityManager.getTransaction().begin();
    	 EmployeeDetails employeeDetails = entityManager.find(EmployeeDetails.class, empId);
    	 entityManager.remove(employeeDetails);
    	 entityManager.close();
     }
}
