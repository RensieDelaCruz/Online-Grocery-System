package com.grocerysystem.classes;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.grocerysystem.forms.LoginForm;

public class OrderHistory {

	private int orderID, numberOfItems;
	private String status, shippingAddress, date;
	private double totalPrice;
	private static User user = LoginForm.getUser();

	private static List<OrderHistory> orderHistoryList = new ArrayList<>();

	// constructor
	public OrderHistory(int orderID, String date, String status, int numberOfItems, double totalPrice,
			String shippingAddress) {
		this.orderID = orderID;
		this.date = date;
		this.status = status;
		this.numberOfItems = numberOfItems;
		this.totalPrice = totalPrice;
		this.shippingAddress = shippingAddress;
	}

	// method that will get the order history data from the database
	public static void fetchOrderHistory(int userID) {
		try (Connection conn = DatabaseConnect.getConnection()) {
			String queryOrderHistory = "SELECT user.user_id, order_table.order_no, order_table.order_date, order_table.order_status, order_table.total_items, order_table.order_total_price, order_shipment.shipping_address "
					+ "FROM order_table " + "INNER JOIN user ON user.user_id = order_table.customer_id "
					+ "INNER JOIN order_shipment ON order_table.order_no = order_shipment.order_id WHERE user.user_id = ?";
			PreparedStatement stmt1 = conn.prepareStatement(queryOrderHistory);
			stmt1.setInt(1, userID);
			ResultSet rs = stmt1.executeQuery();
			while (rs.next()) {
				orderHistoryList.add(new OrderHistory(rs.getInt("order_no"), rs.getDate("order_date").toString(),
						rs.getString("order_status"), rs.getInt("total_items"), rs.getDouble("order_total_price"),
						rs.getString("shipping_address")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// method to get the order history list
	public static List<OrderHistory> getOrderHistoryList() {
		return orderHistoryList;
	}
	

	// getters and setters
	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public int getNumberOfItems() {
		return numberOfItems;
	}

	public void setNumberOfItems(int numberOfItems) {
		this.numberOfItems = numberOfItems;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

}
