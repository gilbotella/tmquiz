package com.tmquiz.service;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import java.io.IOException;
import java.util.Iterator;
import javax.inject.Inject;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;
import com.tmquiz.model.*;

@ContextConfiguration(locations = { "classpath:servlet-context.xml" })
public class QuizServiceImplTest extends AbstractTestNGSpringContextTests {

	@Inject
	QuizService quizService;

	@Test
	public void createAGame() throws IOException {
		QuizBean quiz = quizService.createAGame(QuizLevel.DIFFICULT);
		validaQuiz(quiz);
	}

	@Test
	public void createARandomGame() throws IOException {
		QuizBean quiz = quizService.createARandomGame(QuizLevel.DIFFICULT);
		validaQuiz(quiz);
	}

	private void validaQuiz(QuizBean quiz) {
		assertEquals(quiz.getNumSimilar(), 0);
		assertEquals(quiz.getNumCorrect(), 0);
		assertEquals(quiz.getNumFailed(), 0);
		assertEquals(quiz.getNumPending(), 25);

		assertNotNull(quiz.getQuestions());

		ResponseBean response;
		for (Iterator<Integer> it = quiz.getQuestions().keySet().iterator(); it.hasNext();) {
			response = quiz.getQuestions().get(it.next());

			assertNotNull(response.getTm());
			switch (response.getTm().getId()) {
			case 1:
				assertEquals(response.getTm().getName(), "Don coche");
				assertEquals(response.getTm().getUrllogo(), "/tmquiz/image/ES500000002071473.jpeg");
				break;
			case 5:
				assertEquals(response.getTm().getName(), "Laser-pie");
				assertEquals(response.getTm().getUrllogo(), "/tmquiz/image/ES500000002524002.jpeg");
				break;
			}
		}

	}
}
