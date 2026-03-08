package com.employee_management_project.controller;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.employee_management_project.dao.EmployeeDao;
import com.employee_management_project.entity.Employee;

public class Ops {
	static Scanner s = new Scanner(System.in);

	public static void insert() {
		System.out.println("Enter the Employee ID");
		int eid = s.nextInt();
		System.out.println("Enter the Employee name");
		String ename = s.next();
		System.out.println("Enter the Salary of Employee");
		int salary = s.nextInt();
		System.out.println("Enter the Job role of employee");
		String job = s.next();
		System.out.println("Enter the Dept number of Employee");
		int deptno = s.nextInt();

		Employee emp = new Employee();
		emp.setEid(eid);
		emp.setEname(ename);
		emp.setSalary(salary);
		emp.setRole(job);
		emp.setDeptno(deptno);

		EmployeeDao ed = new EmployeeDao();
		boolean b = ed.insertEmployee(emp);

		if (b) {
			System.out.println("Employee data is inserted");
		}else {
			System.out.println("Failed to insert data");
		}
	}
	
	public static void fetchAll() {
		EmployeeDao ed = new EmployeeDao();
		List<Employee> emp = ed.fetchAll();
		
		for(Employee e : emp) {
			System.out.println("===========================");
			System.out.println("Employee ID = " + e.getEid());
			System.out.println("Employee Name = "+e.getEname());
			System.out.println("Employee Salary = "+e.getSalary());
			System.out.println("Employee Job role = "+ e.getRole());
			System.out.println("Emploee Dept no = "+e.getDeptno());
		}
	}
	
	public static void fetchById() {
		EmployeeDao ed = new EmployeeDao();
		
		System.out.println("Enter the Employee ID for Details");
		int id = s.nextInt();
		Employee e = ed.fetchById(id);
		
		System.out.println("Employee ID = " + e.getEid());
		System.out.println("Employee Name = "+e.getEname());
		System.out.println("Employee Salary = "+e.getSalary());
		System.out.println("Employee Job role = "+ e.getRole());
		System.out.println("Emploee Dept no = "+e.getDeptno());
	}
	
	public static void update() {
		EmployeeDao ed = new EmployeeDao();
		System.out.println("Enter the id of the employee to update salary");
		int eid = s.nextInt();
		System.out.println("Enter the updated salary");
		int newSal = s.nextInt();
		
		boolean b=ed.updateEmployee(eid, newSal);
		
		if(b) {
			System.out.println("Salary Updated.");
		}else {
			System.out.println("Failed to update Salary.");
		}
	}
	
	public static void delete() {
		EmployeeDao ed = new EmployeeDao();
		System.out.println("Enter the Employee id need to delete:");
		int eid = s.nextInt();
		
		boolean b=ed.deleteEmployee(eid);
		
		if(b) {
			System.out.println("Employee data deleted");
		}else {
			System.out.println("Unable to delete employee");
		}
	}
}
