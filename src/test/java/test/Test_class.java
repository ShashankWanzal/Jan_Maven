package test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import base.Base_Class;
import pom.Kite_Login_Page;
import pom.Verify_PN;
import utility.utility_class;


@Listeners(utility.utility_class.class)
public class Test_class extends Base_Class
{

	
	ExtentTest test;
	utility_class util;
	Kite_Login_Page loginpage;
	Verify_PN PN_verify;
	String TCID="001";
	
	@BeforeClass
	public void openchrome() throws IOException
	{

		
		chrome();
		ExtentReporter1();
		
		test = extent.createTest("Validate Kite","Validate Profile Name");
		
		test.log(Status.INFO, "Chrome Browser is opening");
		
		driver.manage().deleteAllCookies();
		test.log(Status.INFO, "Deleted all previous Cookies");
		
		util=new utility_class();
		
		driver.get(util.propertyfile());
		
		test.info("Zerodha is opening");
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		loginpage=new Kite_Login_Page(driver);
		PN_verify=new Verify_PN(driver);
		
		
	}
	
	
	@BeforeMethod
	public void PreCondition() throws EncryptedDocumentException, IOException, InterruptedException
	{
		
		loginpage.SetUserName(util.openexcel(0, 0));
		test.log(Status.INFO, "We Enter User Name= "+util.openexcel(0, 0));
		
		loginpage.SetPassword(util.openexcel(0, 1));
		test.log(Status.INFO, "We Enter Password= "+util.openexcel(0, 1));
		
		loginpage.ClickOnLoginBtn();
		test.log(Status.INFO, "Clicked on LogIn Button ");
		
		
		Thread.sleep(5000);
		test.log(Status.WARNING, "Waiting for 5 min to enter the mobile pass");
		
		
	}
	
	
	
	@Test
	public void Test() throws EncryptedDocumentException, IOException
	{
		
		PN_verify.VerifyProfileName(util.openexcel(0,2));
		
		
		
		
	}
	
	@AfterMethod
	public void PostCondition(ITestResult result) throws IOException
	{
	
		
		if(result.getStatus()== ITestResult.FAILURE )
		{
			util.screenshot(TCID);
			
			test.fail("Test case id 001 is failed",
					MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\shash\\eclipse-workspace\\JanBatch_23\\Screnshot\\test"+TCID+".png").build());
			
			
			
		}
		else 
		{
			test.pass("Test Case is passed");
			
		}
		
		
		test.log(Status.INFO, "Clicked on Logout button ");
		
		
		
		
	
	}
	
	
	
	@AfterClass
	public void CloseBrowser()
	{
		
		driver.close();
		
		test.log(Status.INFO, "rowser is closed  ");
		
		
		extent.flush();
	}
	
	
	
	
}
