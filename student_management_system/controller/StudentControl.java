package com.student_management_system.controller;

import java.util.Scanner;

import com.student_management_system.dao.studentDao;
import com.student_management_system.entity.Student;

public class StudentControl {
public static void main(String[] args) {
	Scanner s = new Scanner(System.in);
	while(true) {
	System.out.println("Welcome to Student Management system");
	System.out.println("=====================================");
	
	System.out.println("1. Enter 1 to insert the student data.");
	System.out.println("2. Enter 2 to fetch all the student.");
	System.out.println("3. Enter 3 to fetch the student data based on ID");
	System.out.println("4. Enter 4 to update the data");
	System.out.println("5. Enter 5 to delete the data based on ID");
	System.out.println("6. to exit");
	System.out.println("--------------------------------------------------");
	System.out.println("Enter your choice");
	int choice = s.nextInt();

	switch(choice) {
		case 1: Ops.Insert();
		break;
		case 2: Ops.Fetch();
		break;
		case 3: Ops.FetchBasedOnId();
		break;
		case 4: Ops.updateBasedOnId();
		break;
		case 5: Ops.Delete();
		break;
		case 6:System.err.println("Thanks for using us..."); 
			System.exit(0);
		
		default:System.out.println("invalid choice...");
	} 
	}
}
}
