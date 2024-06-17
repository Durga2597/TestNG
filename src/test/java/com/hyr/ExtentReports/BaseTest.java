package com.hyr.ExtentReports;

import java.awt.Desktop;


import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URI;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;



public class BaseTest {
        public static WebDriver driver;
		public static String screenshotSubFolderName;
		public static ExtentReports extentReports;
		public static ExtentTest extentTest;
		
		@Parameters("browserName")
		@BeforeTest
		public void setup(ITestContext context, @Optional("chrome") String browserName) {
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
			Capabilities capabilities = ((RemoteWebDriver) driver).getCapabilities();    //Extent Reports for Java -> p9(5:00)
			String device= capabilities.getBrowserName() + " " + capabilities.getBrowserVersion().substring(0, capabilities.getBrowserVersion().indexOf("."));
			String author=context.getCurrentXmlTest().getParameter("author");
			
			extentTest=extentReports.createTest(context.getName());
			extentTest.assignAuthor(author);
			extentTest.assignDevice(device);
		}
		@AfterTest
	    public void teardown() {
		   driver.quit();
	    }
		
		@BeforeSuite
		public void initialiseExtentReports() {
			
			ExtentSparkReporter sparkReporter_all = new ExtentSparkReporter("AllTests.html");
			extentReports = new ExtentReports();
			extentReports.attachReporter(sparkReporter_all);
			//system.getProties()------------gives all system properties
			extentReports.setSystemInfo("OS", System.getProperty( "os.name"));         //Extent Reports for Java -> p9 (7.25 - 14.25))
			extentReports.setSystemInfo("Java Version", System.getProperty( "java.version")); 
			
			
		}
		
		@AfterSuite
		public void generateExtentReports() throws Exception{
			extentReports.flush();
			//to open html report automatically
			Desktop.getDesktop().browse(new File("AllTests.html").toURI());     //Extent Reports for Java -> p3(12:00)
		}
		
		@AfterMethod
		public void checkStatus(Method m,ITestResult result) {    //native dependency injection concept in testng
			if(result.getStatus()==ITestResult.FAILURE) {
				String screenshotPath=null;
				 screenshotPath=captureScreenshot(result.getTestContext().getName() + "_" + result.getMethod().getMethodName()+".jpg");
				extentTest.addScreenCaptureFromPath(screenshotPath);
				extentTest.fail(result.getThrowable());
			}else if(result.getStatus()==ITestResult.SUCCESS) {
				extentTest.pass(m.getName()+ " is passed");
			}
			
			
			extentTest.assignCategory(m.getAnnotation(Test.class).groups());
		}      
		
		public String captureScreenshot(String fileName) {
			if(screenshotSubFolderName == null) {
				LocalDateTime myDateObj = LocalDateTime.now();
			    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
			    screenshotSubFolderName = myDateObj.format(myFormatObj);
			}   
			
			TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
			File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
			File destFile = new File("./Screenshots/"+fileName);
			try {
				FileUtils.copyFile(sourceFile, destFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("Screenshot saved successfully");
			return destFile.getAbsolutePath();         //Extent Reports for Java -> p6 (9.50 )
			}
	}
/* if(result.getStatus()==ITestResult.FAILURE) {
	String screenshotPath=null;
	screenshotPath=captureScreenshot(result.getTestContext().getName() + "_" + result.getMethod().getMethodName()+".jpg");
	extentTest.addScreenCaptureFromPath(screenshotPath);
	extentTest.fail(result.getThrowable());
}else if(result.getStatus()==ITestResult.SUCCESS) {
	extentTest.pass(m.getName()+ " is passed");
}    */


