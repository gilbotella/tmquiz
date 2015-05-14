package com.tmquiz.selenium;

import static org.testng.Assert.fail;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class UnAciertoIT {

	protected WebDriver driver;

	protected String baseUrl;
	protected StringBuffer verificationErrors = new StringBuffer();

	@BeforeTest
	@Parameters({ "localtest", "selenium.remote.server", "server.test",
			"selenium.browser", "ie.driver", "chrome.driver" })
	public void setUp(boolean isLocaltest, String seleniumRemoteServer,
			String serverTest, @Optional("firefox") String browser, String ieDriver,
			String chromeDriver) throws Exception {
		System.out
				.println("testAboutIT - START: " + System.currentTimeMillis());

		if (isLocaltest) {
			if (browser.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
			}
			if (browser.equalsIgnoreCase("iexplore")) {
				File file = new File(ieDriver);
				System.setProperty("webdriver.ie.driver",
						file.getAbsolutePath());
				driver = new InternetExplorerDriver();
			}
			if (browser.equalsIgnoreCase("chrome")) {
				File file = new File(chromeDriver);
				System.setProperty("webdriver.chrome.driver",
						file.getAbsolutePath());
				driver = new ChromeDriver();
			}
		} else {
			DesiredCapabilities capability = null;
			if (browser.equalsIgnoreCase("firefox")) {
				capability = DesiredCapabilities.firefox();
				capability.setBrowserName("firefox");
				capability.setPlatform(org.openqa.selenium.Platform.ANY);
			}
			if (browser.equalsIgnoreCase("iexplore")) {
				capability = DesiredCapabilities.internetExplorer();
				capability.setBrowserName("iexplore");
				capability.setPlatform(org.openqa.selenium.Platform.WINDOWS);
			}
			if (browser.equalsIgnoreCase("chrome")) {
				capability = DesiredCapabilities.chrome();
				capability.setBrowserName("chrome");
				capability.setPlatform(org.openqa.selenium.Platform.ANY);
			}
			driver = new RemoteWebDriver(new URL(seleniumRemoteServer),
					capability);
		}
		baseUrl = serverTest;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterTest
	public void tearDown() throws Exception {
		System.out.println("UnAciertoIT - STOP: " + System.currentTimeMillis());
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	@Test
	public void testUnAciertoIT() throws Exception {
		driver.get(baseUrl + "/tmquiz/");
		driver.manage().window().maximize();

		driver.findElement(By.linkText("English")).click();
		driver.findElement(By.xpath("(//a[contains(@href, '#')])[2]")).click();
		driver.findElement(By.partialLinkText("Easy")).click();
		driver.findElement(By.linkText("English")).click();
		driver.findElement(By.linkText("To do")).click();
		driver.findElement(By.id("tmname")).clear();
		driver.findElement(By.id("tmname")).sendKeys("don coche");
		driver.findElement(By.cssSelector("button.btn")).click();
	}

}
