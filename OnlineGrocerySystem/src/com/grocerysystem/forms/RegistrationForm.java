package com.grocerysystem.forms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.grocerysystem.classes.Customer;

public class RegistrationForm extends JFrame implements ActionListener {

	private JPanel panel;
	private JLabel pageTitle, userName, userPassword, confirmPassword, firstName, lastName, streetAddress, city,
			emailAddress, stateLabel, invalidEmail, userAIU, passwordDM;
	private JTextField userTextBox, firstNameTextBox, lastNameTextBox, emailAddTextBox, streetAddTextBox, cityTextBox;
	private JPasswordField passwordTextBox, confirmTextBox;
	private JComboBox<String> stateComboBox;
	private JButton submitButton, cancelButton;
	private Customer customer = Customer.getInstance();

	public RegistrationForm() {

		// registration form
		// username label, textbox, and error label that will appear if the username is
		// already in use
		userName = new JLabel("Username");
		userName.setFont(new Font("Arial Black", Font.PLAIN, 13));
		userName.setBounds(20, 20, 120, 20);
		userTextBox = new JTextField();
		userTextBox.setBounds(150, 20, 120, 20);
		userAIU = new JLabel("User name is already in use!");
		userAIU.setBounds(290, 20, 180, 20);
		userAIU.setForeground(Color.red);
		userAIU.setVisible(false);

		// password label and textbox
		userPassword = new JLabel("Password");
		userPassword.setFont(new Font("Arial Black", Font.PLAIN, 13));
		userPassword.setBounds(20, 50, 120, 20);
		passwordTextBox = new JPasswordField();
		passwordTextBox.setBounds(150, 50, 120, 20);

		// confirm password label, textbox and error label
		// that will appear if the password and confirm password do not match
		confirmPassword = new JLabel("Confirm Password");
		confirmPassword.setFont(new Font("Arial Black", Font.PLAIN, 12));
		confirmPassword.setBounds(20, 80, 120, 20);
		confirmTextBox = new JPasswordField();
		confirmTextBox.setBounds(150, 80, 120, 20);
		passwordDM = new JLabel("Passwords do not match!");
		passwordDM.setBounds(290, 80, 180, 20);
		passwordDM.setForeground(Color.red);
		passwordDM.setVisible(false);

		// first name label and textbox
		firstName = new JLabel("First name");
		firstName.setFont(new Font("Arial Black", Font.PLAIN, 13));
		firstName.setBounds(20, 120, 120, 20);
		firstNameTextBox = new JTextField();
		firstNameTextBox.setBounds(105, 120, 120, 20);

		// last name label and textbox
		lastName = new JLabel("Last name");
		lastName.setFont(new Font("Arial Black", Font.PLAIN, 13));
		lastName.setBounds(240, 120, 120, 20);
		lastNameTextBox = new JTextField();
		lastNameTextBox.setBounds(325, 120, 120, 20);

		// email address label, textbox and error label that will appear if the email
		// address format is invalid
		emailAddress = new JLabel("Email address");
		emailAddress.setFont(new Font("Arial Black", Font.PLAIN, 13));
		emailAddress.setBounds(20, 150, 120, 20);
		emailAddTextBox = new JTextField();
		emailAddTextBox.setBounds(130, 150, 200, 20);
		invalidEmail = new JLabel("Please enter a valid email");
		invalidEmail.setFont(new Font("Arial Black", Font.PLAIN, 10));
		invalidEmail.setBounds(330, 150, 180, 20);
		invalidEmail.setForeground(Color.red);
		invalidEmail.setVisible(false);

		// street address label and textbox
		streetAddress = new JLabel("Street address");
		streetAddress.setFont(new Font("Arial Black", Font.PLAIN, 13));
		streetAddress.setBounds(20, 180, 120, 20);
		streetAddTextBox = new JTextField();
		streetAddTextBox.setBounds(130, 180, 200, 20);

		// city label and textbox
		city = new JLabel("City");
		city.setFont(new Font("Arial Black", Font.PLAIN, 13));
		city.setBounds(20, 210, 120, 20);
		cityTextBox = new JTextField();
		cityTextBox.setBounds(70, 210, 120, 20);

		// state label and combo box
		stateLabel = new JLabel("State");
		stateLabel.setBounds(220, 210, 120, 20);
		String[] state = { "NL", "PE", "NS", "NB", "QC", "ON", "MB", "SK", "AB", "BC", "YT", "NT", "NU" };
		stateComboBox = new JComboBox<String>(state);
		stateComboBox.setBounds(260, 210, 50, 20);

		// submit button
		submitButton = new JButton("Submit");
		submitButton.setFocusable(false);
		submitButton.setBounds(120, 260, 75, 20);
		submitButton.addActionListener(this);

		// cancel button
		cancelButton = new JButton("Cancel");
		cancelButton.setFocusable(false);
		cancelButton.setBounds(250, 260, 75, 20);
		cancelButton.addActionListener(this);

		// panel
		panel = new JPanel();
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(500, 300));
		panel.add(userName);
		panel.add(userTextBox);
		panel.add(userPassword);
		panel.add(userAIU);
		panel.add(passwordTextBox);
		panel.add(confirmPassword);
		panel.add(confirmTextBox);
		panel.add(passwordDM);
		panel.add(firstName);
		panel.add(firstNameTextBox);
		panel.add(lastName);
		panel.add(lastNameTextBox);
		panel.add(emailAddress);
		panel.add(emailAddTextBox);
		panel.add(invalidEmail);
		panel.add(streetAddress);
		panel.add(streetAddTextBox);
		panel.add(city);
		panel.add(cityTextBox);
		panel.add(stateLabel);
		panel.add(stateComboBox);
		panel.add(submitButton);
		panel.add(cancelButton);

