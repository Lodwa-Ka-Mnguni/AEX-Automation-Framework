package ZoomClientPages;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;

import static Tests.TestUtils.capture;
import static Tests.ZoomClientTest.driver;
import static Tests.ZoomClientTest.*;

public class LandingPage {
    // Locators
    public static String home_page_Title ="/html/body/app-root/div/app-header/div/nav/div[1]/div[2]/strong";
    public static String view_products_button = "/html/body/app-root/div/div[1]/app-landing/div/div/div/div[1]/app-landing-card/div/div[3]/div/button";
    public static String register_button = "/html/body/app-root/div/div[1]/app-landing/div/div/div/div[2]/app-landing-card/div/div[3]/div/button";
    public static  String coverage_Title ="/html/body/app-root/div/div[1]/app-landing/div/div/div/div[1]/app-landing-card/div/div[1]/div/h2";
    public  static  String sign_Up_Title ="/html/body/app-root/div/div[1]/app-landing/div/div/div/div[3]/app-landing-card/div/div[1]/div/h2/strong";
    public static String reacharge_Title ="/html/body/app-root/div/div[1]/app-landing/div/div/div/div[2]/app-landing-card/div/div[3]/div";
    private static final By home_login_button = By.xpath("/html/body/app-root/div/div[1]/app-landing/div/div/div/div[3]/app-landing-card/div/div[3]/div/button");

    // Actions
    public static void verify_home_page() throws IOException, InterruptedException {
        Thread.sleep(2000);
        String expectedTitleRLH = "Powered by";
        String actualTitleRLH = driver.findElement(By.xpath(home_page_Title)).getText();
        Assert.assertEquals(actualTitleRLH,expectedTitleRLH);
        String screenshotPath = captureScreenshot(driver);
        if (expectedTitleRLH.equals(actualTitleRLH)) {
            test.log(Status.PASS, "User is presented with the landing page");
            test.pass("Actual Result",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        } else {
            test.log(Status.FAIL, "Landing page title mismatch. Expected: " + expectedTitleRLH + " but found: " + actualTitleRLH);
            test.fail("Failure Screenshot",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }

    }
    public static void click_view_products_button() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(view_products_button)).click();
    }

    public static void click_register_button() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(register_button)).click();
    }

    public static boolean click_login_button() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(home_login_button)).click();
            return true;
        } catch (Exception e) {
            System.out.println("Error clicking login button: " + e.getMessage());
            return false;
        }
    }


    @SneakyThrows
    public  static void verify_product_button(){
        String expectedTitleRLC = "COVERAGE & PRODUCTS";
        String actualTitleRLC = driver.findElement(By.xpath(coverage_Title)).getText();
        Assert.assertEquals(actualTitleRLC,expectedTitleRLC);
        String screenshotPath = captureScreenshot(driver);
        if (expectedTitleRLC.equals(actualTitleRLC)) {
            test.log(Status.PASS, "User is presented with the landing page which includes the View Product Button");
            test.pass("Actual Result",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        } else {
            test.log(Status.FAIL, "Landing page title mismatch. Expected: " + expectedTitleRLC + " but found: " + actualTitleRLC);
            test.fail("Failure Screenshot",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }

    }
    @SneakyThrows
    public  static void verify_register_button(){
        String expectedTitleRLP = "RECHARGE";
        String actualTitleRLP = driver.findElement(By.xpath(sign_Up_Title)).getText();
        Assert.assertEquals(actualTitleRLP,expectedTitleRLP);
        String screenshotPath = captureScreenshot(driver);
        if (expectedTitleRLP.equals(actualTitleRLP)) {
            test.log(Status.PASS, "User is presented with  the landing page which includes the Register");
            test.pass("Actual Result", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        } else {
            test.log(Status.FAIL,"Register Button Not Displayed");
            test.fail("Failure Screenshot",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
    }
    @SneakyThrows
    public  static void verify_login_button(){
        String expectedTitleLP = "REGISTER";
        String actualTitleLP = driver.findElement(By.xpath(reacharge_Title)).getText();
        Assert.assertEquals(actualTitleLP,expectedTitleLP);
        String screenshotPath = captureScreenshot(driver);
        if (expectedTitleLP.equals(actualTitleLP)) {
            test.log(Status.PASS, "User is presented with  the landing page which includes the Login");
            test.pass("Actual Result", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        } else if (false){
            test.fail("Failure Screenshot",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
    }
}

