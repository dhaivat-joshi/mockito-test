package com.spring.junit.unitTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SomeUnitTestImplSample {
	
	@Test
	public void calculateSumTest_basic() {
		SomeUnitTestImpl test = new SomeUnitTestImpl();
		int actual = test.calculateSum(new int[]{1,2,3});
		int expectedVal = 6;
		assertEquals(expectedVal, actual);
	}
}
