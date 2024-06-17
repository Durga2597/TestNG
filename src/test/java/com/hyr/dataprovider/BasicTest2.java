package com.hyr.dataprovider;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BasicTest2 {

	@Test(dataProvider = "dp1")
	public void TestLogin(String[] s) throws Exception{
		System.out.println(s[0]+">>"+s[1]);
	}
		
	

	@DataProvider()
	public Iterator<String[]> dp1() {
		Set<String[]> data=new HashSet<>();
			data.add(new String[]{"yadagiri","reddy"});
			data.add(new String[]{"john","cena"});
			return data.iterator();	
		
	}
	}
		

	










