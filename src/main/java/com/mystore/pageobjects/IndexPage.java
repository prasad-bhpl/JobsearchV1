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
	
	@FindBy(id="search_query_top")
	WebElement searchProductBox;
	
	@FindBy(name="submit_search")
	WebElement searchButton;
	
	public IndexPage()
	{
		PageFactory.initElements(driver.get(), this);
	}
	public LoginPage clickOnSignIn()
	{
		Action.click(driver.get(), signInBtn);
		return new LoginPage();
	}
	public boolean validateLogo()
	{
		return Action.isDisplayed(driver.get(), myStoreLogo);
		//return myStoreLogo.isDisplayed();
	}
	public String getmyStoreTitle()
	{
		String Mystoretitle=driver.get().getTitle();
		return Mystoretitle;
	}
	public SearchResultPage searchProduct(String productName) throws InterruptedException
	{
		Action.type(searchProductBox, productName);
		Thread.sleep(4000);
		Action.click(driver.get(), searchButton);
		return new SearchResultPage();
	}

}
