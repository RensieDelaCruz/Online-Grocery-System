package com.grocerysystem.classes;

public interface User {
	boolean verifyLogin(String username, String password);
	void updateAccountInfo();
	
}
