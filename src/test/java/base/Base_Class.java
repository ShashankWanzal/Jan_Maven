package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Base_Class
{
	
	public static WebDriver driver;
	public static ChromeOptions options;	
	public static ExtentHtmlReporter report;
	public static ExtentReports extent;
	
	public static void chrome()
	{
		// Browser Opening code
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\shash\\OneDrive\\Documents\\chromedriver_win32\\chromedriver.exe");
		
		options=new ChromeOptions();
		
		options.addArguments("---disable-Notifocations");
		
		
		driver=new ChromeDriver(options);
		
		
		
		
		
	}
	
	
	public static ExtentReports ExtentReporter1()
	{
		
		report=new ExtentHtmlReporter("C:\\Users\\shash\\eclipse-workspace\\JanBatch_23\\Extent_Report\\JanBatch123.html");
		
		extent=new ExtentReports();
		
		extent.attachReporter(report);
		
		return extent;
		
		
	}
	

	
	
	
}
