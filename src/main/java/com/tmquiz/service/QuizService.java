package com.tmquiz.service;

import java.io.IOException;

import com.tmquiz.model.QuizBean;
import com.tmquiz.model.QuizLevel;
import com.tmquiz.model.TmBean;

/**
 * Service to manage quizes
 */
public interface QuizService {

	QuizBean createAGame(QuizLevel level) throws IOException;

	QuizBean createARandomGame(QuizLevel level) throws IOException;
	
	TmBean getATrademark(Integer key) throws IOException;
}
