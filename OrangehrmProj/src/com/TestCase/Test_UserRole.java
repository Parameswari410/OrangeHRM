package com.TestCase;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.commonfunctions.CommonFunctions;
import com.pageobject.UserRolepagepoj;

public class Test_UserRole extends CommonFunctions {
	
	
	public void movetouserpage()  {
		Actions act = new Actions(driver);
		act.moveToElement(UserRolepagepoj.admin);
		act.moveToElement(UserRolepagepoj.useradmin);
		act.moveToElement(UserRolepagepoj.user).click().build().perform();
	}
	
	public void userrole() {
		
		Select  select = new Select(UserRolepagepoj.userrole);
		select.selectByIndex(1);
	}
	
	public void status() {
		Select select = new Select(UserRolepagepoj.status);
		select.selectByIndex(1);
	}

	public void search() {
		UserRolepagepoj.searchresult.click();
	}
	
	public void FinalResults() {
		String role =UserRolepagepoj.userRoleresult.getText();
		String status =UserRolepagepoj.userStatusresult.getText();
		
		Assert.assertEquals(role, "Admin");
		Assert.assertEquals(status, "Enabled");
		
		
	}
	
	@Test
	public void verifyUserole() {
		
		
		PageFactory.initElements(driver, UserRolepagepoj.class);
		
		logger.info("Move to userpage");
		movetouserpage();
		
		logger.info("select userRole");
		userrole();
		
		logger.info("select the status");
		status();
		
		logger.info("verify search result");
		search();
		FinalResults();
		
		
	}
	
}
