package com.welcome;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ReadDB {

	public static void main(String[] args) {
		try {
			// create our mysql database connection
			String myUrl = "jdbc:mysql://localhost/emeeting";
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection conn = DriverManager.getConnection(myUrl, "root", "");

			// our SQL SELECT query.
			// if you only need a few columns, specify them by name instead of
			// using "*"
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
		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
			System.out.println(e.getStackTrace());
		}
	}
}
