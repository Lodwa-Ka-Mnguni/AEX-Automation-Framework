package OpenFiberPortalPages;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;

import static Tests.OpenFiberPortalChecklist.captureScreenshot;
import static Tests.OpenFiberPortalChecklist.driver;
import static Tests.OpenFiberPortalChecklist.test;

public class LandingPortalPage {
    // Locators
    public static String home_Title = "/html/body/div[4]/div/div/div/header/h1";
    public static String shop_front_button = "/html/body/div[4]/div/div/div/div[2]/div[1]/p/a";
    public static String check_coverage_button = "/html/body/div[4]/div/div/div/div[2]/div[2]/p/a";
    public static String coverage_map_title = "/html/body/div[4]/div[1]/div[1]/h3";
    private static final By login_button = By.xpath("/html/body/div[4]/div/div/div/div[3]/div/p[2]/a");

    // Actions
    public static void verify_homeOP_page() throws IOException, InterruptedException {
        Thread.sleep(2000);
        String expectedTitleOF = "Fibre to Business";
        String actualTitleOF = driver.findElement(By.xpath(home_Title)).getText();
        Assert.assertEquals(actualTitleOF,expectedTitleOF);
        String screenshotPath = captureScreenshot(driver);
        if (expectedTitleOF.equals(actualTitleOF)) {
            test.log(Status.PASS, "User is presented with the landing page");
            test.pass("Actual Result",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        } else {
            test.log(Status.FAIL, "Landing page title mismatch. Expected: " + expectedTitleOF + " but found: " + actualTitleOF);
            test.fail("Failure Screenshot",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }

    }

    public static void click_check_coverage_button() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(check_coverage_button)).click();
    }

    public static boolean click_login_button() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(login_button)).click();
            return true;
        } catch (Exception e) {
            System.out.println("Error clicking login button: " + e.getMessage());
            return false;
        }
    }


    @SneakyThrows
    public  static void verify_check_coverage_button(){
        String expectedTitleCOF = "COVERAGE & PRODUCTS";
        String actualTitleCOF = driver.findElement(By.xpath(check_coverage_button)).getText();
        Assert.assertEquals(actualTitleCOF,expectedTitleCOF);
        String screenshotPath = captureScreenshot(driver);
        if (expectedTitleCOF.equals(actualTitleCOF)) {
            test.log(Status.PASS, "User is presented with the landing page which includes the View Product Button");
            test.pass("Actual Result",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        } else {
            test.log(Status.FAIL, "Landing page title mismatch. Expected: " + expectedTitleCOF + " but found: " + actualTitleCOF);
            test.fail("Failure Screenshot",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }

    }

}
