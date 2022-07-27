package com.grocerysystem.classes;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreditCard extends Payment {

	private String nameOnCreditCard;
	private int creditCardCVV, paymentID;
	private long creditCardNum;
	private String creditCardExpDate;
	private double amount;
	private LocalDate date;
	private Timestamp timeStamp;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private Calendar cal = Calendar.getInstance();

	// constructor
	public CreditCard(double amount, String nameOnCreditCard, long creditCardNum, String creditCardExpDate,
			int creditCardCVV) {
		this.amount = amount;
		this.nameOnCreditCard = nameOnCreditCard;
		this.creditCardNum = creditCardNum;
		this.creditCardExpDate = creditCardExpDate;
		this.creditCardCVV = creditCardCVV;
		this.date = LocalDate.now();
		this.timeStamp = new Timestamp(cal.getTimeInMillis());

	}

	// This method will record the credit card info in the database and will return
	// the payment ID that will be given automatically by the database
	@Override
	public int collectPayment() {
		try (Connection conn = DatabaseConnect.getConnection()) {
			// first, insert payment info into payment table to generate an auto-increment
			// payment id that will bne use to other tables
			String insertPayment = "INSERT INTO payment(payment_type, date, time_stamp) VALUES (?,?,?)";
			PreparedStatement stmt1 = conn.prepareStatement(insertPayment);
			stmt1.setString(1, "C");
			stmt1.setDate(2, Date.valueOf(date));
			stmt1.setString(3, sdf.format(timeStamp));
			stmt1.execute();

			// get the the generated payment id
			String getPaymentID = "SELECT payment_id FROM payment WHERE payment_type = ? AND date = ? AND time_stamp = ? ";
			PreparedStatement stmt2 = conn.prepareStatement(getPaymentID);
			stmt2.setString(1, "C");
			stmt2.setDate(2, Date.valueOf(date));
			stmt2.setString(3, sdf.format(timeStamp));
			ResultSet rs = stmt2.executeQuery();
			while (rs.next()) {
				paymentID = rs.getInt("payment_id");
			}

			// insert info in credit card table with the payment id we got from entering
			// data in payment table. This is designed so that when someone views the
			// database, it's easier for them to identify which payment is for which
			// transaction
			String insertQuery = "INSERT INTO payment_creditcard(payment_id, name_on_creditcard, creditcard_no, exp_date, cvv, amount) VALUES(?,?,?,?,?,?)";
			PreparedStatement stmt3 = conn.prepareStatement(insertQuery);
			stmt3.setInt(1, paymentID);
			stmt3.setString(2, nameOnCreditCard);
			stmt3.setLong(3, creditCardNum);
			stmt3.setString(4, creditCardExpDate);
			stmt3.setInt(5, creditCardCVV);
			stmt3.setDouble(6, amount);
			stmt3.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return paymentID;
	}

	/*
	 * The following code uses Luhn Algorithm to check Credit Card Number
	 */

	// Return true if the card number is valid
	public static boolean validateCreditCardNumber(long cnumber) {
		return (thesize(cnumber) >= 13 && thesize(cnumber) <= 16) && (prefixmatch(cnumber, 4) || prefixmatch(cnumber, 5)
				|| prefixmatch(cnumber, 37) || prefixmatch(cnumber, 6))
				&& ((sumdoubleeven(cnumber) + sumodd(cnumber)) % 10 == 0);
	}

	// Get the result from Step 2
	private static int sumdoubleeven(long cnumber) {
		int sum = 0;
		String num = cnumber + "";
		for (int i = thesize(cnumber) - 2; i >= 0; i -= 2)
			sum += getDigit(Integer.parseInt(num.charAt(i) + "") * 2);
		return sum;
	}

	// Return this cnumber if it is a single digit, otherwise,
	// return the sum of the two digits
	private static int getDigit(int cnumber) {
		if (cnumber < 9)
			return cnumber;
		return cnumber / 10 + cnumber % 10;
	}

	// Return sum of odd-place digits in cnumber
	private static int sumodd(long cnumber) {
		int sum = 0;
		String num = cnumber + "";
		for (int i = thesize(cnumber) - 1; i >= 0; i -= 2)
			sum += Integer.parseInt(num.charAt(i) + "");
		return sum;
	}

	// Return true if the digit d is a prefix for cnumber
	private static boolean prefixmatch(long cnumber, int d) {
		return getprefx(cnumber, thesize(d)) == d;
	}

	// Return the number of digits in d
	private static int thesize(long d) {
		String num = d + "";
		return num.length();
	}

	// Return the first k number of digits from
	// number. If the number of digits in number
	// is less than k, return number.
	private static long getprefx(long cnumber, int k) {
		if (thesize(cnumber) > k) {
			String num = cnumber + "";
			return Long.parseLong(num.substring(0, k));
		}
		return cnumber;
	}

	/*
	 * The next code uses an Algotihm to validate credit card
	 * expiry date with pattern "MM/YY"
	 */
	public static boolean validateCardExpiryDate(String expiryDate) {
		return expiryDate.matches("(?:0[1-9]|1[0-2])/[0-9]{2}");
	}
	
	/*
	 *  The next code uses an Algorithm to validate a CVV
	 *  number.
	 */
	// Function to validate
	// CVV (Card Verification Value) number.
	// using regular expression.
	public static boolean validateCVVNumber(String str) {
		// Regex to check valid CVV number.
		String regex = "^[0-9]{3,4}$";

		// Compile the ReGex
		Pattern p = Pattern.compile(regex);

		// If the string is empty
		// return false
		if (str == null) {
			return false;
		}

		// Find match between given string
		// and regular expression
		// using Pattern.matcher()

		Matcher m = p.matcher(str);

		// Return if the string
		// matched the ReGex
		return m.matches();
	}
}
