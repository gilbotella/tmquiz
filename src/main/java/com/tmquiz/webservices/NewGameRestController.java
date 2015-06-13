package com.tmquiz.webservices;

import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.tmquiz.model.QuizBean;
import com.tmquiz.model.QuizLevel;
import com.tmquiz.service.QuizService;

/**
 * A new game is created.
 */
@Controller
@RequestMapping("/newGameWS")
public class NewGameRestController {

	@Inject
	QuizService quizService;

	@RequestMapping(value = "/{way}", method = RequestMethod.GET)
	public @ResponseBody
	QuizBean form(@PathVariable String way, HttpServletResponse response) throws IOException {
		QuizBean quiz;
		if (way.equals("easy")) {
			quiz = quizService.createAGame(QuizLevel.EASY);
		} else if (way.equals("medium")) {
			quiz = quizService.createAGame(QuizLevel.MEDIUM);
		} else if (way.equals("difficult")) {
			quiz = quizService.createAGame(QuizLevel.DIFFICULT);
		} else {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Try again");
			quiz = null;
		}
		return quiz;
	}
}
