package ZoomClientPages;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.io.IOException;

import static Tests.ZoomClientTest.*;

public class DashboardPage {

    //Locators
    public static String verify_dash = "//*[@id=\"sideNav\"]/li[3]";
    public static String my_package_button ="//button[contains(normalize-space(), 'My Packages')]";
    public static String my_profile_button ="//button[contains(normalize-space(), 'My Profile')]";
    public static String verfy_EditMyProfile_page ="//app-profile//h4";
    public static String save_details ="/html/body/app-root/div/div[1]/app-dashboard/div[1]/div[3]/div/app-profile/div/form[1]/div[3]/div[2]/button";
    public static String Updated_user_details_toast ="/div/div";
    public static String order_package ="/html/body/app-root/div/div[1]/app-dashboard/div[1]/div[3]/div/div[4]/div/button";

    //Action
    public static void verify_dashboard_page() throws IOException, InterruptedException {
        Thread.sleep(5000);
        String expectedTitleDASH = "COVERAGE & PRODUCTS";
        String actualTitleDASH = driver.findElement(By.xpath(verify_dash)).getText();
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
    public static void click_my_packages_button() throws InterruptedException, IOException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(my_package_button)).click();
        String screenshotPath = captureScreenshot(driver);
        test.pass("Actual Result",
                MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
    }

    public static void click_order_package_button() throws InterruptedException, IOException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(order_package)).click();
        String screenshotPath = captureScreenshot(driver);
        test.pass("Actual Result",
                MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
    }

    public static void click_my_profile_button() throws InterruptedException, IOException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(my_profile_button)).click();
        String screenshotPath = captureScreenshot(driver);
        test.pass("Actual Result",
                MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

    }
    public static void verify_edit_my_profile_page() throws IOException, InterruptedException {
        Thread.sleep(2000);
        String expectedTitleEMP = "Edit My Profile";
        String actualTitleEMP = driver.findElement(By.xpath(verfy_EditMyProfile_page)).getText();
        Assert.assertEquals(actualTitleEMP,expectedTitleEMP);
        String screenshotPath = captureScreenshot(driver);
        if (expectedTitleEMP.equals(actualTitleEMP)) {
            test.log(Status.PASS, "The following tabs displaye: My Pacakage, My Profile, My Payment History");
            test.pass("Actual Result",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        } else {
            test.log(Status.FAIL, "Landing page title mismatch. Expected: " + expectedTitleEMP + " but found: " + actualTitleEMP);
            test.fail("Failure Screenshot",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
    }
    public static void click_save_details_button() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(save_details)).click();
        String screenshotPath = captureScreenshot(driver);
        test.pass("Actual Result",
                MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
    }
}
