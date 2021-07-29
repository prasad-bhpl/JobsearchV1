package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.Base.BasecClass;
import com.mystore.actiondriver.Action;

public class IndexPage extends BasecClass {
	
	@FindBy(xpath="//a[@class='login']")
	WebElement signInBtn;
	
	@FindBy(xpath="//img[@class='logo img-responsive']")
	WebElement myStoreLogo;
	
	@FindBy(id="//img[@class='search_query_top']")
	WebElement searchProductBox;
	
	@FindBy(name="submit_search']")
	WebElement searchButton;
	
	public IndexPage()
	{
		PageFactory.initElements(driver, this);
	}
	public LoginPage clickOnSignIn()
	{
		Action.click(driver, signInBtn);
		return new LoginPage();
	}
	public boolean validateLogo()
	{
		return Action.isDisplayed(driver, myStoreLogo);
		//return myStoreLogo.isDisplayed();
	}
	public String getmyStoreTitle()
	{
		String Mystoretitle=driver.getTitle();
		return Mystoretitle;
	}
	public SearchResultPage searchProduct(String productName)
	{
		Action.type(searchProductBox, productName);
		Action.click(driver, searchButton);
		return new SearchResultPage();
	}

}
