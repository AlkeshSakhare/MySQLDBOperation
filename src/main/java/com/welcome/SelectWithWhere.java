package com.welcome;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Utility.DB;

public class SelectWithWhere {

	public static void main(String[] args) {
		try {
			Connection conn = DB.getConnection();
			Statement st = conn.createStatement();
			String emp_name = "1";
			String sql = "SELECT * FROM employees where dept_id='" + emp_name
					+ "'";
			ResultSet rs = st.executeQuery(sql);
			System.out.println("Im else");
			System.out.println(rs.first());
			System.out.println(rs.next());

			if (!rs.first()) {
				System.out.println("no data");
			} else {

				do {
					int empId = rs.getInt("emp_id");
					String name = rs.getString("emp_name");
					int salary = rs.getInt("salary");
					int id = rs.getInt("dept_id");

					System.out.println("Emp Id:-->" + empId);
					System.out.println("Emp name:-->" + name);
					System.out.println("Emp salary:-->" + salary);
					System.out.println("Dept_id:-->" + id);

				} while (rs.next());
			}
			rs.close();
			st.close();
			conn.close();
		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
