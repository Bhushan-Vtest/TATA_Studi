package studi.co.pageModules;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.annotations.Test;



import studi.co.Base.*;
import studi.co.pageObjects.*;

public class Module_Login extends BaseClass {

	public static String homepage_title;
	
	
	public void Login_to_app() throws InterruptedException, IOException {

		

//		login.username.clear();
//		login.username.sendKeys(prop.getProperty("username_password"));
//		login.password.clear();
//		login.password.sendKeys(prop.getProperty("username_password"));
//		login.login_button.click();
//		
//		Thread.sleep(5000);
//		
//		homepage_title = login.homepage_title.getText();
//		
//		if(homepage_title.equals("What would\n" + "you like to do next?"))
//			System.out.println("Login successfull");
//		else 
//			System.out.println("Login Failed");
		Object_Login ol= new Object_Login(); 
		Keyword.applyImplicitWait(20);	
		Keyword.clickOnElement(ol.getAlreadyAUser());
		
		Keyword.applyExplicitWait(2);
		
		Keyword.clearText(ol.getMobileNumberTextBox());
		Keyword.sendText(ol.mobileNumberTextBox, "1000000077");
		System.out.println("Entered Mobile Number");
		Keyword.applyExplicitWait(2);
		Keyword.clickOnElement(ol.getLoginButton());
		Keyword.applyExplicitWait(2);
		
		Keyword.sendText(ol.getPasswordTextBox(), "abcd123@");
		System.out.println("Entered Password");
		Keyword.applyExplicitWait(2);
		
		Keyword.clickOnElement(ol.getVerifypasswordButton());
		Keyword.applyExplicitWait(2);
		System.out.println("Credentials verified");
		Keyword.clickOnElement(ol.getRegisteredUserName());
		Keyword.applyExplicitWait(2);
		
		Keyword.scrollTo1("Report an issue");
		System.out.println("Scrolled across the entire viewport on the LandingPage successfully");
		System.out.println("Login is Successful");
	}
}