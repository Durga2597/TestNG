package com.hyr.dataprovider;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BasicTest3 {

	@Test(dataProvider = "dp1")
	public void TestLogin(String s) throws Exception{
		System.out.println(s);
	}
		
	

	@DataProvider(indices= {0,2})
	public String[] dp1() {
		String[] data=new String[]{
				"yadagiri",
				"john",
				"rebecca",
				"smith"
		};
			return data;	
		
	}
	}
		

	










