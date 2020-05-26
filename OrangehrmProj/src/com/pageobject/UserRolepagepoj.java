package com.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRolepagepoj {
	
	@FindBy(id ="menu_admin_viewAdminModule")
	public static WebElement admin;
	
	@FindBy(id ="menu_admin_UserManagement")
	public static WebElement useradmin;
	
	@FindBy(id ="menu_admin_viewSystemUsers")
	public static WebElement user;
	
	@FindBy(id ="searchSystemUser_userType")
	public static WebElement userrole;
	
	@FindBy(id ="searchSystemUser_status")
	public static WebElement status;
	
	@FindBy(id ="searchBtn")
	public static WebElement searchresult;
	
	@FindBy(xpath ="//table[@id='resultTable']//tr//td[3]")
	public static WebElement userRoleresult;
	
	@FindBy(xpath ="//table[@id='resultTable']//tr//td[5]")
	public static WebElement userStatusresult;

}
