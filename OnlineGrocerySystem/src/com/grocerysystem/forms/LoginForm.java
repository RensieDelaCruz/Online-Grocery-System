package com.grocerysystem.forms;

import com.grocerysystem.classes.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
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

public class LoginForm extends JFrame implements ActionListener {

	private JPanel titlePanel, loginPanel, logoPanel;
	private JLabel groceryName, groceryStore, dPIO, loginAs, userName, userPassword, AppLogoLabel;
	private JComboBox<String> userComboBox;
	private JTextField userTextBox;
	private JPasswordField passwordTextBox;
	private JButton loginButton, registerButton;
	private static User user;
	
	public LoginForm() {

		// register button
		registerButton = new JButton("Register");
		registerButton.setBounds(180, 300, 70, 20);
		registerButton.setBorder(null);
		registerButton.setBackground(Color.white);
		registerButton.setForeground(Color.blue);
		registerButton.setFocusable(false);
		registerButton.addActionListener(this);

		// login button
		loginButton = new JButton("Login");
		loginButton.setBounds(180, 230, 70, 20);
		loginButton.setFocusable(false);
		loginButton.addActionListener(this);

		// login input
		loginAs = new JLabel("Login as");
		loginAs.setBounds(120, 75, 100, 20);

		final String[] user = { "Customer", "Administrator" };
		userComboBox = new JComboBox<>(user);
		userComboBox.setBounds(175, 75, 110, 20);

		userName = new JLabel("Username");
		userName.setBounds(70, 150, 100, 20);
		userTextBox = new JTextField();
		userTextBox.setBounds(170, 150, 120, 20);

		userPassword = new JLabel("Password");
		userPassword.setBounds(70, 180, 100, 20);
		passwordTextBox = new JPasswordField();
		passwordTextBox.setBounds(170, 180, 120, 20);

		// loginPanel
		loginPanel = new JPanel();
		loginPanel.setPreferredSize(new Dimension(450, 500));
		loginPanel.setBackground(Color.WHITE);
		loginPanel.setLayout(null);
		loginPanel.add(loginAs);
		loginPanel.add(userComboBox);
		loginPanel.add(userName);
		loginPanel.add(userTextBox);
		loginPanel.add(userPassword);
		loginPanel.add(passwordTextBox);
		loginPanel.add(loginButton);
		loginPanel.add(registerButton);

		// titleLabel
		groceryName = new JLabel("ORGANIC");
		groceryName.setFont(new Font("MV Boli", Font.BOLD, 50));
		groceryName.setBounds(20, 50, 300, 50);
		groceryStore = new JLabel("Grocery Store");
		groceryStore.setFont(new Font("MV Boli", Font.BOLD, 20));
		groceryStore.setBounds(60, 100, 300, 50);
		dPIO = new JLabel("\"Don't Panic, It's Organic\"");
		dPIO.setFont(new Font("MV Boli", Font.BOLD, 20));
		dPIO.setBounds(10, 350, 300, 50);

		// logoPanel
		ImageIcon AppLogo = new ImageIcon(getClass().getResource("/images/AppLogo.png"));
		AppLogo.setImage(AppLogo.getImage().getScaledInstance(180, 180, Image.SCALE_DEFAULT));
		AppLogoLabel = new JLabel(AppLogo);
		logoPanel = new JPanel();
		logoPanel.setBounds(40,150,200,200);
		logoPanel.setVisible(true);
		logoPanel.setBackground(new Color(200,100,100));
		logoPanel.add(AppLogoLabel);
		
		// titlePanel
		titlePanel = new JPanel();
		titlePanel.setPreferredSize(new Dimension(300, 100));
		titlePanel.setBackground(new Color(200, 100, 100));
		titlePanel.setLayout(null);
		titlePanel.add(groceryName);
		titlePanel.add(groceryStore);
		titlePanel.add(dPIO);
		titlePanel.add(logoPanel);

		// log-in frame
		ImageIcon mainIcon = new ImageIcon(getClass().getResource("/images/Cart Icon.jpg"));
		this.setTitle("Organic Grocery Store - Login");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(750, 500);
		this.setResizable(false);
		this.setIconImage(mainIcon.getImage());
		this.getContentPane().setBackground(new Color(200, 100, 100));
		this.setLayout(new BorderLayout());
		this.setVisible(true);

		this.add(loginPanel, BorderLayout.EAST);
		this.add(titlePanel, BorderLayout.WEST);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == loginButton) {
			if (userComboBox.getSelectedItem() == "Customer") {
				user = Customer.getInstance();
				boolean isCorrect = false;
				isCorrect = user.verifyLogin(userTextBox.getText(), String.valueOf(passwordTextBox.getPassword()));
				if (isCorrect) {
					user = Customer.getInstance();
					new MainForm(user);
					System.out.println(Customer.getInstance().getUserID());
					this.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Invalid username or password!", "Invalid",
							JOptionPane.ERROR_MESSAGE);
				}
			} else if (userComboBox.getSelectedItem() == "Administrator") {
				user = Administrator.getInstance();
				boolean isCorrect = false;
				isCorrect = user.verifyLogin(userTextBox.getText(), String.valueOf(passwordTextBox.getPassword()));
				if (isCorrect) {
					new MainForm(user).manageBttn.setVisible(true);
					System.out.println(Administrator.getInstance().getUserID());
					this.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Invalid username or password!", "Invalid",
							JOptionPane.ERROR_MESSAGE);
				}
			}
			System.out.println(user);
			Product.fetchProducts();
		}
		
		if(e.getSource() == registerButton) {
			this.dispose();
			RegistrationForm regform = new RegistrationForm();
		}

	}
	
	public static User getUser() {
		return LoginForm.user;
	}
	

}
