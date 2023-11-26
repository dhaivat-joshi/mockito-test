package com.spring.junit.unitTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SomeBussinessStubTest2 {
	
	@Test
	public void calculateSumUsingDataService_basic() {
		SomeUnitTestImpl test = new SomeUnitTestImpl();
		test.setSomeDataService(new SomeDataServiceStub());
		int actual = test.calculateSumFromData();
		int expectedVal = 6;
		assertEquals(expectedVal, actual);
	}
}
