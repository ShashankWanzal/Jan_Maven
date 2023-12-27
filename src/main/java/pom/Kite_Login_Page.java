package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Kite_Login_Page 
{

	
	@FindBy(xpath="//input[@id='userid']") private WebElement UN;
	
	@FindBy(xpath="//input[@id='password']") private WebElement Pass;
	
	@FindBy(xpath="//button[text()='Login ']") private WebElement LoginBtn;
	
	
	
	public Kite_Login_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void SetUserName(String Username)
	{
		
		UN.sendKeys(Username);
		
	}
	
	
	public void SetPassword(String Password)
	{
		
		Pass.sendKeys(Password);
		
	}
	
	public void ClickOnLoginBtn()
	{
		LoginBtn.click();
	}
	
	
	
}
