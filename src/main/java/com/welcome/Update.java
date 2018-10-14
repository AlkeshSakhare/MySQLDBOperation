package com.welcome;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Utility.DB;

public class Update {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		int dept_id = 3;
		String emp_name = "Aishwarya";
		int emp_id = 3;
		int salary = 15000;
		Connection conn = DB.getConnection();
		String Update_SQL = "update employees set emp_name=? where emp_id=?";
		PreparedStatement statement = conn.prepareStatement(Update_SQL);
		statement.setString(1, emp_name);
		statement.setInt(2, emp_id);
		statement.executeUpdate();

	}
}
