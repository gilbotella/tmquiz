package com.tmquiz.model;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.tmquiz.model.TmBean;

public class TmBeanTest {

	TmBean tm;

	@BeforeSuite
	public void createQuizBean() {
		tm = new TmBean(1, "test1", "test1.com");
	}

	@Test
	public void inicializacion() {
		assertEquals(tm.getId(), Integer.valueOf(1));
		assertEquals(tm.getName(), "test1");
		assertEquals(tm.getUrllogo(), "test1.com");
	}

	@Test
	public void respuestas() {
		tm.setId(5);
		assertEquals(tm.getId().longValue(), 5);

		tm.setName("Name");
		assertEquals(tm.getName(), "Name");

		tm.setUrllogo("testing.com");
		assertEquals(tm.getUrllogo(), "testing.com");
	}
}
