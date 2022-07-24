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

public class DairyPanel extends JPanel {
	
	JLabel saltedButter, unsaltedButter, margarine, milk2, skimMilk1, coffeeCream, cheddarCheese;
	JLabel saltedButterPrice, unsaltedButterPrice, margarinePrice, milk2Price, skimMilk1Price, coffeeCreamPrice, cheddarCheesePrice;
	JPanel saltedButterPanel, unsaltedButterPanel, margarinePanel, milk2Panel, skimMilk1Panel, coffeeCreamPanel, cheddarCheesePanel;
	JButton saltedButterBttn, unsaltedButterBttn, margarineBttn, milk2Bttn, skimMilk1Bttn, coffeeCreamBttn, cheddarCheeseBttn;
	List<Product> products = Product.getProductList();
	
	public DairyPanel() {
		// Cheddar Cheese Button
		cheddarCheeseBttn = new JButton("Add to Cart");
		cheddarCheeseBttn.setVisible(true);
		cheddarCheeseBttn.setFocusable(false);
		cheddarCheeseBttn.setForeground(new Color(210, 105, 30));
		cheddarCheeseBttn.setBackground(Color.white);
		cheddarCheeseBttn.addActionListener(new ActionListener() {

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
							if (p.getProductName().equals("Cheddar Cheese")) {
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

		// Cheddar Cheese Icon, Label and Price
		ImageIcon cheddarCheeseIcon = new ImageIcon(getClass().getResource("/images/CheddarCheese.jpg"));
		cheddarCheeseIcon.setImage(cheddarCheeseIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		cheddarCheese = new JLabel("Cheddar Cheese");
		cheddarCheese.setIcon(cheddarCheeseIcon);
		cheddarCheese.setHorizontalTextPosition(JLabel.CENTER);
		cheddarCheese.setVerticalTextPosition(JLabel.BOTTOM);
		cheddarCheese.setFont(new Font("Arial Black", Font.BOLD, 15));
		cheddarCheesePrice = new JLabel("$7.49/ea");

		// Cheddar Cheese Panel
		cheddarCheesePanel = new JPanel();
		cheddarCheesePanel.setVisible(true);
		cheddarCheesePanel.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		cheddarCheesePanel.setPreferredSize(new Dimension(200, 200));
		cheddarCheesePanel.add(cheddarCheese);
		cheddarCheesePanel.add(cheddarCheesePrice);
		cheddarCheesePanel.add(cheddarCheeseBttn);
		cheddarCheesePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));
		
		// Coffee Cream Button
		coffeeCreamBttn = new JButton("Add to Cart");
		coffeeCreamBttn.setVisible(true);
		coffeeCreamBttn.setFocusable(false);
		coffeeCreamBttn.setForeground(new Color(210, 105, 30));
		coffeeCreamBttn.setBackground(Color.white);
		coffeeCreamBttn.addActionListener(new ActionListener() {

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
							if (p.getProductName().equals("Coffee Cream")) {
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

		// Coffee Cream Icon, Label and Price
		ImageIcon coffeeCreamIcon = new ImageIcon(getClass().getResource("/images/CoffeeCream.jpg"));
		coffeeCreamIcon.setImage(coffeeCreamIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		coffeeCream = new JLabel("Coffee Cream");
		coffeeCream.setIcon(coffeeCreamIcon);
		coffeeCream.setHorizontalTextPosition(JLabel.CENTER);
		coffeeCream.setVerticalTextPosition(JLabel.BOTTOM);
		coffeeCream.setFont(new Font("Arial Black", Font.BOLD, 15));
		coffeeCreamPrice = new JLabel("$3.19/ea");

		// Coffee Cream Panel
		coffeeCreamPanel = new JPanel();
		coffeeCreamPanel.setVisible(true);
		coffeeCreamPanel.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		coffeeCreamPanel.setPreferredSize(new Dimension(200, 200));
		coffeeCreamPanel.add(coffeeCream);
		coffeeCreamPanel.add(coffeeCreamPrice);
		coffeeCreamPanel.add(coffeeCreamBttn);
		coffeeCreamPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));
		
		// 1% Skim Milk Button
		skimMilk1Bttn = new JButton("Add to Cart");
		skimMilk1Bttn.setVisible(true);
		skimMilk1Bttn.setFocusable(false);
		skimMilk1Bttn.setForeground(new Color(210, 105, 30));
		skimMilk1Bttn.setBackground(Color.white);
		skimMilk1Bttn.addActionListener(new ActionListener() {

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
							if (p.getProductName().equals("1% Skim Milk")) {
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

		// 1% Skim Milk Icon, Label and Price
		ImageIcon skimMilk1Icon = new ImageIcon(getClass().getResource("/images/SkimMilk1%.jpg"));
		skimMilk1Icon.setImage(skimMilk1Icon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		skimMilk1 = new JLabel("1% Skim Milk");
		skimMilk1.setIcon(skimMilk1Icon);
		skimMilk1.setHorizontalTextPosition(JLabel.CENTER);
		skimMilk1.setVerticalTextPosition(JLabel.BOTTOM);
		skimMilk1.setFont(new Font("Arial Black", Font.BOLD, 15));
		skimMilk1Price = new JLabel("$1.87/ea");

		// 1% Skim Milk Panel
		skimMilk1Panel = new JPanel();
		skimMilk1Panel.setVisible(true);
		skimMilk1Panel.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		skimMilk1Panel.setPreferredSize(new Dimension(200, 200));
		skimMilk1Panel.add(skimMilk1);
		skimMilk1Panel.add(skimMilk1Price);
		skimMilk1Panel.add(skimMilk1Bttn);
		skimMilk1Panel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));
		
		// 2% Milk Button
		milk2Bttn = new JButton("Add to Cart");
		milk2Bttn.setVisible(true);
		milk2Bttn.setFocusable(false);
		milk2Bttn.setForeground(new Color(210, 105, 30));
		milk2Bttn.setBackground(Color.white);
		milk2Bttn.addActionListener(new ActionListener() {

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
							if (p.getProductName().equals("2% Milk")) {
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

		// 2% Milk Icon, Label and Price
		ImageIcon milk2Icon = new ImageIcon(getClass().getResource("/images/Milk2%.jpg"));
		milk2Icon.setImage(milk2Icon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		milk2 = new JLabel("2% Milk");
		milk2.setIcon(milk2Icon);
		milk2.setHorizontalTextPosition(JLabel.CENTER);
		milk2.setVerticalTextPosition(JLabel.BOTTOM);
		milk2.setFont(new Font("Arial Black", Font.BOLD, 15));
		milk2Price = new JLabel("$1.93/ea");

		// 2% Milk Panel
		milk2Panel = new JPanel();
		milk2Panel.setVisible(true);
		milk2Panel.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		milk2Panel.setPreferredSize(new Dimension(200, 200));
		milk2Panel.add(milk2);
		milk2Panel.add(milk2Price);
		milk2Panel.add(milk2Bttn);
		milk2Panel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));
		
		// Margarine Button
		margarineBttn = new JButton("Add to Cart");
		margarineBttn.setVisible(true);
		margarineBttn.setFocusable(false);
		margarineBttn.setForeground(new Color(210, 105, 30));
		margarineBttn.setBackground(Color.white);
		margarineBttn.addActionListener(new ActionListener() {

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
							if (p.getProductName().equals("Margarine")) {
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

		// Margarine Icon, Label and Price
		ImageIcon margarineIcon = new ImageIcon(getClass().getResource("/images/Margarine.jpg"));
		margarineIcon.setImage(margarineIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		margarine = new JLabel("Margarine");
		margarine.setIcon(margarineIcon);
		margarine.setHorizontalTextPosition(JLabel.CENTER);
		margarine.setVerticalTextPosition(JLabel.BOTTOM);
		margarine.setFont(new Font("Arial Black", Font.BOLD, 15));
		margarinePrice = new JLabel("$4.29/ea");

		// Margarine Panel
		margarinePanel = new JPanel();
		margarinePanel.setVisible(true);
		margarinePanel.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		margarinePanel.setPreferredSize(new Dimension(200, 200));
		margarinePanel.add(margarine);
		margarinePanel.add(margarinePrice);
		margarinePanel.add(margarineBttn);
		margarinePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));
		
		// Unsalted Butter Button
		unsaltedButterBttn = new JButton("Add to Cart");
		unsaltedButterBttn.setVisible(true);
		unsaltedButterBttn.setFocusable(false);
		unsaltedButterBttn.setForeground(new Color(210, 105, 30));
		unsaltedButterBttn.setBackground(Color.white);
		unsaltedButterBttn.addActionListener(new ActionListener() {

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
							if (p.getProductName().equals("Unsalted Butter")) {
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


		// Unsalted Butter Icon, Label and Price
		ImageIcon unsaltedButterIcon = new ImageIcon(getClass().getResource("/images/UnsaltedButter.jpg"));
		unsaltedButterIcon.setImage(unsaltedButterIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		unsaltedButter = new JLabel("Unsalted Butter");
		unsaltedButter.setIcon(unsaltedButterIcon);
		unsaltedButter.setHorizontalTextPosition(JLabel.CENTER);
		unsaltedButter.setVerticalTextPosition(JLabel.BOTTOM);
		unsaltedButter.setFont(new Font("Arial Black", Font.BOLD, 15));
		unsaltedButterPrice = new JLabel("$7.29/ea");

		// Unsalted Butter Panel
		unsaltedButterPanel = new JPanel();
		unsaltedButterPanel.setVisible(true);
		unsaltedButterPanel.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		unsaltedButterPanel.setPreferredSize(new Dimension(200, 200));
		unsaltedButterPanel.add(unsaltedButter);
		unsaltedButterPanel.add(unsaltedButterPrice);
		unsaltedButterPanel.add(unsaltedButterBttn);
		unsaltedButterPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));
		
		// Salted Butter Button
		saltedButterBttn = new JButton("Add to Cart");
		saltedButterBttn.setVisible(true);
		saltedButterBttn.setFocusable(false);
		saltedButterBttn.setForeground(new Color(210, 105, 30));
		saltedButterBttn.setBackground(Color.white);
		saltedButterBttn.addActionListener(new ActionListener() {

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
							if (p.getProductName().equals("Salted Butter")) {
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

		// Salted Butter Icon, Label and Price
		ImageIcon saltedButterIcon = new ImageIcon(getClass().getResource("/images/SaltedButter.jpg"));
		saltedButterIcon.setImage(saltedButterIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		saltedButter = new JLabel("Salted Butter");
		saltedButter.setIcon(saltedButterIcon);
		saltedButter.setHorizontalTextPosition(JLabel.CENTER);
		saltedButter.setVerticalTextPosition(JLabel.BOTTOM);
		saltedButter.setFont(new Font("Arial Black", Font.BOLD, 15));
		saltedButterPrice = new JLabel("$6.99/ea");

		// Salted Butter Panel
		saltedButterPanel = new JPanel();
		saltedButterPanel.setVisible(true);
		saltedButterPanel.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		saltedButterPanel.setPreferredSize(new Dimension(200, 200));
		saltedButterPanel.add(saltedButter);
		saltedButterPanel.add(saltedButterPrice);
		saltedButterPanel.add(saltedButterBttn);
		saltedButterPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));
		
		// Dairy Panel
		this.setVisible(true);
		this.setBackground(Color.white);
		this.setPreferredSize(new Dimension(100, 700));
		this.setLayout(new FlowLayout(FlowLayout.LEADING, 30, 30));
		
		this.add(saltedButterPanel);
		this.add(unsaltedButterPanel);
		this.add(margarinePanel);
		this.add(milk2Panel);
		this.add(skimMilk1Panel);
		this.add(coffeeCreamPanel);
		this.add(cheddarCheesePanel);
	}

}
