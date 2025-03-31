package TestCases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import Utilities.ExtentManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected static ExtentReports extent;  // Make extent static to persist across tests
    protected ExtentTest test;

    @BeforeSuite
    public void setupExtent() {
        extent = ExtentManager.getInstance();  // Initialize ExtentReports
    }

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (test != null) {  // Avoid NullPointerException
            if (result.getStatus() == ITestResult.FAILURE) {
                test.fail("Test Failed: " + result.getName());
                test.fail("Reason: " + result.getThrowable());
            } else if (result.getStatus() == ITestResult.SUCCESS) {
                test.pass("Test Passed: " + result.getName());
            } else {
                test.skip("Test Skipped: " + result.getName());
            }
        }
        driver.quit();
    }

    @AfterSuite
    public void tearDownExtent() {
        if (extent != null) {
            extent.flush();  // Ensure Extent Report is written
        }
    }
}
