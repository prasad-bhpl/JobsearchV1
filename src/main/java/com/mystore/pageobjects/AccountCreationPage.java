/**
 * 
 */
package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.mystore.Base.BasecClass;
import com.mystore.actiondriver.Action;

/**
 * @author prasa
 *
 */
public class AccountCreationPage extends BasecClass {
	
	//Action action= new Action();
	
	@FindBy(xpath = "//h1[text()='Create an account']")
	private WebElement formTitle;
	
	@FindBy(id = "uniform-id_gender1")
	private WebElement mr;
	
	@FindBy(id = "id_gender2")
	private WebElement mrs;

	@FindBy(name = "customer_firstname")
	private WebElement firstName;

	@FindBy(name = "customer_lastname")
	private WebElement lastName;

	@FindBy(name = "passwd")
	private WebElement passWord;

	@FindBy(name = "days")
	private WebElement days;

	@FindBy(name = "months")
	private WebElement months;

	@FindBy(name = "years")
	private WebElement years;

	@FindBy(name = "firstname")
	private WebElement customerNirstName;

	@FindBy(name = "lastname")
	private WebElement customerLastName;

	@FindBy(name = "company")
	private WebElement companyName;

	@FindBy(name = "address1")
	private WebElement address;

	@FindBy(name = "city")
	private WebElement city;

	@FindBy(name = "id_state")
	private WebElement state;

	@FindBy(name = "postcode")
	private WebElement postCode;

	@FindBy(name = "id_country")
	private WebElement country;

	@FindBy(name = "phone")
	private WebElement phone;

	@FindBy(name = "phone_mobile")
	private WebElement mobile;

	@FindBy(name = "alias")
	private WebElement ref;

	@FindBy(name = "submitAccount")
	private WebElement registerBtn;


public AccountCreationPage()
{
	PageFactory.initElements(driver.get(), this);
}
public boolean validateAcountCreatePage1()
{
	return Action.isDisplayed(driver.get(), formTitle);
}

public void createAccountRegistration(String fname, String lname, String emailid, String pwd, int selectday,
        int selectmonth, int selectyear, String addfname, String addlname,
        String companyname, String add1, String cityname, int statename, int post, int countryname, String mobilenumber) throws InterruptedException
	{
		//Action.click(driver.get(), Title);
		Thread.sleep(4000);
		Action.type(firstName, fname);
		Action.type(lastName, lname);
		//Action.type(email, emailid);
		Action.type(passWord, pwd);
		Action.selectByIndex(days, selectday);
		Action.selectByIndex(months, selectmonth);
		Action.selectByIndex(years, selectyear);
		
		new Select(days).selectByIndex(selectday);
		new Select(months).selectByIndex(selectmonth);
		new Select(years).selectByIndex(selectyear);
		
		//Action.type(addfirstname, addfname);
		//Action.type(addlastname, addlname);
		//Action.type(company, companyname);
		//Action.type(address1, add1);
		Action.type(city, cityname);
		new Select(state).selectByIndex(statename);
		
		//Action.type(postcode, post);
		//postcode.sendKeys(String.valueOf(post));
		new Select(country).selectByIndex(countryname);
		Thread.sleep(4000);
		long mobileno=Long.parseLong(mobilenumber);
		mobile.sendKeys(String.valueOf(mobileno));
		//Action.click(driver.get(), submitAccount);

	}

public void createAccount(String gender,String fName, 
		String lName, 
		String pswd, 
		String day, 
		String month, 
		String year,
		String comPany, 
		String addr, 
		String cityString, 
		String stateName, 
		String zip, 
		String countryName,
		String mobilePhone) throws Throwable {
	
	if(gender.equalsIgnoreCase("Mr")) {
		Action.click(getDriver(), mr);
	} else {
		Action.click(getDriver(), mrs);
	}
	
	Action.type(firstName, fName);
	Action.type(lastName, lName);
	Action.type(passWord, pswd);
	Action.selectByValue(days, day);
	Action.selectByValue(months, month);
	Action.selectByValue(years, year);
	Action.type(companyName, comPany);
	Action.type(address, addr);
	Action.type(city, cityString);
	Action.selectByVisibleText(stateName, state);
	Action.type(postCode, zip);
	Action.selectByVisibleText(countryName, country);
	Action.type(mobile, mobilePhone);
}

public HomePage validateRegistration() throws Throwable {
	registerBtn.click();
	return new HomePage();
}

public boolean validateAcountCreatePage() throws Throwable {
	 return Action.isDisplayed(getDriver(), formTitle);
}
	
}
