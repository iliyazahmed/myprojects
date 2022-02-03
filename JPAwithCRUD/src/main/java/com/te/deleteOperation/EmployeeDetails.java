package com.te.deleteOperation;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EmployeeDetails {
 
	@Id
	private int empId;
	private String eName;
	private double sal;
	public EmployeeDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeDetails(int empId, String eName, double sal) {
		super();
		this.empId = empId;
		this.eName = eName;
		this.sal = sal;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	@Override
	public String toString() {
		return "EmployeeDetails [empId=" + empId + ", eName=" + eName + ", sal=" + sal + "]";
	}
	
}
