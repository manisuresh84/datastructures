package com.suresh.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectJdbcDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String dbUrl = "jdbc:mysql://localhost:3306/test";
		String userName = "root";
		String passWord = "Suresh2014";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			// 1. Get Connection

			Connection dbConnection = DriverManager.getConnection(dbUrl, userName, passWord);

			// 2. Create Statement

			Statement mySts = dbConnection.createStatement();

			// 3. Execute Statement

			ResultSet myResultSet = mySts.executeQuery("select empname, empid from emp");

			// 4. Process ResultSet

			while (myResultSet.next()) {
				System.out.println("Emp Name [" + myResultSet.getString("empname") + "] Emp No ["
						+ myResultSet.getInt("empid") + "]");
			}
			
			myResultSet.close();
			mySts.close();
			dbConnection.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
