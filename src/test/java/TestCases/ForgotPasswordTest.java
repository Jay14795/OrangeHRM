package TestCases;

import Pages.ForgotPasswordPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ForgotPasswordTest extends BaseTest {

    @Test(priority = 1)
    public void ForgotPw_click() throws InterruptedException {
        test = extent.createTest("Forgot Password Click Test");

        test.info("Navigating to Forgot Password page");
        ForgotPasswordPage fp = new ForgotPasswordPage(driver);
        fp.click_forgotPw();

        WebElement reset = driver.findElement(By.xpath("//h6[normalize-space()='Reset Password']"));
        if (reset.isDisplayed()) {
            test.pass("Reset Password page displayed successfully");
            Assert.assertTrue(true);
        } else {
            test.fail("Reset Password page not displayed");
        }
    }

    @Test(priority = 2)
    public void ForgotPw_valid() throws InterruptedException {
        test = extent.createTest("Forgot Password - Valid Username Test");

        ForgotPasswordPage fp = new ForgotPasswordPage(driver);
        fp.click_forgotPw();
        Thread.sleep(3000);

        test.info("Entering valid username");
        fp.getForgotUsername("Admin");

        test.info("Clicking Reset Password");
        fp.click_Resetpw();
        Thread.sleep(3000);

        String expectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/sendPasswordReset";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
        test.pass("Valid username test passed");
    }

    @Test(priority = 3)
    public void ForgotPw_Invalid() throws InterruptedException {
        test = extent.createTest("Forgot Password - Invalid Username Test");

        ForgotPasswordPage fp = new ForgotPasswordPage(driver);
        fp.click_forgotPw();
        Thread.sleep(3000);

        test.info("Entering invalid username");
        fp.getForgotUsername("QA_Admin");

        test.info("Clicking Reset Password");
        fp.click_Resetpw();
        Thread.sleep(3000);

        String expectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/sendPasswordReset";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
        test.pass("Invalid username test passed");
    }
}
