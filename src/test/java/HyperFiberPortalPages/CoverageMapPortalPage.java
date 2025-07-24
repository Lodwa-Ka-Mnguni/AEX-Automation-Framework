package HyperFiberPortalPages;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;

import static Tests.OpenFiberPortalChecklist.*;
import static Tests.OpenFiberPortalChecklist.test;

public class CoverageMapPortalPage {

    static String search_predifind_premises_input = "/html/body/span/span/span[1]/input";
    static String map_header_title = "/html/body/div[4]/div[1]/div[1]/h3";
    static String click_search = "//*[@id=\"select2-pac-input-container\"]/span";
    static String select_address = "//*[@id=\"select2-pac-input-results\"]/li[1]";
    static String order_now_button = "//*[@id=\"map-canvas\"]/div/div[3]/div[1]/div[2]/div/div[4]/div/div/div/div[1]/div[2]/div/div/div/div[3]/button[1]";
    static String home_img = "/html/body/div[3]/header/div/div/div[1]";

    public static void click_search_bar() throws InterruptedException, IOException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(click_search)).click();
    }

    public static void enter_address() throws InterruptedException, IOException {
        Thread.sleep(2000);
        WebElement btn = driver.findElement(By.xpath(search_predifind_premises_input));
        btn.sendKeys("S-Squared, Gateway Theatre of Shopping, Umhlanga Ridge, Durban, KwaZulu-Natal");
        btn.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        String screenshotPath = captureScreenshot(driver);
        test.pass("Actual Result",
                MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
    }
    public static void select_address() throws InterruptedException, IOException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(select_address)).click();
        Thread.sleep(3000);
        String screenshotPath = captureScreenshot(driver);
        test.pass("Actual Result",
                MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
    }

    public static void click_order_now_button() throws InterruptedException, IOException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(order_now_button)).click();
        Thread.sleep(2000);
        String screenshotPath = captureScreenshot(driver);
        test.pass("Actual Result",
                MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
    }

    public static void verify_map_page() throws IOException, InterruptedException {
        Thread.sleep(2000);
        String expectedTitleMAP = "Map Colour Key";
        String actualTitleMAP = driver.findElement(By.xpath(map_header_title)).getText();
        Assert.assertEquals(actualTitleMAP, expectedTitleMAP);
        String screenshotPath = captureScreenshot(driver);
        if (expectedTitleMAP.equals(actualTitleMAP)) {
            test.log(Status.PASS, "User is presented with the Map page");
            test.pass("Actual Result",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        } else {
            test.log(Status.FAIL, "Landing page title mismatch. Expected: " + expectedTitleMAP + " but found: " + actualTitleMAP);
            test.fail("Failure Screenshot",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
    }

    public static void click_home_img() throws InterruptedException, IOException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(home_img)).click();
    }
}
