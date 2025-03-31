package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	public WebDriver driver;

    // Locators
	By userName = By.xpath("//input[@name='username']");
	By password = By.xpath("//input[@name='password']");
	By LoginBtn= By.xpath("//button[@type='submit']");
	By fogotpw= By.xpath("//p[contains(@class, 'orangehrm-login-forgot-header')]");
	
	
	// Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    
    //Methods
    public void enterUserName(String username) {
        WebElement user_Name = driver.findElement(userName);
        user_Name.clear();  // Clears any previous input
        user_Name.sendKeys(username);
    }

    public void enterpassword(String Password) {
    	WebElement pw= driver.findElement(password);
    	pw.sendKeys(Password);
    	
    }
    

    public void LoginClick() {
    	WebElement loginButton= driver.findElement(LoginBtn);
    	loginButton.click();
    	
    }
    public void click_forgotPw() {
    	WebElement forgotpW= driver.findElement(fogotpw);
    	forgotpW.click();
    	
    }
   
    
    
    
}
