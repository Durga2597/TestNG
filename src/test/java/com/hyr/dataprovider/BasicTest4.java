package com.hyr.dataprovider;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BasicTest4 {

	@Test(dataProvider = "dp1", dataProviderClass=DataSupplier.class)
	public void TestLogin(String s) throws Exception{
		System.out.println(s);
	}
		
	

	}
		

	










