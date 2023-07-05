package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class MyAccount
{
	

	//variable
	
   @FindBy(xpath = "//div[@class='textCapitalize sc-ckVGcZ kWpXlQ']") private WebElement username;

   @FindBy(xpath = "//div[@class='h_l']") private WebElement logOutButton;
   //constructor

     public MyAccount(WebDriver driver)
{
     Reporter.log("clicking my account ", true);
	PageFactory.initElements(driver, this);
}
 
    public String validateUsername()
    {
    	Reporter.log("validate username", true);
    	String actualUn = username.getText();
    	return actualUn;
    }

    public void logoutbutton() 
	
    {
    	Reporter.log("logout browser", true);
    	logOutButton.click();
    }
}
