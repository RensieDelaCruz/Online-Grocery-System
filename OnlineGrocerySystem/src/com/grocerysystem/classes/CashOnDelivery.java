package com.grocerysystem.classes;

public class CashOnDelivery extends Payment {

	private double amountRemainingBalance, amountRecieved, amountChange;
	
	@Override
	public void collectPayment() {

	}

	public double calculateRemainingBalance() {
		return 0.0;
	}
	
	public double calculateChange() {
		return 0.0;
	}

}
