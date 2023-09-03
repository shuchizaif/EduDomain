package com.qa.opencart.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;

public class ProductInfoPage {

	private WebDriver driver;
	private ElementUtil eleUtil;
	
	//By Locators
	private By productHeader = By.cssSelector("div#content h1");
	private By productImages = By.cssSelector("ul.thumbnails img");
	private By productMetaData = By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[position()=1]/li");
	private By productPriceData = By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[position()=2]/li");
	private By quantity = By.id("input-quantity");
	private By addToCartBtn = By.id("button-cart");
	
	
	
	private Map<String,String>productInfoMap;//
	
	public ProductInfoPage(WebDriver driver) 
	{
		this.driver = driver;
		eleUtil= new ElementUtil(this.driver);
		
	}
	public String getproductHeaderName()
	{
		return eleUtil.doGetElementText(productHeader);
	}
	
	public int  getProductImagesCount()
	{
		return eleUtil.waitForElementsVisible(productImages, 10).size();
	}
	
	public Map<String, String> getProductInfo()
	{
		getProductMetaData();
		getProductPriceData();
		productInfoMap.put("produtname", getproductHeaderName());
		return productInfoMap;
	}
	
	
	
	//Brand: Apple
	//Product Code: Product 18
	//Reward Points: 800
	//Availability: In Stock
	
	
	private void getProductMetaData()
	{
		List<WebElement>metaList = eleUtil.getElements(productMetaData);
		productInfoMap = new HashMap<String,String>();//will store key, value data after trim
		for(WebElement e:metaList )
		{
			String metatext = e.getText();//here it will give output as Brand: Apple
			String metaInfo[] = metatext.split(":");//to split Brand: Apple in key and value pair
			String key = metaInfo[0].trim();//this will give us text Brand
			String value = metaInfo[1].trim();//this will give us text Apple
			productInfoMap.put(key, value);//add key, value in this productInfoMap
			
		}
		
	}
	
	//$2,000.00
	//Ex Tax : $2,000.00
	
	private void getProductPriceData()
	{
		List<WebElement>priceList = eleUtil.getElements(productMetaData);
		String priceValue = priceList.get(0).getText();
		String extTaxPrice = priceList.get(1).getText();
		String extraPriceValue = extTaxPrice.split(":")[1].trim();
		
		productInfoMap.put("productprice", priceValue);
		productInfoMap.put(extTaxPrice, extraPriceValue);
		
		
		
		
		
		
	
}
	
}
