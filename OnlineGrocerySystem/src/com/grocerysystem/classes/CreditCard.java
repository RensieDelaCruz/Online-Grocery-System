package com.grocerysystem.classes;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreditCard extends Payment {

	private String nameOnCreditCard;
	private int creditCardNum, creditCardCVV;
	private LocalDate creditCardExpDate;

	@Override
	public void collectPayment() {

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
