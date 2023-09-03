package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class AccountsPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	public AccountsPage (WebDriver driver)
	{
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	//By Locators
	private By logout = By.xpath("//*[@id='column-right']/div/a[13]");
	private By myAccount = By.linkText("My Account");
	private By accHeaders = By.cssSelector("div#content h2");
	private By search = By.name("search");
	private By searchIcon = By.cssSelector("div#search button");
	
	//Page Actions
	
	public String getAccountPageTitle()
	{
		/*String title = driver.getTitle();
		System.out.println("Account Page title is " + title);
		return title;*/
		
		//By.linkText("Logout");
		
		return eleUtil.waitForTitleIsAndCapture(AppConstants.ACCOUNTS_PAGE_TITLE_VALUE,AppConstants.MEDIUM_DEFAULT_WAIT);
	}
	
	public boolean isLogoutLinkExist()
	{
		//return driver.findElement(logout).isDisplayed();
		return eleUtil.checkElementIsDisplayed(logout);
	}
	
	public boolean isMyAccountLinkExist()
	{
		//return driver.findElement(myAccount).isDisplayed();
		return eleUtil.checkElementIsDisplayed(myAccount);
	}
	
	public List<String> getAccountsPageHeaderList()
	{
		//List<WebElement> headersList =  driver.findElements(accHeaders);
		List<WebElement> headersList= eleUtil.waitForElementsVisible(accHeaders, AppConstants.MEDIUM_DEFAULT_WAIT);
		List<String>headersValList = new ArrayList<String>();
		for(WebElement e : headersList)
		{
			String text =e.getText();
			headersValList.add(text);
			
		}
		return headersValList;
		
	}
	
	public ResultsPage doSearch(String searchTerm)
	{
		
		//driver.findElement(search).sendKeys(searchTerm);
		//driver.findElement(searchIcon).click();
		eleUtil.waitForElementVisible(search, AppConstants.MEDIUM_DEFAULT_WAIT);
		eleUtil.doSendKeys(search, searchTerm);// this Element util method will internally clear the search field before sending any search term
		eleUtil.doClick(searchIcon);
		return new ResultsPage(driver);
	}

}
