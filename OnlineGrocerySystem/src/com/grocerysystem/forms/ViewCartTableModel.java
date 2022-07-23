package com.grocerysystem.forms;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

import com.grocerysystem.classes.Product;
import com.grocerysystem.classes.ProductsInCart;

public class ViewCartTableModel extends AbstractTableModel {

	private final static List<ProductsInCart> productInCartList = ProductsInCart.getProductsInCart();

	private final String[] columnNames = new String[] { "Product ID", "Product Name", "Product Department",
			"Product Price", "Quantity", "Subtotal" };

	private final Class[] columnClass = new Class[] { Integer.class, String.class, String.class, Double.class,
			Integer.class, Double.class };

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
		return productInCartList.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		ProductsInCart row = productInCartList.get(rowIndex);
		if (0 == columnIndex) {
			return row.getProductID();
		} else if (1 == columnIndex) {
			return row.getProductName();
		} else if (2 == columnIndex) {
			return row.getProductDepartment();
		} else if (3 == columnIndex) {
			return row.getProductPrice();
		} else if (4 == columnIndex) {
			return row.getQuantity();
		} else if (5 == columnIndex) {
			return row.getSubtotal();
		}
		return null;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		if (columnIndex == 4) {
			return true;
		}else
			return false;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		ProductsInCart row = productInCartList.get(rowIndex);
		if (4 == columnIndex) {
			if ((Integer) aValue == 0) {
				ProductsInCart.removeFromCart(row);
			} else {
				row.setQuantity((Integer) aValue);
				
				this.addTableModelListener(new TableModelListener() {
					
					@Override
					public void tableChanged(TableModelEvent e) {
						row.setSubtotal(row.getQuantity());
				
					}
				});
				fireTableCellUpdated(rowIndex, columnIndex);
				
			}
		}
	}

}