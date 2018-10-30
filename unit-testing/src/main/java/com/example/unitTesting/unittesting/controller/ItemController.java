package com.example.unitTesting.unittesting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.unitTesting.unittesting.business.ItemBusinessService;
import com.example.unitTesting.unittesting.model.Item;

@RestController
public class ItemController {
	
	@Autowired
	private ItemBusinessService businessService;
	
	@GetMapping("/dummy-item")
	public Item dummyItems() {
		return new Item(1, "Ball", 10, 100);
	}
	
	@GetMapping("/item-from-business")
	public Item itemFromBusiness() {
		return businessService.retrieveHardcodedValues();
	}
	
	@GetMapping("/all-items")
	public List<Item> retrieveAllItem(){
		return businessService.retrieveAllItems();
	}

}
