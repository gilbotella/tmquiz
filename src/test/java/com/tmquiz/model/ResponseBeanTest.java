package com.tmquiz.model;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.tmquiz.model.ResponseBean;
import com.tmquiz.model.TmBean;
import com.tmquiz.model.ResponseBean.ResponseState;

public class ResponseBeanTest {

	ResponseBean responseBean;
	TmBean tm;

	@BeforeSuite
	public void createResponseBean() {
		tm = new TmBean(1, "test1", "test1.com");
		responseBean = new ResponseBean(tm);
	}

	@Test
	public void inicializacion() {
		assertEquals(responseBean.getState(), ResponseState.PENDING);
		assertNotNull(responseBean.getTm());
		assertEquals(responseBean.getTm().getId(), Integer.valueOf(1));

		responseBean.setState(ResponseState.CORRECT);
		assertEquals(responseBean.getState(), ResponseState.CORRECT);
	}
}
