package com.qa.opencart.dataproviders;

import org.testng.annotations.DataProvider;

import com.qa.opencart.pojo.ProductPOJO;

public class ProductPojoDataProvider {
	
	@DataProvider(name = "productData")
	public Object[][] getMasterProductTestData()
	{
		return new Object[][]
		{
		{new ProductPOJO("Macbook", "MacBook Pro", 4)},//calling Constructor making object of class ProductPOJO
		{new ProductPOJO("iMac", "iMac", 3)},
		{new ProductPOJO("Samsung", "Samsung SyncMaster 941BW", 1)},
		{new ProductPOJO("Samsung", "Samsung Galaxy Tab 10.1", 7)}
	};

	}
	@DataProvider
	public Object[][] getProductSearchKeyData()
	{
		return new Object[][]
				{
			          {"Macbook"},
			          {"iMac"},
			          {"Samsung"}
				};
	}
	
	@DataProvider
	public Object[][] getProductTestData()
	{
		return new Object[][]
				{
			       {"Macbook","MacBook Pro"},
			       {"iMac","iMac"},
			       {"Samsung","Samsung SyncMaster 941BW"},
			       {"Samsung","Samsung Galaxy Tab 10.1"}
				};
	}
	
	@DataProvider
	public Object[][] getProductImagesTestData()
	{
		return new Object[][]
				{

			{"Macbook","MacBook Pro",4},
			{"iMac","iMac",3},
			{"Samsung","Samsung SyncMaster 941BW",1},
			{"Samsung","Samsung Galaxy Tab 10.1",7}
			      
			
				};
		
		
	}
	
}
