package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage {
	public WebDriver driver;

	//Locators
	By forgotusername= By.xpath("//input[@placeholder='Username']");
	By fogotpw= By.xpath("//p[contains(@class, 'orangehrm-login-forgot-header')]");
	By Resetpw= By.xpath("//button[normalize-space()='Reset Password']");
	By cancel = By.xpath("//button[normalize-space()='Cancel']");

	
	// Constructor
    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void click_forgotPw() {
    	WebElement forgotpW= driver.findElement(fogotpw);
    	forgotpW.click();
    	
    }
    
    public void getForgotUsername(String name) {
    	WebElement s= driver.findElement(forgotusername);
    	s.sendKeys(name);
    	
    	
    }
    
    public void click_Resetpw() {
    	WebElement Reset= driver.findElement(Resetpw);
    	Reset.click();
    	
    }
    
    public void click_Cancel() {
    	WebElement Cancel= driver.findElement(cancel);
    	Cancel.click();
    	
    }
}
