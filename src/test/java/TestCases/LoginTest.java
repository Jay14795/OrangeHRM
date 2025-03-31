package TestCases;

import Pages.LoginPage;
import Utilities.ReadExcelData;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
	
    @Test(priority = 1, dataProvider = "Valid_Login", dataProviderClass = ReadExcelData.class)
    public void Valid_login(String Username, String Password) throws InterruptedException {
        test = extent.createTest("Valid Login Test");
        LoginPage login = new LoginPage(driver);

        test.info("Entering valid username");
        login.enterUserName(Username);

        test.info("Entering valid password");
        login.enterpassword(Password);

        test.info("Clicking Login");
        login.LoginClick();
        Thread.sleep(2000);

        String Expected = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
        Assert.assertEquals(driver.getCurrentUrl(), Expected);
        test.pass("Valid login test passed");
    }

    @Test(priority = 2, dataProvider = "Invalid_Login", dataProviderClass = ReadExcelData.class)
    public void Invalid_login(String Username, String Password) throws InterruptedException {
        test = extent.createTest("Invalid Login Test");
        LoginPage login = new LoginPage(driver);

        test.info("Entering valid username");
        login.enterUserName(Username);

        test.info("Entering invalid password");
        login.enterpassword(Password);

        test.info("Clicking Login");
        login.LoginClick();
        Thread.sleep(2000);

        String Expected = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
        Assert.assertEquals(driver.getCurrentUrl(), Expected);
        test.pass("Invalid login test passed");
    }
}
