package com.qa.opencart.test;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.opencart.Base.BaseTest;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.utils.AppConstants;

public class AccountsPageTest extends BaseTest {
	
	
	//We will declare here method specific only to this Class.As we need to dologin before we execute any account page methods
	@BeforeClass 
	public void accPageSetup()
	{
		accPage = loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@Test
	public void accPageTitleTest()
	{
		String actTitle = accPage.getAccountPageTitle();
		Assert.assertEquals(actTitle, AppConstants.ACCOUNTS_PAGE_TITLE_VALUE);
	}
	
	@Test
	public void  isLogoutLinkExistTest()
	{
		Assert.assertTrue(accPage.isLogoutLinkExist());
	}
	
	@Test
	public void isMyAccountLinkExistTest()
	{
		Assert.assertTrue(accPage.isMyAccountLinkExist());
	}
	
	@Test
	public void accountPageHeadersCountTest()
	{
		List<String> actAccHeadersList = accPage.getAccountsPageHeaderList();
		actAccHeadersList.size();
		Assert.assertEquals(actAccHeadersList.size(), 4);
		
	}
	
	@Test
	public void accountPageHeadersTest()
	{
		List<String> actAccHeadersList = accPage.getAccountsPageHeaderList();
		
		Assert.assertEquals(actAccHeadersList, AppConstants.EXP_ACCOUNTS_HEADERS_LIST);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
