package TestCases;

import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(priority = 1)
    public void Valid_login() throws InterruptedException {
        test = extent.createTest("Valid Login Test");
        LoginPage login = new LoginPage(driver);

        test.info("Entering valid username");
        login.enterUserName("Admin");

        test.info("Entering valid password");
        login.enterpassword("admin123");

        test.info("Clicking Login");
        login.LoginClick();
        Thread.sleep(2000);

        String Expected = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
        Assert.assertEquals(driver.getCurrentUrl(), Expected);
        test.pass("Valid login test passed");
    }

    @Test(priority = 2)
    public void Invalid_login() throws InterruptedException {
        test = extent.createTest("Invalid Login Test");
        LoginPage login = new LoginPage(driver);

        test.info("Entering valid username");
        login.enterUserName("Admin");

        test.info("Entering invalid password");
        login.enterpassword("admin1234");

        test.info("Clicking Login");
        login.LoginClick();
        Thread.sleep(2000);

        String Expected = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
        Assert.assertEquals(driver.getCurrentUrl(), Expected);
        test.pass("Invalid login test passed");
    }
}
