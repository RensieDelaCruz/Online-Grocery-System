package com.grocerysystem.classes;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class Order {

	private Payment paymentMethod;
	private int orderID, userID, paymentID, totalItemsInCart;
	private double orderTotalPrice;
	private String street, city, province, postal;
	private List<ProductsInCart> productsInCart;
	private long phone;
	private LocalDate date;

	// constructor
	public Order(int userID, double orderTotalPrice, Payment paymentMethod, List<ProductsInCart> productsInCart,
			String street, String city, String postal, String province, long phone, int totalItemsInCart) {
		this.userID = userID;
		this.orderTotalPrice = orderTotalPrice;
		this.paymentMethod = paymentMethod;
		this.productsInCart = productsInCart;
		this.street = street;
		this.city = city;
		this.postal = postal;
		this.province = province;
		this.phone = phone;
		this.totalItemsInCart = totalItemsInCart;
		paymentID = paymentMethod.collectPayment();
		date = LocalDate.now();
	}

	// method that will enter the data in database
	public void checkout() {
		try (Connection conn = DatabaseConnect.getConnection()) {
			// first, insert data in order table to generate the order ID which will be use
			// in other table
			String insertOrder = "INSERT INTO order_table(customer_id, total_items, order_total_price, order_date, order_status, payment_id) VALUES (?,?,?,?,?,?)";
			PreparedStatement stmt1 = conn.prepareStatement(insertOrder);
			stmt1.setInt(1, userID);
			stmt1.setInt(2, totalItemsInCart);
			stmt1.setDouble(3, orderTotalPrice);
			stmt1.setDate(4, Date.valueOf(date));
			stmt1.setString(5, "Pending");
			stmt1.setInt(6, paymentID);
			stmt1.execute();

			// get the order ID that was generated from creating a new entry in order table
			String getOrderID = "SELECT order_no FROM order_table WHERE payment_id = ?";
			PreparedStatement stmt2 = conn.prepareStatement(getOrderID);
			stmt2.setInt(1, paymentID);
			ResultSet rs = stmt2.executeQuery();
			while (rs.next()) {
				orderID = rs.getInt("order_no");
			}

			// insert data in order shipment table using the order id we get from creating
			// the entry on order table
			String insertShipment = "INSERT INTO order_shipment(order_id, shipping_address, postal_code, phone_number) VALUES (?,?,?,?)";
			PreparedStatement stmt3 = conn.prepareStatement(insertShipment);
			stmt3.setInt(1, orderID);
			stmt3.setString(2, street + " " + city + " " + province);
			stmt3.setString(3, postal);
			stmt3.setLong(4, phone);
			stmt3.execute();

			// record every product that was bought under the order number for this transaction
			for (ProductsInCart p : productsInCart) {
				String insertProducts = "INSERT INTO order_detail(order_id, product_id, quantity, subtotal) VALUES (?,?,?,?)";
				PreparedStatement stmt4 = conn.prepareStatement(insertProducts);
				stmt4.setInt(1, orderID);
				stmt4.setInt(2, p.getProductID());
				stmt4.setInt(3, p.getQuantity());
				stmt4.setDouble(4, p.getSubtotal());
				stmt4.execute();
				
				// query that will update the quantity in stock
				String updateQty = "UPDATE products SET quantity_instock = quantity_instock - ? WHERE product_id = ?";
				PreparedStatement stmt5 = conn.prepareStatement(updateQty);
				stmt5.setInt(1, p.getQuantity());
				stmt5.setInt(2, p.getProductID());
				stmt5.execute();
			}
			
			ProductsInCart.clearCart();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void viewOrderStatus() {
		
	}

}
