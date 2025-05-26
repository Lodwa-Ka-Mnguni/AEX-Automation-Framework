package ZoomClientPages;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;

import static Tests.TestUtils.capture;
import static Tests.ZoomClientTest.*;

public class DashboardPage {

    //Locators
    public static String my_packages = "/html/body/app-root/div/div[1]/app-dashboard/div[1]/div[2]/span[1]/button";
    public static String my_profile = "/html/body/app-root/div/div[1]/app-dashboard/div[1]/div[2]/span[2]/button";

    //Action
    public static void verify_dashboard_page() throws IOException, InterruptedException {
        Thread.sleep(2000);
        String expectedTitleDASH = "My Packages";
        String actualTitleDASH = driver.findElement(By.xpath(my_packages)).getText();
        Assert.assertEquals(actualTitleDASH,expectedTitleDASH);
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
}
