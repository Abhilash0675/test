package com.qa.hs.tests;
import com.qa.hs.keyword.base.*;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


import com.qa.hs.keyword.engine.KeyWordEngine;
/**
 * 
 * AUTHOR : ABHILASH 
 *
 */
public class LoginTest {
	
	public KeyWordEngine keyWordEngine;
	public Base base;
	public Properties prop;
	public WebDriver driver;

	
	@BeforeSuite
	public void start() {
		base = new Base();
		prop = base.init_properties();
		driver = base.init_driver(prop.getProperty("browser"));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(300, TimeUnit.SECONDS);
		
	}
	
	@Test (priority = 1)
	public void loginTest() throws InterruptedException{
		keyWordEngine = new KeyWordEngine(driver);
		keyWordEngine.startExecution("login");
		keyWordEngine.startExecution("create_contact_form");
		Thread.sleep(5000);
		//d

	}
	
//	@Test (priority = 2)
//	public void leadsTest() throws InterruptedException{
//		//keyWordEngine = new KeyWordEngine(driver);
//		keyWordEngine.startExecution("leads");
//		Thread.sleep(7000);
//		//d
//	}
	
	
	@AfterSuite
	public void end() {
		driver.quit();
	}
	
//	@Test
//	public void signUpTest(){
//		keyWordEngine = new KeyWordEngine();
//		keyWordEngine.startExecution("signup");
//	}
	
	
	

}
