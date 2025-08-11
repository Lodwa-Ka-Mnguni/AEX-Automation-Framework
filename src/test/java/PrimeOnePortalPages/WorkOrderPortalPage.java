package PrimeOnePortalPages;

import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.By;

import java.io.IOException;

import static Tests.PrimeOnePortalTest.*;

public class WorkOrderPortalPage {

    static String work_oder_ref ="//*[@id=\"pr_id_1-table\"]/tbody/tr[2]/td[1]/div/div/div/a";
    static String new_status ="//*[@id=\"StatusId\"]";
    static String view_service ="//*[@id=\"divBackEndPage\"]/div[3]/div[2]/dl/dd[9]/button";

    public static void click_work_oder_ref() throws IOException, InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath(work_oder_ref)).click();
        Thread.sleep(2000);
        String screenshotPath = captureScreenshot(driver);
        test.pass("Actual Result",
                MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
    }

    public static void click_new_status() throws IOException, InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath(new_status)).click();
        Thread.sleep(2000);
        String screenshotPath = captureScreenshot(driver);
        test.pass("Actual Result",
                MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
    }

    public static void click_view_service() throws IOException, InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath(view_service)).click();
        Thread.sleep(2000);
        String screenshotPath = captureScreenshot(driver);
        test.pass("Actual Result",
                MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
    }
}
