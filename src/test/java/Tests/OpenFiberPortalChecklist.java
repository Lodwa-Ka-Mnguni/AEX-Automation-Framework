package Tests;

import HyperFiberPortalPages.*;
import ZoomClientPages.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static Tests.TestUtils.capture;
import static org.testng.AssertJUnit.assertTrue;

public class OpenFiberPortalChecklist {
        public static WebDriver driver;
        public static ExtentReports extent = new ExtentReports();
        public static ExtentTest test;

        @BeforeSuite
        public static void Setup() throws IOException, InterruptedException {
            driver = new ChromeDriver();
            driver.get("https://preprod.openfibre.dev.aex.systems/");

            ExtentSparkReporter spark = new ExtentSparkReporter("target/OpenFiberPortal.html");
            spark.loadXMLConfig(new File("extent-config.xml"));
            extent.attachReporter(spark);




            driver.manage().window().maximize();
            test = extent.createTest("General System Health", "User is presented with  the landing page");
            LandingPortalPage.verify_homeOP_page();


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
                String screenshotPath = captureScreenshot(driver);
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
            LandingPortalPage.click_check_coverage_button();
            CoverageMapPortalPage.verify_map_page();
            test.info("Upon entering a live premise address, the user is presented with a list of relevant addresses in the dropdown.");
            CoverageMapPortalPage.click_search_bar();
            CoverageMapPortalPage.enter_address();

            test.info("Verify products appear on maps");
            CoverageMapPortalPage.select_address();

            test.info("Attempt to place an order");
            CoverageMapPortalPage.click_order_now_button();
            CoverageMapPortalPage.click_home_img();
        }

        @Test(priority = 2)
        void Portal_Login() throws InterruptedException, IOException {
            test = extent.createTest("Portal:Application Access");

            test.info("Verify login page.");
            LandingPortalPage.click_login_button();
            LogInPortalPage.verify_login_page();

            test.info("Valid credentials were entered, and the user is now presented with the Dashboard page.");
            LogInPortalPage.enter_email();
            LogInPortalPage.enter_password();
            LogInPortalPage.click_login();

            test.info("Password Reset to check that emails are being sent and delivered");
        }
         @Test(priority = 4)
         void Functional_Testing() throws IOException, InterruptedException {
            test = extent.createTest("Portal:  HF & Ripple Functional Testing");

             test.info("Progress a Work Order");
             UiNavigationPortalpage.click_work_orders_button();
             WorkOrderPortalPage.click_work_oder_ref();
             test.info("Use Reject the Service to simulate cancellation");
             WorkOrderPortalPage.click_new_status();
             test.info("Go to Service Search and use Delete to remove the service");
             WorkOrderPortalPage.click_view_service();
             CoverageMapPortalPage.click_home_img();

         }

         @Test
         void UI_Feature_Review(){
            test = extent.createTest("UI & Feature Review");

             test.info("Confirm all front-end changes from the release are present and functional");
             test.info("Add roles as needed for test scenarios");
         }

         @Test(priority = 3)
         void Navigation_Component_checks() throws IOException, InterruptedException {
            test = extent.createTest(" UI Navigation & Component Checks");

             test.info("All page links and navigation function correctly");
             UiNavigationPortalpage.click_search_users_button();
             CoverageMapPortalPage.click_home_img();
             test.info("Dashboards load for all user roles");
             UiNavigationPortalpage.click_admin_tab_button();
             CoverageMapPortalPage.click_home_img();
             test.info("Service Status widgets/components render as expected");
             UiNavigationPortalpage.click_search_service_button();
             CoverageMapPortalPage.click_home_img();
             test.info("Work Order History is visible and complete");
             UiNavigationPortalpage.click_work_orders_button();
             CoverageMapPortalPage.click_home_img();
             test.info("BI Reports load successfully");

         }

        @AfterSuite
        public static void cleanup() {
            extent.flush();
            if (driver != null) {
                driver.quit();
            }
        }




    }


