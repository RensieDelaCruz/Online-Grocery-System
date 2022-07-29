package com.grocerysystem.forms;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.grocerysystem.classes.OrderHistory;

public class ViewOrderHistoryModel extends AbstractTableModel {
	private final static List<OrderHistory> orderHistoryList = OrderHistory.getOrderHistoryList();
	
	private final String[] columnNames = new String[] { "Order ID", "Date", "Status",
			"Total Items", "Total Price", "Shipping Address" };
	
	private final Class[] columnClass = new Class[] { Integer.class, String.class, String.class, Integer.class,
			Double.class, String.class };
	
	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return columnClass[columnIndex];
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return orderHistoryList.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		OrderHistory row = orderHistoryList.get(rowIndex);
		if (0 == columnIndex) {
			return row.getOrderID();
		} else if (1 == columnIndex) {
			return row.getDate();
		} else if (2 == columnIndex) {
			return row.getStatus();
		} else if (3 == columnIndex) {
			return row.getNumberOfItems();
		} else if (4 == columnIndex) {
			return row.getTotalPrice();
		} else if (5 == columnIndex) {
			return row.getShippingAddress();
		}
		return null;
	}
}
