package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.Base.BasecClass;
import com.mystore.actiondriver.Action;

public class HomePage extends BasecClass{

@FindBy(xpath="//span[text()='My wishlists']")
WebElement myWishList;

@FindBy(xpath="//span[text()='Order history and details']")
WebElement orderHistory;

public HomePage()
{
	PageFactory.initElements(driver, this);
}

public boolean validateMyWishList()
{
	return Action.isDisplayed(driver, myWishList);
}
public void validateorderHistory()
{
	Action.isDisplayed(driver, orderHistory);
}
}
