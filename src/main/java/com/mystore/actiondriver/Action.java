package com.mystore.actiondriver;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mystore.Base.BasecClass;

public class Action extends BasecClass
{
	
public static void implicitwait(WebDriver ldriver, long time)
{
	
	getDriver().manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	
}
public static void pageloadtimeout(WebDriver ldriver, long time)
{
	getDriver().manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);
}
public static void click(WebDriver ldriver, WebElement locatorname)
{
	Actions ac=new Actions(ldriver);
	ac.moveToElement(locatorname).click().build().perform();
}

public static boolean findelement(WebDriver ldriver, WebElement ele)
{
	boolean flag=false;
	try {
		ele.isDisplayed();
		flag=true;
	} catch (Exception e) {
		flag=false;
	}
	finally {
		if(flag)
		{
			System.out.println("Successfully element found at");
		}
		else
		{
			System.out.println("Unable to locate element at");
		}	
	}
	return flag;
	
}
public static boolean isDisplayed(WebDriver ldriver, WebElement ele)
{
	boolean flag=false;
	flag=findelement(ldriver, ele);
	if(flag)
	{
		flag=ele.isDisplayed();
	if(flag)
		{
			System.out.println("The element is displayed");
		}
		else
		{
			System.out.println("The element is not displayed");
		}
	}
	else
	{
		System.out.println("Not displayed");
	}
	return flag;	
}
public static boolean selectByVisibleText(String visibletext, WebElement ele)
{
	boolean flag=false;
		try {
			Select s=new Select(ele);
			s.selectByVisibleText(visibletext);
			flag=true;
			return true;
		} catch (Exception e) {
			return false;
		}
		finally {
			if(flag)
			{
				System.out.println("Option Selected by VisibleText");
			}
			else
			{
				System.out.println("Option not Selected by VisibleText");
			}
		}
	
}
public static boolean JSClick(WebDriver driver, WebElement ele) throws Exception
{
	boolean flag=false;
		try {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", ele);
			flag=true;
		} catch (Exception e) {
			throw e;
		}
		finally {
			if(flag)
			{
				System.out.println("Click Action is Performed");
			}
			else if(!flag)
			{
				System.out.println("Click Action is not Performed");
			}
		}
		return flag;
}


public static boolean type(WebElement ele, String text)
{
	boolean flag=false;
	
	try {
		flag=ele.isDisplayed();
			ele.clear();
			ele.sendKeys(text);
			flag=true;
	} catch (Exception e) {
		System.out.println("Location not found");
		flag=false;
	}
	finally {
		
		if(flag)
		{
			System.out.println("Successfully entered value");
		}
		else
		{
			System.out.println("Unable to entered value");
		}
	}
		return flag;
	}


public static boolean selectByIndex(WebElement element, int index)
{
	boolean flag=false;
	
	try {
		Select s=new Select(element);
		s.selectByIndex(index);
			flag=true;
			return true;
	} catch (Exception e) {
		flag=false;
	}
	finally {
		
		if(flag)
		{
			System.out.println("Option Selected By Index");
		}
		else
		{
			System.out.println("Option not Selected By Index");
		}
	}
		return flag;
	}
public static boolean selectByVisibleText(WebElement element, String text)
{
	boolean flag=false;
	
	try {
		Select s=new Select(element);
		s.selectByVisibleText(text);
			flag=true;
			return true;
	} catch (Exception e) {
		flag=false;
	}
	finally {
		
		if(flag)
		{
			System.out.println("Option Selected By Text");
		}
		else
		{
			System.out.println("Option not Selected By Text");
		}
	}
		return flag;
	}

public static boolean selectByValue(WebElement element,String value) {
	boolean flag = false;
	try {
		Select s = new Select(element);
		s.selectByValue(value);
		flag = true;
		return true;
	} catch (Exception e) {

		return false;
	} finally {
		if (flag) {
			System.out.println("Option selected by Value");
		} else {
			System.out.println("Option not selected by Value");
		}
	}
}

public static void waitforanelement(WebDriver ldriver, WebElement element, int timeOut)
{
    WebDriverWait wait = new WebDriverWait(ldriver, timeOut);
     wait.until(ExpectedConditions.visibilityOf(element));
}
public static void fluentWait(WebDriver driver,WebElement element, int timeOut) {
    Wait<WebDriver> wait = null;
    try {
        wait = new FluentWait<WebDriver>((WebDriver) driver)
        		.withTimeout(Duration.ofSeconds(20))
        	    .pollingEvery(Duration.ofSeconds(2))
        	    .ignoring(Exception.class);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }catch(Exception e) {
    }
}
public String screenShot(WebDriver driver, String filename) {
	String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
	File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
	String destination = System.getProperty("user.dir") + "\\ScreenShots\\" + filename + "_" + dateName + ".png";

	try {
		FileUtils.copyFile(source, new File(destination));
	} catch (Exception e) {
		e.getMessage();
	}
	return destination;
	
}
}
