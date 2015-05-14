package com.tmquiz.model;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.tmquiz.model.ResponseTmBean;

public class ResponseTmBeanTest {

	ResponseTmBean responseTmBean;

	@BeforeSuite
	public void createResponseBean() {
		responseTmBean = new ResponseTmBean();
	}

	@Test
	public void inicializacion() {

		assertNull(responseTmBean.getTmname());

		responseTmBean.setTmname("prueba1");
		assertEquals(responseTmBean.getTmname(), "prueba1");
	}
}
