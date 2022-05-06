package com.tns.springbootkeycloak.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tns.springbootkeycloak.entity.EmployeeDTO;

@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeDTO, Integer> {

}
