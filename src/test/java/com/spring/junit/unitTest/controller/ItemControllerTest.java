package com.spring.junit.unitTest.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.spring.junit.unitTest.business.ItemBussinessService;
import com.spring.junit.unitTest.model.Item;


@WebMvcTest(value = ItemController.class)
public class ItemControllerTest {
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	private ItemBussinessService itemBussinessService;
	
	@Test
	public void dummyItemTest() throws Exception {
		MockHttpServletRequestBuilder dummyItem = MockMvcRequestBuilders
			.get("/dummy-item")
			.accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(dummyItem).andExpect(status().isOk())
				.andExpect(content().json("{\"id\": 1,\"name\": \"dhaivat\",\"price\": 100,\"quantity\": 2}")).andReturn();
	}

	
	@Test
	public void dummyItemTestJsonAssert() throws Exception {
		MockHttpServletRequestBuilder dummyItem = MockMvcRequestBuilders
			.get("/dummy-item")
			.accept(MediaType.APPLICATION_JSON);
		MvcResult actual = mockMvc.perform(dummyItem).andExpect(status().isOk())
				.andReturn();
		JSONAssert.assertEquals("{\"id\": 1,\"name\": \"dhaivat\",\"price\": 100,\"quantity\": 2}", 
				 actual.getResponse().getContentAsString(), true);
	}
	
	
	@Test
	public void dummyTestResponseFromBussinessService() throws Exception {
		when(itemBussinessService.retriveHardCodeITem()).thenReturn(new Item(2, "me", 100, 3));
		
		MockHttpServletRequestBuilder accept = MockMvcRequestBuilders
					.get("/item-from-bussiness-service")
					.accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(accept).andExpect(status().isOk())
				.andExpect(content().json("{id:2,name:me,price:100}")).andReturn();//2, "me", 100, 3
	}
}
