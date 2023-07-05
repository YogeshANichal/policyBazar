package base;

import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Base
{
     //driver and browser setup
	
       static protected  WebDriver driver;
	   
	   public void launchBrowser()
	   { 
		   driver=new ChromeDriver();
		   
		   driver.get("https://www.policybazaar.com/");
		   
		   driver.manage().window().maximize();
		   
		   
		   Reporter.log("Launching browser", true);
		   
	   }
	   
	   public void closeBrowser()
	   {
		   driver.quit();
		   
		   Reporter.log("close browser", true);
	   }

}
