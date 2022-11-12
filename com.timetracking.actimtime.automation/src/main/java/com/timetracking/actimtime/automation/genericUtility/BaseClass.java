package com.timetracking.actimtime.automation.genericUtility;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.timetracking.actimtime.automation.pomRepo.HomePage;
import com.timetracking.actimtime.automation.pomRepo.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver;
	public FileUtility fUtils = new FileUtility();

	
	@BeforeSuite
	public void bsConfig() {
		System.out.println("Data Base Connectivity has been established");
	}
	
	@BeforeClass
	public void bcConfig() throws IOException {
		
		String url = fUtils.fetchDataFromPropertyFile("url");
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);

	}
	
	@BeforeMethod
	public void bmConfig() throws IOException {
		String username = fUtils.fetchDataFromPropertyFile("username");
		String password = fUtils.fetchDataFromPropertyFile("password");
		LoginPage login=new LoginPage(driver);
		login.loginAction(username, password);
	}
	
	@AfterMethod
	public void amVConfig() {
		HomePage home=new HomePage(driver);
		home.logoutAction();

	}
	
	@AfterClass
	public void acConfig() {
		driver.quit();
	}
	
	@AfterSuite
	public void asConfig() {
		System.out.println("Data Base Connection has been Closed");
	}

}
