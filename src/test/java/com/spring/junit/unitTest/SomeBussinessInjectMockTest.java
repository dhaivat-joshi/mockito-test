package com.spring.junit.unitTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SomeBussinessInjectMockTest {
	
	@InjectMocks
	SomeUnitTestImpl test;
	@Mock
	SomeDataService mock2;

	

	@Test
	public void calculateSumUsingDataService_basic() {
		when(mock2.getAllData()).thenReturn(new int[] { 1, 2, 3 });
		int expectedVal = 6;
		int actual = test.calculateSumFromData();
		assertEquals(expectedVal, actual);
	}

	@Test
	public void calculateSumUsingDataService_empty() {
		when(mock2.getAllData()).thenReturn(new int[] {});
		int actual = test.calculateSumFromData();
		assertEquals(0, actual);

	}

	@Test
	public void calculateSumUsingDataService_One() {
		when(mock2.getAllData()).thenReturn(new int[] { 1 });
		int actual = test.calculateSumFromData();
		System.out.println("actual=>" + actual);
		assertEquals(1, actual);

	}
}
