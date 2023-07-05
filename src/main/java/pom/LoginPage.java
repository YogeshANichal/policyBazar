package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class LoginPage
{

	// variables
	
     @FindBy(xpath="//a[text()='Sign in']") private WebElement SigninButtonHomepage;
     
     @FindBy(xpath="(//input[@type='number'])[2]") private WebElement mobileNumField;
     
     @FindBy(xpath="(//span[text()='Sign in with Password'])[2]") private WebElement signwithpassword;
     
     @FindBy(xpath="//input[@type='password']" ) private WebElement password;
     
     @FindBy(xpath="//span[text()='Sign in']" ) private WebElement signIn;
     
     @FindBy(xpath= "//div[text()='My Account']") private WebElement myAccount;
     
     @FindBy(xpath="//span[text()=' My profile ']") private WebElement myProfile;
     
      //constructor
     
     public  LoginPage(WebDriver driver)
     {
    	 Reporter.log("click login page", true);
    	 PageFactory.initElements(driver, this);
     }
     
     //methods
     
     public void SigninButtonHomepage()
     {	
    	 Reporter.log("clicking sign in button", true);
    	 SigninButtonHomepage.click();
     }
     
     public void mobileNumField(String mobileNum)
     {   
    	 Reporter.log("entering mobile number", true);
    	 mobileNumField.sendKeys(mobileNum);;
     }
     
     public void signwithpassword()
     {
    	 Reporter.log("clicking signin with password", true);
    	 signwithpassword.click();
     }
     
     public void password(String Pass)
     {
    	 Reporter.log("entering password", true);
    	 password.sendKeys(Pass);
     }
     
     public void signIn()
     {
    	 Reporter.log("clicking sign in button", true);
    	 signIn.click();
     }
     
     public void myAccount()
     {
    	 Reporter.log("clicking my account", true);
    	 myAccount.click();
     }
     
     public void myProfile()
     {
    	 Reporter.log("clicking my profile", true);
    	 myProfile.click();
     }
     
   
    	 
    	 


}
