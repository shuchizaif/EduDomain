package com.qa.opeancart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {
//initialize the driver
	
	WebDriver driver;
	public WebDriver initDriver(Properties prop)
	{
		String browserName = prop.getProperty("browser").trim();
		System.out.println("Browser name is : " + browserName );
	
	switch (browserName.toLowerCase()) {
	case "chrome":
		driver =  new ChromeDriver();
		
		break;
	case "edge":
		driver =  new EdgeDriver();
	case "Safari":
		driver =  new SafariDriver();
	case "firefox":
		driver =  new FirefoxDriver();
	default:
		System.out.println("Please pass the right browser " + browserName );
		break;
	}
	
	   driver.manage().window().maximize();
	   driver.get(prop.getProperty("url"));
	   return driver;
	
	}
	
	
	
	public Properties initProp()
	{
		Properties prop = new Properties();//will read .properties file
		try {
			FileInputStream ip = new FileInputStream("./src/main/resources/config/config.properties");//will create connection with.properties file
			prop.load(ip);//once connection is made, load method will load all properties file content
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//will make connection with config properties file
 catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prop;
		
	}
}
