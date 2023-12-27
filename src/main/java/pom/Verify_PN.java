package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;


public class Verify_PN 
{

	@FindBy(xpath="//span[@class='user-id']") private WebElement PN;
	
	
	public Verify_PN(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	public void VerifyProfileName(String ProfileName)
	{
		
		String act = PN.getText();
		
		SoftAssert soft=new SoftAssert();
		
		soft.assertEquals(act, ProfileName,"Profile Name is Not Matching");
		soft.assertAll();
	}
	
	
	
}
