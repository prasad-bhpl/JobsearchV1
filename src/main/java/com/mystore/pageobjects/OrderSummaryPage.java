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
public class OrderSummaryPage extends BasecClass{

	@FindBy(xpath="//span[contains(text(), 'I confirm my order')]")
	WebElement confirmOrderBtn;
	
	
	public OrderSummaryPage()
	{
		PageFactory.initElements(driver.get(), this);
	}
	public OrderConfirmationPage clickOnConfirmOrderBtn()
	{
		Action.click(driver.get(), confirmOrderBtn);
		return new OrderConfirmationPage();
	}
}
