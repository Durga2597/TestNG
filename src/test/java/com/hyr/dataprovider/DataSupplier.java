package com.hyr.dataprovider;

import org.testng.annotations.DataProvider;

public class DataSupplier {

	@DataProvider()
	public String[] dp1() {
		String[] data=new String[]{
				"yadagiri",
				"john",
				"rebecca",
				"smith"
		};
			return data;	
		
	}
	public String[] dp2() {
		String[] data=new String[]{
				"sumanth",
				"teju",
				"cena",
				
		};
			return data;	
		
	}
	}
		

	










