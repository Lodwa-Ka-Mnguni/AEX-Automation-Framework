package Tests;

import PrimeOnePortalPages.LandingPortalPage;
import PrimeOnePortalPages.LogInPortalPage;
import PrimeOnePortalPages.UiNavigationPortalpage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
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

public class PrimeOnePortalTest {
    public static WebDriver driver;
    public static ExtentReports extent = new ExtentReports();
    public static ExtentTest test;

    @BeforeSuite
    public static void Setup() throws IOException, InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://preprod.primeone.dev.aex.systems/");

        ExtentSparkReporter spark = new ExtentSparkReporter("target/PrimeOnePortal.html");
        spark.loadXMLConfig(new File("extent-config.xml"));
        extent.attachReporter(spark);




        driver.manage().window().maximize();
        test = extent.createTest("General System Health", "User is presented with  the landing page");
        PrimeOnePortalPages.LandingPortalPage.verify_homeOP_page();


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
    void Portal_Login() throws InterruptedException, IOException {
        test = extent.createTest("Portal:Application Access");

        test.info("Verify login page.");
        LandingPortalPage.click_login_button();
        PrimeOnePortalPages.LogInPortalPage.verify_login_page();

        test.info("Valid credentials were entered, and the user is now presented with the Dashboard page.");
        PrimeOnePortalPages.LogInPortalPage.enter_email();
        PrimeOnePortalPages.LogInPortalPage.enter_password();
        LogInPortalPage.click_login();

        test.info("Password Reset to check that mails are being sent and delivered");
    }

    @Test(priority = 2)
    void UI_Feature_Review() throws IOException, InterruptedException {
        test = extent.createTest("UI & Feature Review");

        test.info("Confirm all front-end changes from the release are present and functional");
        PrimeOnePortalPages.UiNavigationPortalpage.click_admin_tab_button();
        PrimeOnePortalPages.UiNavigationPortalpage.click_address_management_option();
        PrimeOnePortalPages.UiNavigationPortalpage.click_home_img();

        test.info("Add roles as needed for test scenarios");
    }

    @Test(priority = 3)
    void Navigation_Component_checks() throws IOException, InterruptedException {
        test = extent.createTest(" UI Navigation & Component Checks");

        test.info("All page links and navigation function correctly");
        PrimeOnePortalPages.UiNavigationPortalpage.click_search_users_button();
        PrimeOnePortalPages.UiNavigationPortalpage.click_home_img();
        test.info("Dashboards load for all user roles");
        PrimeOnePortalPages.UiNavigationPortalpage.click_admin_tab_button();
        PrimeOnePortalPages.UiNavigationPortalpage.click_home_img();
        test.info("Service Status widgets/components render as expected");
        PrimeOnePortalPages.UiNavigationPortalpage.click_search_service_button();
        PrimeOnePortalPages.UiNavigationPortalpage.click_home_img();

        PrimeOnePortalPages.UiNavigationPortalpage.click_Service_tab();
        PrimeOnePortalPages.UiNavigationPortalpage.click_Dashboard_option();
        PrimeOnePortalPages.UiNavigationPortalpage.click_summary_accordion_element();
        PrimeOnePortalPages.UiNavigationPortalpage.verify_summary_accordion_element();
        PrimeOnePortalPages.UiNavigationPortalpage.click_hyperfiber_accordion_element();
        PrimeOnePortalPages.UiNavigationPortalpage.verify_hyperfiber_accordion_element();

        PrimeOnePortalPages.UiNavigationPortalpage.click_home_img();

        test.info("Work Order History is visible and complete");
        PrimeOnePortalPages.UiNavigationPortalpage.click_work_orders_button();
        PrimeOnePortalPages.UiNavigationPortalpage.click_home_img();
        test.info("BI Reports load successfully");

    }

    @Test(priority = 4)
    void Create_Multiple_Accounts() throws IOException, InterruptedException {
        test = extent.createTest("Create Multiple Accounts");

        test.info("Click on SERVICES tab");
        PrimeOnePortalPages.UiNavigationPortalpage.click_Service_tab();
        test.info("Select ORDER SERVICES");
        PrimeOnePortalPages.UiNavigationPortalpage.click_ADD_SERVICES();
        test.info("Verify Service Provider screen");
        PrimeOnePortalPages.UiNavigationPortalpage.verify_Service_provider_header();
        test.info("Select Service Provide");
        PrimeOnePortalPages.UiNavigationPortalpage.click_select_service_provider();
        PrimeOnePortalPages.UiNavigationPortalpage.click_option_one();
        test.info("Click Submit Button");
        PrimeOnePortalPages.UiNavigationPortalpage.click_Submit_Button_provoder();
        test.info("Verify Service Provider Form");
        PrimeOnePortalPages.UiNavigationPortalpage.verify_ISP_Header();
        test.info("Enter the following details: Address, First Name, Last Name, Email, Mobile Number, ID Number, Product, Sales Agent, and Promo Code. Then verify the status");
        PrimeOnePortalPages.UiNavigationPortalpage.click_ADD_ROW_Button();
        PrimeOnePortalPages.UiNavigationPortalpage.click_ADD_ROW_Button();

        PrimeOnePortalPages.UiNavigationPortalpage.enter_address_input();
        PrimeOnePortalPages.UiNavigationPortalpage.enter_address_input22();
        PrimeOnePortalPages.UiNavigationPortalpage.enter_address_input3();

        PrimeOnePortalPages.UiNavigationPortalpage.enter_first_name_input();
        PrimeOnePortalPages.UiNavigationPortalpage.enter_first_name_input2();
        PrimeOnePortalPages.UiNavigationPortalpage.enter_first_name_input3();

        PrimeOnePortalPages.UiNavigationPortalpage.enter_last_name_input();
        PrimeOnePortalPages.UiNavigationPortalpage.enter_last_name_input2();
        PrimeOnePortalPages.UiNavigationPortalpage.enter_last_name_input3();

        PrimeOnePortalPages.UiNavigationPortalpage.enter_Email_input();
        PrimeOnePortalPages.UiNavigationPortalpage.enter_Email_input2();
        PrimeOnePortalPages.UiNavigationPortalpage.enter_Email_input3();

        PrimeOnePortalPages.UiNavigationPortalpage.enter_mobile_number();
        PrimeOnePortalPages.UiNavigationPortalpage.enter_mobile_number2();
        PrimeOnePortalPages.UiNavigationPortalpage.enter_mobile_number3();

        PrimeOnePortalPages.UiNavigationPortalpage.click_Product_Input();
        PrimeOnePortalPages.UiNavigationPortalpage.click_product_option_one();
        PrimeOnePortalPages.UiNavigationPortalpage.click_Product_Input2();
        PrimeOnePortalPages.UiNavigationPortalpage.click_product_option_two();
        PrimeOnePortalPages.UiNavigationPortalpage.click_Product_Input3();
        PrimeOnePortalPages.UiNavigationPortalpage.click_prodct_option_three();

        PrimeOnePortalPages.UiNavigationPortalpage.verify_ISP_Header();

    }
    @Test(priority = 5)
    void Promo_And_Discount() throws IOException, InterruptedException {
        test = extent.createTest("Promo and Discount");
        PrimeOnePortalPages.UiNavigationPortalpage.click_admin_tab_button();
        PrimeOnePortalPages.UiNavigationPortalpage.click_promo_and_discount();
        test.info("Verify Layout of Promotion Overview page");
        UiNavigationPortalpage.verify_promotions_header();

    }

    @AfterSuite
    public static void cleanup() {
        extent.flush();
        if (driver != null) {
            driver.quit();
        }
    }


}
