package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class ResultsPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	//By Locators
	private By resultsProduct  = By.cssSelector("div.product-layout.product-grid");
	
	//Constructor
	public ResultsPage(WebDriver driver)
	{
		this.driver= driver;
		eleUtil = new ElementUtil(this.driver);
	}
	

	//Page Actions
	public String getResultsPageTitle(String searchkey)
	{
		return eleUtil.waitForTitleIsAndCapture(searchkey, AppConstants.SHORT_DEFAULT_WAIT);
	}
	
	public int getProductsResultsCount()
	{
		int resultCount = eleUtil.waitForElementsVisible(resultsProduct, AppConstants.MEDIUM_DEFAULT_WAIT).size();
		System.out.println("Product Result Count is " + resultCount);
		return resultCount;
	}
	
	public ProductInfoPage selectProduct(String productName)
	{
		By productNameLocator = By.linkText(productName);
		//declaring By locator for search product here and not on class level as its dynamic result which will keep on changing
		eleUtil.doClick(productNameLocator);
		return new ProductInfoPage(driver);
	}
	
	
	

}
