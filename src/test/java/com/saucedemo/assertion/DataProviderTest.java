package com.saucedemo.assertion;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {

	// same test cases can be run with different set of data
	// it uses a method to supply data to other methods
	// one method is responsible to generate data @dataprovider pass it to another Method
	// another method  uses that data
	
	@Test(dataProvider = "LoginDataProvider")
	void loginTest(String name, String password) {
		System.out.println(name + password);
	}

	@DataProvider(name = "LoginDataProvider")
	public Object[][] getData() {

		Object[][] data = { { "rabbishakir@gmail.com", "021091030" }, { "h_shail@hotmail.com", "123456" },
				{ "fmithila@gmail.com", "9098767" } };
		return data;

	}

}
