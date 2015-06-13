package com.tmquiz.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import com.tmquiz.model.ResponseBean.ResponseState;

/**
 * A collection with 5 trademarks to game.
 */
public class QuizBean {

	private long startTime;
	private QuizLevel level;
	private Map<Integer, ResponseBean> questions = new HashMap<Integer, ResponseBean>();

	public QuizBean(QuizLevel level) {
		this.level = level;
		this.startTime = System.currentTimeMillis();
	}

	public QuizLevel getLevel() {
		return level;
	}

	private int getNum(ResponseState state) {
		int cont = 0;
		for (Iterator<Integer> it = questions.keySet().iterator(); it.hasNext();) {
			if (questions.get(it.next()).getState() == state) {
				cont++;
			}
		}
		return cont;
	}

	public int getNumSimilar() {
		return getNum(ResponseState.SIMILAR);
	}

	public int getNumCorrect() {
		return getNum(ResponseState.CORRECT);
	}

	public int getNumFailed() {
		return getNum(ResponseState.FAILED);
	}

	public int getNumPending() {
		return getNum(ResponseState.PENDING);
	}

	public Map<Integer, ResponseBean> getQuestions() {
		return questions;
	}

	public long getStartTime() {
		return startTime;
	}

	public boolean isResolved() {
		return getNumCorrect() == questions.size();
	}
}
