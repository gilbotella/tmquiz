package com.tmquiz.model;

public enum QuizLevel {
	EASY(3), MEDIUM(4), DIFFICULT(5);

	private int size;

	private QuizLevel(int size) {
		this.size = size;
	}

	public int getSize() {
		return size;
	}
}
