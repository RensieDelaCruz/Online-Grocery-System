package com.grocerysystem.forms;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.grocerysystem.classes.Product;
import com.grocerysystem.classes.ProductsInCart;

public class MeatPanel extends JPanel {

	JLabel chickenBreast, groundBeef, groundPork, groundTurkey, ribeyeSteak, tenderloinSteak, wholeChicken;
	JLabel chickenBreastPrice, groundBeefPrice, groundPorkPrice, groundTurkeyPrice, ribeyeSteakPrice,
			tenderloinSteakPrice, wholeChickenPrice;
	JPanel chickenBreastPanel, groundBeefPanel, groundPorkPanel, groundTurkeyPanel, ribeyeSteakPanel,
			tenderloinSteakPanel, wholeChickenPanel;
	JButton chickenBreastBttn, groundBeefBttn, groundPorkBttn, groundTurkeyBttn, ribeyeSteakBttn, tenderloinSteakBttn,
			wholeChickenBttn;
	List<Product> products = Product.getProductList();

	public MeatPanel() {
		// Whole Chicken Button
		wholeChickenBttn = new JButton("Add to Cart");
		wholeChickenBttn.setVisible(true);
		wholeChickenBttn.setFocusable(false);
		wholeChickenBttn.setForeground(new Color(210, 105, 30));
		wholeChickenBttn.setBackground(Color.white);
		wholeChickenBttn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int qty = 0;
				String input = null;
				ProductsInCart pic = null;
				try {
					input = JOptionPane.showInputDialog(null, "Enter Quantity");
					if (input != null) {
						qty = Integer.parseInt(input);
						for (Product p : products) {
							if (p.getProductName().equals("Whole Chicken")) {
								pic = new ProductsInCart(p.getProductID(), p.getProductName(), p.getProductDepartment(),
										p.getProductPrice(), qty);
							}
						}
						ProductsInCart.addToCart(pic);
					}
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Please enter a valid Number", "Invalid",
							JOptionPane.ERROR_MESSAGE);

				}

			}
		});

		// Whole Chicken Icon, Label and Price
		ImageIcon wholeChickenIcon = new ImageIcon(getClass().getResource("/images/WholeChicken.jpg"));
		wholeChickenIcon.setImage(wholeChickenIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		wholeChicken = new JLabel("Whole Chicken");
		wholeChicken.setIcon(wholeChickenIcon);
		wholeChicken.setHorizontalTextPosition(JLabel.CENTER);
		wholeChicken.setVerticalTextPosition(JLabel.BOTTOM);
		wholeChicken.setFont(new Font("Arial Black", Font.BOLD, 15));
		wholeChickenPrice = new JLabel("$25.70/1.50kg");

		// Whole Chicken Panel
		wholeChickenPanel = new JPanel();
		wholeChickenPanel.setVisible(true);
		wholeChickenPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));
		wholeChickenPanel.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		wholeChickenPanel.setPreferredSize(new Dimension(200, 200));
		wholeChickenPanel.add(wholeChicken);
		wholeChickenPanel.add(wholeChickenPrice);
		wholeChickenPanel.add(wholeChickenBttn);

		// Tenderloin Steak Button
		tenderloinSteakBttn = new JButton("Add to Cart");
		tenderloinSteakBttn.setVisible(true);
		tenderloinSteakBttn.setFocusable(false);
		tenderloinSteakBttn.setForeground(new Color(210, 105, 30));
		tenderloinSteakBttn.setBackground(Color.white);
		tenderloinSteakBttn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int qty = 0;
				String input = null;
				ProductsInCart pic = null;
				try {
					input = JOptionPane.showInputDialog(null, "Enter Quantity");
					if (input != null) {
						qty = Integer.parseInt(input);
						for (Product p : products) {
							if (p.getProductName().equals("Tenderloin Steak")) {
								pic = new ProductsInCart(p.getProductID(), p.getProductName(), p.getProductDepartment(),
										p.getProductPrice(), qty);
							}
						}
						ProductsInCart.addToCart(pic);
					}
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Please enter a valid Number", "Invalid",
							JOptionPane.ERROR_MESSAGE);

				}

			}
		});

		// Tenderloin Steak Icon, Label and Price
		ImageIcon tenderloinSteakIcon = new ImageIcon(getClass().getResource("/images/TenderloinSteak.jpg"));
		tenderloinSteakIcon.setImage(tenderloinSteakIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		tenderloinSteak = new JLabel("Tenderloin Steak");
		tenderloinSteak.setIcon(tenderloinSteakIcon);
		tenderloinSteak.setHorizontalTextPosition(JLabel.CENTER);
		tenderloinSteak.setVerticalTextPosition(JLabel.BOTTOM);
		tenderloinSteak.setFont(new Font("Arial Black", Font.BOLD, 15));
		tenderloinSteakPrice = new JLabel("$21.60/400g");

		// Tenderloin Steak Panel
		tenderloinSteakPanel = new JPanel();
		tenderloinSteakPanel.setVisible(true);
		tenderloinSteakPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));
		tenderloinSteakPanel.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		tenderloinSteakPanel.setPreferredSize(new Dimension(200, 200));
		tenderloinSteakPanel.add(tenderloinSteak);
		tenderloinSteakPanel.add(tenderloinSteakPrice);
		tenderloinSteakPanel.add(tenderloinSteakBttn);

		// Ribeye Steak Button
		ribeyeSteakBttn = new JButton("Add to Cart");
		ribeyeSteakBttn.setVisible(true);
		ribeyeSteakBttn.setFocusable(false);
		ribeyeSteakBttn.setForeground(new Color(210, 105, 30));
		ribeyeSteakBttn.setBackground(Color.white);
		ribeyeSteakBttn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int qty = 0;
				String input = null;
				ProductsInCart pic = null;
				try {
					input = JOptionPane.showInputDialog(null, "Enter Quantity");
					if (input != null) {
						qty = Integer.parseInt(input);
						for (Product p : products) {
							if (p.getProductName().equals("Ribeye Steak")) {
								pic = new ProductsInCart(p.getProductID(), p.getProductName(), p.getProductDepartment(),
										p.getProductPrice(), qty);
							}
						}
						ProductsInCart.addToCart(pic);
					}
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Please enter a valid Number", "Invalid",
							JOptionPane.ERROR_MESSAGE);

				}

			}
		});

		// Ribeye Steak Icon, Label and Price
		ImageIcon ribeyeSteakIcon = new ImageIcon(getClass().getResource("/images/RibeyeSteak.jpg"));
		ribeyeSteakIcon.setImage(ribeyeSteakIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		ribeyeSteak = new JLabel("Ribeye Steak");
		ribeyeSteak.setIcon(ribeyeSteakIcon);
		ribeyeSteak.setHorizontalTextPosition(JLabel.CENTER);
		ribeyeSteak.setVerticalTextPosition(JLabel.BOTTOM);
		ribeyeSteak.setFont(new Font("Arial Black", Font.BOLD, 15));
		ribeyeSteakPrice = new JLabel("$21.16/300g");

		// Ribeye Steak Panel
		ribeyeSteakPanel = new JPanel();
		ribeyeSteakPanel.setVisible(true);
		ribeyeSteakPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));
		ribeyeSteakPanel.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		ribeyeSteakPanel.setPreferredSize(new Dimension(200, 200));
		ribeyeSteakPanel.add(ribeyeSteak);
		ribeyeSteakPanel.add(ribeyeSteakPrice);
		ribeyeSteakPanel.add(ribeyeSteakBttn);

		// Chicken Breast Button
		chickenBreastBttn = new JButton("Add to Cart");
		chickenBreastBttn.setVisible(true);
		chickenBreastBttn.setFocusable(false);
		chickenBreastBttn.setForeground(new Color(210, 105, 30));
		chickenBreastBttn.setBackground(Color.white);
		chickenBreastBttn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int qty = 0;
				String input = null;
				ProductsInCart pic = null;
				try {
					input = JOptionPane.showInputDialog(null, "Enter Quantity");
					if (input != null) {
						qty = Integer.parseInt(input);
						for (Product p : products) {
							if (p.getProductName().equals("Chicken Breast")) {
								pic = new ProductsInCart(p.getProductID(), p.getProductName(), p.getProductDepartment(),
										p.getProductPrice(), qty);
							}
						}
						ProductsInCart.addToCart(pic);
					}
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Please enter a valid Number", "Invalid",
							JOptionPane.ERROR_MESSAGE);

				}

			}
		});

		// Chicken Breast Icon, Label and Price
		ImageIcon chickenBreastIcon = new ImageIcon(getClass().getResource("/images/ChickenBreast.jpg"));
		chickenBreastIcon.setImage(chickenBreastIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		chickenBreast = new JLabel("Chicken Breast");
		chickenBreast.setIcon(chickenBreastIcon);
		chickenBreast.setHorizontalTextPosition(JLabel.CENTER);
		chickenBreast.setVerticalTextPosition(JLabel.BOTTOM);
		chickenBreast.setFont(new Font("Arial Black", Font.BOLD, 15));
		chickenBreastPrice = new JLabel("$14.97/850g");

		// Chicken Breast Panel
		chickenBreastPanel = new JPanel();
		chickenBreastPanel.setVisible(true);
		chickenBreastPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));
		chickenBreastPanel.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		chickenBreastPanel.setPreferredSize(new Dimension(200, 200));
		chickenBreastPanel.add(chickenBreast);
		chickenBreastPanel.add(chickenBreastPrice);
		chickenBreastPanel.add(chickenBreastBttn);

		// Ground Turkey Button
		groundTurkeyBttn = new JButton("Add to Cart");
		groundTurkeyBttn.setVisible(true);
		groundTurkeyBttn.setFocusable(false);
		groundTurkeyBttn.setForeground(new Color(210, 105, 30));
		groundTurkeyBttn.setBackground(Color.white);
		groundTurkeyBttn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int qty = 0;
				String input = null;
				ProductsInCart pic = null;
				try {
					input = JOptionPane.showInputDialog(null, "Enter Quantity");
					if (input != null) {
						qty = Integer.parseInt(input);
						for (Product p : products) {
							if (p.getProductName().equals("Ground Turkey")) {
								pic = new ProductsInCart(p.getProductID(), p.getProductName(), p.getProductDepartment(),
										p.getProductPrice(), qty);
							}
						}
						ProductsInCart.addToCart(pic);
					}
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Please enter a valid Number", "Invalid",
							JOptionPane.ERROR_MESSAGE);

				}

			}
		});

		// Ground Turkey Icon, Label and Price
		ImageIcon groundTurkeyIcon = new ImageIcon(getClass().getResource("/images/GroundTurkey.jpg"));
		groundTurkeyIcon.setImage(groundTurkeyIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		groundTurkey = new JLabel("Ground Turkey");
		groundTurkey.setIcon(groundTurkeyIcon);
		groundTurkey.setHorizontalTextPosition(JLabel.CENTER);
		groundTurkey.setVerticalTextPosition(JLabel.BOTTOM);
		groundTurkey.setFont(new Font("Arial Black", Font.BOLD, 15));
		groundTurkeyPrice = new JLabel("$6.19/469g");

		// Ground Turkey Panel
		groundTurkeyPanel = new JPanel();
		groundTurkeyPanel.setVisible(true);
		groundTurkeyPanel.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		groundTurkeyPanel.setPreferredSize(new Dimension(200, 200));
		groundTurkeyPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));
		groundTurkeyPanel.add(groundTurkey);
		groundTurkeyPanel.add(groundTurkeyPrice);
		groundTurkeyPanel.add(groundTurkeyBttn);

		// Ground Pork Button
		groundPorkBttn = new JButton("Add to Cart");
		groundPorkBttn.setVisible(true);
		groundPorkBttn.setFocusable(false);
		groundPorkBttn.setForeground(new Color(210, 105, 30));
		groundPorkBttn.setBackground(Color.white);
		groundPorkBttn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int qty = 0;
				String input = null;
				ProductsInCart pic = null;
				try {
					input = JOptionPane.showInputDialog(null, "Enter Quantity");
					if (input != null) {
						qty = Integer.parseInt(input);
						for (Product p : products) {
							if (p.getProductName().equals("Ground Pork")) {
								pic = new ProductsInCart(p.getProductID(), p.getProductName(), p.getProductDepartment(),
										p.getProductPrice(), qty);
							}
						}
						ProductsInCart.addToCart(pic);
					}
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Please enter a valid Number", "Invalid",
							JOptionPane.ERROR_MESSAGE);

				}

			}
		});

		// Ground Pork Icon, Label and Price
		ImageIcon groundPorkIcon = new ImageIcon(getClass().getResource("/images/GroundPork.jpg"));
		groundPorkIcon.setImage(groundPorkIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		groundPork = new JLabel("Ground Pork");
		groundPork.setIcon(groundPorkIcon);
		groundPork.setHorizontalTextPosition(JLabel.CENTER);
		groundPork.setVerticalTextPosition(JLabel.BOTTOM);
		groundPork.setFont(new Font("Arial Black", Font.BOLD, 15));
		groundPorkPrice = new JLabel("$6.19/469g");

		// Ground Pork Panel
		groundPorkPanel = new JPanel();
		groundPorkPanel.setVisible(true);
		groundPorkPanel.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		groundPorkPanel.setPreferredSize(new Dimension(200, 200));
		groundPorkPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));
		groundPorkPanel.add(groundPork);
		groundPorkPanel.add(groundPorkPrice);
		groundPorkPanel.add(groundPorkBttn);

		// Ground Beef Button
		groundBeefBttn = new JButton("Add to Cart");
		groundBeefBttn.setVisible(true);
		groundBeefBttn.setFocusable(false);
		groundBeefBttn.setForeground(new Color(210, 105, 30));
		groundBeefBttn.setBackground(Color.white);
		groundBeefBttn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int qty = 0;
				String input = null;
				ProductsInCart pic = null;
				try {
					input = JOptionPane.showInputDialog(null, "Enter Quantity");
					if (input != null) {
						qty = Integer.parseInt(input);
						for (Product p : products) {
							if (p.getProductName().equals("Ground Beef")) {
								pic = new ProductsInCart(p.getProductID(), p.getProductName(), p.getProductDepartment(),
										p.getProductPrice(), qty);
							}
						}
						ProductsInCart.addToCart(pic);
					}
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Please enter a valid Number", "Invalid",
							JOptionPane.ERROR_MESSAGE);

				}

			}
		});

		// GroundBeef Icon, Label and Price
		ImageIcon groundBeefIcon = new ImageIcon(getClass().getResource("/images/GroundBeef.jpg"));
		groundBeefIcon.setImage(groundBeefIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		groundBeef = new JLabel("Ground Beef");
		groundBeef.setIcon(groundBeefIcon);
		groundBeef.setHorizontalTextPosition(JLabel.CENTER);
		groundBeef.setVerticalTextPosition(JLabel.BOTTOM);
		groundBeef.setFont(new Font("Arial Black", Font.BOLD, 15));
		groundBeefPrice = new JLabel("$7.00/500g");

		// GroundBeef Panel
		groundBeefPanel = new JPanel();
		groundBeefPanel.setVisible(true);
		groundBeefPanel.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		groundBeefPanel.setPreferredSize(new Dimension(200, 200));
		groundBeefPanel.add(groundBeef);
		groundBeefPanel.add(groundBeefPrice);
		groundBeefPanel.add(groundBeefBttn);
		groundBeefPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));

		// Meat Panel
		this.setVisible(true);
		this.setBackground(Color.white);
		this.setPreferredSize(new Dimension(100, 1200));
		this.setLayout(new FlowLayout(FlowLayout.LEADING, 30, 30));

		this.add(groundBeefPanel);
		this.add(groundPorkPanel);
		this.add(groundTurkeyPanel);
		this.add(chickenBreastPanel);
		this.add(ribeyeSteakPanel);
		this.add(tenderloinSteakPanel);
		this.add(wholeChickenPanel);
	}

}
