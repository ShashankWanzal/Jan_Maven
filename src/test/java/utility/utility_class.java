package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import base.Base_Class;

public class utility_class extends Base_Class implements ITestListener
{


	public void onStart(ITestContext context) {
		
		System.out.println("Test is started");
		
	}
	

	public String propertyfile() throws IOException
	{
		
		Properties file=new Properties();
		
		FileInputStream source=new FileInputStream("C:\\Users\\shash\\eclipse-workspace\\JanBatch_23\\Property File\\Jan_23_1.properties");
		
		file.load(source);
		
		String url = file.getProperty("URL");
		
		return url;
		
		
	}
	
	public void screenshot(String str) throws IOException
	{
		
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File Dest=new File("C:\\Users\\shash\\eclipse-workspace\\JanBatch_23\\Screnshot\\test"+str+".png");
		
		FileHandler.copy(source, Dest);
		
		
	}
	
	public String openexcel(int Rows,int Columns) throws EncryptedDocumentException, IOException
	{
		
		FileInputStream source=new FileInputStream("C:\\Users\\shash\\eclipse-workspace\\JanBatch_23\\Excel\\Jan_23.xlsx");
		
		
		Sheet sheet = WorkbookFactory.create(source).getSheet("Sheet1");
		
		String value = sheet.getRow(Rows).getCell(Columns).getStringCellValue();
		
		return value;
		
	}
	
	
	
	public void onFinish(ITestContext context) {
		System.out.println("Test is compleated");
	}
	
	

	
	
	
	
	
	
	
	
	
}