		// pageTitle
		pageTitle = new JLabel("Create a new account");
		pageTitle.setFont(new Font("MV Boli", Font.BOLD, 30));

		// frame
		ImageIcon mainIcon = new ImageIcon("Cart Icon.jpg");
		this.setTitle("Organic Grocery Store - Register");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(500, 380);
		this.setResizable(false);
		this.setIconImage(mainIcon.getImage());
		this.getContentPane().setBackground(new Color(200, 100, 100));
		this.setLayout(new BorderLayout());
		this.setVisible(true);

		this.add(panel, BorderLayout.SOUTH);
		this.add(pageTitle, BorderLayout.NORTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == submitButton) {
			boolean uniqueUsername = false;
			boolean passwordMatch = false;
			boolean emailValid = false;
			boolean allFieldFilled= false;
			uniqueUsername = isUsernameUnique(); // call the helper method that will check username
			passwordMatch = isPasswordMatch(); // call the helper method that will check if the password and confirm password are match
			emailValid = isEmailValid(); // call helper method that will check validity of email address
			allFieldFilled = checkFields(); // call helper method that will make sure all the fields are filled\

			if(uniqueUsername && passwordMatch && emailValid && allFieldFilled) {
				customer.register(userTextBox.getText(), String.valueOf(passwordTextBox.getPassword()), 
						firstNameTextBox.getText(), lastNameTextBox.getText(), streetAddTextBox.getText(), 
						cityTextBox.getText(), String.valueOf(stateComboBox.getSelectedItem()), emailAddTextBox.getText());
				JOptionPane.showMessageDialog(null, "Registration Successful!", "Successful",
						JOptionPane.PLAIN_MESSAGE);
				this.dispose();
				LoginForm login = new LoginForm();
			}

		}
		
		// If the user wants to cancel registration and return to login page
		if (e.getSource() == cancelButton) {
			this.dispose();
			LoginForm main = new LoginForm();
		}

	}


	// Helper method that will call checkUsername() method in Customer Class
	// to check if the username is unique
	private boolean isUsernameUnique() {
		boolean uniqueUsername = false;
		uniqueUsername = Customer.checkUsername(userTextBox.getText());
		if (!uniqueUsername) {
			userAIU.setVisible(true);
		} else {
			userAIU.setVisible(false);
			uniqueUsername = true;
		}
		return uniqueUsername;
	}

	// Helper method that will check if the passwordTextBox and confirmTextBox are
	// match
	private boolean isPasswordMatch() {
		boolean passwordMatch = false;
		if (!((String.valueOf(passwordTextBox.getPassword())).equals((String.valueOf(confirmTextBox.getPassword()))))) {
			passwordDM.setVisible(true);
		} else {
			passwordDM.setVisible(false);
			passwordMatch = true;
		}
		return passwordMatch;

	}

	// Helper method that will call validateEmail() Customer Class
	// to check if the email is a valid email
	private boolean isEmailValid() {
		boolean validEmail = false;
		if (!(customer.validateEmail(emailAddTextBox.getText()))) {
			invalidEmail.setVisible(true);
		} else {
			invalidEmail.setVisible(false);
			validEmail = true;
		}
		return validEmail;
	}
	
	// Helper method to check if all the required fields are filled
	private boolean checkFields() {
		boolean areAllFieldFilled = false;
		if (userTextBox.getText().length() <= 0) {
			userName.setForeground(Color.red);
		} else {
			userName.setForeground(Color.black);}

		if (passwordTextBox.getPassword().length <= 0 || confirmTextBox.getPassword().length <= 0) {
			userPassword.setForeground(Color.red);
			confirmPassword.setForeground(Color.red);
		} else {
			userPassword.setForeground(Color.black);
			confirmPassword.setForeground(Color.black);
		}
		
		if(firstNameTextBox.getText().length() <= 0) {
			firstName.setForeground(Color.red);
		}else {
			firstName.setForeground(Color.black);
		}
		
		if(lastNameTextBox.getText().length() <= 0) {
			lastName.setForeground(Color.red);
		}else {
			lastName.setForeground(Color.black);
		}
		
		if(emailAddTextBox.getText().length() <= 0) {
			emailAddress.setForeground(Color.red);
		}else {
			emailAddress.setForeground(Color.black);
		}
		
		if(streetAddTextBox.getText().length() <= 0) {
			streetAddress.setForeground(Color.red);
		}else {
			streetAddress.setForeground(Color.black);
		}
		
		if(cityTextBox.getText().length() <= 0) {
			city.setForeground(Color.red);
		}else {
			city.setForeground(Color.black);
		}
		
		if(userTextBox.getText().length() > 0 && (passwordTextBox.getPassword().length > 0 || confirmTextBox.getPassword().length > 0) 
				&& firstNameTextBox.getText().length() > 0 && lastNameTextBox.getText().length() > 0 && emailAddTextBox.getText().length() > 0
				&& streetAddTextBox.getText().length() > 0 && cityTextBox.getText().length() > 0) {
			areAllFieldFilled = true;
		}
		
		return areAllFieldFilled;
	}

}// end of class
