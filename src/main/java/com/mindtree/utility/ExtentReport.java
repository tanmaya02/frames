package com.mindtree.utility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReport {

	WebDriver driver;
	public ExtentTest logger;
	public ExtentReports extent;

	public ExtentReport(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		extent = new ExtentReports(
				System.getProperty("user.dir")+"//Report//report" + TakeSS.getCurrentDate() + ".html");
	}

	public void setUp(String name) throws IOException {

		logger = extent.startTest(name);
		logger.log(LogStatus.PASS, logger.addScreenCapture(TakeSS.captureScreenShot(driver)) + "Test Passed " + name);

	}

	public void end() {
		extent.endTest(logger);
		extent.flush();
	}
}
