package com.mystore.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.mystore.actiondriver.Action;
import com.mystore.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasecClass {
	public static Properties prop;
	//public static WebDriver driver;
	
	//Declare Threadlocal driver
	
	public static ThreadLocal<RemoteWebDriver> driver=new ThreadLocal<RemoteWebDriver>();
	
	@BeforeSuite
	public void loadConfig()
	{
		ExtentManager.setExtent();
		DOMConfigurator.configure("log4j.xml");
		try {
			prop=new Properties();
			System.out.println("super constructor invoked");
			FileInputStream fi=new FileInputStream(System.getProperty("user.dir")+"\\Configuration\\config.properties");
			prop.load(fi);
			System.out.println("driver: "+driver);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static WebDriver getDriver()
	{
		//Get driver from Threadlocalmap
		return driver.get();
	}
	
	public static void launchapp(String browsername)
	{
		
		//String browsername=prop.getProperty("browser");
		if(browsername.contains("Chrome"))
		{
			WebDriverManager.chromedriver().config();
			System.setProperty("webdriver.chrome.driver", "D:\\Prasad_Selenium\\Prasad_Testing_Notes\\Testing_Notes\\chromedriver.exe");
			//driver=new ChromeDriver();
			driver.set(new ChromeDriver());
		}
		else if(browsername.contains("FireFox"))
		{
			WebDriverManager.firefoxdriver().config();
			driver.set(new FirefoxDriver());
		}
		else if(browsername.contains("IE"))
		{
			driver.set(new InternetExplorerDriver());
		}
		Action.implicitwait(getDriver(), 10);
		Action.pageloadtimeout(getDriver(), 20);
		getDriver().get(prop.getProperty("url"));
	}
	
	@AfterSuite
	public void aftersuite()
	{
		ExtentManager.endReport();
	}

}
