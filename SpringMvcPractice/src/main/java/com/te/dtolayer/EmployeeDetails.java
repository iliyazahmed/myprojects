package com.te.dtolayer;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EmployeeDetails implements Serializable{
	 
	  @Id
	  @GeneratedValue(strategy= GenerationType.AUTO)
      private int empId;
      private String empName;
      private String emailAddress;
      private long mobileNumber;
      private String password;
      
			public EmployeeDetails() {
				super();
				// TODO Auto-generated constructor stub
			}
			public EmployeeDetails(int empId, String empName, String emailAddress, long mobileNumber, String password) {
				super();
				this.empId = empId;
				this.empName = empName;
				this.emailAddress = emailAddress;
				this.mobileNumber = mobileNumber;
				this.password = password;
			}
			public int getEmpId() {
				return empId;
			}
			public void setEmpId(int empId) {
				this.empId = empId;
			}
			public String getEmpName() {
				return empName;
			}
			public void setEmpName(String empName) {
				this.empName = empName;
			}
			public String getEmailAddress() {
				return emailAddress;
			}
			public void setEmailAddress(String emailAddress) {
				this.emailAddress = emailAddress;
			}
			public long getMobileNumber() {
				return mobileNumber;
			}
			public void setMobileNumber(long mobileNumber) {
				this.mobileNumber = mobileNumber;
			}
			public String getPassword() {
				return password;
			}
			public void setPassword(String password) {
				this.password = password;
			}
			@Override
			public String toString() {
				return "EmployeeDetails [empId=" + empId + ", empName=" + empName + ", emailAddress=" + emailAddress
						+ ", mobileNumber=" + mobileNumber + ", password=" + password + "]";
			}
			
      
      
}
