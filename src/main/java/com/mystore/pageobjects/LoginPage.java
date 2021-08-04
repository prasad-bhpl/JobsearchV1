package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.Base.BasecClass;
import com.mystore.actiondriver.Action;

public class LoginPage extends BasecClass{

@FindBy(id="email")
WebElement userName;

@FindBy(id="passwd")
WebElement password;

@FindBy(id="SubmitLogin")
WebElement signInBtn;

@FindBy(name="email_create")
WebElement emailForNewAccount;

@FindBy(name="SubmitCreate")
WebElement createNewAccountBtn;

public LoginPage()
{
	PageFactory.initElements(driver.get(), this);
}

public HomePage login(String uname, String pswd)
{
	Action.type(userName, uname);
	Action.type(password, pswd);
	Action.click(driver.get(), signInBtn);
	return new HomePage();
}
public AddressPage login1(String uname, String pswd)
{
	Action.type(userName, uname);
	Action.type(password, pswd);
	Action.click(driver.get(), signInBtn);
	return new AddressPage();
}
public AccountCreationPage createNewAccount(String newemail)
{
	Action.type(emailForNewAccount, newemail);
	Action.click(driver.get(), createNewAccountBtn);
	return new AccountCreationPage();
	
}

}
