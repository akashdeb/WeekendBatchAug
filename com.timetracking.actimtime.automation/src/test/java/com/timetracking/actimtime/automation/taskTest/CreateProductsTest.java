package com.timetracking.actimtime.automation.taskTest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.timetracking.actimtime.automation.genericUtility.BaseClass;
import com.timetracking.actimtime.automation.genericUtility.ExcelUtility;
import com.timetracking.actimtime.automation.pomRepo.CustomerDetailsPage;
import com.timetracking.actimtime.automation.pomRepo.HomePage;
import com.timetracking.actimtime.automation.pomRepo.TaskPage;

public class CreateProductsTest extends BaseClass {
	
	@Test
	public void createProductsAndVerifyProductNameTest() throws IOException {
		
		ExcelUtility eUtils=new ExcelUtility();
		String expectedCustomerName = eUtils.fetchDataFromExcelSheet("Sheet2", 2, 0);
		String description = eUtils.fetchDataFromExcelSheet("Sheet2", 2, 1);
		
		HomePage home=new HomePage(driver);
		home.clickOnTaskButton();
		
		TaskPage task = new TaskPage(driver);
		task.createCustomer(expectedCustomerName, description);
		
		CustomerDetailsPage customer=new CustomerDetailsPage(driver);
		String actualCustomerName = customer.verifycustomerName(expectedCustomerName);
		
		Assert.assertEquals(actualCustomerName, expectedCustomerName);
		System.out.println("Pass: Customer Name has been verified");
		
	}
	

}
