package com.spring.junit.unitTest.business;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.junit.unitTest.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
