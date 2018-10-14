package com.welcome;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import Utility.DB;

public class ReadDB {

	public static void main(String[] args) {
		try {

			Connection conn = DB.getConnection();
			String query = "SELECT * FROM employees";
			// create the java statement
			Statement st = conn.createStatement();

			// execute the query, and get a java resultset
			ResultSet rs = st.executeQuery(query);

			// iterate through the java resultset
			while (rs.next()) {
				int empId = rs.getInt("emp_id");
				String name = rs.getString("emp_name");
				int salary = rs.getInt("salary");
				int id = rs.getInt("dept_id");

				System.out.println("Emp Id:-->" + empId);
				System.out.println("Emp name:-->" + name);
				System.out.println("Emp salary:-->" + salary);

				System.out.println("Dept_id:-->" + empId);

			}
			st.close();
			conn.close();
		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
			System.out.println(e.getStackTrace());
		}
	}
}
