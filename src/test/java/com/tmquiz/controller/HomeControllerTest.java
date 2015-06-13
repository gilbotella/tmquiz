package com.tmquiz.controller;

import static org.springframework.test.web.server.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.view;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.server.MockMvc;
import org.springframework.test.web.server.setup.MockMvcBuilders;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.*;
import org.testng.annotations.*;

@ContextConfiguration("classpath:servlet-context.xml")
public class HomeControllerTest extends AbstractTestNGSpringContextTests {

	@Autowired
	HomeController controller;

	MockMvc mockMvc;

	@BeforeClass
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(controller).setViewResolvers(viewResolver()).build();
	}

	@Test
	public void testAbout() throws Exception {
		mockMvc.perform(get("/about")).andExpect(status().isOk()).andExpect(view().name("about"));
	}

	@Test
	public void testError() throws Exception {
		mockMvc.perform(get("/homee")).andExpect(status().isNotFound());
	}

	@Test
	public void testHome() throws Exception {

		mockMvc.perform(get("/home")).andExpect(status().isOk()).andExpect(view().name("home"));
	}

	private ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/jsp/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}
}
