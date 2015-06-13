package com.tmquiz.webservices;

import static org.springframework.test.web.server.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.server.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.status;
import javax.inject.Inject;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.server.MockMvc;
import org.springframework.test.web.server.setup.MockMvcBuilders;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.tmquiz.webservices.NewGameRestController;

@ContextConfiguration("classpath:servlet-context.xml")
public class NewGameRestControllerTest extends AbstractTestNGSpringContextTests {

	@Inject
	NewGameRestController controller;

	MockMvc mockMvc;

	@BeforeClass
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Test
	public void testNewGameEasy() throws Exception {
		mockMvc.perform(get("/newGameWS/{way}", "easy")).andExpect(status().isOk())
				.andExpect(content().mimeType("application/json;charset=UTF-8")).andDo(print())
				.andExpect(jsonPath("$.level").value("EASY"));
	}
}
