package com.employee_management_project.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnection {
	public static Connection getCon() {
		String user = "postgres";
		String pswd = "<Enter the password of ur postgresql>"; // eneter yout own password 
		String url = "jdbc:postgresql://localhost:5432/employee_management_project";
		
		try {
			Class.forName("org.postgresql.Driver");
			
			Connection con =DriverManager.getConnection(url,user,pswd);
			
			return con;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException s) {
			s.printStackTrace();
		}
		
		return null;
	}
}

