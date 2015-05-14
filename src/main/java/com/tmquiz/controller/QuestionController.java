package com.tmquiz.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.tmquiz.model.QuizBean;
import com.tmquiz.model.ResponseBean;
import com.tmquiz.model.ResponseTmBean;
import com.tmquiz.model.ResponseBean.ResponseState;
import com.tmquiz.service.QuizService;

/**
 * A new game is created.
 */
@Controller
@SessionAttributes("quiz")
class QuestionController {
	@Inject
	QuizService quizService;

	/**
	 * Create a new bean with trademarks to game.
	 * 
	 * @return New tradmarks to game.
	 * @throws IOException
	 */
	@ModelAttribute("responseTm")
	public ResponseTmBean createResponse() throws IOException {
		return new ResponseTmBean();
	}

	/**
	 * Shows the panel with trademarks
	 */
	@RequestMapping(value = "/question/{id}", method = RequestMethod.GET)
	public String form(@ModelAttribute("quiz") QuizBean quiz,
			@PathVariable Integer id, ModelMap modelo) throws IOException {

		modelo.addAttribute("question", quiz.getQuestions().get(id));

		return "question";
	}

	/**
	 * Shows the panel with trademarks
	 */
	@RequestMapping(value = "/response", method = RequestMethod.POST)
	public String form(@ModelAttribute("quiz") QuizBean quiz,
			@RequestParam Integer id, @Valid ResponseTmBean response,
			ModelMap modelo, SessionStatus sessionStatus) throws IOException {
		ResponseBean rb = quiz.getQuestions().get(id);

		if (response.getTmname().equalsIgnoreCase(rb.getTm().getName())) {
			rb.setState(ResponseState.CORRECT);
		} else {
			if (StringUtils.getLevenshteinDistance(
					StringUtils.upperCase(response.getTmname()),
					StringUtils.upperCase(rb.getTm().getName())) > 3) {
				rb.setState(ResponseState.FAILED);
			} else {
				rb.setState(ResponseState.SIMILAR);
			}
		}
		if (quiz.isResolved()) {
			sessionStatus.setComplete();

			modelo.addAttribute("time", getTimeInFormat((System
					.currentTimeMillis() - quiz.getStartTime()) / 1000));

			return "congratulations";
		}
		return "redirect:newGame";
	}

	private String getTimeInFormat(long totalSecs) {
		long hours = totalSecs / 3600;
		long minutes = (totalSecs % 3600) / 60;
		long seconds = totalSecs % 60;

		return (hours > 0 ? hours + "h " : "")
				+ (minutes > 0 ? minutes + "m " : "")
				+ (seconds > 0 ? seconds + "s " : "");
	}
}
