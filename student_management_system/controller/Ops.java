package com.student_management_system.controller;

import java.util.List;
import java.util.Scanner;

import com.student_management_system.dao.studentDao;
import com.student_management_system.entity.Student;

public class Ops {
	public static void Insert() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter student Id");
		int sid = s.nextInt();
		s.nextLine();
		System.out.println("Enter the name of the student");
		String sname = s.nextLine();
		System.out.println("Enter the age");
		int age = s.nextInt();
		s.nextLine();
		System.out.println("Enter the email");
		String email = s.nextLine();
		System.out.println("Enter the gender of the student");
		String gender = s.nextLine();
		System.out.println("Enter the address of the student");
		String addr = s.nextLine();

		Student std = new Student();
		std.setSid(sid);
		std.setName(sname);
		std.setAge(age);
		std.setEmail(email);
		std.setGender(gender);
		std.setAddress(addr);
		
		studentDao sd = new studentDao();
		Boolean value = sd.saveStudent(std);

		if (value) {
			System.out.println("Data is inserted");
		} else {
			System.out.println("Data is not inserted");
		}
	}

	public static void Fetch() {
		studentDao sd = new studentDao();
		List<Student> std = sd.getAllStudent();
		
		for (Student s : std) {
			System.out.println("==================================");
			System.out.println("student Id = "+ s.getSid());
			System.out.println("student Name = "+ s.getName());
			System.out.println("student Age = "+ s.getAge());
			System.out.println("student Email = "+ s.getEmail());
			System.out.println("student Gender = "+ s.getGender());
			System.out.println("student Address = "+ s.getAddress());
		}
		}
	
	public static void updateBasedOnId() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the student Id you need to update");
		int id = s.nextInt();
		System.out.println("Enter the updated name :");
		String name = s.next();
		
		studentDao sd = new studentDao();
		boolean b = sd.updateStudentBasedOnId(id, name);
		
		if(b) {
			System.out.println("Data is updated");
		}else {
			System.out.println("Data is not updated");
		}
	}
	
	public static void FetchBasedOnId() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the id to be fetched");
		int id = s.nextInt();
		
		studentDao sd = new studentDao();
		String result = sd.FetchBasedOnId(id);
		
		System.out.println(result);
	}
	
	public static void Delete() {
		Scanner s = new Scanner(System.in);
		studentDao sd = new studentDao();
		System.out.println("Enter the ID of student that need to be deleted: ");
		int sid = s.nextInt();
		boolean b = sd.deleteStudent(sid);
		
		if(b) {
			System.out.println("Data is deleted");
		}else {
			System.out.println("Sid was not found");
		}
	}
		}
