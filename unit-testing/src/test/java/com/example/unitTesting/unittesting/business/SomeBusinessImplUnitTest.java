package com.example.unitTesting.unittesting.business;

import static org.junit.Assert.*;

import org.junit.Test;

public class SomeBusinessImplUnitTest {
	@Test
	public void calculateSum_basic() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		int result = business.calculateSum(new int [] {1,2,3});
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
