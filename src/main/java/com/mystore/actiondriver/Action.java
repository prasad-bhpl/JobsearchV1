package com.mystore.actiondriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.mystore.Base.BasecClass;

public class Action extends BasecClass
{
	
public static void implicitwait(WebDriver ldriver, long time)
{
	
	driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	
}
public static void pageloadtimeout(WebDriver ldriver, long time)
{
	driver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);
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



}
