package com.example.unitTesting.unittesting.business;

import static org.junit.Assert.*;
//import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

//import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
//import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.unitTesting.unittesting.data.SomeDataService;

@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessImplMockUnitTest {
	@InjectMocks
	SomeBusinessImpl business = new SomeBusinessImpl();
	
	@Mock
	SomeDataService dataServiceMock;
	
	//SomeDataService dataServiceMock = mock(SomeDataService.class); // mocking data service
	
//	@Before
//	public void before() {
//		business.setSomeDataService(dataServiceMock);
//	}
	
	@Test
	public void calculateSumUsingDataService_basic() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int [] {1,2,3});
		assertEquals(6, business.calculateSumUsingDataService());
	}
	
	@Test
	public void calculateSumUsingDataService_empty() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int [] {});
		assertEquals(0, business.calculateSumUsingDataService());
	}
	
	@Test
	public void calculateSumUsingDataService_Single() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int [] {5});
		assertEquals(5, business.calculateSumUsingDataService());
	}
}
