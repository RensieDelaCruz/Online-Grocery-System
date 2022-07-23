package com.grocerysystem.forms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.grocerysystem.classes.ProductsInCart;

public class CheckoutForm extends JFrame implements ItemListener {

	private JPanel centerPanel, creditCardPanel;
	private JLabel checkoutLabel, subTotalLabel, taxLabel, totalLabel, cartSummaryLabel, shippingAddressLabel,
			streetAddressLabel, cityLabel, postalLabel, stateLabel, emailAddressLabel, paymentLabel, paymentMethodLabel,
			creditCardNumberLabel, expiryDateLabel, cvvLabel;
	private JComboBox<String> stateComboBox;
	private JTextField streetAddTextBox, cityTextBox, postalTextBox, emailTextbox, creditCardTexBox, expiryTextBox,
			cvvTextBox;
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
		cancelButton.setBounds(350, 550, 100, 20);
		
		// checkOutButton
		checkOutButton = new JButton("Checkout");
		checkOutButton.setBackground(Color.white);
		checkOutButton.setForeground(new Color(210, 105, 30));
		checkOutButton.setFocusable(false);
		checkOutButton.setBorder(BorderFactory.createEtchedBorder(20, Color.GRAY, Color.LIGHT_GRAY));
		checkOutButton.setBounds(220, 550, 100, 20);

		// Credit Card Label and textbox
		creditCardNumberLabel = new JLabel("Credit Card Number");
		creditCardNumberLabel.setFont(new Font("Arial Black", Font.PLAIN, 15));
		creditCardNumberLabel.setBounds(10, 10, 200, 20);
		creditCardTexBox = new JTextField("0000 000 0000 0000");
		creditCardTexBox.setBounds(180, 10, 200, 20);
		expiryDateLabel = new JLabel("Expiry Date");
		expiryDateLabel.setFont(new Font("Arial Black", Font.PLAIN, 15));
		expiryDateLabel.setBounds(10, 40, 200, 20);
		expiryTextBox = new JTextField("MM/YY");
		expiryTextBox.setBounds(180, 40, 100, 20);
		cvvLabel = new JLabel("CVV");
		cvvLabel.setFont(new Font("Arial Black", Font.PLAIN, 15));
		cvvLabel.setBounds(10, 70, 200, 20);
		cvvTextBox = new JTextField("000");
		cvvTextBox.setBounds(180, 70, 50, 20);

		// Credit Card panel
		creditCardPanel = new JPanel();
		creditCardPanel.setPreferredSize(new Dimension(100, 100));
		creditCardPanel.setBounds(30, 430, 600, 100);
		creditCardPanel.setVisible(false);
		creditCardPanel.setBackground(Color.white);
		creditCardPanel.setLayout(null);
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
		cashOnDeliveryButton = new JRadioButton("Cash on Delivery");
		cashOnDeliveryButton.setFont(new Font("Arial Black", Font.PLAIN, 15));
		cashOnDeliveryButton.setBounds(450, 390, 200, 20);
		cashOnDeliveryButton.setFocusable(false);
		cashOnDeliveryButton.setBackground(null);
		cashOnDeliveryButton.addItemListener(this);
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
		streetAddressLabel.setBounds(30, 230, 150, 15);
		streetAddTextBox = new JTextField();
		streetAddTextBox.setBounds(160, 225, 200, 20);
		cityLabel = new JLabel("City");
		cityLabel.setFont(new Font("Arial Black", Font.PLAIN, 15));
		cityLabel.setBounds(400, 225, 150, 20);
		cityTextBox = new JTextField();
		cityTextBox.setBounds(450, 225, 200, 20);
		postalLabel = new JLabel("Postal Code");
		postalLabel.setFont(new Font("Arial Black", Font.PLAIN, 15));
		postalLabel.setBounds(30, 265, 150, 15);
		postalTextBox = new JTextField();
		postalTextBox.setBounds(140, 260, 150, 20);
		stateLabel = new JLabel("State");
		stateLabel.setFont(new Font("Arial Black", Font.PLAIN, 15));
		stateLabel.setBounds(320, 263, 150, 15);
		String[] state = { "NL", "PE", "NS", "NB", "QC", "ON", "MB", "SK", "AB", "BC", "YT", "NT", "NU" };
		stateComboBox = new JComboBox<String>(state);
		stateComboBox.setBounds(370, 260, 50, 20);
		emailAddressLabel = new JLabel("Email Address");
		emailAddressLabel.setFont(new Font("Arial Black", Font.PLAIN, 15));
		emailAddressLabel.setBounds(30, 300, 150, 15);
		emailTextbox = new JTextField();
		emailTextbox.setBounds(160, 295, 200, 20);

		// Shipping Address Label
		shippingAddressLabel = new JLabel("Shipping Address");
		shippingAddressLabel.setFont(new Font("Arial Black", Font.BOLD, 20));
		shippingAddressLabel.setForeground(new Color(139, 69, 19));
		shippingAddressLabel.setBounds(30, 180, 200, 50);

		// CartSummary, Subtotal, Tax and Total Label
		cartSummaryLabel = new JLabel("Cart Summary: Items");
		cartSummaryLabel.setFont(new Font("Arial Black", Font.BOLD, 15));
		cartSummaryLabel.setBounds(30, 60, 200, 18);
		subTotalLabel = new JLabel("Subtotal: " + String.format("%.2f", ProductsInCart.getCartSubtotal()));
		subTotalLabel.setFont(new Font("Arial Black", Font.BOLD, 15));
		subTotalLabel.setBounds(30, 85, 200, 18);
		taxLabel = new JLabel("Tax: " + String.format("%.2f", ProductsInCart.getCalculatedTax()));
		taxLabel.setFont(new Font("Arial Black", Font.BOLD, 15));
		taxLabel.setBounds(30, 110, 200, 18);
		totalLabel = new JLabel("Total: " + String.format("%.2f", ProductsInCart.getCalculatedTax()));
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
		centerPanel.add(emailAddressLabel);
		centerPanel.add(emailTextbox);
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
}
