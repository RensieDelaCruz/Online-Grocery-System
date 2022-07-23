package com.grocerysystem.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnect {
	
	private static String url = "jdbc:mysql://localhost:3306/grocerymanagementsystem";
   	private static String username = "root";
   	private static String password = "root123";

	//method that returns Connection to the database
   	public static Connection getConnection() throws SQLException {
   		Connection conn = DriverManager.getConnection(url, username, password);
   		System.out.println("connected");
   		return conn;
   	}
	
}
