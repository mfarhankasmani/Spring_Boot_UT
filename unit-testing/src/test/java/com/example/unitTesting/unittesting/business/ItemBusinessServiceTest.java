package com.example.unitTesting.unittesting.business;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.unitTesting.unittesting.data.ItemRepository;
import com.example.unitTesting.unittesting.model.Item;

@RunWith(MockitoJUnitRunner.class)
public class ItemBusinessServiceTest {
	@InjectMocks
	private ItemBusinessService business;
	
	@Mock
	private ItemRepository repository;
	
	@Test
	public void calculateSumUsingDataService_basic() {
		when(repository.findAll()).thenReturn(Arrays.asList(new Item(1, "Ball", 10, 100), new Item(2, "Ball", 20, 100)));
		List<Item> items= business.retrieveAllItems();
		assertEquals(1000, items.get(0).getValue());
		assertEquals(2000, items.get(1).getValue());
	}
	
}
