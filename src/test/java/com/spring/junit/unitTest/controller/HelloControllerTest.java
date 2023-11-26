package com.spring.junit.unitTest.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(value = HelloController.class)
public class HelloControllerTest {

	@Autowired
	MockMvc mockMvc;

	@Test
	public void HelloWorlTest() throws Exception {
		MockHttpServletRequestBuilder accept = MockMvcRequestBuilders.get("/hello-world")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult andReturn = mockMvc.perform(accept).andExpect(status().isOk()).andReturn();
		assertEquals("hello-world", andReturn.getResponse().getContentAsString());

	}

}
