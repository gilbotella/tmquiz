package com.tmquiz.model;

/**
 * Trademark information
 */
public class ResponseBean {

	public enum ResponseState {
		PENDING, FAILED, CORRECT, SIMILAR
	}

	private TmBean tm;
	private ResponseState state;

	public ResponseBean(TmBean tm) {
		this.tm = tm;
		this.state = ResponseState.PENDING;
	}

	public ResponseState getState() {
		return state;
	}

	public TmBean getTm() {
		return tm;
	}

	public void setState(ResponseState state) {
		this.state = state;
	}
}
