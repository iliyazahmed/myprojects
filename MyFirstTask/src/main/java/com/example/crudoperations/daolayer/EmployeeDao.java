package com.example.crudoperations.daolayer;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.crudoperations.dtolayer.EmployeeDto;

@Repository
public interface EmployeeDao extends CrudRepository<EmployeeDto, Integer> {

}
