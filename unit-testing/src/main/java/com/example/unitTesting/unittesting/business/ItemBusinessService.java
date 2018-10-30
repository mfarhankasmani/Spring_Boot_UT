package com.example.unitTesting.unittesting.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.unitTesting.unittesting.data.ItemRepository;
import com.example.unitTesting.unittesting.model.Item;

@Service
public class ItemBusinessService {
	
	@Autowired
	private ItemRepository repository;
	
	public Item retrieveHardcodedValues() {
		return new Item(1, "Ball", 10, 100);
	}
	
	public List<Item> retrieveAllItems(){
		List<Item> items = repository.findAll();
		for(Item item:items) {
			item.setValue(item.getPrice() * item.getQuantity());
		}
		return items;
	}

}
