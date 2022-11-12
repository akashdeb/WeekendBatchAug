package com.timetracking.actimtime.automation.pomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public HomePage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[text()='Tasks']")
	private WebElement taskButton;
	
	@FindBy(xpath = "//a[text()='Logout']")
	private WebElement logoutButton;

	public WebElement getTaskButton() {
		return taskButton;
	}

	public WebElement getLogoutButton() {
		return logoutButton;
	}
	
	public void clickOnTaskButton() {
		taskButton.click();
	}
	
	public void logoutAction() {
		logoutButton.click();
	}
}
