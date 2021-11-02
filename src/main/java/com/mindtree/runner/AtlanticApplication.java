package com.mindtree.runner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mindtree.pageobjects.AddToCart;
import com.mindtree.pageobjects.MyAccountPage;
import com.mindtree.pageobjects.SearchPage;
import com.mindtree.reusablecomponents.WebDriverHelper;
import com.mindtree.utility.Excel;
import com.mindtree.utility.ExtentReport;

public class AtlanticApplication extends WebDriverHelper {

	WebDriver driver1;
	private static Logger log = LogManager.getLogger(AtlanticApplication.class.getName());

	@Test(priority = 2)
	public void searchBook() throws IOException {
		driver1 = WebDriverHelper.startBrowser();
		log.info("Starting Application!");
		ExtentReport er = new ExtentReport(driver1);
		er.setUp("Search book");
		Excel ex = new Excel();
		ArrayList<String> data = ex.getData("Books");
		AddToCart ac = new AddToCart(driver1);
		SearchPage sp = new SearchPage(driver1);
		for (int i = 1; i < data.size(); i++) {
			sp.getSearch().sendKeys(data.get(i));
			sp.getSearch().sendKeys(Keys.ENTER);
			log.info("Searching for the book " + i);
			ac.addToCart().click();
			driver1.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}
		driver1.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		er.end();

	}

	@Test(priority = 1, dataProvider = "getData")
	public void LoginApp(String username, String password) throws IOException {
		driver1 = WebDriverHelper.startBrowser();
		log.info("Starting application");
		ExtentReport er = new ExtentReport(driver1);
		er.setUp("Login");
		MyAccountPage ap = new MyAccountPage(driver1);
		ap.getAccount().click();
		ap.getEmail().sendKeys(username);
		ap.getPassword().sendKeys(password);
		ap.getSignIn().click();
		log.info("Logging in");
		er.end();
	}

	@DataProvider
	public Object[][] getData() {

		Object[][] data = new Object[2][2];
		data[0][0] = "demo@qw.com";
		data[0][1] = "123456";
		data[1][0] = "user@qw.com";
		data[1][1] = "456788";

		return data;

	}

	@AfterMethod
	public void tearDownn() {
		WebDriverHelper.quitBrowser(driver1);
	}

}
