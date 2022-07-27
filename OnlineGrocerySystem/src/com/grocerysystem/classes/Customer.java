package com.grocerysystem.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Customer implements User {

	private int userID;
	private String firstName, lastName, customerStreetAddress, customerCityAddress, customerStateAddress,
			customerEmailAddress;
	private static Customer customer;

	private Customer() {
	}

	// method to get a Customer instance using a Singleton pattern
	// to make sure that there's only one user instance running at a time.
	public static Customer getInstance() {
		if (customer == null)
			customer = new Customer();
		return customer;

	}

	// method to check login credentials
	// this method will return true if the user will enter a matching registered
	// username and password, hence, a successful login
	@Override
	public boolean verifyLogin(String userName, String userPassword) {
		boolean valid = false;
		try (Connection conn = DatabaseConnect.getConnection()) {
			String query = "SELECT * FROM user WHERE username = ? AND password = ? AND user_type = 'C'";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, userName);
			stmt.setString(2, userPassword);
			ResultSet rs = stmt.executeQuery();
			if (rs.next())
				valid = true;

		} catch (SQLException e) {
			valid = false;
		}

		if (valid) {
			currentUser(userName, userPassword);
		}
		return valid;
	}

	// method to register a new user
	// In this method, I created a new entry in user table in the database first
	// because the user table has a user_id column which is the primary ID and set
	// to auto increment. I did it this way so that I can query the new user_id and
	// then set it to create the new customer entry in the user_customer table to
	// give it a matching user_id from the new entry in user table
	public void register(String userName, String userPassword, String firstName, String lastName,
			String customerStreetAddress, String customerCityAddress, String customerStateAddress,
			String customerEmailAddress) {
		try (Connection conn = DatabaseConnect.getConnection()) {
			String newUserQuery = "INSERT INTO user (username, password, user_type) VALUES (?, ?, 'C')";
			PreparedStatement stmt1 = conn.prepareStatement(newUserQuery);
			stmt1.setString(1, userName);
			stmt1.setString(2, userPassword);
			stmt1.execute();

			String selectQuery = "SELECT user_id FROM user WHERE username = ?";
			PreparedStatement stmt2 = conn.prepareStatement(selectQuery);
			stmt2.setString(1, userName);
			ResultSet rs = stmt2.executeQuery();
			while (rs.next()) {
				userID = rs.getInt("user_id");
			}

			String customerInfoQuery = "INSERT INTO user_customer (user_id, first_name, last_name, street_address, city_address, state_address, email_address)"
					+ "VALUES (?,?,?,?,?,?,?)";
			PreparedStatement stmt3 = conn.prepareStatement(customerInfoQuery);
			stmt3.setInt(1, userID);
			stmt3.setString(2, firstName);
			stmt3.setString(3, lastName);
			stmt3.setString(4, customerStreetAddress);
			stmt3.setString(5, customerCityAddress);
			stmt3.setString(6, customerStateAddress);
			stmt3.setString(7, customerEmailAddress);
			stmt3.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Helper method to check if username is already in use
	// this method will check if the username entered in registration phases is
	// already in use and in database. If the username is already in use, this
	// method will return false meaning the username is invalid because it's already
	// in use.
	public static boolean checkUsername(String userName) {
		boolean isValidUserName = false;
		try (Connection conn = DatabaseConnect.getConnection()) {
			String query = "SELECT * FROM user WHERE username = ?";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, userName);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) { // if rs.next() is true, it means username is already in use
				isValidUserName = false;
			} else {
				isValidUserName = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isValidUserName;
	}

	// Helper method that has inner class EmailValidator that will validate the
	// format of the email
	public boolean validateEmail(String email) {
		class EmailValidator {

			private Pattern pattern;
			private Matcher matcher;

			private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
					+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

			EmailValidator() {
				pattern = Pattern.compile(EMAIL_PATTERN);
			}

			public boolean validate(final String hex) {

				matcher = pattern.matcher(hex);
				return matcher.matches();
			}
		}
		boolean isEmailValid = false;
		EmailValidator emailValidator = new EmailValidator();
		isEmailValid = emailValidator.validate(email);
		return isEmailValid;
	}


	// this method will get the current user's info from the database
	private void currentUser(String username, String password) {
		try (Connection conn = DatabaseConnect.getConnection()) {
			String query = "SELECT * FROM user_customer JOIN user ON user.user_id = user_customer.user_id WHERE user.username= ?  AND user.password= ?";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, username);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				userID = rs.getInt("user_id");
				firstName = rs.getString("first_name");
				lastName = rs.getString("last_name");
				customerStreetAddress = rs.getString("street_address");
				customerCityAddress = rs.getString("city_address");
				customerStateAddress = rs.getString("state_address");
				customerEmailAddress = rs.getString("email_address");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// getters and setters
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

	public String getCustomerStreetAddress() {
		return customerStreetAddress;
	}

	public void setCustomerStreetAddress(String customerStreetAddress) {
		this.customerStreetAddress = customerStreetAddress;
	}

	public String getCustomerCityAddress() {
		return customerCityAddress;
	}

	public void setCustomerCityAddress(String customerCityAddress) {
		this.customerCityAddress = customerCityAddress;
	}

	public String getCustomerStateAddress() {
		return customerStateAddress;
	}

	public void setCustomerStateAddress(String customerStateAddress) {
		this.customerStateAddress = customerStateAddress;
	}

	public String getCustomerEmailAddress() {
		return customerEmailAddress;
	}

	public void setCustomerEmailAddress(String customerEmailAddress) {
		this.customerEmailAddress = customerEmailAddress;
	}

	@Override
	public void updateAccountInfo() {

	}

}
