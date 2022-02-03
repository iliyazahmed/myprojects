package com.te.deleteOperation;

public class DeleteOperation {

	public static void main(String[] args) {
     EmployeeDetails employeeDetails = new EmployeeDetails(101,"Iliyaz", 12000);
     DeleteDao dao = new DeleteDao();
//   dao.addDetails(employeeDetails);
	dao.deleteDetails(101);
   
   
	}
}
