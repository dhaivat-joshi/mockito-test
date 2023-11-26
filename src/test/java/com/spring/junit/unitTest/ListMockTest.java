package com.spring.junit.unitTest;

import static org.assertj.core.api.Assertions.anyOf;
import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;

import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ListMockTest {
	List<Integer> mock;

	@SuppressWarnings("unchecked")
	@BeforeEach
	public void init() {
		mock = Mockito.mock(ArrayList.class);
	}

	@Test
	public void size_basic() {
		when(mock.size()).thenReturn(5);
		assertEquals(5, mock.size());
	}

	@Test
	public void size_withDifferentParameter() {
		when(mock.size()).thenReturn(5).thenReturn(10);
		assertEquals(5, mock.size());
		assertEquals(10, mock.size());
	}
	
	@Test
	public void size_runWithParameters() {
		when(mock.get(0)).thenReturn(100);
		assertEquals(100, mock.get(0));
		assertEquals(null, mock.get(1));
	}
	
	public void returnWithGenericParameter() {
//		when(mock.get(anyOf(Integer.class)))
	}

}
