package com.example.unitTesting.unittesting.controller;

//import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.example.unitTesting.unittesting.controller.HelloWorldController;

@RunWith(SpringRunner.class)
@WebMvcTest(HelloWorldController.class)
public class HelloControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void helloworld_basic() throws Exception {
		// call GET
		RequestBuilder request = MockMvcRequestBuilders.get("/hello")
				.accept(org.springframework.http.MediaType.APPLICATION_JSON);
//		MvcResult result = 
		mockMvc.perform(request).andExpect(status().isOk()).andExpect(content().string("Hello")).andReturn();

		// verify output
		// assertEquals("Hello", result.getResponse().getContentAsString());
	}
}
