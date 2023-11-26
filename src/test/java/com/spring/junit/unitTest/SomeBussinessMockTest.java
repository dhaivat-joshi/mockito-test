package com.spring.junit.unitTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

public class SomeBussinessMockTest {

	SomeUnitTestImpl test = new SomeUnitTestImpl();
	SomeDataService mock2 = mock(SomeDataService.class);

	@BeforeEach
	public void before() {
		test.setSomeDataService(mock2);
	}

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
