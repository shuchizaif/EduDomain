package com.qa.opencart.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.Base.BaseTest;
import com.qa.opencart.dataproviders.ProductPojoDataProvider;
import com.qa.opencart.pojo.ProductPOJO;

public class SearchDataPOJOTest extends BaseTest {
	
	
	@BeforeClass
	public void searchSetup()
	{
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	//In case we have DataProvider in different class not in same Test class
	/*@DataProvider(name = "productData")
	public Object[][] getProductTestData()
	
		return new Object[][]
		{
		{new ProductPOJO("Macbook", "MacBook Pro", 4)},//calling Constructor making object of class ProductPOJO
		{new ProductPOJO("iMac", "iMac", 3)},
		{new ProductPOJO("Samsung", "Samsung SyncMaster 941BW", 1)},
		{new ProductPOJO("Samsung", "Samsung Galaxy Tab 10.1", 7)}
	};
	
	}*/
	@Test(dataProvider="productData",dataProviderClass= ProductPojoDataProvider.class)
	public void searchProductResultCountTest(ProductPOJO product)//passing reference variable of Page class to call their get/setmethods
	{
		resultsPage = accPage.doSearch(product.getSearchKey());//we are passing values by calling reference variable 
		//product of class ProductPOJO and then calling that class getter methods
		
		Assert.assertTrue(resultsPage.getProductsResultsCount()>0);
	}
	
	@Test(dataProvider ="productData",dataProviderClass= ProductPojoDataProvider.class)
	public void searchPageTitleTest(ProductPOJO product)
	{
		resultsPage = accPage.doSearch(product.getSearchKey());
		String actSearchTitle = resultsPage.getResultsPageTitle(product.getSearchKey());
		System.out.println("Serch Page title is " + actSearchTitle);
		Assert.assertEquals(actSearchTitle, "Search - "+product.getSearchKey());
	}
	
	
	
	@Test(dataProvider ="productData",dataProviderClass= ProductPojoDataProvider.class)
	public void selectProductTest(ProductPOJO product)
	{
		resultsPage = accPage.doSearch(product.getSearchKey());
		productInfoPage = resultsPage.selectProduct(product.getProductName());
		String actProductHeaderName = productInfoPage.getproductHeaderName();
		System.out.println("Actual Product name is " + actProductHeaderName );
		
	}
	

	
	@Test(dataProvider ="productData",dataProviderClass= ProductPojoDataProvider.class)
	public void  productImagesTest(ProductPOJO product)
	{
		resultsPage = accPage.doSearch(product.getSearchKey());
		productInfoPage = resultsPage.selectProduct(product.getProductName());
		int actProductImagesCount =  productInfoPage.getProductImagesCount();
		System.out.println("Actual Image count is " + actProductImagesCount);
		Assert.assertEquals(actProductImagesCount, product.getProductImages());
	}
	
	
	

}
	
	


