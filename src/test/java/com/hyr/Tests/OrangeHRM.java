package com.hyr.Tests;

import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class OrangeHRM {
	WebDriver driver;
	
	@Parameters("browserName")
	@BeforeTest
	public void InitializeBrowser(@Optional("chrome") String browserName) {
		switch(browserName.toLowerCase()) {
		case "chrome":
			driver=new ChromeDriver();
			break;
		case "edge":
			driver=new EdgeDriver();
			break;
		case "firefox":
			driver=new FirefoxDriver();
			break;	
		default:
			System.err.println("Browsername is invalid");
			break;
		}
		
		driver.manage().window().maximize();
		
	}
	
	@Parameters("sleepTime")
	@AfterTest
	public void Teardown(Long sleepTime) throws Exception {
		System.out.println(sleepTime);
		Thread.sleep(sleepTime);
		driver.quit();
	}
	
    @Parameters("url")
	 @Test
	public void LaunchApp(String url) {
		
		driver.get(url);
		}
		
	@Parameters({"username" , "password"}) 
	@Test
	public void EnterLoginDetails(String userName, String password) throws Exception {
		Thread.sleep(3000);
		driver.findElement(By.name("username")).sendKeys(userName);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.cssSelector(".orangehrm-login-button")).click();
	}
	
	@Test
	public void NavigateToMyInfo() throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".active")).click();
    }
	
	@Test
	public void VerifyMyInfo() throws Exception {
		Thread.sleep(1000);
		boolean actualValue=driver.findElement(By.xpath("//ul[@class='oxd-main-menu']/li[6]")).isDisplayed();
		assertTrue(actualValue);
	}
	
	@Test
	public void VerifyLogin() throws Exception {
		Thread.sleep(3000);
		WebElement ele=driver.findElement(By.cssSelector(".oxd-userdropdown-name"));
		assertTrue(ele.isDisplayed());
		assertTrue(ele.getText().endsWith("user"));
		
	}



}
