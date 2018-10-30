package com.example.unitTesting.unittesting.business;

import static org.junit.Assert.*;

import org.junit.Test;

import com.example.unitTesting.unittesting.data.SomeDataService;

class SomeDataServiceStub implements SomeDataService {

	@Override
	public int[] retrieveAllData() {
		// TODO Auto-generated method stub
		return new int[] {1,2,3};
	}
	
}

public class SomeBusinessImplStubUnitTest {
	@Test
	public void calculateSumUsingDataService_basic() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		business.setSomeDataService(new SomeDataServiceStub());
		int result = business.calculateSumUsingDataService();
		int expectedResult = 6;
		assertEquals(expectedResult, result);
	}
	
	@Test
	public void calculateSum_empty() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		int result = business.calculateSum(new int [] {});
		int expectedResult = 0;
		assertEquals(expectedResult, result);
	}
}
