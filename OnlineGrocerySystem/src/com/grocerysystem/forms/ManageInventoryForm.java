package com.grocerysystem.forms;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import com.grocerysystem.classes.Administrator;
import com.grocerysystem.classes.Product;

public class ManageInventoryForm extends JFrame implements ItemListener, ActionListener, MouseListener {

	private JPanel headerPanel, centerPanel, tablePanel;
	private JLabel headerPanelLabel, departmentLabel, productID, productName, productPrice, productQuantity;
	private JComboBox<String> departmentComboBox;
	private JButton addBttn, updateBttn, removeBttn, closeBttn, resetBttn;
	private JTable productsTable;
	private JScrollPane productsScrollPane;
	private JTextField productIDTxt, productNameTxt, productPriceTxt, productQuantityTxt;
	private ProductsTableModel model = new ProductsTableModel();

	public ManageInventoryForm() {

		productsTable = new JTable(model);
		productsTable.addMouseListener(this);
		productsScrollPane = new JScrollPane(productsTable, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		tablePanel = new JPanel();
		tablePanel.setLayout(new BorderLayout());
		tablePanel.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
		tablePanel.setBackground(Color.WHITE);
		tablePanel.setBounds(20, 200, 940, 300);
		tablePanel.add(productsScrollPane, BorderLayout.CENTER);

		// Product name, price, quantity and in stock inputs.
		productID = new JLabel("Product ID");
		productID.setFont(new Font("Arial Black", Font.BOLD, 15));
		productID.setBounds(30, 80, 250, 18);
		productIDTxt = new JTextField();
		productIDTxt.setBounds(200, 80, 150, 18);
		productIDTxt.setEditable(false);
		productName = new JLabel("Product Name");
		productName.setFont(new Font("Arial Black", Font.BOLD, 15));
		productName.setBounds(30, 110, 250, 18);
		productNameTxt = new JTextField();
		productNameTxt.setBounds(200, 110, 150, 18);
		productPrice = new JLabel("Product Price");
		productPrice.setFont(new Font("Arial Black", Font.BOLD, 15));
		productPrice.setBounds(30, 140, 250, 18);
		productPriceTxt = new JTextField();
		productPriceTxt.setBounds(200, 140, 150, 18);
		productQuantity = new JLabel("Product Quantity");
		productQuantity.setFont(new Font("Arial Black", Font.BOLD, 15));
		productQuantity.setBounds(30, 170, 250, 18);
		productQuantityTxt = new JTextField();
		productQuantityTxt.setBounds(200, 170, 150, 18);

		// Add, Update, Remove and Close Buttons
		resetBttn = new JButton("Reset");
		resetBttn.setBackground(Color.white);
		resetBttn.setForeground(new Color(210, 105, 30));
		resetBttn.setFocusable(false);
		resetBttn.setBorder(BorderFactory.createEtchedBorder(20, Color.GRAY, Color.LIGHT_GRAY));
		resetBttn.setBounds(600, 160, 70, 30);
		resetBttn.addActionListener(this);

		removeBttn = new JButton("Remove");
		removeBttn.setBackground(Color.white);
		removeBttn.setForeground(new Color(210, 105, 30));
		removeBttn.setFocusable(false);
		removeBttn.setBorder(BorderFactory.createEtchedBorder(20, Color.GRAY, Color.LIGHT_GRAY));
		removeBttn.setBounds(600, 120, 70, 30);
		removeBttn.addActionListener(this);

		updateBttn = new JButton("Update");
		updateBttn.setBackground(Color.white);
		updateBttn.setForeground(new Color(210, 105, 30));
		updateBttn.setFocusable(false);
		updateBttn.setBorder(BorderFactory.createEtchedBorder(20, Color.GRAY, Color.LIGHT_GRAY));
		updateBttn.setBounds(600, 80, 70, 30);
		updateBttn.addActionListener(this);

		addBttn = new JButton("Add");
		addBttn.setBackground(Color.white);
		addBttn.setForeground(new Color(210, 105, 30));
		addBttn.setFocusable(false);
		addBttn.setBorder(BorderFactory.createEtchedBorder(20, Color.GRAY, Color.LIGHT_GRAY));
		addBttn.setBounds(600, 40, 70, 30);
		addBttn.addActionListener(this);

		closeBttn = new JButton("Close");
		closeBttn.setBackground(Color.white);
		closeBttn.setForeground(new Color(210, 105, 30));
		closeBttn.setFocusable(false);
		closeBttn.setBorder(BorderFactory.createEtchedBorder(20, Color.GRAY, Color.LIGHT_GRAY));
		closeBttn.setBounds(450, 520, 70, 20);
		closeBttn.addActionListener(this);

		// Department Label and Checkbox
		final String[] depts = new String[] { "Meats", "Seafoods", "Fruits", "Vegetables", "Dairies", "Eggs" };
		departmentComboBox = new JComboBox<>(depts);
		departmentComboBox.setBounds(140, 30, 100, 20);
		departmentComboBox.setFocusable(false);
		departmentComboBox.addItemListener(this);
		departmentLabel = new JLabel("Department");
		departmentLabel.setFont(new Font("Arial Black", Font.BOLD, 15));
		departmentLabel.setForeground(new Color(139, 69, 19));
		departmentLabel.setBounds(20, 30, 120, 20);

		// Center Panel
		centerPanel = new JPanel();
		centerPanel.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
		centerPanel.setBackground(Color.WHITE);
		centerPanel.setLayout(null);
		centerPanel.add(departmentLabel);
		centerPanel.add(departmentComboBox);
		centerPanel.add(addBttn);
		centerPanel.add(updateBttn);
		centerPanel.add(removeBttn);
		centerPanel.add(resetBttn);
		centerPanel.add(tablePanel);
		centerPanel.add(productID);
		centerPanel.add(productIDTxt);
		centerPanel.add(productName);
		centerPanel.add(productNameTxt);
		centerPanel.add(productPrice);
		centerPanel.add(productPriceTxt);
		centerPanel.add(productQuantity);
		centerPanel.add(productQuantityTxt);
		centerPanel.add(closeBttn);

		// Header Panel
		headerPanelLabel = new JLabel("Inventory Manager");
		headerPanelLabel.setFont(new Font("Arial Black", Font.BOLD, 25));
		headerPanelLabel.setForeground(new Color(139, 69, 19));

		headerPanel = new JPanel();
		headerPanel.setPreferredSize(new Dimension(100, 80));
		headerPanel.setVisible(true);
		headerPanel.setBackground(Color.white);
		headerPanel.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
		headerPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 30, 15));
		headerPanel.add(headerPanelLabel);

