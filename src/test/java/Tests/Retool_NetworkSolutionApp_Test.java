package Tests;

import NetworkSupportSolutionPages.RetoolLandingPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class Retool_NetworkSolutionApp_Test {
    public static WebDriver driver1;
    public static ExtentReports extent = new ExtentReports();
    public static ExtentTest test;

    @BeforeSuite
    public static void Setup() throws IOException, InterruptedException {
        System.setProperty("webdriver.edge.driver", "src/test/resources/drivers/msedgedriver.exe");

        driver1 = new EdgeDriver();
        driver1.get("https://dev.automationexchange.retool.com/");

        ExtentSparkReporter spark = new ExtentSparkReporter("target/OpenFiberPortal.html");
        spark.loadXMLConfig(new File("extent-config.xml"));
        extent.attachReporter(spark);

        driver1.manage().window().maximize();
        test = extent.createTest("General System Health", "User is presented with  the landing page");
        RetoolLandingPage.verify_home_screen();
    }
    //Screenshots
    public static String captureScreenshot(WebDriver driver) throws IOException {
        // Save to target/screenshots/
        String folderPath = System.getProperty("user.dir") + "/target/screenshots/";
        String fileName = System.currentTimeMillis() + ".png";
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destFile = new File(folderPath + fileName);
        // Create folder if it doesn't exist
        new File(folderPath).mkdirs();
        FileUtils.copyFile(scrFile, destFile);
        // Return relative path for ExtentReports to embed in HTML
        return "screenshots/" + fileName;
    }


    // After each test
    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            String screenshotPath = captureScreenshot(driver1);
            test.fail("Test Failed: " + result.getThrowable());
            test.addScreenCaptureFromPath(screenshotPath);
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.pass("Test passed");
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.skip("Test skipped: " + result.getThrowable());
        }
    }
    @Test(priority = 1)
    void Map_And_Product_Functionality() throws IOException, InterruptedException {
        test = extent.createTest("Portal:Map & Product Functionality");
        test.info("Confirm kMLs load in both the Portal and Client App");

        test.info("Upon entering a live premise address, the user is presented with a list of relevant addresses in the dropdown.");


        test.info("Verify products appear on maps");


        test.info("Attempt to place an order");

    }
}
