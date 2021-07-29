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
public class AccountCreationPage extends BasecClass {
	
@FindBy(xpath="//h1[text()='Create an account']")
WebElement formTitle;

public AccountCreationPage()
{
	PageFactory.initElements(driver, this);
}
public boolean validateAcountCreatePage()
{
	return Action.isDisplayed(driver, formTitle);
}

}
