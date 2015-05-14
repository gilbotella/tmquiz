package com.tmquiz.controller;

import java.io.IOException;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.tmquiz.model.QuizLevel;
import com.tmquiz.service.QuizService;

/**
 * A new game is created.
 */
@Controller
@RequestMapping("/newGame")
@SessionAttributes("quiz")
class NewGameController {

	@Inject
	QuizService quizService;

	/**
	 * Shows the panel with trademarks
	 */
	@RequestMapping(value = "/{way}", method = RequestMethod.GET)
	public String form(@PathVariable String way, ModelMap modelo)
			throws IOException {
		if (way.equals("easy")) {
			modelo.addAttribute("quiz", quizService.createAGame(QuizLevel.EASY));
		} else if (way.equals("medium")) {
			modelo.addAttribute("quiz",
					quizService.createAGame(QuizLevel.MEDIUM));
		} else if (way.equals("difficult")) {
			modelo.addAttribute("quiz",
					quizService.createAGame(QuizLevel.DIFFICULT));
		}
		return "quizPanel";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String next() {
		return "quizPanel";
	}
}
