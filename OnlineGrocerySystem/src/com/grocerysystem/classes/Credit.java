package com.grocerysystem.classes;

import java.time.LocalDate;

public class Credit extends Payment {
	
	private String nameOnCreditCard;
	private int creditCardNum, creditCardCVV;
	private LocalDate creditCardExpDate;
	
	@Override
	public void collectPayment() {
		
		
	}
	
	private boolean verifyCreditCard() {
		return false;
	}

}
