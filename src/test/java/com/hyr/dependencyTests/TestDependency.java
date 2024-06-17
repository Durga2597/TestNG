package com.hyr.dependencyTests;

import org.testng.annotations.Test;

public class TestDependency {
	static String trackingNumber=null;
	
/*	
	@Test
	public void CreateShipment()
	{
	System.out.println(5/0);
		System.out.println("CreateShipment");
		trackingNumber="ABC1234EFG";
	}
*/	
	
	@Test(dependsOnMethods= {"CreateShipment"},ignoreMissingDependencies = true)
	public void TrackShipment() throws Exception
	{
		if(trackingNumber!=null)
			System.out.println("TrackShipment");
		else
		throw new Exception("invalid tracking number");
	}
	
	@Test(dependsOnMethods= {"CreateShipment","TrackShipment"},ignoreMissingDependencies = true)
	public void CancelShipment() throws Exception
	{
		if(trackingNumber!=null)
		System.out.println("CancelShipment");
	else
	throw new Exception("invalid tracking number");
	}
	

}
