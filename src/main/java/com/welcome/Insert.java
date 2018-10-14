package com.welcome;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Utility.DB;

public class Insert {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		String emp_name = "Sona";
		int salary = 10000;
		int dept_id = 4;

		Connection conn = DB.getConnection();
		String INSERT_SQL = "INSERT INTO employees(emp_name,salary,dept_id) values(?, ?, ?) ";
		PreparedStatement statement = conn.prepareStatement(INSERT_SQL);
		statement.setString(1, emp_name);
		statement.setInt(2, salary);
		statement.setInt(3, dept_id);
		statement.execute();
		String query = "SELECT * FROM employees";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			int empId = rs.getInt("emp_id");
			String name = rs.getString("emp_name");
			int salary1 = rs.getInt("salary");
			int id = rs.getInt("dept_id");

			System.out.println("Emp Id:-->" + empId);
			System.out.println("Emp name:-->" + name);
			System.out.println("Emp salary:-->" + salary1);

			System.out.println("Dept_id:-->" + empId);

		}
		st.close();

		statement.close();
		conn.close();
	}
}
