package com.agileTeachAssert;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DproviderTest {

	@Test(dataProvider = "loginData")
	void loginTest(String username, String password) {

		System.out.println("Username: " + username);
		System.out.println("Password: " + password);

		// selenium test
		// find username input element
		// find password input
		// click the button

	}

	@DataProvider(name = "loginData")
	Object[][] dprovider() { // since this method will provide data // will have a return type

		Object[][] data = { { "rabbishakir@gmail.com", "021091000" }, { "fmithila@gmail.com", "1234567" },
				{ "h_shail@hotmail.com", "qwwerr456" } };

		return data;
	}

}
