package com.student_management_system.dao;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.student_management_system.connection.GetConnectionObject;
import com.student_management_system.entity.Student;

public class studentDao {
	Connection con = GetConnectionObject.getConnection();
	/*
	 * Designing method to insert the data into database but here, we need a class
	 * of the data person we are creating for, hence we have Entity layer. So we
	 * create a student class into the entity later
	 */

	public boolean saveStudent(Student s) {

		String InsertQuery = "insert into student values(?,?,?,?,?,?)";

		try {
			PreparedStatement pstm = con.prepareStatement(InsertQuery);

			// set-get pair
			pstm.setInt(1, s.getSid());
			pstm.setString(2, s.getName());
			pstm.setInt(3, s.getAge());
			pstm.setString(4, s.getEmail());
			pstm.setString(5, s.getGender());
			pstm.setString(6, s.getAddress()); // here we are getting the object, not putting the data, The data will be
												// sent, but this receive the data.

			int row = pstm.executeUpdate();

			return row > 0;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;

	}

	// Method to insert the student
	public List<Student> getAllStudent() {
		String selectQuery = "Select * from student";
		List<Student> std = new ArrayList<Student>();

		try {
			PreparedStatement pstm = con.prepareStatement(selectQuery);

			ResultSet res = pstm.executeQuery();

			while (res.next()) {
				int sid = res.getInt("sid");
				String name = res.getString("name");
				int age = res.getInt("age");
				String email = res.getString("email");
				String gender = res.getString("gender");
				String address = res.getString("address");

				// bind the data into object

				Student s = new Student();
				s.setSid(sid);
				s.setAge(age);
				s.setAddress(address);
				s.setEmail(email);
				s.setGender(gender);
				s.setName(name);

				// add to the list
				std.add(s);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return std;
	}

	/*
	 * Method to update the student Name(can be anything) based on the Student ID
	 */
	public boolean updateStudentBasedOnId(int id, String name) {
		String updateQuery = "Update student set name=? where sid=?";

		try {
			PreparedStatement pstm = con.prepareStatement(updateQuery);

			pstm.setInt(2, id);
			pstm.setString(1, name);

			int row = pstm.executeUpdate();

			return row > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	// Method to fetch the data based on student Id
	public String FetchBasedOnId(int id) {
		String fetchQuery = "Select * from student where sid = ?";
		String details = " ";

		try {
			PreparedStatement pstm = con.prepareStatement(fetchQuery);
			pstm.setInt(1, id);

			ResultSet res = pstm.executeQuery();
			while (res.next()) {
				int sid = res.getInt("sid");
				String name = res.getString("name");
				int age = res.getInt("age");
				String email = res.getString("email");
				String gender = res.getString("gender");
				String address = res.getString("address");

				Student s = new Student();
				s.setSid(sid);
				s.setAge(age);
				s.setAddress(address);
				s.setEmail(email);
				s.setGender(gender);
				s.setName(name);

				details = "sid=" + sid + "| Name=" + name + "| Age=" + age + "| Email=" + email + "| Gender=" + gender
						+ "| Address=" + address;
			}
			return details;
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return "details not found";
	}

	// Method to delete the student
	public boolean deleteStudent(int id) {
		String deleteQuery = "delete from student where sid=?";

		try {
			PreparedStatement pstm = con.prepareStatement(deleteQuery);
			pstm.setInt(1, id);
			int row = pstm.executeUpdate();

			return row > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
}
