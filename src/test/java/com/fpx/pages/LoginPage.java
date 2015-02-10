package com.fpx.pages;

import java.io.IOException;

import com.fpx.base.Base;
import com.fpx.elements.LoginPageElements;

public class LoginPage extends LoginPageElements{
	
	public void loginToApplication() 
	{
		LoginPageElements loginPgEle = new LoginPageElements();
		findById(loginPgEle.username_id).sendKeys("rajagopal.arumugam@fpx.com");
		findById(loginPgEle.password_id).sendKeys("!mag!nea21");
		findByXpath(loginPgEle.submit_xpath).submit();
		
//		username.sendKeys("rajagopal.arumugam@fpx.com");
//		password.sendKeys("!mag!nea21");
//		submit.click();
	}

}
