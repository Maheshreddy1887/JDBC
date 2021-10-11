package com.xworkz.jdbcemployee;

public class Employee {

	public static void main(String[] args) {

		EmployeeDAOImp mahesh = new EmployeeDAOImp();

		mahesh.employeeAllDetails();

		mahesh.updateEmployeeDetails();

		mahesh.singleEmployeeDetailsByID();

		mahesh.insertEmployeeDetails();

		mahesh.deleteEmployeeDetails();

		mahesh.updateSalaryAndEmail();

		mahesh.readSalaryByID();

		mahesh.readEmailByID();

		mahesh.readEmailByID();
	}

}
