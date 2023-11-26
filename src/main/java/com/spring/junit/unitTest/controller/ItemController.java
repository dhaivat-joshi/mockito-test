package com.spring.junit.unitTest.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.junit.unitTest.business.ItemBussinessService;
import com.spring.junit.unitTest.model.Item;

@RestController
public class ItemController {
	
	private final ItemBussinessService itemBussinessService;
	
	protected ItemController(ItemBussinessService itemBussinessService){
		this.itemBussinessService=itemBussinessService;
	}
	
	@GetMapping("/dummy-item")
	public Item getItem() {
		return new Item(1,"dhaivat",100,2);
	}
	
	@GetMapping("/item-from-bussiness-service")
	public Item itemFromBussinessService() {
		return itemBussinessService.retriveHardCodeITem();
	}
	
	@GetMapping("/all-item-from-database")
	public List<Item> retriveAllItemFromDatabse() {
		List<Item> items = itemBussinessService.retriveAllItem();

		return items.stream().peek(item -> item.setValue(item.getPrice() * item.getQuantity()))
				.collect(Collectors.toList());

	}
	@GetMapping("/hello")
	public String helloMe(){
		return "hello dhaivat";
	}

}
