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
public class AddToCartPage extends BasecClass {
	
@FindBy(id="quantity_wanted")
WebElement quantity;

@FindBy(name="group_1")
WebElement size;

@FindBy(xpath="//span[text()='Add to cart']")
WebElement addToCartBtn;

@FindBy(xpath="//*[@id=\"layer_cart\"]//h2/i")
WebElement addToCartMessag;

@FindBy(xpath="//span[contains(text(), 'Proceed to checkout')]")
WebElement proceedToCheckOutBtn;

public AddToCartPage()
{
	PageFactory.initElements(driver.get(), this);
}

public void enterQuantity(String quantity1)
{
	Action.type(quantity, quantity1);
}
public void enterSize(String size1)
{
	Action.selectByVisibleText(size1, size);
}
public void clickOnAddToCart()
{
	Action.click(driver.get(), addToCartBtn);
}
public boolean validateAddToCart() throws InterruptedException
{
	Action.waitforanelement(driver.get(), addToCartMessag, 10);
	Action.findelement(driver.get(), addToCartMessag);
	return Action.isDisplayed(driver.get(), addToCartMessag);
}
public OrderPage clickOnCheckOut() throws Exception
{
	Action.fluentWait(driver.get(), proceedToCheckOutBtn, 5);
	Action.JSClick(driver.get(), proceedToCheckOutBtn);
	return new OrderPage();
}
}
