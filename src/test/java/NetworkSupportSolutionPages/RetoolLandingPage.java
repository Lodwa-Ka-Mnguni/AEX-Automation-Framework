package NetworkSupportSolutionPages;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.io.IOException;

import static Tests.OpenFiberPortalChecklist.*;
import static Tests.OpenFiberPortalChecklist.test;
import static Tests.Retool_NetworkSolutionApp_Test.driver1;

public class RetoolLandingPage {

    static String Home_screen ="//*[@id=\"skip-main\"]/div/div/div[2]/div[2]/div/div/div[2]/div/main/div/div/div/div/div/div/div/div/div/div/div/span/div/section/div/div/div/div/div/div/div/div/div/div/span/form/div/section/div/div/div/div/div[2]/div/div[1]/div/div/div/span/div/div/div/p";

    public static void verify_home_screen() throws IOException, InterruptedException {
        Thread.sleep(2000);
        String expectedTitleReTool = "Please log in to continue";
        String actualTitleReTool = driver1.findElement(By.xpath(Home_screen)).getText();
        Assert.assertEquals(actualTitleReTool,expectedTitleReTool);
        String screenshotPath = captureScreenshot(driver1);
        if (expectedTitleReTool.equals(actualTitleReTool)) {
            test.log(Status.PASS, "User is presented with the landing page");
            test.pass("Actual Result",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        } else {
            test.log(Status.FAIL, "Landing page title mismatch. Expected: " + expectedTitleReTool + " but found: " + actualTitleReTool);
            test.fail("Failure Screenshot",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }

    }

}
