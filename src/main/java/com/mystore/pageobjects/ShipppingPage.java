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
		PageFactory.initElements(driver, this);
	}
	public void checkTheTerms()
	{
		Action.click(driver, terms);
	}
	public PaymentPage clickOnProceedToCheckOut()
	{
		Action.click(driver, proceedToCheckOutBtn);
		return new PaymentPage();
	}

}
