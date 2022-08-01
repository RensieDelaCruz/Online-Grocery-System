package com.grocerysystem.classes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Product {

	private static List<Product> productList = new ArrayList<>();
	private static List<Product> filterProductList = new ArrayList<>();
	private int productID, qtyInStock;
	private String productName, productDepartment, status;

	private double productPrice;
	private boolean inStock;

	public Product() {
	}

	//constructor
	public Product(int productID, String productName, String productDepartment, double productPrice, int qtyInStock,
			boolean inStock, String status) {
		this.productID = productID;
		this.productName = productName;
		this.productDepartment = productDepartment;
		this.productPrice = productPrice;
		this.qtyInStock = qtyInStock;
		this.inStock = inStock;
		this.status = status;
	}

	// method that will be called on the start of the program to get all products
	// from the database
	// this method will be also called anytime there are changes in management side
	// that will reset the list and get the updated product list from the database
	public static void fetchProducts() {
		try (Connection conn = DatabaseConnect.getConnection()) {
			productList.removeAll(productList);
			String query = "SELECT * FROM products";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				productList.add(new Product(rs.getInt("product_id"), rs.getString("product_name"),
						rs.getString("department"), rs.getDouble("price"), rs.getInt("quantity_instock"),
						rs.getBoolean("in_stock"), rs.getString("status")));
			}
		} catch (SQLException e) {
		}
	}

	// method that will return List of products in database
	public static List<Product> getProductList() {
		return productList;
	}

	// method that accepts which product department is being viewed and return the
	// filtered product list
	public static List<Product> getFilteredProductList(String dept) {
		filterProductList.removeAll(filterProductList);
		for (Product p : productList) {
			if (p.getProductDepartment().equals(dept)) {
				filterProductList.add(p);
			}
		}
		return filterProductList;
	}

	// getters and setter
	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public int getQtyInStock() {
		return qtyInStock;
	}

	public void setQtyInStock(int qtyInStock) {
		this.qtyInStock = qtyInStock;
	}

	public String getProductDepartment() {
		return productDepartment;
	}

	public void setProductDepartment(String productDepartment) {
		this.productDepartment = productDepartment;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public boolean isInStock() {
		return inStock;
	}

	public void setInStock(boolean inStock) {
		this.inStock = inStock;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
