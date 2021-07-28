package com.mystore.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasecClass {
	public static Properties prop;
	public static WebDriver driver;
	
	@BeforeTest
	public void loadConfig()
	{
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
	public static void launchapp()
	{
		WebDriverManager.chromedriver().config();
		String browsername=prop.getProperty("browser");
		if(browsername.contains("Chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browsername.contains("FireFox"))
		{
			driver=new FirefoxDriver();
		}
		else if(browsername.contains("IE"))
		{
			driver=new InternetExplorerDriver();
		}
	}

}
