package com.mindtree.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.mindtree.reusablecomponents.WebDriverHelper;

public class TakeSS extends WebDriverHelper {

	public static String captureScreenShot(WebDriver driver) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"//Screenshot//SS" + getCurrentDate() + ".png";
		FileUtils.copyFile(src, new File(path));
		return path;
	}

	public static String getCurrentDate() {

		DateFormat df = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date date = new Date();
		return df.format(date);

	}
}