package ZoomClientPages;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.io.IOException;

import static Tests.TestUtils.capture;
import static Tests.ZoomClientTest.*;


public class LoginPage {

    // Locators
     static String emailInput ="//*[@id='email']//input";
     static String passwordInput = "//*[@id='password']//input";
     static String loginBtn = "/html/body/app-root/div/div[1]/app-login/div/div/form/div[5]/div/button";
     static String login_header_title ="/html/body/app-root/div/div[1]/app-login/div/div/h4";


    public static void verify_login_page() throws IOException, InterruptedException {
        Thread.sleep(2000);
        String expectedTitleLOG = "LOGIN";
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
    public static void click_login() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(loginBtn)).click();
    }

}
