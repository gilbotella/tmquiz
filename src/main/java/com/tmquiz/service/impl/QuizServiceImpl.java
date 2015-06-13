package com.tmquiz.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import com.tmquiz.model.QuizBean;
import com.tmquiz.model.QuizLevel;
import com.tmquiz.model.ResponseBean;
import com.tmquiz.model.TmBean;
import com.tmquiz.service.QuizService;

/**
 * Service to manage quizes
 */
@Service
class QuizServiceImpl implements QuizService {

	@Value("classpath:/tmquiz.txt")
	private Resource tmquiz;

	private Map<Integer, TmBean> tms = new HashMap<Integer, TmBean>();
	private Random rand = new Random();

	public TmBean getATrademark(Integer key) throws IOException {
		if (tms.size() == 0) {
			parseFile();
		}
		return tms.get(key);
	}

	public QuizBean createAGame(QuizLevel level) throws IOException {
		if (tms.size() == 0) {
			parseFile();
		}
		QuizBean quiz = new QuizBean(level);

		Integer key;
		for (int i = 0; i < level.getSize() * level.getSize(); i++) {
			// Get element in position pos
			Iterator<Integer> it = tms.keySet().iterator();
			int cont = -1;
			do {
				cont++;
				key = it.next();
			} while (cont < i);
			quiz.getQuestions().put(tms.get(key).getId(), new ResponseBean(tms.get(key)));
		}
		return quiz;
	}

	public QuizBean createARandomGame(QuizLevel level) throws IOException {
		if (tms.size() == 0) {
			parseFile();
		}
		QuizBean quiz = new QuizBean(level);

		int pos;
		Integer key;
		while (quiz.getQuestions().size() < level.getSize() * level.getSize()) {
			pos = rand.nextInt(tms.size());

			// Get element in position pos
			Iterator<Integer> it = tms.keySet().iterator();
			int cont = -1;
			do {
				cont++;
				key = it.next();
			} while (cont < pos);
			if (!quiz.getQuestions().containsKey(key)) {
				quiz.getQuestions().put(tms.get(key).getId(), new ResponseBean(tms.get(key)));
			}
		}
		return quiz;
	}

	private void parseFile() throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(tmquiz.getInputStream()));
		String line = null;

		String[] tm;
		while ((line = in.readLine()) != null) {
			tm = line.split("\\|");
			tms.put(Integer.valueOf(tm[0]), new TmBean(Integer.valueOf(tm[0]), tm[1], tm[2]));
		}
	}
}
