package com.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PendingleaveRequest_PageObject {
	
	@FindBy(id="txtUsername")
	public static WebElement username;
	@FindBy(id="txtPassword")
	public static WebElement password;
	@FindBy(id="btnLogin")
	public static WebElement login;
	@FindBy(xpath="//table[@class='table hover']//tr//td[1]")
	public static WebElement Records;
}
