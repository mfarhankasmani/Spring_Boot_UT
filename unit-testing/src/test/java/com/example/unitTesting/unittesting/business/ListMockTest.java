package com.example.unitTesting.unittesting.business;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.mockito.ArgumentCaptor;


public class ListMockTest {
	
	List<String> mock = mock(List.class);
	
	@Test
	public void size_basic() {
		when(mock.size()).thenReturn(5);
		assertEquals(5, mock.size());
	}
	
	@Test
	public void returnDiffValues() {
		when(mock.size()).thenReturn(5).thenReturn(10);
		assertEquals(5, mock.size());
		assertEquals(10, mock.size());
	}
	
	@Test
	public void returnWithParameters() {
		when(mock.get(0)).thenReturn("inMinutes");
		assertEquals("inMinutes", mock.get(0));
		assertEquals(null, mock.get(1));
	}
	
	@Test
	public void returnWithGenericParameters() {
		when(mock.get(anyInt())).thenReturn("inMinutes");
		assertEquals("inMinutes", mock.get(0));
	}

	@Test
	public void verificationBasics() {
		//SUT
		String value1 = mock.get(0);
		String value2 = mock.get(1);
		
		//verify
		verify(mock).get(0);
		verify(mock, times(2)).get(anyInt());
		verify(mock,atLeast(1)).get(0);
	}
	
	@Test
	public void argumentCap() {
		//SUT
		mock.add("SomeString");
		
		//Verification
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mock).add(captor.capture());
		
		assertEquals("SomeString", captor.getValue());
	}
	
	@Test
	public void MultiArgumentCap() {
		//SUT
		mock.add("SomeString1");
		mock.add("SomeString2");
		
		//Verification
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mock, times(2)).add(captor.capture());
		
		List<String> allValues = captor.getAllValues();
		assertEquals("SomeString1", allValues.get(0));
		assertEquals("SomeString2", allValues.get(1));
	}
	
	@Test
	public void spying() {
		//Spy changes the working of actual class
		ArrayList arrayListSpy = spy(ArrayList.class);
		arrayListSpy.add("Test0");
		System.out.println(arrayListSpy.get(0));
		System.out.println(arrayListSpy.size());
		arrayListSpy.add("Test1");
		arrayListSpy.add("Test2");
		System.out.println(arrayListSpy.size());
		
		when(arrayListSpy.size()).thenReturn(5);
		System.out.println(arrayListSpy.size());
		
		arrayListSpy.add("Test3");
		System.out.println(arrayListSpy.size());
		
		verify(arrayListSpy.add("Test"));
	}
}
