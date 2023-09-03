package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class LoginPage {
	//define driver
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	//Initialize Private webdriver using Public Constructor----Encapsulation
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		eleUtil = new ElementUtil(this.driver);
	}
	
	//Declare By Locators
	private By emailid = By.id("input-email");
	private By password = By.id("input-password");
	private By loginBtn = By.xpath("//input[@value= 'Login']");
	private By forgotPwdlnk = By.linkText("Forgotten Password");
	private By footerLinks = By.xpath("//footer//a");
	private By registerLink = By.linkText("Register");
	
	//Create  public Action Methods using  Private By Locators--Encapsulation
	
	public   String getLoginPageTitle()
	{
		/*String title = driver.getTitle();
		System.out.println("Page title is " + title);
		return title;*/
		return eleUtil.waitForTitleIsAndCapture(AppConstants.LOGIN_PAGE_TITLE_VALUE, AppConstants.SHORT_DEFAULT_WAIT);
	}
	
	public String getLoginPageUrl()
	{
		/*String Url = driver.getCurrentUrl();
		System.out.println("Page Url is " + Url);
		return Url;*/
		return eleUtil.waitForURLContainsAndCapture(AppConstants.LOGIN_PAGE_URL_FRACTION_VALUE, AppConstants.SHORT_DEFAULT_WAIT);
	}
	
	public  boolean isForgotPwdLinkExist()
	{
		return eleUtil.checkElementIsDisplayed(forgotPwdlnk);
	}
	
	public List<String> getFooterLinkList()
	{
		//List<WebElement> footerLinksList = driver.findElements(footerLinks);//holds list of all footer links
		List<WebElement> footerLinksList = eleUtil.waitForElementsVisible(footerLinks, AppConstants.MEDIUM_DEFAULT_WAIT);
		List<String>footerTextList = new ArrayList<String>();//Created empty String list to add text of each footer link
		for(WebElement e: footerLinksList)
		{
			String text = e.getText();
			footerTextList.add(text);
		}
		return footerTextList;
		
	}
	
	public AccountsPage doLogin(String username,String pwrd)
	{
	  eleUtil.waitForElementVisible(emailid, AppConstants.MEDIUM_DEFAULT_WAIT).sendKeys(username);
	  eleUtil.doSendKeys(password, pwrd);
	  eleUtil.doClick(loginBtn);
		//return the next landing page--Accounts Page--Page Chaining Concept
		return new AccountsPage(driver);
	
	}
	
	public RegisterPage navigateToRegisterPage()
	{
		eleUtil.doClick(registerLink);
		return new RegisterPage(driver);
	}

}
