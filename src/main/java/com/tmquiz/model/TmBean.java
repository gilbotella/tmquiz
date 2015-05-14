package com.tmquiz.model;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Trademark information
 */
public class TmBean {
	@NotNull
	private Integer id;

	@NotEmpty
	@Length(max = 15)
	private String name;

	@NotEmpty
	private String urllogo;

	public TmBean(Integer id, String name, String urllogo) {
		this.id = id;
		this.name = name;
		this.urllogo = urllogo;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getUrllogo() {
		return urllogo;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUrllogo(String urllogo) {
		this.urllogo = urllogo;
	}
}
