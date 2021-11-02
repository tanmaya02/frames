package com.mindtree.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.uistore.MyAccountPageUI;
import com.mindtree.uistore.LandingPageUI;

public class MyAccountPage {

	WebDriver driver;

	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getAccount() {
		return driver.findElement(LandingPageUI.acc);

	}

	public WebElement getEmail() {
		return driver.findElement(MyAccountPageUI.email);

	}

	public WebElement getPassword() {
		return driver.findElement(MyAccountPageUI.password);

	}

	public WebElement getSignIn() {
		return driver.findElement(MyAccountPageUI.signIn);

	}
}
