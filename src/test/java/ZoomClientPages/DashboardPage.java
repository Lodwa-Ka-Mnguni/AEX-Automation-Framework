package ZoomClientPages;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;

import static Tests.TestUtils.capture;
import static Tests.ZoomClientTest.*;

public class DashboardPage {

    //Locators
    public static String verify_dash = "//*[@id=\"sideNav\"]/li[3]";
    public static String my_package_button = "//app-dashboard//button[1]";

    //Action
    public static void verify_dashboard_page() throws IOException, InterruptedException {
        String expectedTitleDASH = "COVERAGE & PRODUCTS";
        String actualTitleDASH = driver.findElement(By.xpath(verify_dash)).getText();
        Assert.assertEquals(actualTitleDASH,expectedTitleDASH);
        Thread.sleep(2000);
        String screenshotPath = captureScreenshot(driver);
        if (expectedTitleDASH.equals(actualTitleDASH)) {
            test.log(Status.PASS, "The following tabs displaye: My Pacakage, My Profile, My Payment History");
            test.pass("Actual Result",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        } else {
            test.log(Status.FAIL, "Landing page title mismatch. Expected: " + expectedTitleDASH + " but found: " + actualTitleDASH);
            test.fail("Failure Screenshot",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }

    }
    public static void click_my_profile_button() throws InterruptedException, IOException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(my_package_button)).click();
        String screenshotPath = captureScreenshot(driver);
        test.pass("Actual Result",
                MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
    }
}
