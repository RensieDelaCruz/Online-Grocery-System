package com.grocerysystem.forms;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import com.grocerysystem.classes.Product;

public class ProductsTableModel extends AbstractTableModel {

	private final String[] columnNames = new String[] { "Product ID", "Product Name", "Price", "Quantity", "In Stock",
			"Status" };

	private final Class[] columnClass = new Class[] { Integer.class, String.class, Double.class, Integer.class,
			Boolean.class, String.class };

	private static List<Product> filteredProductList = Product.getFilteredProductList("Meats");

	// method that will update the whole table depending on what is the selected
	// department on the combo box
	public void updateTable(String dept) {
		filteredProductList = Product.getFilteredProductList(dept);
		fireTableDataChanged();
	}

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
		return filteredProductList.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Product row = filteredProductList.get(rowIndex);
		if (0 == columnIndex) {
			return row.getProductID();
		} else if (1 == columnIndex) {
			return row.getProductName();
		} else if (2 == columnIndex) {
			return row.getProductPrice();
		} else if (3 == columnIndex) {
			return row.getQtyInStock();
		} else if (4 == columnIndex) {
			return row.isInStock();
		} else if (5 == columnIndex) {
			return row.getStatus();
		}
		return null;
	}
}
