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

public class EggPanel extends JPanel {

	JLabel whiteEggs30, whiteEggs12, brownEggs12, eggWhites, saltedDuckEggs, pickledEggs, plantBasedEgg;
	JLabel whiteEggs30Price, whiteEggs12Price, brownEggs12Price, eggWhitesPrice, saltedDuckEggsPrice, pickledEggsPrice,
			plantBasedEggPrice;
	JPanel whiteEggs30Panel, whiteEggs12Panel, brownEggs12Panel, eggWhitesPanel, saltedDuckEggsPanel, pickledEggsPanel,
			plantBasedEggPanel;
	JButton whiteEggs30Bttn, whiteEggs12Bttn, brownEggs12Bttn, eggWhitesBttn, saltedDuckEggsBttn, pickledEggsBttn,
			plantBasedEggBttn;
	List<Product> products = Product.getProductList();

	public EggPanel() {
		// Plant Based Eggs Button
		plantBasedEggBttn = new JButton("Add to Cart");
		plantBasedEggBttn.setVisible(true);
		plantBasedEggBttn.setFocusable(false);
		plantBasedEggBttn.setForeground(new Color(210, 105, 30));
		plantBasedEggBttn.setBackground(Color.white);
		plantBasedEggBttn.addActionListener(new ActionListener() {

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
							if (p.getProductName().equals("Plant Based Eggs")) {
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

		// Plant Based Eggs Icon, Label and Price
		ImageIcon plantBasedEggIcon = new ImageIcon(getClass().getResource("/images/PlantBasedEgg.jpg"));
		plantBasedEggIcon.setImage(plantBasedEggIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		plantBasedEgg = new JLabel("Plant Based Eggs");
		plantBasedEgg.setIcon(plantBasedEggIcon);
		plantBasedEgg.setHorizontalTextPosition(JLabel.CENTER);
		plantBasedEgg.setVerticalTextPosition(JLabel.BOTTOM);
		plantBasedEgg.setFont(new Font("Arial Black", Font.BOLD, 15));
		plantBasedEggPrice = new JLabel("$6.99/ea");

		// Plant Based Eggs Panel
		plantBasedEggPanel = new JPanel();
		plantBasedEggPanel.setVisible(true);
		plantBasedEggPanel.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		plantBasedEggPanel.setPreferredSize(new Dimension(200, 200));
		plantBasedEggPanel.add(plantBasedEgg);
		plantBasedEggPanel.add(plantBasedEggPrice);
		plantBasedEggPanel.add(plantBasedEggBttn);
		plantBasedEggPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));

		// Pickled Eggs Button
		pickledEggsBttn = new JButton("Add to Cart");
		pickledEggsBttn.setVisible(true);
		pickledEggsBttn.setFocusable(false);
		pickledEggsBttn.setForeground(new Color(210, 105, 30));
		pickledEggsBttn.setBackground(Color.white);
		pickledEggsBttn.addActionListener(new ActionListener() {

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
							if (p.getProductName().equals("Pickled Eggs")) {
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


		// Pickled Eggs Icon, Label and Price
		ImageIcon pickledEggsIcon = new ImageIcon(getClass().getResource("/images/PickledEggs.jpg"));
		pickledEggsIcon.setImage(pickledEggsIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		pickledEggs = new JLabel("Pickled Eggs");
		pickledEggs.setIcon(pickledEggsIcon);
		pickledEggs.setHorizontalTextPosition(JLabel.CENTER);
		pickledEggs.setVerticalTextPosition(JLabel.BOTTOM);
		pickledEggs.setFont(new Font("Arial Black", Font.BOLD, 15));
		pickledEggsPrice = new JLabel("$3.19/ea");

		// Pickled Eggs Panel
		pickledEggsPanel = new JPanel();
		pickledEggsPanel.setVisible(true);
		pickledEggsPanel.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		pickledEggsPanel.setPreferredSize(new Dimension(200, 200));
		pickledEggsPanel.add(pickledEggs);
		pickledEggsPanel.add(pickledEggsPrice);
		pickledEggsPanel.add(pickledEggsBttn);
		pickledEggsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));

		// Salted Duck Eggs Button
		saltedDuckEggsBttn = new JButton("Add to Cart");
		saltedDuckEggsBttn.setVisible(true);
		saltedDuckEggsBttn.setFocusable(false);
		saltedDuckEggsBttn.setForeground(new Color(210, 105, 30));
		saltedDuckEggsBttn.setBackground(Color.white);
		saltedDuckEggsBttn.addActionListener(new ActionListener() {

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
							if (p.getProductName().equals("Salted Duck Eggs")) {
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


		// Salted Duck Eggs Icon, Label and Price
		ImageIcon saltedDuckEggsIcon = new ImageIcon(getClass().getResource("/images/SaltedDuckEggs.jpg"));
		saltedDuckEggsIcon.setImage(saltedDuckEggsIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		saltedDuckEggs = new JLabel("Salted Duck Eggs");
		saltedDuckEggs.setIcon(saltedDuckEggsIcon);
		saltedDuckEggs.setHorizontalTextPosition(JLabel.CENTER);
		saltedDuckEggs.setVerticalTextPosition(JLabel.BOTTOM);
		saltedDuckEggs.setFont(new Font("Arial Black", Font.BOLD, 15));
		saltedDuckEggsPrice = new JLabel("$3.69/tray");

		// Salted Duck Eggs Panel
		saltedDuckEggsPanel = new JPanel();
		saltedDuckEggsPanel.setVisible(true);
		saltedDuckEggsPanel.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		saltedDuckEggsPanel.setPreferredSize(new Dimension(200, 200));
		saltedDuckEggsPanel.add(saltedDuckEggs);
		saltedDuckEggsPanel.add(saltedDuckEggsPrice);
		saltedDuckEggsPanel.add(saltedDuckEggsBttn);
		saltedDuckEggsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));

		// Egg Whites Button
		eggWhitesBttn = new JButton("Add to Cart");
		eggWhitesBttn.setVisible(true);
		eggWhitesBttn.setFocusable(false);
		eggWhitesBttn.setForeground(new Color(210, 105, 30));
		eggWhitesBttn.setBackground(Color.white);
		eggWhitesBttn.addActionListener(new ActionListener() {

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
							if (p.getProductName().equals("Egg Whites")) {
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


		// Egg Whites Icon, Label and Price
		ImageIcon eggWhitesIcon = new ImageIcon(getClass().getResource("/images/EggWhites.jpg"));
		eggWhitesIcon.setImage(eggWhitesIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		eggWhites = new JLabel("Egg Whites");
		eggWhites.setIcon(eggWhitesIcon);
		eggWhites.setHorizontalTextPosition(JLabel.CENTER);
		eggWhites.setVerticalTextPosition(JLabel.BOTTOM);
		eggWhites.setFont(new Font("Arial Black", Font.BOLD, 15));
		eggWhitesPrice = new JLabel("$3.99/ea");

		// Egg Whites Panel
		eggWhitesPanel = new JPanel();
		eggWhitesPanel.setVisible(true);
		eggWhitesPanel.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		eggWhitesPanel.setPreferredSize(new Dimension(200, 200));
		eggWhitesPanel.add(eggWhites);
		eggWhitesPanel.add(eggWhitesPrice);
		eggWhitesPanel.add(eggWhitesBttn);
		eggWhitesPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));

		// Brown Eggs 12 Button
		brownEggs12Bttn = new JButton("Add to Cart");
		brownEggs12Bttn.setVisible(true);
		brownEggs12Bttn.setFocusable(false);
		brownEggs12Bttn.setForeground(new Color(210, 105, 30));
		brownEggs12Bttn.setBackground(Color.white);
		brownEggs12Bttn.addActionListener(new ActionListener() {

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
							if (p.getProductName().equals("Brown Eggs, 12")) {
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

		// Brown Eggs 12 Icon, Label and Price
		ImageIcon brownEggs12Icon = new ImageIcon(getClass().getResource("/images/BrownEggs12.jpg"));
		brownEggs12Icon.setImage(brownEggs12Icon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		brownEggs12 = new JLabel("Brown Eggs, 12");
		brownEggs12.setIcon(brownEggs12Icon);
		brownEggs12.setHorizontalTextPosition(JLabel.CENTER);
		brownEggs12.setVerticalTextPosition(JLabel.BOTTOM);
		brownEggs12.setFont(new Font("Arial Black", Font.BOLD, 15));
		brownEggs12Price = new JLabel("$6.39/tray");

		// Brown Eggs 12 Panel
		brownEggs12Panel = new JPanel();
		brownEggs12Panel.setVisible(true);
		brownEggs12Panel.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		brownEggs12Panel.setPreferredSize(new Dimension(200, 200));
		brownEggs12Panel.add(brownEggs12);
		brownEggs12Panel.add(brownEggs12Price);
		brownEggs12Panel.add(brownEggs12Bttn);
		brownEggs12Panel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));

		// White Eggs 12 Button
		whiteEggs12Bttn = new JButton("Add to Cart");
		whiteEggs12Bttn.setVisible(true);
		whiteEggs12Bttn.setFocusable(false);
		whiteEggs12Bttn.setForeground(new Color(210, 105, 30));
		whiteEggs12Bttn.setBackground(Color.white);
		whiteEggs12Bttn.addActionListener(new ActionListener() {

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
							if (p.getProductName().equals("White Eggs, 12")) {
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

		// White Eggs 12 Icon, Label and Price
		ImageIcon whiteEggs12Icon = new ImageIcon(getClass().getResource("/images/WhiteEggs12.jpg"));
		whiteEggs12Icon.setImage(whiteEggs12Icon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		whiteEggs12 = new JLabel("White Eggs, 12");
		whiteEggs12.setIcon(whiteEggs12Icon);
		whiteEggs12.setHorizontalTextPosition(JLabel.CENTER);
		whiteEggs12.setVerticalTextPosition(JLabel.BOTTOM);
		whiteEggs12.setFont(new Font("Arial Black", Font.BOLD, 15));
		whiteEggs12Price = new JLabel("$3.49/tray");

		// White Eggs 12 Panel
		whiteEggs12Panel = new JPanel();
		whiteEggs12Panel.setVisible(true);
		whiteEggs12Panel.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		whiteEggs12Panel.setPreferredSize(new Dimension(200, 200));
		whiteEggs12Panel.add(whiteEggs12);
		whiteEggs12Panel.add(whiteEggs12Price);
		whiteEggs12Panel.add(whiteEggs12Bttn);
		whiteEggs12Panel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));

		// White Eggs 30 Button
		whiteEggs30Bttn = new JButton("Add to Cart");
		whiteEggs30Bttn.setVisible(true);
		whiteEggs30Bttn.setFocusable(false);
		whiteEggs30Bttn.setForeground(new Color(210, 105, 30));
		whiteEggs30Bttn.setBackground(Color.white);
		whiteEggs30Bttn.addActionListener(new ActionListener() {

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
							if (p.getProductName().equals("White Eggs, 30")) {
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

		// White Eggs 30 Icon, Label and Price
		ImageIcon whiteEggs30Icon = new ImageIcon(getClass().getResource("/images/WhiteEggs30.jpg"));
		whiteEggs30Icon.setImage(whiteEggs30Icon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		whiteEggs30 = new JLabel("White Eggs, 30");
		whiteEggs30.setIcon(whiteEggs30Icon);
		whiteEggs30.setHorizontalTextPosition(JLabel.CENTER);
		whiteEggs30.setVerticalTextPosition(JLabel.BOTTOM);
		whiteEggs30.setFont(new Font("Arial Black", Font.BOLD, 15));
		whiteEggs30Price = new JLabel("$8.99/tray");

		// White Eggs 30 Panel
		whiteEggs30Panel = new JPanel();
		whiteEggs30Panel.setVisible(true);
		whiteEggs30Panel.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		whiteEggs30Panel.setPreferredSize(new Dimension(200, 200));
		whiteEggs30Panel.add(whiteEggs30);
		whiteEggs30Panel.add(whiteEggs30Price);
		whiteEggs30Panel.add(whiteEggs30Bttn);
		whiteEggs30Panel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));

		// Egg Panel
		this.setVisible(true);
		this.setBackground(Color.white);
		this.setPreferredSize(new Dimension(100, 700));
		this.setLayout(new FlowLayout(FlowLayout.LEADING, 30, 30));

		this.add(whiteEggs30Panel);
		this.add(whiteEggs12Panel);
		this.add(brownEggs12Panel);
		this.add(eggWhitesPanel);
		this.add(saltedDuckEggsPanel);
		this.add(pickledEggsPanel);
		this.add(plantBasedEggPanel);
	}

}
