package com.tmquiz.model;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 
 */
public class ResponseTmBean {

	@NotEmpty
	private String tmname;

	public String getTmname() {
		return tmname;
	}

	public void setTmname(String tmname) {
		this.tmname = tmname;
	}
}
