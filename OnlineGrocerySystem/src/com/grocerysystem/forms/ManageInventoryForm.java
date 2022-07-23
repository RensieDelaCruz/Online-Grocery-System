package com.grocerysystem.forms;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

public class ManageInventoryForm extends JFrame implements ItemListener {

	JPanel headerPanel, centerPanel, tablePanel;
	JLabel headerPanelLabel, departmentLabel;
	JComboBox<String> departmentComboBox;
	JButton addBttn, updateBttn, removeBttn;
	JTable meatTable, seafoodTable, fruitTable, veggiesTable, dairyTable, eggTable;
	JScrollPane meatScrollPane, seafoodScrollPane, fruitScrollPane, veggiesScrollPane, dairyScrollPane, eggScrollPane;
	CardLayout cards;

	public ManageInventoryForm() {
		// Departments tables (I just added one entry for each to demonstrate the functionality of the combobox)
		String[] columnNames = new String[] { "Product ID", "Product Name", "Product Price", "Quantity", "In Stock" };
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columnNames);
		Object[][] meatData = {{"1","Ground Beef", "7.00", "50", "true"}};
		Object[][] seafoodData = {{"8","seafood", "7.00", "50", "true"}};
		Object[][] fruitData = {{"16","fruit", "7.00", "50", "true"}};
		Object[][] veggiesData = {{"24","veggie", "7.00", "50", "true"}};
		Object[][] dairyData = {{"32","dairy", "7.00", "50", "true"}};
		Object[][] eggData = {{"40","egg", "7.00", "50", "true"}};
		meatTable = new JTable(meatData, columnNames);
		seafoodTable = new JTable(seafoodData, columnNames);
		fruitTable = new JTable(fruitData, columnNames);
		veggiesTable = new JTable(veggiesData, columnNames);
		dairyTable = new JTable(dairyData, columnNames);
		eggTable = new JTable(eggData, columnNames);
		
		// Egg ScrollPane
		eggScrollPane = new JScrollPane(eggTable, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		// Dairy ScrollPane
		dairyScrollPane = new JScrollPane(dairyTable, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		// Vegetable ScrollPane
		veggiesScrollPane = new JScrollPane(veggiesTable, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		// Fruit ScrollPane
		fruitScrollPane = new JScrollPane(fruitTable, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		// Seafood ScrollPane
		seafoodScrollPane = new JScrollPane(seafoodTable, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		// Meat ScrollPane
		meatScrollPane = new JScrollPane(meatTable, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		// Table Panel
		cards = new CardLayout();
		tablePanel = new JPanel();
		tablePanel.setLayout(cards);
		tablePanel.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
		tablePanel.setBackground(Color.WHITE);
		tablePanel.setBounds(20, 80, 940, 400);
		tablePanel.add(meatScrollPane, "meat");
		tablePanel.add(seafoodScrollPane, "seafood");
		tablePanel.add(fruitScrollPane, "fruit");
		tablePanel.add(veggiesScrollPane, "vegetable");
		tablePanel.add(dairyScrollPane, "dairy");
		tablePanel.add(eggScrollPane, "egg");

		// Add, Update, Remove Buttons
		removeBttn = new JButton("Remove");
		removeBttn.setBackground(Color.white);
		removeBttn.setForeground(new Color(210, 105, 30));
		removeBttn.setFocusable(false);
		removeBttn.setBorder(BorderFactory.createEtchedBorder(20, Color.GRAY, Color.LIGHT_GRAY));
		removeBttn.setBounds(780, 30, 70, 20);

		updateBttn = new JButton("Update");
		updateBttn.setBackground(Color.white);
		updateBttn.setForeground(new Color(210, 105, 30));
		updateBttn.setFocusable(false);
		updateBttn.setBorder(BorderFactory.createEtchedBorder(20, Color.GRAY, Color.LIGHT_GRAY));
		updateBttn.setBounds(690, 30, 70, 20);

		addBttn = new JButton("Add");
		addBttn.setBackground(Color.white);
		addBttn.setForeground(new Color(210, 105, 30));
		addBttn.setFocusable(false);
		addBttn.setBorder(BorderFactory.createEtchedBorder(20, Color.GRAY, Color.LIGHT_GRAY));
		addBttn.setBounds(600, 30, 70, 20);

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
		centerPanel.add(tablePanel);

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
		ImageIcon mainIcon = new ImageIcon("Cart Icon.jpg");
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

	@Override
	public void itemStateChanged(ItemEvent e) {

		JComboBox selected = (JComboBox)e.getItemSelectable();
		if (selected.getSelectedIndex() == 0) {
			cards.show(tablePanel, "meat");
			centerPanel.add(tablePanel);
		}
		
		if (selected.getSelectedIndex() == 1) {
			cards.show(tablePanel, "seafood");
			centerPanel.add(tablePanel);
		}
		
		if (selected.getSelectedIndex() == 2) {
			cards.show(tablePanel, "fruit");
			centerPanel.add(tablePanel);
		}
		
		if (selected.getSelectedIndex() == 3) {
			cards.show(tablePanel, "vegetable");
			centerPanel.add(tablePanel);
		}
		
		if (selected.getSelectedIndex() == 4) {
			cards.show(tablePanel, "dairy");
			centerPanel.add(tablePanel);
		}
		
		if (selected.getSelectedIndex() == 5) {
			cards.show(tablePanel, "egg");
			centerPanel.add(tablePanel);
		}

	}
}
