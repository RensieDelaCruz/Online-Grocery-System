package com.grocerysystem.forms;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

public class ViewOrderHistoryPanel extends JPanel {

	private JLabel orderHistoryLabel;
	private JTable orderHistoryTable;

	public ViewOrderHistoryPanel() {
		// Cart Table
		String[] columnNames = new String[] { "Order Number", "Date", "Status", "Ship Date",
				"Number of Items", "Total Price" };
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columnNames);
		orderHistoryTable = new JTable(model);
		JScrollPane tableSP = new JScrollPane(orderHistoryTable, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		tableSP.setBounds(30, 60, 700, 400);

		// Order History Panel
		orderHistoryLabel = new JLabel("Order History");
		orderHistoryLabel.setFont(new Font("Arial Black", Font.BOLD, 20));
		orderHistoryLabel.setForeground(new Color(139, 69, 19));
		orderHistoryLabel.setBounds(30, 10, 170, 50);

		// Order history panel
		this.setVisible(true);
		this.setBackground(Color.white);
		this.setPreferredSize(new Dimension(100, 1200));
		this.setLayout(null);

		this.add(orderHistoryLabel);
		this.add(tableSP);
	}

}
