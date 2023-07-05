package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class Utility
{
    

	//Commonly used method
	
	//screenshot
	//scrolling
	//data reading
	//wait
	
	public static void TakeScreenshot(WebDriver driver,String filename) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("C:\\Users\\lenovo\\eclipse-workspace\\PolicyBazar\\screenshot\\"+filename+".png");
		FileHandler.copy(src, dest);
		Reporter.log("taking screenshot", true);
	}
	
	public static void scrollintoView(WebDriver driver,WebElement element)
	{
		((JavascriptExecutor)driver).executeScript("arguments[0]scrollIntoView[true]", element);
		Reporter.log("scrollIntoview", true);
	}
	
	public static String readDataFromExcel(int row,int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream myfile=new FileInputStream("D:\\yogeshdoc\\Book1.xlsx");
		String value = WorkbookFactory.create(myfile).getSheet("Sheet2").getRow(row).getCell(cell).getStringCellValue();
		
		return value;
	}
	
	public static void waitTime(int wait) throws InterruptedException
	{
		Thread.sleep(wait);
	}

	public static String ReadDataFromPropertyFile(String key) throws IOException
	{
		Properties prop=new Properties();
		FileInputStream myfile=new FileInputStream("C:\\Users\\lenovo\\eclipse-workspace\\selinumStudy\\properties");
		prop.load(myfile);
		String value = prop.getProperty(key);
		return value;
		
	}
	

}
