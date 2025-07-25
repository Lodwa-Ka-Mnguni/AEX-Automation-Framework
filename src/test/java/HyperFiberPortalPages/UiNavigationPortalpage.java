package HyperFiberPortalPages;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.io.IOException;

import static Tests.OpenFiberPortalChecklist.*;
import static Tests.OpenFiberPortalChecklist.test;

public class UiNavigationPortalpage {

    //Locators
    static String main_manu ="/html/body/div[3]/header/div/div/div[2]/ul";
    static String search_services_button ="//*[@id=\"btnServiceSearch\"]";
    static String search_work_orders_button ="//*[@id=\"btnWorkOrderSearch\"]";
    static String search_users_button ="//*[@id=\"btnUserSearch\"]";
    static String serial_number_search_input ="//*[@id=\"SearchString\"]";
    static String search_serial_button ="//*[@id=\"btnSearch\"]";
    static String reports_tab ="/html/body/div[3]/header/div/div/div[2]/ul/li[9]/a";
    static String reports_overview_option ="//a[normalize-space()='Overview']";
    static String admin_tabs = "/html/body/div[3]/header/div/div/div[2]/ul/li[6]/a";
    static String address_management_op = "/html/body/div[3]/header/div/div/div[2]/ul/li[6]/ul/li[8]/a";
    static String Service_tab = "/html/body/div[3]/header/div/div/div[2]/ul/li[4]/a";
    static String Dashboard_option = "/html/body/div[3]/header/div/div/div[2]/ul/li[4]/ul/li[2]/a";
    static String Service_dashdoard_header = "/html/body/div[4]/div/div/div/header/h1";
    static String summary_accordion_element = "//*[@id=\"ui-id-1\"]";
    static String metacom_accordion_element = "//*[@id=\"ui-id-3\"]";
    static String reflexISP_accordion_element ="//*[@id=\"ui-id-5\"]";



    public static void click_search_service_button() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(search_services_button)).click();
        Thread.sleep(2000);
        String screenshotPath = captureScreenshot(driver);
        test.pass("Actual Result",
                MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
    }

    public static void click_work_orders_button() throws IOException, InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath(search_work_orders_button)).click();
        Thread.sleep(2000);
        String screenshotPath = captureScreenshot(driver);
        test.pass("Actual Result",
                MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
    }

    public static void click_search_users_button() throws IOException, InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath(search_users_button)).click();
        Thread.sleep(2000);
        String screenshotPath = captureScreenshot(driver);
        test.pass("Actual Result",
                MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
    }

    public static void click_admin_tab_button() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(admin_tabs)).click();
        Thread.sleep(2000);
        String screenshotPath = captureScreenshot(driver);
        test.pass("Actual Result",
                MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
    }

    public static void click_address_management_option() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(address_management_op)).click();
        Thread.sleep(2000);
        String screenshotPath = captureScreenshot(driver);
        test.pass("Actual Result",
                MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
    }

    public static void click_reports_tab_button() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(reports_tab)).click();
        Thread.sleep(2000);
        String screenshotPath = captureScreenshot(driver);
        test.pass("Actual Result",
                MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
    }

    public static void click_reports_overview_option_button() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(reports_overview_option)).click();
        Thread.sleep(2000);
        String screenshotPath = captureScreenshot(driver);
        test.pass("Actual Result",
                MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
    }

    public static void verify_summary_accordion_element() throws IOException, InterruptedException {
        Thread.sleep(2000);
        String expectedTitleMAP = "Summary";
        String actualTitleMAP = driver.findElement(By.xpath(summary_accordion_element)).getText();
        Assert.assertEquals(actualTitleMAP, expectedTitleMAP);
        String screenshotPath = captureScreenshot(driver);
        if (expectedTitleMAP.equals(actualTitleMAP)) {
            test.log(Status.PASS, "Verify the summary accordion element and the count bubbles.");
            test.pass("Actual Result",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        } else {
            test.log(Status.FAIL, "Landing page title mismatch. Expected: " + expectedTitleMAP + " but found: " + actualTitleMAP);
            test.fail("Failure Screenshot",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
    }
    public static void verify_metacom_accordion_element() throws IOException, InterruptedException {
        Thread.sleep(2000);
        String expectedTitleMAP = "Metacom";
        String actualTitleMAP = driver.findElement(By.xpath(metacom_accordion_element)).getText();
        Assert.assertEquals(actualTitleMAP, expectedTitleMAP);
        String screenshotPath = captureScreenshot(driver);
        if (expectedTitleMAP.equals(actualTitleMAP)) {
            test.log(Status.PASS, "Verify the metacom accordion element and the count bubbles.");
            test.pass("Actual Result",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        } else {
            test.log(Status.FAIL, "Landing page title mismatch. Expected: " + expectedTitleMAP + " but found: " + actualTitleMAP);
            test.fail("Failure Screenshot",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
    }

    public static void verify_reflexISP_accordion_element() throws IOException, InterruptedException {
        Thread.sleep(2000);
        String expectedTitleMAP = "Service Dashboard";
        String actualTitleMAP = driver.findElement(By.xpath(Service_dashdoard_header)).getText();
        Assert.assertEquals(actualTitleMAP, expectedTitleMAP);
        String screenshotPath = captureScreenshot(driver);
        if (expectedTitleMAP.equals(actualTitleMAP)) {
            test.log(Status.PASS, "Verify the reflex ISP accordion element and the count bubbles.");
            test.pass("Actual Result",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        } else {
            test.log(Status.FAIL, "Landing page title mismatch. Expected: " + expectedTitleMAP + " but found: " + actualTitleMAP);
            test.fail("Failure Screenshot",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
    }
    public static void click_Service_tab() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(Service_tab)).click();
        Thread.sleep(2000);
        String screenshotPath = captureScreenshot(driver);
        test.pass("Actual Result",
                MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
    }

    public static void click_Dashboard_option() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(Dashboard_option)).click();
        Thread.sleep(2000);
        String screenshotPath = captureScreenshot(driver);
        test.pass("Actual Result",
                MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
    }

    public static void click_metacom_accordion_element() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(metacom_accordion_element)).click();
    }
    public static void click_summary_accordion_element() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(summary_accordion_element)).click();
    }
    public static void click_reflexISP_accordion_element() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(reflexISP_accordion_element)).click();
    }
}
