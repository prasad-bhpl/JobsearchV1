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
public class OrderPage extends BasecClass{
	
@FindBy(xpath="//td[@class='cart_unit']/span/span")
WebElement unitPrice;

@FindBy(xpath="//span[@id='total_price']")
WebElement totalPrice;

@FindBy(xpath="//span[text()='Proceed to checkout']")
WebElement proceedToCheckOut;

	public OrderPage() {
		PageFactory.initElements(driver.get(), this);
		
	}
	public double getUnitPrice()
	{
		String unitPrice1=unitPrice.getText();
		String unit=unitPrice1.replaceAll("[^a-zA-Z0-9]", "");
		double finalunitprice=Double.parseDouble(unit);
		return finalunitprice/100;
	}
	public double getTotalPrice()
	{
		String totalPrice1=totalPrice.getText();
		String total=totalPrice1.replaceAll("[^a-zA-Z0-9]", "");
		double finaltotalprice=Double.parseDouble(total);
		return finaltotalprice/100;
	}
	public LoginPage clickOnCheckOut()
	{
		Action.click(driver.get(), proceedToCheckOut);
		return new LoginPage();
	}
}
