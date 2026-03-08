package com.student_management_system.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnectionObject {
	public static Connection getConnection() {
		String url = "jdbc:postgresql://localhost:5432/student_management_system";
		String user = "postgres";
		String pwd = "<enter your own password >"; // enter the connection password given for the postgreSQL

		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(url, user, pwd);
			return con;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException s) {
			s.printStackTrace();
		}
		
		return null;
	}
}

