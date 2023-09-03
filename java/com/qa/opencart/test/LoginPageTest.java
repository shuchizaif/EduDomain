package com.qa.opencart.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.opencart.Base.BaseTest;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.utils.AppConstants;

public class LoginPageTest extends BaseTest {
	
	
	
	
	@Test
	public void loginPageTitleTest()
	{
		String actTitle = loginPage.getLoginPageTitle();
		Assert.assertEquals(actTitle,AppConstants.LOGIN_PAGE_TITLE_VALUE);
	}
	
	@Test
	public void forgotPwdLinkExistTest()
	{
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
		}
	
	@Test
	public void loginPageUrlTest()
	{
	   String actualUrl =loginPage.getLoginPageUrl();
	   Assert.assertTrue(actualUrl.contains(AppConstants.LOGIN_PAGE_URL_FRACTION_VALUE));
	}
	
	
	@Test
	public void loginTest()
	{
		accPage = loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
		Assert.assertTrue(accPage.isLogoutLinkExist());
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
