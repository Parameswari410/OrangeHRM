package com.TestCase;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.commonfunctions.CommonFunctions;
import com.pageobject.PendingleaveRequest_PageObject;

public class Test_PendingleaveReq extends CommonFunctions {

	String text;
	
	public void get_Pending_Leave_request(){
		
		text = PendingleaveRequest_PageObject.Records.getText();
	}
	
	@Test
	public void verifyPendingLeaveRequest(){
		
		logger.info("verify the pendingLeaveRequest");
		
		login();
		get_Pending_Leave_request();
		
		Assert.assertEquals(text, "No Records are Available");
	}
}
