package com.testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.baseDriver.BaseDriver;
import com.databases.DataBaseHandler;

public class FeedBackTestCase extends BaseDriver {
	String name = null, email = null, message = null;
	Properties prop = new Properties();
	InputStream in = null;
	String contact = null;

	@Test
	public void feedbackTestCase() {

		driver.get(baseUrl6);
		String submit = "//input[@type='submit' and @value='Submit']";
		// driver.findElement(By.linkText("FEEDBACK")).click();
		try {

			in = new FileInputStream("feedback.properties");

			// load a properties file
			prop.load(in);

			// get the property value
			name = prop.getProperty("name");
			email = prop.getProperty("email");
			message = prop.getProperty("message");
			contact = prop.getProperty("contact");

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
		driver.findElement(By.id("Name")).sendKeys(name);
		driver.findElement(By.id("Email")).sendKeys(email);
		driver.findElement(By.id("Message")).sendKeys(message);
		driver.findElement(By.id("Contact")).sendKeys(contact);
		driver.findElement(By.xpath(submit)).click();
		/*
		 * List<WebElement> submitbtn =
		 * driver.findElements(By.tagName("input")); for (int i = 0; i <
		 * submitbtn.size(); i++) {
		 * 
		 * if (submitbtn.get(i).getAttribute("value")
		 * .equalsIgnoreCase("submit")) {
		 * 
		 * submitbtn.get(i).click(); // This will take the execution out of for
		 * loop break; } }
		 */
		DataBaseHandler db = new DataBaseHandler();
		db.isFeedBackExist(name, email, message, contact);
	}
}
