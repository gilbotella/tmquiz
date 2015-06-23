package com.tmquiz.controller;

import static org.hamcrest.Matchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.*;
import org.testng.Assert;
import org.testng.annotations.*;
import com.tmquiz.model.QuizBean;

@ContextConfiguration("classpath:servlet-context.xml")
public class NewGameControllerTest extends AbstractTestNGSpringContextTests {

	@Autowired
	NewGameController controller;

	MockMvc mockMvc;

	@BeforeClass
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(controller).setViewResolvers(viewResolver()).build();
	}

	@Test
	public void testNewGameDifficult() throws Exception {
		testNewGameWay("difficult", 25);
	}

	@Test
	public void testNewGameEasy() throws Exception {
		testNewGameWay("easy", 9);
	}

	@Test
	public void testNewGameError() throws Exception {
		mockMvc.perform(get("/newGame/{way}", "error")).andExpect(status().isOk()).andExpect(view().name("quizPanel"));
	}

	@Test
	public void testNewGameGet() throws Exception {

		mockMvc.perform(get("/newGame")).andExpect(status().isOk()).andExpect(view().name("quizPanel"));
	}

	@Test
	public void testNewGameMedium() throws Exception {
		testNewGameWay("medium", 16);
	}

	@Test
	public void testNewGamePost() throws Exception {

		mockMvc.perform(post("/newGame")).andExpect(status().isMethodNotAllowed());
	}

	private void testNewGameWay(String way, int size) throws Exception {
		MvcResult result = mockMvc.perform(get("/newGame/{way}", way)).andExpect(status().isOk()).andExpect(view().name("quizPanel"))
				.andExpect(model().attribute("quiz", any(QuizBean.class))).andReturn();

		// Get attribute "quiz" from the model
		QuizBean quiz = (QuizBean) result.getModelAndView().getModel().get("quiz");

		Assert.assertEquals(quiz.getQuestions().size(), size);
	}

	private ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/jsp/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}
}
