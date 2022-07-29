package com.grocerysystem.forms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.grocerysystem.classes.CashOnDelivery;
import com.grocerysystem.classes.CreditCard;
import com.grocerysystem.classes.Customer;
import com.grocerysystem.classes.Order;
import com.grocerysystem.classes.Payment;
import com.grocerysystem.classes.ProductsInCart;

public class CheckoutForm extends JFrame implements ItemListener, ActionListener {

	private JPanel centerPanel, creditCardPanel;
	private JLabel checkoutLabel, subTotalLabel, taxLabel, totalLabel, cartSummaryLabel, shippingAddressLabel,
			streetAddressLabel, cityLabel, postalLabel, stateLabel, phoneNumberLabel, paymentLabel, paymentMethodLabel,
			creditCardNumberLabel, expiryDateLabel, cvvLabel, nameOnCreditCardLabel;
	private JComboBox<String> stateComboBox;
	private JTextField streetAddTextBox, cityTextBox, postalTextBox, phoneTextbox, creditCardTexBox, expiryTextBox,
			cvvTextBox, nameTextBox;
	private JRadioButton creditCardButton, cashOnDeliveryButton;
	private ButtonGroup buttonGroup;
	private JButton checkOutButton, cancelButton;

	public CheckoutForm() {
		// cancel button
		cancelButton = new JButton("Cancel");
		cancelButton.setBackground(Color.white);
		cancelButton.setForeground(new Color(210, 105, 30));
		cancelButton.setFocusable(false);
		cancelButton.setBorder(BorderFactory.createEtchedBorder(20, Color.GRAY, Color.LIGHT_GRAY));
		cancelButton.setBounds(350, 570, 100, 20);
		cancelButton.addActionListener(this);

		// checkOutButton
		checkOutButton = new JButton("Checkout");
		checkOutButton.setBackground(Color.white);
		checkOutButton.setForeground(new Color(210, 105, 30));
		checkOutButton.setFocusable(false);
		checkOutButton.setBorder(BorderFactory.createEtchedBorder(20, Color.GRAY, Color.LIGHT_GRAY));
		checkOutButton.setBounds(220, 570, 100, 20);
		checkOutButton.addActionListener(this);

		// Credit Card Label and textbox
		nameOnCreditCardLabel = new JLabel("Name on Credit Card");
		nameOnCreditCardLabel.setFont(new Font("Arial Black", Font.PLAIN, 15));
		nameOnCreditCardLabel.setBounds(10, 10, 200, 20);
		nameTextBox = new JTextField("John Doe");
		nameTextBox.setBounds(200, 10, 150, 20);
		creditCardNumberLabel = new JLabel("Credit Card Number");
		creditCardNumberLabel.setFont(new Font("Arial Black", Font.PLAIN, 15));
		creditCardNumberLabel.setBounds(10, 35, 200, 20);
		creditCardTexBox = new JTextField("0000000000000000");
		creditCardTexBox.setBounds(200, 35, 150, 20);
		expiryDateLabel = new JLabel("Expiry Date");
		expiryDateLabel.setFont(new Font("Arial Black", Font.PLAIN, 15));
		expiryDateLabel.setBounds(10, 60, 200, 20);
		expiryTextBox = new JTextField("MM/YY");
		expiryTextBox.setBounds(200, 60, 100, 20);
		cvvLabel = new JLabel("CVV");
		cvvLabel.setFont(new Font("Arial Black", Font.PLAIN, 15));
		cvvLabel.setBounds(10, 90, 200, 20);
		cvvTextBox = new JTextField();
		cvvTextBox.setBounds(200, 90, 50, 20);

		// Credit Card panel
		creditCardPanel = new JPanel();
		creditCardPanel.setPreferredSize(new Dimension(100, 100));
		creditCardPanel.setBounds(30, 430, 600, 120);
		creditCardPanel.setVisible(false);
		creditCardPanel.setBackground(Color.white);
		creditCardPanel.setLayout(null);
		creditCardPanel.add(nameOnCreditCardLabel);
		creditCardPanel.add(nameTextBox);
		creditCardPanel.add(creditCardNumberLabel);
		creditCardPanel.add(creditCardTexBox);
		creditCardPanel.add(expiryDateLabel);
		creditCardPanel.add(expiryTextBox);
		creditCardPanel.add(cvvLabel);
		creditCardPanel.add(cvvTextBox);

		// Payment Method labels and buttons
		paymentMethodLabel = new JLabel("Choose a Payment Method");
		paymentMethodLabel.setFont(new Font("Arial Black", Font.PLAIN, 15));
		paymentMethodLabel.setBounds(30, 390, 250, 20);
		creditCardButton = new JRadioButton("Credit Card");
		creditCardButton.setFont(new Font("Arial Black", Font.PLAIN, 15));
		creditCardButton.setBounds(300, 390, 150, 20);
		creditCardButton.setFocusable(false);
		creditCardButton.setBackground(null);
		creditCardButton.addItemListener(this);
		creditCardButton.setActionCommand("Credit Card");
		cashOnDeliveryButton = new JRadioButton("Cash on Delivery");
		cashOnDeliveryButton.setFont(new Font("Arial Black", Font.PLAIN, 15));
		cashOnDeliveryButton.setBounds(450, 390, 200, 20);
		cashOnDeliveryButton.setFocusable(false);
		cashOnDeliveryButton.setBackground(null);
		cashOnDeliveryButton.addItemListener(this);
		cashOnDeliveryButton.setActionCommand("Cash On Delivery");
		buttonGroup = new ButtonGroup();
		buttonGroup.add(creditCardButton);
		buttonGroup.add(cashOnDeliveryButton);

		// Payment Label
		paymentLabel = new JLabel("Payment");
		paymentLabel.setFont(new Font("Arial Black", Font.BOLD, 20));
		paymentLabel.setForeground(new Color(139, 69, 19));
		paymentLabel.setBounds(30, 340, 150, 50);

		// Address Form
		streetAddressLabel = new JLabel("Street Address");
		streetAddressLabel.setFont(new Font("Arial Black", Font.PLAIN, 15));
		streetAddressLabel.setBounds(30, 210, 150, 15);
		streetAddTextBox = new JTextField();
		streetAddTextBox.setBounds(160, 205, 200, 20);
		cityLabel = new JLabel("City");
		cityLabel.setFont(new Font("Arial Black", Font.PLAIN, 15));
		cityLabel.setBounds(30, 235, 150, 20);
		cityTextBox = new JTextField();
		cityTextBox.setBounds(70, 235, 200, 20);
		postalLabel = new JLabel("Postal Code");
		postalLabel.setFont(new Font("Arial Black", Font.PLAIN, 15));
		postalLabel.setBounds(30, 268, 150, 15);
		postalTextBox = new JTextField();
		postalTextBox.setBounds(140, 265, 150, 20);
		stateLabel = new JLabel("State");
		stateLabel.setFont(new Font("Arial Black", Font.PLAIN, 15));
		stateLabel.setBounds(450, 240, 150, 15);
		String[] state = { "NL", "PE", "NS", "NB", "QC", "ON", "MB", "SK", "AB", "BC", "YT", "NT", "NU" };
		stateComboBox = new JComboBox<String>(state);
		stateComboBox.setBounds(500, 238, 50, 20);
		phoneNumberLabel = new JLabel("Phone Number");
		phoneNumberLabel.setFont(new Font("Arial Black", Font.PLAIN, 15));
		phoneNumberLabel.setBounds(30, 303, 150, 15);
		phoneTextbox = new JTextField();
		phoneTextbox.setBounds(160, 300, 200, 20);

		// Shipping Address Label
		shippingAddressLabel = new JLabel("Shipping Address");
		shippingAddressLabel.setFont(new Font("Arial Black", Font.BOLD, 20));
		shippingAddressLabel.setForeground(new Color(139, 69, 19));
		shippingAddressLabel.setBounds(30, 160, 200, 50);

		// CartSummary, Subtotal, Tax and Total Label
		cartSummaryLabel = new JLabel("Cart Summary: " + ProductsInCart.getTotalItemsInCart() + " Items");
		cartSummaryLabel.setFont(new Font("Arial Black", Font.BOLD, 15));
		cartSummaryLabel.setBounds(30, 60, 250, 18);
		subTotalLabel = new JLabel("Subtotal: " + String.format("%.2f", ProductsInCart.getCartSubtotal()));
		subTotalLabel.setFont(new Font("Arial Black", Font.BOLD, 15));
		subTotalLabel.setBounds(30, 85, 200, 18);
		taxLabel = new JLabel("Tax: " + String.format("%.2f", ProductsInCart.getCalculatedTax()));
		taxLabel.setFont(new Font("Arial Black", Font.BOLD, 15));
		taxLabel.setBounds(30, 110, 200, 18);
		totalLabel = new JLabel("Total: "
				+ String.format("%.2f", ProductsInCart.getCalculatedTax() + ProductsInCart.getCartSubtotal()));
		totalLabel.setFont(new Font("Arial Black", Font.BOLD, 15));
		totalLabel.setBounds(30, 135, 200, 18);

		// Checkout Label
		checkoutLabel = new JLabel("Checkout");
		checkoutLabel.setFont(new Font("Arial Black", Font.BOLD, 20));
		checkoutLabel.setForeground(new Color(139, 69, 19));
		checkoutLabel.setBounds(30, 10, 150, 50);

		// Center Panel
		centerPanel = new JPanel();
		centerPanel.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
		centerPanel.setBackground(Color.WHITE);
		centerPanel.setLayout(null);
		centerPanel.add(checkoutLabel);
		centerPanel.add(cartSummaryLabel);
		centerPanel.add(subTotalLabel);
		centerPanel.add(taxLabel);
		centerPanel.add(totalLabel);
		centerPanel.add(shippingAddressLabel);
		centerPanel.add(streetAddressLabel);
		centerPanel.add(streetAddTextBox);
		centerPanel.add(cityLabel);
		centerPanel.add(cityTextBox);
		centerPanel.add(postalLabel);
		centerPanel.add(postalTextBox);
		centerPanel.add(stateLabel);
		centerPanel.add(stateComboBox);
		centerPanel.add(phoneNumberLabel);
		centerPanel.add(phoneTextbox);
		centerPanel.add(paymentLabel);
		centerPanel.add(paymentMethodLabel);
		centerPanel.add(creditCardButton);
		centerPanel.add(cashOnDeliveryButton);
		centerPanel.add(creditCardPanel);
		centerPanel.add(checkOutButton);
		centerPanel.add(cancelButton);

		// Checkout Frame
		ImageIcon mainIcon = new ImageIcon(getClass().getResource("/images/Cart Icon.jpg"));
		this.setTitle("Organic Grocery Store - Checkout");
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setSize(700, 700);
		this.setResizable(false);
		this.setIconImage(mainIcon.getImage());
		this.getContentPane().setBackground(new Color(200, 100, 100));
		this.setLayout(new BorderLayout(30, 10));
		this.setVisible(true);
		this.add(centerPanel);

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == creditCardButton) {
			if (e.getStateChange() == 1) {
				creditCardPanel.setVisible(true);
			}else
				creditCardPanel.setVisible(false);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == cancelButton) {
			this.setVisible(false);
			MainForm.getInstance().setVisible(true);
		}

