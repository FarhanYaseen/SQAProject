package com.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.baseDriver.BaseDriver;
import com.databases.DataBaseHandler;

public class CommentTestCase extends BaseDriver {
	@Test
	public void commentTestCase() {
		driver.get(baseUrl2);
		String signIn = "//input[@type='submit' and @value='Sign In']";
		String commentClick = "//input[@type='text' and @name='Comment']";
		String password = "arsman123";
		String name = "arsman123";
		String comment = "Post o rhi he";
		driver.findElement(By.id("inputName")).sendKeys(name);
		driver.findElement(By.id("inputPassword")).sendKeys(password);
		driver.findElement(By.xpath(signIn)).click();
		driver.findElement(By.name("Comment")).sendKeys(comment);
		driver.findElement(By.xpath(commentClick)).submit();

		DataBaseHandler db = new DataBaseHandler();
		db.isCommentExist(name, comment);

	}
}
