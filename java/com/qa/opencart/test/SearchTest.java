package com.qa.opencart.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.Base.BaseTest;
import com.qa.opencart.dataproviders.ProductPojoDataProvider;

public class SearchTest extends BaseTest {
	
	@BeforeClass
	public void searchSetup()
	{
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	//Passing dataProvider from ProductPojoDataProvider class
	/*@DataProvider
	public Object[][] getProductSearchKeyData()
	{
		return new Object[][]
				{
			          {"Macbook"},
			          {"iMac"},
			          {"Samsung"}
				};
	}*/
	
	@Test(dataProvider="getProductSearchKeyData",dataProviderClass = ProductPojoDataProvider.class)
	public void searchProductResultCountTest(String searchKey)
	{
		resultsPage = accPage.doSearch(searchKey);
		Assert.assertTrue(resultsPage.getProductsResultsCount()>0);
	}
	
	@Test(dataProvider ="getProductSearchKeyData",dataProviderClass = ProductPojoDataProvider.class)
	public void searchPageTitleTest(String searchKey)
	{
		resultsPage = accPage.doSearch(searchKey);
		String actSearchTitle = resultsPage.getResultsPageTitle(searchKey);
		System.out.println("Search Page title is " + actSearchTitle);
		Assert.assertEquals(actSearchTitle, "Search - "+searchKey);
	}
	
	/*@DataProvider
	public Object[][] getProductTestData()
	{
		return new Object[][]
				{
			       {"Macbook","MacBook Pro"},
			       {"iMac","iMac"},
			       {"Samsung","Samsung SyncMaster 941BW"},
			       {"Samsung","Samsung Galaxy Tab 10.1"}
				};
	}*/
	
	@Test(dataProvider ="getProductTestData",dataProviderClass = ProductPojoDataProvider.class)
	public void selectProductTest(String searchKey,String productName)
	{
		resultsPage = accPage.doSearch(searchKey);
		productInfoPage = resultsPage.selectProduct(productName);
		String actProductHeaderName = productInfoPage.getproductHeaderName();
		System.out.println("Actual Product name is " + actProductHeaderName );
		
	}
	/*@DataProvider
	public Object[][] getProductImagesTestData()
	{
		return new Object[][]
				{

			{"Macbook","MacBook Pro",4},
			{"iMac","iMac",3},
			{"Samsung","Samsung SyncMaster 941BW",1},
			{"Samsung","Samsung Galaxy Tab 10.1",7}
			      
			
				};
		
		
	}*/

	
	@Test(dataProvider ="getProductImagesTestData",dataProviderClass = ProductPojoDataProvider.class)
	public void  productImagesTest(String searchKey,String productName,int expImagesCount)
	{
		resultsPage = accPage.doSearch(searchKey);
		productInfoPage = resultsPage.selectProduct(productName);
		int actProductImagesCount =  productInfoPage.getProductImagesCount();
		System.out.println("Actual Image count is " + actProductImagesCount);
		Assert.assertEquals(actProductImagesCount, expImagesCount);
	}
	
	
	

}
