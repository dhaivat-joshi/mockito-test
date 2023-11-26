package com.spring.junit.unitTest.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.junit.unitTest.model.Item;

@Component
public class ItemBussinessService {
	@Autowired
	private ItemRepository itemRepository;
	
	public Item retriveHardCodeITem() {
		// TODO Auto-generated method stub
		return new Item(2, "me", 100, 3);
	}
	
	public List<Item> retriveAllItem(){
		return itemRepository.findAll();
	}

}
