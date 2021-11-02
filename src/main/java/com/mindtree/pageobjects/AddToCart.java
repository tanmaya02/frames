package com.mindtree.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.mindtree.uistore.AddToCartUI;

public class AddToCart {
	WebDriver driver;

	public AddToCart(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement addToCart() {
		return driver.findElement(AddToCartUI.addTocart);

	}

}