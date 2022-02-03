package com.te.dto;

import java.io.Serializable;

public class UserDetails implements Serializable{
        private int empId;
        private String empName;
        private String passKey;
        
		public UserDetails() {
			super();
			
		}
		public UserDetails(int empId, String empName, String passKey) {
			super();
			this.empId = empId;
			this.empName = empName;
			this.passKey = passKey;
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
		public String getPassKey() {
			return passKey;
		}
		public void setPassKey(String passKey) {
			this.passKey = passKey;
		}
		@Override
		public String toString() {
			return "UserDetails [empId=" + empId + ", eName=" + empName + ", passKey=" + passKey + "]";
		}
		
        
        
}
