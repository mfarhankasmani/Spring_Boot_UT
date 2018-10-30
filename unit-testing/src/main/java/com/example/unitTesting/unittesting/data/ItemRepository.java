package com.example.unitTesting.unittesting.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.unitTesting.unittesting.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {
	

}
