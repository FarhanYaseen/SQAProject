package com.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.baseDriver.BaseDriver;
import com.databases.DataBaseHandler;

public class CommentMobileArenaTestCase extends BaseDriver {
	@Test
	public void commentMobileArenaTestCase() {
		driver.get(baseUrl5);
		String signIn = "//input[@type='submit' and @value='Login']";
		String commentBar = "//input[@type='text' and @id='name']";
		String searchBar = "//input[@type='text' and @name='mobileName']";
		String password = "12";
		String name = "bitf12m036@pucit.edu.pk";
		String comment = "123";
		driver.findElement(By.id("name")).sendKeys(name);
		driver.findElement(By.id("pass")).sendKeys(password);

		driver.findElement(By.xpath(signIn)).click();
		// driver.findElement(By.name("mobileName")).sendKeys("s4");

		driver.findElement(By.xpath(searchBar)).sendKeys("s4");
		driver.findElement(By.xpath(searchBar)).submit();

		driver.findElement(By.xpath(commentBar)).sendKeys(comment);
		driver.findElement(By.xpath(commentBar)).submit();

		DataBaseHandler db = new DataBaseHandler();
		db.isCommentInMAExist(name, comment);
	}
}
