package com.employee_management_project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.employee_management_project.connection.GetConnection;
import com.employee_management_project.entity.Employee;

public class EmployeeDao {
	Connection con = GetConnection.getCon();
	
	//Inserting the data
	public boolean insertEmployee(Employee e) {
		String insertQuery = "insert into employee values(?,?,?,?,?)";
		
		try {
			PreparedStatement pstm = con.prepareStatement(insertQuery);
			
			//set-get pair
			pstm.setInt(1, e.getEid());
			pstm.setString(2, e.getEname());
			pstm.setInt(3, e.getSalary());
			pstm.setString(4,e.getRole());
			pstm.setInt(5, e.getDeptno());
			
			int row = pstm.executeUpdate();
			
			return row>0;
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return false;
	}
	
	public List<Employee> fetchAll(){
		String fetchQuery = "select * from employee";
		List<Employee> emp = new ArrayList<Employee>();
		
		try {
			PreparedStatement pstm=con.prepareStatement(fetchQuery);
			
			ResultSet res=pstm.executeQuery();
			
			while(res.next()) {
				int eid = res.getInt("eid");
				String ename = res.getString("ename");
				int salary = res.getInt("salary");
				String role = res.getString("role");
				int deptno = res.getInt("deptno");
				
				Employee e = new Employee();
				e.setEid(eid);
				e.setEname(ename);
				e.setSalary(salary);
				e.setRole(role);
				e.setDeptno(deptno);
				
				emp.add(e);
			}
			
			return emp;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return emp;
	}
	
	public Employee fetchById(int id) {
		String fetchIdQuery = "select * from employee where eid=?";
		List<Employee> std = new ArrayList<Employee>();
		
		try {
			PreparedStatement pstm=con.prepareStatement(fetchIdQuery);
			pstm.setInt(1, id);
			Employee e = new Employee();
			
			ResultSet res=pstm.executeQuery();
			
			while(res.next()) {
				int eid = res.getInt("eid");
				String ename = res.getString("ename");
				int salary = res.getInt("salary");
				String role = res.getString("role");
				int deptno = res.getInt("deptno");
				
				
				e.setEid(eid);
				e.setEname(ename);
				e.setSalary(salary);
				e.setRole(role);
				e.setDeptno(deptno);
			}
			
			return e;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public boolean updateEmployee(int id, int salary) {
		String updateQuery = "update employee set salary=? where eid=?";
		
		try {
			PreparedStatement pstm=con.prepareStatement(updateQuery);
			pstm.setInt(1, salary);
			pstm.setInt(2, id);
			
			int row =pstm.executeUpdate();
			
			return row>0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean deleteEmployee(int id) {
		String deleteQuery = "delete from employee where eid=?";
		try {
			PreparedStatement pstm=con.prepareStatement(deleteQuery);
			pstm.setInt(1, id);
			
			int row=pstm.executeUpdate();
			
			return row>0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return false;
	}
}
