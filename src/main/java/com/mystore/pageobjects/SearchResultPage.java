/**
 * 
 */
package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.Base.BasecClass;
import com.mystore.actiondriver.Action;

/**
 * @author prasa
 *
 */
public class SearchResultPage extends BasecClass {

	@FindBy(xpath="//*[@id=\"center_column\"]//img")
	WebElement productResult;
	
	
	public SearchResultPage()
	{
		PageFactory.initElements(driver.get(), this);
	}
	
	public boolean isProductAvailable()
	{
		return Action.isDisplayed(driver.get(), productResult);
	}
	
	public AddToCartPage clickOnProduct()
	{
		Action.click(driver.get(), productResult);
		return new AddToCartPage();
	}
}
