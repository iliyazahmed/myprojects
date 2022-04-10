package com.example.crudoperations.dtolayer;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "employeeDto")
@ApiModel(value="Details About Employee Information")
public class EmployeeDto {
	@Id
	@ApiModelProperty(notes="This is Employee Id which is unqiue")
	private int empId;
	@ApiModelProperty(notes="This is for Employee Name")
	private String eName;
	@ApiModelProperty(notes="This is about payscale")
	private double salary;
	

}
