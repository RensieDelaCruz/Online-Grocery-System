package com.grocerysystem.classes;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;

public class CashOnDelivery extends Payment {

	private double amount;
	private LocalDate date;
	private Timestamp timeStamp;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private Calendar cal = Calendar.getInstance();
	private int paymentID;

	public CashOnDelivery(double amount) {
		this.amount = amount;
		this.date = LocalDate.now();
		this.timeStamp = new Timestamp(cal.getTimeInMillis());
	}

	@Override
	public int collectPayment() {
		try (Connection conn = DatabaseConnect.getConnection()) {
			// first, insert payment info into payment table to generate an auto-increment
			// payment id that will bne use to other tables
			String insertPayment = "INSERT INTO payment(payment_type, date, time_stamp) VALUES (?,?,?)";
			PreparedStatement stmt1 = conn.prepareStatement(insertPayment);
			stmt1.setString(1, "M");
			stmt1.setDate(2, Date.valueOf(date));
			stmt1.setString(3, sdf.format(timeStamp));
			stmt1.execute();

			// get the the generated payment id
			String getPaymentID = "SELECT payment_id FROM payment WHERE payment_type = ? AND date = ? AND time_stamp = ? ";
			PreparedStatement stmt2 = conn.prepareStatement(getPaymentID);
			stmt2.setString(1, "M");
			stmt2.setDate(2, Date.valueOf(date));
			stmt2.setString(3, sdf.format(timeStamp));
			ResultSet rs = stmt2.executeQuery();
			while (rs.next()) {
				paymentID = rs.getInt("payment_id");
			}
			
			String insertQuery = "INSERT INTO payment_cash(payment_id, amount) VALUES(?,?)";
			PreparedStatement stmt3 = conn.prepareStatement(insertQuery);
			stmt3.setInt(1, paymentID);
			stmt3.setDouble(2, amount);
			stmt3.execute();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return paymentID;
	}

}