		if (e.getSource() == checkOutButton) {
			boolean allFieldsFilled = checkFields();
			try {
				if (buttonGroup.getSelection().getActionCommand().equals("Credit Card")) {
					boolean isCreditCardValid = validateCreditCard();
					if (allFieldsFilled && isCreditCardValid) {
						Payment creditCard = new CreditCard(ProductsInCart.getTotalPrice(), nameTextBox.getText(),
								Long.parseLong(creditCardTexBox.getText()), expiryTextBox.getText(),
								Integer.parseInt(cvvTextBox.getText()));
						Order order = new Order(Customer.getInstance().getUserID(), ProductsInCart.getTotalPrice(),
								creditCard, ProductsInCart.getProductsInCart(), streetAddTextBox.getText(),
								cityTextBox.getText(), postalTextBox.getText(),
								stateComboBox.getSelectedItem().toString(), Long.parseLong(phoneTextbox.getText()),
								ProductsInCart.getTotalItemsInCart());
						order.checkout();
						JOptionPane.showMessageDialog(null, "Your Order has been placed!", "Successful",
								JOptionPane.PLAIN_MESSAGE);
						this.dispose();
						MainForm.getInstance().setVisible(true);
					}
				} else if (buttonGroup.getSelection().getActionCommand().equals("Cash On Delivery")) {
					if (allFieldsFilled){
						Payment cashOnDelivery = new CashOnDelivery(ProductsInCart.getTotalPrice());
						Order order = new Order(Customer.getInstance().getUserID(), ProductsInCart.getTotalPrice(),
								cashOnDelivery, ProductsInCart.getProductsInCart(), streetAddTextBox.getText(),
								cityTextBox.getText(), postalTextBox.getText(),
								stateComboBox.getSelectedItem().toString(), Long.parseLong(phoneTextbox.getText()),
								ProductsInCart.getTotalItemsInCart());
						order.checkout();
						JOptionPane.showMessageDialog(null, "Your Order has been placed!", "Successful",
								JOptionPane.PLAIN_MESSAGE);
						this.dispose();
						MainForm.getInstance().setVisible(true);
					}
				}

			} catch (NullPointerException ex) {
				paymentMethodLabel.setForeground(Color.red);
			}
		}

	}

	// helper method that will check if all the required field to checkout are all
	// filled. Returns true if all the fields are filled.
	private boolean checkFields() {
		boolean areAllFieldFilled = false;

		// If one of the textbox doesn't have any entry on it, the label of that textbox
		// will turn red meaning the user needs to enter a valid entry
		if (streetAddTextBox.getText().length() <= 0) {
			streetAddressLabel.setForeground(Color.red);
		} else {
			streetAddressLabel.setForeground(Color.black);
		}

		if (cityTextBox.getText().length() <= 0) {
			cityLabel.setForeground(Color.red);
		} else {
			cityLabel.setForeground(Color.black);
		}

		if (postalTextBox.getText().length() <= 0) {
			postalLabel.setForeground(Color.red);
		} else {
			postalLabel.setForeground(Color.black);
		}

		// I added a try-catch with this one because the user might enter something that
		// does not a number
		boolean isPhoneValid = false;
		try {
			if (phoneTextbox.getText().length() > 0) {
				phoneNumberLabel.setForeground(Color.black);
				Long.parseLong(phoneTextbox.getText());
				isPhoneValid = true;
			} else {
				phoneNumberLabel.setForeground(Color.red);
			}
		} catch (NumberFormatException ex) {
			phoneNumberLabel.setForeground(Color.red);
		}

		if (buttonGroup.getSelection() == null) {
			paymentMethodLabel.setForeground(Color.red);
		} else {
			paymentMethodLabel.setForeground(Color.black);
		}

		// if all the textboxes are filled, this method will return true
		if (streetAddTextBox.getText().length() > 0 && cityTextBox.getText().length() > 0
				&& postalTextBox.getText().length() > 0 && isPhoneValid
				&& buttonGroup.getSelection() != null)
			areAllFieldFilled = true;
		return areAllFieldFilled;

	}

	// helper method to validate credit card. Returns true if the inputs on credit
	// card are valid
	private boolean validateCreditCard() {
		boolean isCreditCardValid = false;
		boolean isNameValid = false;
		boolean isCreditCardNumberValid = false;
		boolean isCreditCardExpDateValid = false;
		boolean isCreditCardCVVValid = false;

		// checking if the user entered a name in the credit card name textbox
		// If invalid, the Name on Credit card label will turn red meaning the user
		// needs to enter a valid one.
		if (nameTextBox.getText().length() > 0) {
			isNameValid = true;
			nameOnCreditCardLabel.setForeground(Color.black);
		} else
			nameOnCreditCardLabel.setForeground(Color.red);

		// checking if the user entered a valid credit card number. Might throw an
		// exception if the user enter a string instead of a long.
		// If invalid, the Credit Card Number label will turn red meaning the user
		// needs to enter a valid one.
		try {
			isCreditCardNumberValid = CreditCard.validateCreditCardNumber(Long.parseLong(creditCardTexBox.getText()));
			if (!isCreditCardNumberValid) {
				creditCardNumberLabel.setForeground(Color.red);
			} else
				creditCardNumberLabel.setForeground(Color.black);
		} catch (NumberFormatException ex) {
			creditCardNumberLabel.setForeground(Color.red);
		}

		// checking if the user entered a valid credit card expiry date in format
		// "MM/YY".
		// If invalid, the Credit Card Expiry Date label will turn red meaning the user
		// needs to enter a valid one.
		isCreditCardExpDateValid = CreditCard.validateCardExpiryDate(expiryTextBox.getText());
		if (!isCreditCardExpDateValid) {
			expiryDateLabel.setForeground(Color.red);
		} else
			expiryDateLabel.setForeground(Color.black);

		// checking if the user entered a valid CVV number.
		// If invalid, the Credit Card CVV label will turn red meaning the user
		// needs to enter a valid one.
		isCreditCardCVVValid = CreditCard.validateCVVNumber(cvvTextBox.getText());
		if (!isCreditCardCVVValid) {
			cvvLabel.setForeground(Color.red);
		} else
			cvvLabel.setForeground(Color.black);

		// if all the entries are valid, this method will return true.
		if (isNameValid && isCreditCardNumberValid && isCreditCardExpDateValid && isCreditCardCVVValid)
			isCreditCardCVVValid = true;
		return isCreditCardValid;
	}

}
