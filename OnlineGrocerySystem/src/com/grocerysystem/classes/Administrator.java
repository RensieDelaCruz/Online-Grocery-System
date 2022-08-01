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

	@Override
	public void updateAccountInfo() {

	}

	// method that will add a new product to the database and management table
	public void addProduct(String name, String dept, double price, int qty) {
		try (Connection conn = DatabaseConnect.getConnection()) {
			String insertQuery = "INSERT INTO products(product_name, department, price, quantity_instock, in_stock, status) VALUES (?, ?, ?, ?, 1, 'pending')";
			PreparedStatement stmt1 = conn.prepareStatement(insertQuery);
			stmt1.setString(1, name);
			stmt1.setString(2, dept);
			stmt1.setDouble(3, price);
			stmt1.setInt(4, qty);
			stmt1.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// method that will update certain product in the database and management table
	public void updateProduct(String name, double price, int qty, int productID) {
		try (Connection conn = DatabaseConnect.getConnection()) {
			String updateQuery = "UPDATE products SET product_name = ?, price = ?, quantity_instock = ? WHERE product_id = ?";
			PreparedStatement stmt2 = conn.prepareStatement(updateQuery);
			stmt2.setString(1, name);
			stmt2.setDouble(2, price);
			stmt2.setInt(3, qty);
			stmt2.setInt(4, productID);
			stmt2.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// method that will delete certain product in the database and management table
	public void deleteProduct(int productID) {
		try(Connection conn = DatabaseConnect.getConnection()){
			String deleteQuery = "DELETE FROM products WHERE product_id = ?";
			PreparedStatement stmt3 = conn.prepareStatement(deleteQuery);
			stmt3.setInt(1, productID);
			stmt3.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
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


}
