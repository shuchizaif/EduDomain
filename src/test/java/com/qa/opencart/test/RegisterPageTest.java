package com.qa.opencart.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.Base.BaseTest;
import com.qa.opencart.utils.AppConstants;
import com.qa.opencart.utils.ExcelUtil;

public class RegisterPageTest extends BaseTest{
	
	@BeforeClass
	public void regSetup()
	{
		registerPage = loginPage.navigateToRegisterPage();
	}
	//we created below method as whenever we will run userRegisterTest(). it will give warning email id already created
	//so we are randomly creating email id that will be different every time.
	public String getRandomEmailID()
	{
		return "testautomation"+System.currentTimeMillis() +  "@gmail.com";//this will give emailid: testautomation+some number +@gmail.com
	}
	
	//@DataProvider(name = "regData")
	//public Object[][] getUserRegTestData() {
	//return new Object[][] {
			//{"abhi", "anand", "9876545678", "abhi@123", "yes"},
			//{"robinson", "matinez", "9876545600", "robin@123", "no"},
			//{"amber", "automation", "9876545998", "amber@123", "yes"},
		//};
	//}
	
	@DataProvider(name = "regExcelData")
	public Object[][] getRegExcelTestData()
	{
		Object regData[][] = ExcelUtil.getTestData(AppConstants.REGISTER_SHEET_NAME);
		return regData;
	}
	
	
	@Test(dataProvider = "regExcelData")
	public void userRegisterTest(String firstName,String lastName,String telephone,String password,String subscribe)
	{
		String actRegSuccMessg = registerPage.registerUser(firstName, lastName,getRandomEmailID() ,telephone,password, subscribe);
	    Assert.assertEquals(actRegSuccMessg, AppConstants.USER_REG_SUCCESS_MESSG);
	}
	
	
	
	
}
