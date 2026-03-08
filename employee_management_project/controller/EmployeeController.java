package com.employee_management_project.controller;

import java.util.Scanner;

public class EmployeeController {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Welcome to Employee Management System");

		while (true) {
			System.out.println();
			System.out.println("*********************************");
			System.out.println("1.Insert the Employee Data");
			System.out.println("2.Fetch all the employees");
			System.out.println("3.Fetch Employee name by ID");
			System.out.println("4.Update Employee data based on Employee ID");
			System.out.println("5.Delete Employee data based on Employee ID");
			System.out.println("6. Exit the operations");
			System.out.println("-------------------------------------------");
			System.out.println("Enter you Choice");
			int choice = s.nextInt();

			switch (choice) {
			
			case 1:
				Ops.insert();
				break;
			case 2:
				Ops.fetchAll();
				break;
			case 3:
				Ops.fetchById();
				break;
			case 4:
				Ops.update();
				break;
			case 5:
				Ops.delete();
				break;
			case 6:
				System.err.println("Thank you for visiting us...");
				System.exit(0);

			default:
				System.out.println("Invalid Input");
			}
		}
	}
}
