package com.example.unitTesting.unittesting.controller;

import static org.mockito.Mockito.*;
//import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.unitTesting.unittesting.business.ItemBusinessService;
import com.example.unitTesting.unittesting.controller.ItemController;
import com.example.unitTesting.unittesting.model.Item;;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ItemBusinessService businessService;

	@Test
	public void dummyItem_basic() throws Exception {
		// call GET
		RequestBuilder request = MockMvcRequestBuilders.get("/dummy-item")
				.accept(org.springframework.http.MediaType.APPLICATION_JSON);
//		MvcResult result = 
		mockMvc.perform(request).andExpect(status().isOk())
				.andExpect(content().json("{\"id\": 1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}")).andReturn();

		// verify output
		// assertEquals("Hello", result.getResponse().getContentAsString());
	}

	@Test
	public void itemFromBusiness_basic() throws Exception {
		// call GET
		when(businessService.retrieveHardcodedValues()).thenReturn(new Item(1, "Ball", 10, 100));
		RequestBuilder request = MockMvcRequestBuilders.get("/item-from-business")
				.accept(org.springframework.http.MediaType.APPLICATION_JSON);
//		MvcResult result = 
		mockMvc.perform(request).andExpect(status().isOk())
				.andExpect(content().json("{\"id\": 1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}")).andReturn();

	}

	@Test
	public void retrieveAllItems_basic() throws Exception {
		// call GET
		when(businessService.retrieveAllItems()).thenReturn(Arrays.asList(new Item(1, "Ball", 10, 100), new Item(2, "Ball", 20, 100)));
		RequestBuilder request = MockMvcRequestBuilders.get("/all-items")
				.accept(org.springframework.http.MediaType.APPLICATION_JSON);
//		MvcResult result = 
		mockMvc.perform(request).andExpect(status().isOk())
				.andExpect(content().json("[{\"id\": 1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}, {\"id\": 2,\"name\":\"Ball\",\"price\":20}]")).andReturn();

	}
}
