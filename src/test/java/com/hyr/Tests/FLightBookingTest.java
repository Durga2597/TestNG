package com.hyr.Tests;
import org.testng.annotations.Test;

public class FLightBookingTest {
    @Test(priority=-1)
	public void Signup() {
		System.out.println("Signup");
	}
    @Test
	public void Login() {
		System.out.println("Login");
	}
    @Test(priority=3)
	public void SearchForTheFlight() {
		System.out.println("SearchForTheFlight");
	}
    @Test(priority=3)
	public void BookTheFlight() {
		System.out.println("BookTheFlight");
	}
    @Test(priority=4)
	public void SaveTheFlight() {
		System.out.println("SaveTheFlight");
	}
    @Test(priority=5)
	public void Logout() {
		System.out.println("Logout");
	}
	
}
