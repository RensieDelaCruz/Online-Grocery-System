package com.grocerysystem.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class Administrator implements User {
	
	private int userID;
	private String firstName, lastName, emailAddress;
	private static Administrator admin;
	
	public static Administrator getInstance() {
		if(admin == null)
			admin = new Administrator();
		return admin;
	}

	//method to check login info
	//	// this method will return true if the user will enter a matching registered
	// username and password, hence, a successful login
	@Override
	public boolean verifyLogin(String userName, String userPassword) {
			boolean valid = false;
			try (Connection conn = DatabaseConnect.getConnection()) {
				String query = "SELECT * FROM user WHERE username = ? AND password = ? AND user_type = 'A'";
				PreparedStatement stmt = conn.prepareStatement(query);
				stmt.setString(1, userName);
				stmt.setString(2, userPassword);
				ResultSet rs = stmt.executeQuery();
				if (rs.next())
					valid = true;

			} catch (SQLException e) {
				valid = false;
			}
			if(valid)
				currentAdmin(userName,userPassword);
			return valid;
	}

	// this method will get the current admin's info from the database
	private void currentAdmin(String userName, String userPassword) {
		try (Connection conn = DatabaseConnect.getConnection()) {
			String query = "SELECT * FROM user_administrator JOIN user ON user.user_id = user_administrator.user_id WHERE user.username= ?  AND user.password= ?";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, userName);
			stmt.setString(2, userPassword);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				userID = rs.getInt("user_id");
				firstName = rs.getString("first_name");
				lastName = rs.getString("last_name");
				emailAddress = rs.getString("company_email");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	
	@Override
	public void updateAccountInfo() {

	}

	public void createProduct() {

	}

	public void updateProduct() {

	}

	public void deleteProduct() {

	}

	
}
