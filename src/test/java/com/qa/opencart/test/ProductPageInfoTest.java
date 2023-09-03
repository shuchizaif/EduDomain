package com.qa.opencart.test;

import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.Base.BaseTest;

public class ProductPageInfoTest extends BaseTest {
	
	@BeforeClass
	public void accPageSetup()
	{
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void productInfoTest()
	{
		resultsPage= accPage.doSearch("MacBook");
		productInfoPage =resultsPage.selectProduct("MacBook Pro");
		Map<String,String> productInfoMap =  productInfoPage.getProductInfo();
		System.out.println(productInfoMap);
	
	
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
