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
	private int productID, qtyInStock;
	private String productName, productDepartment;

	private double productPrice;
	private boolean inStock;
	private static int product = 0;


	static {
		try (Connection conn = DatabaseConnect.getConnection()) {
			String query = "SELECT * FROM products";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				productList.add(
						new Product(rs.getInt("product_id"), rs.getString("product_name"), rs.getString("department"),
								rs.getDouble("price"), rs.getInt("quantity_instock"), rs.getBoolean("in_stock")));
			}
		} catch (SQLException e) {
		}
	}

	public Product() {
	}

	public Product(int productID, String productName, String productDepartment, double productPrice, int qtyInStock,
			boolean inStock) {
		this.productID = productID;
		this.productName = productName;
		this.productDepartment = productDepartment;
		this.productPrice = productPrice;
		this.qtyInStock = qtyInStock;
		this.inStock = inStock;
	}

	public static List<Product> getProductList() {
		return productList;
	}

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

}
