package com.testcases;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
import com.baseDriver.BaseDriver;
import com.databases.DataBaseHandler;

public class SignUpMobileArenaTestCase extends BaseDriver {

	String fname = null, lname = null, city = null, country = null,
			email = null;
	String password = null, confirmPassword = null, DOB = null;
	Properties prop = new Properties();
	InputStream in = null;

	@Test
	public void signUpMobileArenaTestCase() {
		driver.get(baseUrl1);
		String submitButton = "//input[@type='submit' and @value='Sign Up']";

		try {

			in = new FileInputStream("mobileArenaSignUp.properties");

			// load a properties file
			prop.load(in);

			// get the property value
			fname = prop.getProperty("fname");
			lname = prop.getProperty("lname");
			email = prop.getProperty("email");
			password = prop.getProperty("password");
			confirmPassword = prop.getProperty("confirmPassword");
			country = prop.getProperty("country");
			DOB = prop.getProperty("DOB");
			city = prop.getProperty("city");

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		driver.findElement(By.id("FirstName")).sendKeys(fname);
		driver.findElement(By.id("LastName")).sendKeys(lname);
		driver.findElement(By.id("UserName")).sendKeys(email);
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.id("ConfirmPassword")).sendKeys(confirmPassword);

		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		if (cap.getBrowserName().equalsIgnoreCase("chrome"))
			driver.findElement(By.id("DateOfBirth")).sendKeys(DOB);
		else
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].value=arguments[1]",
					driver.findElement(By.id("DateOfBirth")), DOB);
		driver.findElement(By.id("City")).sendKeys(city);
		driver.findElement(By.id("Country")).sendKeys(country);

		driver.findElement(By.xpath(submitButton)).submit();
		DataBaseHandler db = new DataBaseHandler();
		db.isUserExistInMA(email, confirmPassword);
//		login();
	}

	public void login() {

		String signIn = "//input[@type='submit' and @value='Login']";
		String logout = "//input[@type='submit' and @value='Logout']";
		driver.findElement(By.id("name")).sendKeys(email);
		driver.findElement(By.id("pass")).sendKeys(password);

		driver.findElement(By.xpath(signIn)).click();
		driver.findElement(By.xpath(logout)).click();
		DataBaseHandler db = new DataBaseHandler();
		db.isUserExistInMA(email, confirmPassword);
	}

}