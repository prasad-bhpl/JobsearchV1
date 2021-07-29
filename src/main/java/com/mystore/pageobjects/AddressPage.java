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
public class AddressPage extends BasecClass{
	@FindBy(xpath="//span[text()='Proceed to checkout']")
	WebElement proceedToCheckOut;
	
	public AddressPage()
	{
		PageFactory.initElements(driver, this);
	}
	public ShipppingPage clickOnCheckOut()
	{
		Action.click(driver, proceedToCheckOut);
		return new ShipppingPage();
	}

}
