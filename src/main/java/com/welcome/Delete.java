package com.welcome;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Utility.DB;

public class Delete {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		int emp_id = 4;
		Connection connection = DB.getConnection();
		String delete_emp = "Delete from employees where emp_id=?";
		PreparedStatement statement = connection.prepareStatement(delete_emp);
		statement.setInt(1, emp_id);
		statement.executeUpdate();
	}
}
