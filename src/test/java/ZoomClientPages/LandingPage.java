package ZoomClientPages;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.io.IOException;

import static Tests.ZoomClientTest.driver;
import static Tests.ZoomClientTest.*;

public class LandingPage {
    // Locators
    public static String home_log ="/html/body/app-root/div/app-header/div/nav/div[1]/div[1]";
    public static String login_button = "/html/body/app-root/div/div[1]/app-landing/div/div/div/div[3]/app-landing-card/div/div[3]/div/button";
    public static String view_products_button = "/html/body/app-root/div/div[1]/app-landing/div/div/div/div[1]/app-landing-card/div/div[3]/div/button";
    public static String register_button = "/html/body/app-root/div/div[1]/app-landing/div/div/div/div[2]/app-landing-card/div/div[3]/div/button";
    public static  String coverage_Title ="/html/body/app-root/div/div[1]/app-landing/div/div/div/div[1]/app-landing-card/div/div[1]/div/h2";
    public  static  String sign_Up_Title ="/html/body/app-root/div/div[1]/app-landing/div/div/div/div[2]/app-landing-card/div/div[3]/div";
    public static String reacharge_Title ="/html/body/app-root/div/div[1]/app-landing/div/div/div/div[2]/app-landing-card/div/div[3]/div";

    // Actions
    public static void click_home_button() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(home_log)).click();
    }
    public static void click_view_products_button() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(view_products_button)).click();
    }

    public static void click_register_button() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(register_button)).click();
    }

    public static void click_login_button() throws IOException, InterruptedException {
     Thread.sleep(2000);
     driver.findElement(By.xpath(login_button)).click();
    }
    @SneakyThrows
    public  static void verify_product_button(){
        String expectedTitleRLC = "COVERAGE & PRODUCTS";
        String actualTitleRLC = driver.findElement(By.xpath(coverage_Title)).getText();
        Assert.assertEquals(actualTitleRLC,expectedTitleRLC);
        if (expectedTitleRLC.equals(actualTitleRLC)) {
            test.log(Status.PASS, "User is presented with the landing page which includes the View Product Button");
            test.pass("Actual Result",
                    MediaEntityBuilder.createScreenCaptureFromPath(capture(driver)).build());
        } else {
            test.log(Status.FAIL, "Landing page title mismatch. Expected: " + expectedTitleRLC + " but found: " + actualTitleRLC);
            test.fail("Failure Screenshot",
                    MediaEntityBuilder.createScreenCaptureFromPath(capture(driver)).build());
        }

    }
    @SneakyThrows
    public  static void verify_register_button(){
        String expectedTitleRLP = "SIGN UP";
        String actualTitleRLP = driver.findElement(By.xpath(sign_Up_Title)).getText();
        Assert.assertEquals(actualTitleRLP,expectedTitleRLP);
        if (expectedTitleRLP.equals(actualTitleRLP)) {
            test.log(Status.PASS, "User is presented with  the landing page which includes the Register");
            test.pass("Actual Result", MediaEntityBuilder.createScreenCaptureFromPath(capture(driver)).build());
        } else {
            test.log(Status.FAIL,"Register Button Not Displayed");
        }
    }
    @SneakyThrows
    public  static void verify_login_button(){
        String expectedTitleLP = "RECHARGE";
        String actualTitleLP = driver.findElement(By.xpath(reacharge_Title)).getText();
        Assert.assertEquals(actualTitleLP,expectedTitleLP);
        if (expectedTitleLP.equals(actualTitleLP)) {
            test.log(Status.PASS, "User is presented with  the landing page which includes the Login");
            test.pass("Actual Result", MediaEntityBuilder.createScreenCaptureFromPath(capture(driver)).build());
        } else if (false){
            test.fail(MediaEntityBuilder.createScreenCaptureFromBase64String("Failed Screenshot").build());
        }
    }
}

