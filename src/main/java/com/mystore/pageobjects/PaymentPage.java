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
public class PaymentPage extends BasecClass{
	
	@FindBy(xpath="//a[contains(text(), 'Pay by bank wire')]")
	WebElement bankWireMethod;
	
	@FindBy(xpath="//a[contains(text(), 'Pay by check ')]")
	WebElement payByCheckMethod;
	
	public PaymentPage()
	{
		PageFactory.initElements(driver.get(), this);
	}
	public OrderSummaryPage clickOnPaymentWireMethod()
	{
		Action.click(driver.get(), bankWireMethod);
		return new OrderSummaryPage();
	}
	
	public OrderSummaryPage clickOnPaymentCheckMethod()
	{
		Action.click(driver.get(), payByCheckMethod);
		return new OrderSummaryPage();
	}

}
