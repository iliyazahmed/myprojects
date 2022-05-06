package com.tns.springbootkeycloak.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int empId;
	private String ename;
	private double salary;
	private String jobRole;
}
