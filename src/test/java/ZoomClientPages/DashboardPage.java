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
    public static String my_package_button ="/html/body/app-root/div/div[1]/app-dashboard/div[1]/div[2]/span[1]/button";
    public static String my_profile_button ="//button[contains(normalize-space(), 'My Profile')]";
    public static String verfy_EditMyProfile_page ="//app-profile//h4";
    public static String save_details ="//button[contains(text(), 'Save Details')]";
    public static String Updated_user_details_toast ="/div/div";
    public static String order_package ="//button[contains(text(), 'Order Package')]";
    public static String manage_packages_btn ="//button[contains(text(), 'Manage Packages')]";
    public static String verify_manage_packages_screen ="/html/body/app-root/div/div[1]/app-service-view/div/div/div[1]/button";
    public static String information_package_name ="/html/body/app-root/div/div[1]/app-dashboard/div[1]/div[3]/div/div[3]/app-customer-status/div/div[1]/div[2]/div/span[1]";
    public static String information_premise ="//app-customer-status//div[2]//span[3]";
    public static String information_account_summary ="";
    public static String information_current_status ="";
    public static String payment_history_Accordion ="";
    public static String back_to_dashboard_button ="";

    //Action
    public static void verify_dashboard_page() throws IOException, InterruptedException {
        Thread.sleep(8000);
        String expectedTitleDASH = "COVERAGE & PRODUCTS";
        String actualTitleDASH = driver.findElement(By.xpath(verify_dash)).getText();
        Assert.assertEquals(actualTitleDASH,expectedTitleDASH);
        String screenshotPath = captureScreenshot(driver);
        if (expectedTitleDASH.equals(actualTitleDASH)) {
            test.log(Status.PASS, "The following Links displayed: MY PROFILE, COVERAGE & PRODUCTS, LOGIN REGISTER");
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
        Thread.sleep(4000);
        String screenshotPath = captureScreenshot(driver);
        test.pass("Actual Result",
                MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
    }

    public static void click_manage_packages_button() throws InterruptedException, IOException {
        Thread.sleep(6000);
        driver.findElement(By.xpath(manage_packages_btn)).click();
        String screenshotPath = captureScreenshot(driver);
        test.pass("Actual Result",
                MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
    }

    public static void verify_manage_package_page() throws IOException, InterruptedException {
        Thread.sleep(3000);
        String expectedTitleMPS = "< DASHBOARD";
        String actualTitleMPS = driver.findElement(By.xpath(verify_manage_packages_screen)).getText();
        Assert.assertEquals(actualTitleMPS,expectedTitleMPS);
        String screenshotPath = captureScreenshot(driver);
        if (expectedTitleMPS.equals(actualTitleMPS)) {
            test.log(Status.PASS, "The package details screen displays which includes the below sections: Package Information, Payment History,Wi-Fi Settings, Rica Documents");
            test.pass("Actual Result",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        } else {
            test.log(Status.FAIL, "Landing page title mismatch. Expected: " + expectedTitleMPS + " but found: " + actualTitleMPS);
            test.fail("Failure Screenshot",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
    }
    public static void verify_package_name() throws IOException, InterruptedException {
        Thread.sleep(4000);
        String actualTitlePname = driver.findElement(By.xpath(information_package_name)).getText();
        String screenshotPath = captureScreenshot(driver);
        if (actualTitlePname.contains("Bundle")) {
            test.log(Status.PASS, "Package name is displayed and contains 'Bundle': " + actualTitlePname);
            test.pass("Actual Result",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        } else {
            test.log(Status.FAIL, "Package name does not contain 'Bundle'. Found: " + actualTitlePname);
            test.fail("Failure Screenshot",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        //Optional assertion to fail test execution if needed
        Assert.assertTrue(actualTitlePname.contains("Bundle"), "Package name should contain 'Bundle'");
    }

    public static void verify_address_has_any_value() throws IOException, InterruptedException {
        Thread.sleep(2000);
        String addressValue = driver.findElement(By.xpath(information_premise)).getAttribute("value");
        String screenshotPath = captureScreenshot(driver);
        if (addressValue != null && !addressValue.trim().isEmpty()) {
            test.log(Status.PASS, "Address input has a value: '" + addressValue + "'");
            test.pass("Address Input Screenshot",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        } else {
            test.log(Status.FAIL, "Address input is empty!");
            test.fail("Failure Screenshot",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        // Assert to fail the test if no value is present
        Assert.assertTrue(addressValue != null && !addressValue.trim().isEmpty(), "Address input should have any non-empty string");
    }

}
