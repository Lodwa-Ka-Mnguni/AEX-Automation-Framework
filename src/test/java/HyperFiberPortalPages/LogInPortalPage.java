package HyperFiberPortalPages;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.io.IOException;

import static Tests.OpenFiberPortalChecklist.captureScreenshot;
import static Tests.OpenFiberPortalChecklist.driver;
import static Tests.OpenFiberPortalChecklist.test;

public class LogInPortalPage {
    // Locators
    static String emailInput ="//*[@id=\"Email\"]";
    static String passwordInput = "//*[@id=\"Password\"]";
    static String loginBtn = "//*[@id=\"loginForm\"]/form/div[4]/div/button";
    static String login_header_title ="/html/body/div[4]/div/div/div/header/h1";


    public static void verify_login_page() throws IOException, InterruptedException {
        Thread.sleep(2000);
        String expectedTitleLOG = "Login";
        String actualTitleLOG = driver.findElement(By.xpath(login_header_title)).getText();
        Assert.assertEquals(actualTitleLOG,expectedTitleLOG);
        String screenshotPath = captureScreenshot(driver);
        if (expectedTitleLOG.equals(actualTitleLOG)) {
            test.log(Status.PASS, "User is presented with the dashboard page");
            test.pass("Actual Result",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        } else {
            test.log(Status.FAIL, "Landing page title mismatch. Expected: " + expectedTitleLOG + " but found: " + actualTitleLOG);
            test.fail("Failure Screenshot",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }


    }
    public static void enter_email() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(emailInput)).sendKeys("tendanir@automationexchange.co.za");
    }
    public static void enter_password() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(passwordInput)).sendKeys("tendanir@automationexchange.co.za");
    }
    public static void click_login() throws InterruptedException, IOException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(loginBtn)).click();
        String screenshotPath = captureScreenshot(driver);
        test.pass("Actual Result",
                MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
    }
}
