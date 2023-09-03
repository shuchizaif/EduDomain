package com.qa.opencart.utils;

import java.util.Arrays;
import java.util.List;

public class AppConstants {
	
	// In AppConstants page we maintain all values that are constant/hard coded values
	//and these variables are static- so that can be called every where without creating object of class
	//final so that no one can change them and written using UPPER CASE with underscore separators
	public static final String LOGIN_PAGE_TITLE_VALUE ="Account Login";
	public static final String ACCOUNTS_PAGE_TITLE_VALUE ="My Account";
	public static final String LOGIN_PAGE_URL_FRACTION_VALUE = "route=account/login";
	public static final int SHORT_DEFAULT_WAIT = 10;
	public static final int MEDIUM_DEFAULT_WAIT = 15;
	public static final int LONG_DEFAULT_WAIT = 25;
	public static final String USER_REG_SUCCESS_MESSG = "Your Account Has Been Created!";
	
	public static final List<String> EXP_ACCOUNTS_HEADERS_LIST  = Arrays.asList("My Account", "My Orders", "My Affiliate Account", "Newsletter");
	
	//***********************SHEET NAMES*******************************************8
	public static final String REGISTER_SHEET_NAME ="register";
	
	
	
	
}
