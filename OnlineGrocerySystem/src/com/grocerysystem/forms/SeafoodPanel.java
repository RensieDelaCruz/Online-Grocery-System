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

public class SeafoodPanel extends JPanel {

	JLabel salmonFillets, halibutFillets, codFillets, ahiTuna, imitCrab, crustedCod, salmonPatties;
	JLabel salmonFilletsPrice, halibutFilletsPrice, codFilletsPrice, ahiTunaPrice, imitCrabPrice, crustedCodPrice,
			salmonPattiesPrice;
	JPanel salmonFilletsPanel, halibutFilletsPanel, codFilletsPanel, ahiTunaPanel, imitCrabPanel, crustedCodPanel,
			salmonPattiesPanel;
	JButton salmonFilletsBttn, halibutFilletsBttn, codFilletsBttn, ahiTunaBttn, imitCrabBttn, crustedCodBttn,
			salmonPattiesBttn;
	List<Product> products = Product.getProductList();

	public SeafoodPanel() {
		// Salmon PattiesButton
		salmonPattiesBttn = new JButton("Add to Cart");
		salmonPattiesBttn.setVisible(true);
		salmonPattiesBttn.setFocusable(false);
		salmonPattiesBttn.setForeground(new Color(210, 105, 30));
		salmonPattiesBttn.setBackground(Color.white);
		salmonPattiesBttn.addActionListener(new ActionListener() {

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
							if (p.getProductName().equals("Salmon Patties")) {
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

		// Salmon PattiesIcon, Label and Price
		ImageIcon salmonPattiesIcon = new ImageIcon(getClass().getResource("/images/SalmonPatties.jpg"));
		salmonPattiesIcon.setImage(salmonPattiesIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		salmonPatties = new JLabel("Salmon Patties");
		salmonPatties.setIcon(salmonPattiesIcon);
		salmonPatties.setHorizontalTextPosition(JLabel.CENTER);
		salmonPatties.setVerticalTextPosition(JLabel.BOTTOM);
		salmonPatties.setFont(new Font("Arial Black", Font.BOLD, 15));
		salmonPattiesPrice = new JLabel("$12.99/4pcs");

		// Salmon Patties Panel
		salmonPattiesPanel = new JPanel();
		salmonPattiesPanel.setVisible(true);
		salmonPattiesPanel.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		salmonPattiesPanel.setPreferredSize(new Dimension(200, 200));
		salmonPattiesPanel.add(salmonPatties);
		salmonPattiesPanel.add(salmonPattiesPrice);
		salmonPattiesPanel.add(salmonPattiesBttn);
		salmonPattiesPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));

		// Crusted Cod Button
		crustedCodBttn = new JButton("Add to Cart");
		crustedCodBttn.setVisible(true);
		crustedCodBttn.setFocusable(false);
		crustedCodBttn.setForeground(new Color(210, 105, 30));
		crustedCodBttn.setBackground(Color.white);
		crustedCodBttn.addActionListener(new ActionListener() {

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
							if (p.getProductName().equals("Crusted Cod")) {
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

		// Crusted Cod Icon, Label and Price
		ImageIcon crustedCodIcon = new ImageIcon(getClass().getResource("/images/CrustedCod.jpg"));
		crustedCodIcon.setImage(crustedCodIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		crustedCod = new JLabel("Crusted Cod");
		crustedCod.setIcon(crustedCodIcon);
		crustedCod.setHorizontalTextPosition(JLabel.CENTER);
		crustedCod.setVerticalTextPosition(JLabel.BOTTOM);
		crustedCod.setFont(new Font("Arial Black", Font.BOLD, 15));
		crustedCodPrice = new JLabel("$14.80/330g");

		// Crusted CodPanel
		crustedCodPanel = new JPanel();
		crustedCodPanel.setVisible(true);
		crustedCodPanel.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		crustedCodPanel.setPreferredSize(new Dimension(200, 200));
		crustedCodPanel.add(crustedCod);
		crustedCodPanel.add(crustedCodPrice);
		crustedCodPanel.add(crustedCodBttn);
		crustedCodPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));

		// Imitation Crab Button
		imitCrabBttn = new JButton("Add to Cart");
		imitCrabBttn.setVisible(true);
		imitCrabBttn.setFocusable(false);
		imitCrabBttn.setForeground(new Color(210, 105, 30));
		imitCrabBttn.setBackground(Color.white);
		imitCrabBttn.addActionListener(new ActionListener() {

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
							if (p.getProductName().equals("Imitation Crab")) {
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


		// Imitation Crab Icon, Label and Price
		ImageIcon imitCrabIcon = new ImageIcon(getClass().getResource("/images/ImitationCrab.jpg"));
		imitCrabIcon.setImage(imitCrabIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		imitCrab = new JLabel("Imitation Crab");
		imitCrab.setIcon(imitCrabIcon);
		imitCrab.setHorizontalTextPosition(JLabel.CENTER);
		imitCrab.setVerticalTextPosition(JLabel.BOTTOM);
		imitCrab.setFont(new Font("Arial Black", Font.BOLD, 15));
		imitCrabPrice = new JLabel("$6.15/325g");

		// Imitation Crab Panel
		imitCrabPanel = new JPanel();
		imitCrabPanel.setVisible(true);
		imitCrabPanel.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		imitCrabPanel.setPreferredSize(new Dimension(200, 200));
		imitCrabPanel.add(imitCrab);
		imitCrabPanel.add(imitCrabPrice);
		imitCrabPanel.add(imitCrabBttn);
		imitCrabPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));

		// Ahi Tuna Button
		ahiTunaBttn = new JButton("Add to Cart");
		ahiTunaBttn.setVisible(true);
		ahiTunaBttn.setFocusable(false);
		ahiTunaBttn.setForeground(new Color(210, 105, 30));
		ahiTunaBttn.setBackground(Color.white);
		ahiTunaBttn.addActionListener(new ActionListener() {

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
							if (p.getProductName().equals("Ahi Tuna")) {
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

		// Ahi Tuna Icon, Label and Price
		ImageIcon ahiTunaIcon = new ImageIcon(getClass().getResource("/images/AhiTuna.jpg"));
		ahiTunaIcon.setImage(ahiTunaIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		ahiTuna = new JLabel("Ahi Tuna");
		ahiTuna.setIcon(ahiTunaIcon);
		ahiTuna.setHorizontalTextPosition(JLabel.CENTER);
		ahiTuna.setVerticalTextPosition(JLabel.BOTTOM);
		ahiTuna.setFont(new Font("Arial Black", Font.BOLD, 15));
		ahiTunaPrice = new JLabel("$8.95/250g");

		// Ahi Tuna Panel
		ahiTunaPanel = new JPanel();
		ahiTunaPanel.setVisible(true);
		ahiTunaPanel.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		ahiTunaPanel.setPreferredSize(new Dimension(200, 200));
		ahiTunaPanel.add(ahiTuna);
		ahiTunaPanel.add(ahiTunaPrice);
		ahiTunaPanel.add(ahiTunaBttn);
		ahiTunaPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));

		// Cod Fillets Button
		codFilletsBttn = new JButton("Add to Cart");
		codFilletsBttn.setVisible(true);
		codFilletsBttn.setFocusable(false);
		codFilletsBttn.setForeground(new Color(210, 105, 30));
		codFilletsBttn.setBackground(Color.white);
		codFilletsBttn.addActionListener(new ActionListener() {

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
							if (p.getProductName().equals("Cod Fillets")) {
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

		// Cod Fillets Icon, Label and Price
		ImageIcon codFilletsIcon = new ImageIcon(getClass().getResource("/images/CodFillets.jpg"));
		codFilletsIcon.setImage(codFilletsIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		codFillets = new JLabel("Cod Fillets");
		codFillets.setIcon(codFilletsIcon);
		codFillets.setHorizontalTextPosition(JLabel.CENTER);
		codFillets.setVerticalTextPosition(JLabel.BOTTOM);
		codFillets.setFont(new Font("Arial Black", Font.BOLD, 15));
		codFilletsPrice = new JLabel("$5.24/150g");

		// Cod Fillets Panel
		codFilletsPanel = new JPanel();
		codFilletsPanel.setVisible(true);
		codFilletsPanel.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		codFilletsPanel.setPreferredSize(new Dimension(200, 200));
		codFilletsPanel.add(codFillets);
		codFilletsPanel.add(codFilletsPrice);
		codFilletsPanel.add(codFilletsBttn);
		codFilletsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));

		// Halibut Fillets Button
		halibutFilletsBttn = new JButton("Add to Cart");
		halibutFilletsBttn.setVisible(true);
		halibutFilletsBttn.setFocusable(false);
		halibutFilletsBttn.setForeground(new Color(210, 105, 30));
		halibutFilletsBttn.setBackground(Color.white);
		halibutFilletsBttn.addActionListener(new ActionListener() {

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
							if (p.getProductName().equals("Halibut Fillets")) {
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

		// halibutFillets Icon, Label and Price
		ImageIcon halibutFilletsIcon = new ImageIcon(getClass().getResource("/images/HalibutFillets.jpg"));
		halibutFilletsIcon.setImage(halibutFilletsIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		halibutFillets = new JLabel("Halibut Fillets");
		halibutFillets.setIcon(halibutFilletsIcon);
		halibutFillets.setHorizontalTextPosition(JLabel.CENTER);
		halibutFillets.setVerticalTextPosition(JLabel.BOTTOM);
		halibutFillets.setFont(new Font("Arial Black", Font.BOLD, 15));
		halibutFilletsPrice = new JLabel("$28.95/500g");

		// halibutFillets Panel
		halibutFilletsPanel = new JPanel();
		halibutFilletsPanel.setVisible(true);
		halibutFilletsPanel.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		halibutFilletsPanel.setPreferredSize(new Dimension(200, 200));
		halibutFilletsPanel.add(halibutFillets);
		halibutFilletsPanel.add(halibutFilletsPrice);
		halibutFilletsPanel.add(halibutFilletsBttn);
		halibutFilletsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));

		// Salmon Fillets Button
		salmonFilletsBttn = new JButton("Add to Cart");
		salmonFilletsBttn.setVisible(true);
		salmonFilletsBttn.setFocusable(false);
		salmonFilletsBttn.setForeground(new Color(210, 105, 30));
		salmonFilletsBttn.setBackground(Color.white);
		salmonFilletsBttn.addActionListener(new ActionListener() {

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
							if (p.getProductName().equals("Salmon Fillets")) {
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

		// salmonFillets Icon, Label and Price
		ImageIcon salmonFilletsIcon = new ImageIcon(getClass().getResource("/images/SalmonFillets.jpg"));
		salmonFilletsIcon.setImage(salmonFilletsIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		salmonFillets = new JLabel("Salmon Fillets");
		salmonFillets.setIcon(salmonFilletsIcon);
		salmonFillets.setHorizontalTextPosition(JLabel.CENTER);
		salmonFillets.setVerticalTextPosition(JLabel.BOTTOM);
		salmonFillets.setFont(new Font("Arial Black", Font.BOLD, 15));
		salmonFilletsPrice = new JLabel("$13.57/454g");

		// salmonFillets Panel
		salmonFilletsPanel = new JPanel();
		salmonFilletsPanel.setVisible(true);
		salmonFilletsPanel.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		salmonFilletsPanel.setPreferredSize(new Dimension(200, 200));
		salmonFilletsPanel.add(salmonFillets);
		salmonFilletsPanel.add(salmonFilletsPrice);
		salmonFilletsPanel.add(salmonFilletsBttn);
		salmonFilletsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));

		// Seafood Panel
		this.setVisible(true);
		this.setBackground(Color.white);
		this.setPreferredSize(new Dimension(100, 1200));
		this.setLayout(new FlowLayout(FlowLayout.LEADING, 30, 30));

		this.add(salmonFilletsPanel);
		this.add(halibutFilletsPanel);
		this.add(codFilletsPanel);
		this.add(ahiTunaPanel);
		this.add(imitCrabPanel);
		this.add(crustedCodPanel);
		this.add(salmonPattiesPanel);

	}

}
