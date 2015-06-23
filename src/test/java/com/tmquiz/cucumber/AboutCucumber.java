package com.tmquiz.cucumber;

import static org.testng.Assert.assertEquals;
import cucumber.api.java.*;
import cucumber.api.java.en.*;

public class AboutCucumber {
	private WebConnector connector;

	public AboutCucumber(WebConnector connector) {
		this.connector = connector;
	}

	@Before
	public void beforeScenario() {
		System.out.println(" *** Before");
	}

	@After
	public void afterScenario() {
		System.out.println(" *** After");
	}

	@Given("^User is on Home Page$")
	public void user_is_on_Home_Page() throws Throwable {
		connector.openAndWait("http://localhost:8080/tmquiz");
	}

	@When("^user select English$")
	public void user_select_English() throws Throwable {
		connector.clickLanguage("English");
	}

	@When("^user click about$")
	public void user_click_about() throws Throwable {
		connector.clickAbout();
	}

	@Then("^email found is mine$")
	public void email_found_is_mine() throws Throwable {
		assertEquals(connector.getEmail(), "mailto:julian_gil@ieci.es");
	}
}
