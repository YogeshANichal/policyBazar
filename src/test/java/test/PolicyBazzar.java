package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.Base;
import pom.LoginPage;
import pom.MyAccount;
import utility.Utility;


public class PolicyBazzar extends Base {
	
	MyAccount myAcc;
	LoginPage Login;
	String TCID="PB_TC1234";
	
  @BeforeClass 
  public void launchbrowser() throws InterruptedException 
  {
	Utility.waitTime(500);  
    launchBrowser();
    
    myAcc=new MyAccount(driver);
    Login=new LoginPage(driver);
  }
  
  @BeforeMethod
  public void SigninPolicyBazar() throws InterruptedException, EncryptedDocumentException, IOException
  {
	  Utility.waitTime(2000);
	  Login.SigninButtonHomepage();
	  Utility.waitTime(2000);
	  Login.mobileNumField(Utility.ReadDataFromPropertyFile("mobNum"));
	  Utility.waitTime(2000);
	  Login.signwithpassword();
	  Utility.waitTime(2000);
	  Login.password(Utility.ReadDataFromPropertyFile("password"));
	  Utility.waitTime(2000);
	  Login.signIn();
	  Utility.waitTime(2000);
	  Login.myAccount();
	  Utility.waitTime(2000);
	  Login.myProfile();
	  Utility.waitTime(2000);
	  
	  Set<String> allIds = driver.getWindowHandles();
	  ArrayList<String>L=new ArrayList<>(allIds);
	  
	  String mainWindow = L.get(0);
	  String childWindow = L.get(1);
	  
	  driver.switchTo().window(childWindow);
  }
	  @Test
	  public void validateUserName1() throws EncryptedDocumentException, IOException
	  {
		  String ActualUN = myAcc.validateUsername();
		  
		  String expectedUN = Utility.ReadDataFromPropertyFile("UName");
		  
		  Assert.assertEquals(ActualUN, expectedUN,"Test case is fail acctual and expexted is not match");
		  
		  Utility.TakeScreenshot(driver, expectedUN+TCID);
	  }	  
	  @AfterMethod
	  public void logoutPolicyBazar()
	  {
		  myAcc.logoutbutton();
	  }
	  
	  @AfterClass
	  public void closebrowser() throws InterruptedException
	  {
		  closeBrowser();
	  }
	  
  }
  
  
  
  
  
  
  
  
  
  
  

