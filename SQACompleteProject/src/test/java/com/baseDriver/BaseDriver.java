package com.baseDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseDriver {
	protected WebDriver driver = null;
	protected String baseUrl1 = null;
	protected String baseUrl2 = null;
	protected String baseUrl3 = null;
	protected String baseUrl4 = null;
	protected String baseUrl5 = null;
	protected String baseUrl6 = null;

	@Parameters("browser")
	@BeforeClass
	public void setUp(String browser) {

		if (browser.equalsIgnoreCase("firefox")) {
			System.out.println("Firefox");
			driver = new FirefoxDriver();
		}

		// DBHandler b = new DBHandler();
		// b.openConnection();

		if (browser.equalsIgnoreCase("chrome")) {
			System.out.println("Chrome");
			System.setProperty("webdriver.chrome.driver",
					"resources/chromedriver.exe");
			driver = new ChromeDriver();
		}
		if (browser.equalsIgnoreCase("InternetExplorer")) {
			System.out.println("IExplorer");
			System.setProperty("webdriver.ie.driver",
					"resources/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}

		if (browser.equalsIgnoreCase("safari")) {
			System.out.println("Safari");
			System.setProperty("webdriver.safari.driver",
					"resources/SafariDriver.safariextension");
			driver = new SafariDriver();
		}
		baseUrl1 = "https://bitf12m036mobilearena.apphb.com/Home/SignUp";
		baseUrl2 = "http://farhanyaseensocialpedia.apphb.com/Home/SignIn";
		baseUrl3 = "http://bitf12m036mobilearena.apphb.com/";
		baseUrl4 = "http://bitf12m051.apphb.com/Home/SignUp";
		baseUrl5 = "https://bitf12m036mobilearena.apphb.com/Home/Login";
		baseUrl6 = "http://bitf12m036mobilearena.apphb.com/Home/Feedback";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterClass
	public void tearDown() {
		// driver.quit();
	}

}
