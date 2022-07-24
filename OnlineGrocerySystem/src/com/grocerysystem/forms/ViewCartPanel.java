package com.grocerysystem.forms;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

public class ViewCartPanel extends JPanel {

	private JTable cartTable;
	private JLabel cartLabel;
	public static JLabel subTotalLabel, taxLabel, totalLabel;
	private JButton checkOutBttn;

	static DefaultTableModel model;
	static Object[] row;

	public ViewCartPanel() {
		// Checkout Button
		checkOutBttn = new JButton("Checkout");
		checkOutBttn.setBackground(Color.white);
		checkOutBttn.setForeground(new Color(210, 105, 30));
		checkOutBttn.setFocusable(false);
		checkOutBttn.setBorder(BorderFactory.createEtchedBorder(20, Color.GRAY, Color.LIGHT_GRAY));
		checkOutBttn.setBounds(300, 500, 100, 20);
		checkOutBttn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new CheckoutForm();
				MainForm.getInstance().setVisible(false);
			}
		});

		// Subtotal, Tax and Total Label
		subTotalLabel = new JLabel("Subtotal: ");
		subTotalLabel.setFont(new Font("Arial Black", Font.BOLD, 15));
		subTotalLabel.setBounds(30, 375, 200, 20);
		taxLabel = new JLabel("Tax: ");
		taxLabel.setFont(new Font("Arial Black", Font.BOLD, 15));
		taxLabel.setBounds(30, 400, 200, 20);
		totalLabel = new JLabel("Total: ");
		totalLabel.setFont(new Font("Arial Black", Font.BOLD, 15));
		totalLabel.setBounds(30, 425, 200, 20);

		
		// Cart Table
		ViewCartTableModel model = new ViewCartTableModel();
		cartTable = new JTable(model);
		JScrollPane tableSP = new JScrollPane(cartTable, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		tableSP.setBounds(30, 60, 700, 300);

		// Cart Label
		cartLabel = new JLabel("Your Cart");
		cartLabel.setFont(new Font("Arial Black", Font.BOLD, 20));
		cartLabel.setForeground(new Color(139, 69, 19));
		cartLabel.setBounds(30, 10, 150, 50);

		// View cart panel
		this.setVisible(true);
		this.setBackground(Color.white);
		this.setPreferredSize(new Dimension(100, 1200));
		this.setLayout(null);

		this.add(cartLabel);
		this.add(tableSP);
		this.add(subTotalLabel);
		this.add(taxLabel);
		this.add(totalLabel);
		this.add(checkOutBttn);
	}

}