		// Manage inventory form
		ImageIcon mainIcon = new ImageIcon(getClass().getResource("/images/Cart Icon.jpg"));
		this.setTitle("Organic Grocery Store - Inventory Manager");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(1000, 700);
		this.setResizable(false);
		this.setIconImage(mainIcon.getImage());
		this.getContentPane().setBackground(new Color(200, 100, 100));
		this.setLayout(new BorderLayout(30, 10));
		this.setVisible(true);

		this.add(headerPanel, BorderLayout.NORTH);
		this.add(centerPanel, BorderLayout.CENTER);
	}

	// Entries in the table will change depending on what is selected on the
	// combobox
	@Override
	public void itemStateChanged(ItemEvent e) {

		JComboBox<String> selected = (JComboBox<String>) e.getItemSelectable();
		if (selected.getSelectedIndex() == 0) {
			model.updateTable(departmentComboBox.getSelectedItem().toString());
		}

		if (selected.getSelectedIndex() == 1) {
			model.updateTable(departmentComboBox.getSelectedItem().toString());
		}

		if (selected.getSelectedIndex() == 2) {
			model.updateTable(departmentComboBox.getSelectedItem().toString());
		}

		if (selected.getSelectedIndex() == 3) {
			model.updateTable(departmentComboBox.getSelectedItem().toString());
		}

		if (selected.getSelectedIndex() == 4) {
			model.updateTable(departmentComboBox.getSelectedItem().toString());
		}

		if (selected.getSelectedIndex() == 5) {
			model.updateTable(departmentComboBox.getSelectedItem().toString());
		}

	}

	// Actions that will happen once a button is pressed in the UI
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == closeBttn) {
			this.dispose();
			MainForm.getInstance().setVisible(true);
		}

		if (e.getSource() == addBttn) {
			if (validateInputs()) {
				Administrator.getInstance().addProduct(productNameTxt.getText(),
						departmentComboBox.getSelectedItem().toString(), Double.parseDouble(productPriceTxt.getText()),
						Integer.parseInt(productQuantityTxt.getText()));
				JOptionPane.showMessageDialog(null, "Product Added!", "Successful", JOptionPane.PLAIN_MESSAGE);
				Product.fetchProducts();
				model.updateTable(departmentComboBox.getSelectedItem().toString());

				productIDTxt.setText("");
				productNameTxt.setText("");
				productPriceTxt.setText("");
				productQuantityTxt.setText("");
			}
		}

		if (e.getSource() == updateBttn) {
			if (validateInputs()) {
				Administrator.getInstance().updateProduct(productNameTxt.getText(),
						Double.parseDouble(productPriceTxt.getText()), Integer.parseInt(productQuantityTxt.getText()),
						Integer.parseInt(productIDTxt.getText()));
				JOptionPane.showMessageDialog(null, "Product Updated!", "Successful", JOptionPane.PLAIN_MESSAGE);
				Product.fetchProducts();
				model.updateTable(departmentComboBox.getSelectedItem().toString());

				productIDTxt.setText("");
				productNameTxt.setText("");
				productPriceTxt.setText("");
				productQuantityTxt.setText("");
			}
		}

		if (e.getSource() == removeBttn) {
			Administrator.getInstance().deleteProduct(Integer.parseInt(productIDTxt.getText()));
			JOptionPane.showMessageDialog(null, "Product Deleted!", "Successful", JOptionPane.PLAIN_MESSAGE);
			Product.fetchProducts();
			model.updateTable(departmentComboBox.getSelectedItem().toString());

			productIDTxt.setText("");
			productNameTxt.setText("");
			productPriceTxt.setText("");
			productQuantityTxt.setText("");
		}

		if (e.getSource() == resetBttn) {
			productIDTxt.setText("");
			productNameTxt.setText("");
			productPriceTxt.setText("");
			productQuantityTxt.setText("");
		}

	}

	// Mouse Event that will determine which entry is being selected
	@Override
	public void mouseClicked(MouseEvent e) {
		int selectedRow = productsTable.getSelectedRow();

		productIDTxt.setText(model.getValueAt(selectedRow, 0).toString());
		productNameTxt.setText(model.getValueAt(selectedRow, 1).toString());
		productPriceTxt.setText(model.getValueAt(selectedRow, 2).toString());
		productQuantityTxt.setText(model.getValueAt(selectedRow, 3).toString());

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	// helper method that will validate inputs before adding or updateing data in
	// database
	private boolean validateInputs() {
		boolean isValid = false;
		if (productNameTxt.getText().length() <= 0) {
			productName.setForeground(Color.red);
		} else
			productName.setForeground(Color.black);

		boolean isPriceValid = false;
		try {
			if (productPriceTxt.getText().length() > 0) {
				productPrice.setForeground(Color.black);
				Double.parseDouble(productPriceTxt.getText());
				isPriceValid = true;
			} else {
				productPrice.setForeground(Color.red);
			}
		} catch (NumberFormatException ex) {
			productPrice.setForeground(Color.red);
		}

		boolean isQuantityValid = false;
		try {
			if (productQuantityTxt.getText().length() > 0) {
				productQuantity.setForeground(Color.black);
				Integer.parseInt(productQuantityTxt.getText());
				isQuantityValid = true;
			} else {
				productQuantity.setForeground(Color.red);
			}
		} catch (NumberFormatException ex) {
			productQuantity.setForeground(Color.red);
		}

		if (productNameTxt.getText().length() > 0 && isPriceValid && isQuantityValid)
			isValid = true;
		return isValid;
	}

}
