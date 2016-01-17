package com.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.baseDriver.BaseDriver;
import com.databases.DataBaseHandler;

public class PostTestCase extends BaseDriver {
	@Test
	public void postTestCase() {

		driver.get(baseUrl2);
		String password = "arsman123";
		String name = "arsman123";
		String signIn = "//input[@type='submit' and @value='Sign In']";
		String post = "//input[@type='submit' and @value='Post']";
		String postText = "Hello SQA";
		String url = "";
		driver.findElement(By.id("inputName")).sendKeys(name);
		driver.findElement(By.id("inputPassword")).sendKeys(password);
		driver.findElement(By.xpath(signIn)).click();

		driver.findElement(By.name("video")).sendKeys(url);
		driver.findElement(By.id("mypost")).sendKeys(postText);
		driver.findElement(By.xpath(post)).click();

		DataBaseHandler db = new DataBaseHandler();

		db.isPostExist(name, postText);

	}
}
