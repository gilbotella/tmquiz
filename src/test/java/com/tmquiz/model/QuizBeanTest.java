package com.tmquiz.model;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import java.util.Map;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.tmquiz.model.QuizBean;
import com.tmquiz.model.QuizLevel;
import com.tmquiz.model.ResponseBean;
import com.tmquiz.model.TmBean;
import com.tmquiz.model.ResponseBean.ResponseState;

public class QuizBeanTest {

	QuizBean quizBean;

	@BeforeSuite
	public void createQuizBean() {
		quizBean = new QuizBean(QuizLevel.EASY);
	}

	@Test
	public void inicializacion() {
		assertEquals(quizBean.getNumSimilar(), 0);
		assertEquals(quizBean.getNumCorrect(), 0);
		assertEquals(quizBean.getNumFailed(), 0);
		assertEquals(quizBean.getNumPending(), 0);
	}

	@Test
	public void respuestas() {
		Map<Integer, ResponseBean> questions = quizBean.getQuestions();

		ResponseBean rb1 = new ResponseBean(new TmBean(1, "test1", "test1.com"));
		ResponseBean rb2 = new ResponseBean(new TmBean(2, "test2", "test2.com"));
		ResponseBean rb3 = new ResponseBean(new TmBean(3, "test3", "test3.com"));
		ResponseBean rb4 = new ResponseBean(new TmBean(4, "test4", "test4.com"));

		questions.put(1, rb1);
		questions.put(2, rb2);
		questions.put(3, rb3);
		questions.put(4, rb4);

		assertEquals(quizBean.getNumSimilar(), 0);
		assertEquals(quizBean.getNumCorrect(), 0);
		assertEquals(quizBean.getNumFailed(), 0);
		assertEquals(quizBean.getNumPending(), 4);

		rb1.setState(ResponseState.SIMILAR);
		assertEquals(quizBean.getNumSimilar(), 1);
		assertEquals(quizBean.getNumCorrect(), 0);
		assertEquals(quizBean.getNumFailed(), 0);
		assertEquals(quizBean.getNumPending(), 3);

		rb2.setState(ResponseState.CORRECT);
		assertEquals(quizBean.getNumSimilar(), 1);
		assertEquals(quizBean.getNumCorrect(), 1);
		assertEquals(quizBean.getNumFailed(), 0);
		assertEquals(quizBean.getNumPending(), 2);

		rb3.setState(ResponseState.FAILED);
		assertEquals(quizBean.getNumSimilar(), 1);
		assertEquals(quizBean.getNumCorrect(), 1);
		assertEquals(quizBean.getNumFailed(), 1);
		assertEquals(quizBean.getNumPending(), 1);

		assertFalse(quizBean.isResolved());

		rb1.setState(ResponseState.CORRECT);
		rb2.setState(ResponseState.CORRECT);
		rb3.setState(ResponseState.CORRECT);
		rb4.setState(ResponseState.CORRECT);

		assertTrue(quizBean.isResolved());
	}
}
