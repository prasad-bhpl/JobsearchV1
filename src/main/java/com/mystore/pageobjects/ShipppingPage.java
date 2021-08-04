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
public class ShipppingPage extends BasecClass {

	@FindBy(id="cgv")
	WebElement terms;
	
	@FindBy(xpath="//button/span[contains(text(), 'Proceed to checkout')]")
	WebElement proceedToCheckOutBtn;
	
	public ShipppingPage()
	{
		PageFactory.initElements(driver.get(), this);
	}
	public void checkTheTerms()
	{
		Action.click(driver.get(), terms);
	}
	public PaymentPage clickOnProceedToCheckOut()
	{
		Action.click(driver.get(), proceedToCheckOutBtn);
		return new PaymentPage();
	}

}
