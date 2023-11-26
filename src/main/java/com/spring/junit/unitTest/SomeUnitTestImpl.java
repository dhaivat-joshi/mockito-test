package com.spring.junit.unitTest;

public class SomeUnitTestImpl {
	private SomeDataService someDataService;
	
	
	public void setSomeDataService(SomeDataService someDataService) {
		this.someDataService = someDataService;
	}

	public int calculateSum(int[] data) {
		int sum=0;
		for(int val:data) {
			sum+=val;
		}
		return sum;
	}
	
	public int calculateSumFromData() {
		int sum=0;
		int[] data = someDataService.getAllData();
		for(int val:data) {
			sum+=val;
		}
		return sum;
	}

}
