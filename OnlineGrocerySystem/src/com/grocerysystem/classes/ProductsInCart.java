package com.grocerysystem.classes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.grocerysystem.forms.MainForm;
import com.grocerysystem.forms.ViewCartPanel;

public class ProductsInCart {

	private int productID, quantity;
	private String productName, productDepartment;
	private double productPrice, subtotal;


	private static double cartSubTotal;
	private static List<ProductsInCart> productsInCart = new ArrayList<>();

	public ProductsInCart(int productID, String productName, String productDepartment, Double productPrice,
			int quantity) {
		this.productID = productID;
		this.productName = productName;
		this.productDepartment = productDepartment;
		this.productPrice = productPrice;
		this.quantity = quantity;
		this.subtotal = (double) quantity * productPrice;
	}

	// this method will check first if the cart already has the product that the
	// customer wants to be added. If the cart has the product already, the quantity
	// that the customer wants to add will be added to the product that is already
	// in the cart. If the cart doesn't have athe product, it will add the new
	// product in the cart.
	public static void addToCart(ProductsInCart pic) {
		if (productsInCart.contains(pic)) {
			for (ProductsInCart p : productsInCart) {
				if (p.equals(pic)) {
					p.quantity += pic.quantity; // add the new product's quantity to the same product that already in
												// the
												// cart
					p.setSubtotal(p.quantity); // update the subtotal as the quantity changes
				}
			}
		} else {
			productsInCart.add(pic);
			updateCartSubtotal();
		}
	}

	// this method will remove product from productsInCart list if the quantity is
	// set to 0 on the JTable. An Iterator was used to prevent
	// java.util.ConcurrentModificationException to be thrown
	public static void removeFromCart(ProductsInCart pic) {
		for (Iterator<ProductsInCart> iterator = productsInCart.iterator(); iterator.hasNext();) {
			ProductsInCart p = iterator.next();
			if (p.equals(pic)) {
				iterator.remove();
			}
		}
		updateCartSubtotal();
	}

	// this method will be called everytime there's a change inside the
	// productsInCart List.
	public static void updateCartSubtotal() {
		cartSubTotal = 0;
		if (productsInCart.size() > 0) {
			for (ProductsInCart p : productsInCart) {
				cartSubTotal += p.getSubtotal();
				MainForm.subTotalLabel.setText("Subtotal: " + String.format("%.2f", getCartSubtotal()));
				ViewCartPanel.subTotalLabel.setText("Subtotal: " + String.format("%.2f", getCartSubtotal()));
				ViewCartPanel.taxLabel.setText("Tax: " + String.format("%.2f", getCalculatedTax()));
				ViewCartPanel.totalLabel.setText("Total: " + String.format("%.2f", ProductsInCart.getTotalPrice()));
			}
		} else {
			MainForm.subTotalLabel.setText("Subtotal: " + String.format("%.2f", getCartSubtotal()));
			ViewCartPanel.subTotalLabel.setText("Subtotal: " + String.format("%.2f", getCartSubtotal()));
			ViewCartPanel.taxLabel.setText("Tax: " + String.format("%.2f", getCalculatedTax()));
			ViewCartPanel.totalLabel.setText("Total: " + String.format("%.2f", ProductsInCart.getTotalPrice()));
		}
	}
	
	public static double getCalculatedTax() {
		double calculatedTax = 0;
		calculatedTax = (double) getCartSubtotal() * .13;
		return calculatedTax;
	}
	
	// method to get total number of items in the cart
	public static int getTotalItemsInCart() {
		int numberOfItemsInCart = 0;
		for(ProductsInCart p: productsInCart) {
			numberOfItemsInCart += p.quantity;
		}
		return numberOfItemsInCart;
	}
	
	public static void clearCart() {
		productsInCart.removeAll(productsInCart);
		updateCartSubtotal();
	}

	// getters and setters

	public static double getTotalPrice() {
		return cartSubTotal + getCalculatedTax();
	}

	// method to get the ProductsInCart List
	public static List<ProductsInCart> getProductsInCart() {
		return productsInCart;
	}

	// method that will return the total price of all items in the cart
	public static double getCartSubtotal() {
		return cartSubTotal;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
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

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(int qty) {
		this.subtotal = (double) qty * this.productPrice;
		updateCartSubtotal();
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof ProductsInCart) {
			ProductsInCart p = (ProductsInCart) o;
			return this.getProductName().equals(p.getProductName());
		} else
			return false;
	}
}
