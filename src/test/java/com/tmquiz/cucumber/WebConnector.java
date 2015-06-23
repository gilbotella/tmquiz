package com.tmquiz.cucumber;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import cucumber.api.java.*;

public class WebConnector {
	private final static long DEFAULT_TIMEOUT = 2000;
	WebDriver driver = new FirefoxDriver();

	@Before
	public void initSelenium() throws Exception {
	}

	@After
	public void destroySelenium() {
		driver.close();
	}

	public void clickAndWait(String selector) {
		WebElement element = driver.findElement(By.id(selector));
		element.click();
		driver.manage().timeouts().implicitlyWait(DEFAULT_TIMEOUT, TimeUnit.MILLISECONDS);
	}

	public void clickLanguage(String lang) {
		driver.findElement(By.linkText(lang)).click();
		driver.findElement(By.xpath("(//a[contains(@href, '#')])[2]")).click();
	}

	public void openAndWait(String location) {
		driver.get(location);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(DEFAULT_TIMEOUT, TimeUnit.MILLISECONDS);
	}

	public void clickAbout() {
		driver.findElement(By.partialLinkText("About")).click();
	}

	public boolean isTextPresent(String text) {
		WebElement content = driver.findElement(By.tagName("body"));
		return content.getText().contains(text);
	}

	public String getEmail() {
		return driver.findElement(By.partialLinkText("julian_gil")).getAttribute("href");
	}
}
