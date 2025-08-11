package Tests;

import EvotelPortalPages.LandingPortalPage;
import EvotelPortalPages.LogInPortalPage;
import EvotelPortalPages.UiNavigationPortalpage;
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

public class EvotelPortalTest {
    public static WebDriver driver;
    public static ExtentReports extent = new ExtentReports();
    public static ExtentTest test;

    @BeforeSuite
    public static void Setup() throws IOException, InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://preprod.evotel.dev.aex.systems/");

        ExtentSparkReporter spark = new ExtentSparkReporter("target/EvotelPortal.html");
        spark.loadXMLConfig(new File("extent-config.xml"));
        extent.attachReporter(spark);




        driver.manage().window().maximize();
        test = extent.createTest("General System Health", "User is presented with  the landing page");
        LandingPortalPage.verify_home_page();


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
        LogInPortalPage.verify_login_page();

        test.info("Valid credentials were entered, and the user is now presented with the Dashboard page.");
        LogInPortalPage.enter_email();
        LogInPortalPage.enter_password();
        LogInPortalPage.click_login();

        test.info("Password Reset to check that mails are being sent and delivered");
    }

    @Test(priority = 2)
    void UI_Feature_Review() throws IOException, InterruptedException {
        test = extent.createTest("UI & Feature Review");

        test.info("Confirm all front-end changes from the release are present and functional");
        UiNavigationPortalpage.click_admin_tab_button();
        UiNavigationPortalpage.click_address_management_option();
        UiNavigationPortalpage.click_home_img();
        UiNavigationPortalpage.click_manage_account();
        UiNavigationPortalpage.verify_Manage_Account();

        test.info("Add roles as needed for test scenarios");
    }

    @Test(priority = 3)
    void Navigation_Component_checks() throws IOException, InterruptedException {
        test = extent.createTest(" UI Navigation & Component Checks");

        test.info("All page links and navigation function correctly");
        UiNavigationPortalpage.click_search_users_button();
        UiNavigationPortalpage.click_home_img();
        test.info("Dashboards load for all user roles");
        UiNavigationPortalpage.click_admin_tab_button();
        UiNavigationPortalpage.click_home_img();
        UiNavigationPortalpage.click_manage_account();
        UiNavigationPortalpage.verify_Manage_Account();
        test.info("Service Status widgets/components render as expected");
        UiNavigationPortalpage.click_search_service_button();
        UiNavigationPortalpage.click_home_img();
        UiNavigationPortalpage.click_manage_account();

        UiNavigationPortalpage.click_Service_tab();
        UiNavigationPortalpage.click_Dashboard_option();
        UiNavigationPortalpage.click_summary_accordion_element();
        UiNavigationPortalpage.verify_summary_accordion_element();
        UiNavigationPortalpage.click_hyperfiber_accordion_element();
        UiNavigationPortalpage.verify_hyperfiber_accordion_element();

        UiNavigationPortalpage.click_home_img();
        UiNavigationPortalpage.click_manage_account();
        UiNavigationPortalpage.verify_Manage_Account();

        test.info("Work Order History is visible and complete");
        UiNavigationPortalpage.click_work_orders_button();
        UiNavigationPortalpage.click_home_img();
        UiNavigationPortalpage.click_manage_account();
        UiNavigationPortalpage.verify_Manage_Account();
        test.info("BI Reports load successfully");

    }

    @Test(priority = 4)
    void Create_Multiple_Accounts() throws IOException, InterruptedException {
        test = extent.createTest("Create Multiple Accounts");

        test.info("Click on SERVICES tab");
        UiNavigationPortalpage.click_Service_tab();
        test.info("Select ORDER SERVICES");
        UiNavigationPortalpage.click_ADD_SERVICES();
        test.info("Verify Service Provider screen");
        UiNavigationPortalpage.verify_Service_provider_header();
        test.info("Select Service Provide");
        UiNavigationPortalpage.click_select_service_provider();
        UiNavigationPortalpage.click_option_one();
        test.info("Click Submit Button");
        UiNavigationPortalpage.click_Submit_Button_provoder();
        test.info("Verify Service Provider Form");
        UiNavigationPortalpage.verify_ISP_Header();
        test.info("Enter the following details: Address, First Name, Last Name, Email, Mobile Number, ID Number, Product, Sales Agent, and Promo Code. Then verify the status");
        UiNavigationPortalpage.click_ADD_ROW_Button();
        UiNavigationPortalpage.click_ADD_ROW_Button();

        UiNavigationPortalpage.enter_address_input();
        UiNavigationPortalpage.enter_address_input22();
        UiNavigationPortalpage.enter_address_input3();

        UiNavigationPortalpage.enter_first_name_input();
        UiNavigationPortalpage.enter_first_name_input2();
        UiNavigationPortalpage.enter_first_name_input3();

        UiNavigationPortalpage.enter_last_name_input();
        UiNavigationPortalpage.enter_last_name_input2();
        UiNavigationPortalpage.enter_last_name_input3();

        UiNavigationPortalpage.enter_Email_input();
        UiNavigationPortalpage.enter_Email_input2();
        UiNavigationPortalpage.enter_Email_input3();

        UiNavigationPortalpage.enter_mobile_number();
        UiNavigationPortalpage.enter_mobile_number2();
        UiNavigationPortalpage.enter_mobile_number3();

//        UiNavigationPortalpage.enter_Alternative_Number();
//        UiNavigationPortalpage.enter_Alternative_Number2();
//        UiNavigationPortalpage.enter_Alternative_Number3();

//        UiNavigationPortalpage.click_Preferred_Contact_Method_input();
//        UiNavigationPortalpage.click_Preferred_Contact_Method_option();
//        UiNavigationPortalpage.click_Preferred_Contact_Method_input2();
//        UiNavigationPortalpage.click_Preferred_Contact_Method_option2();
//        UiNavigationPortalpage.click_Preferred_Contact_Method_input3();
//        UiNavigationPortalpage.click_Preferred_Contact_Method_option3();

//        UiNavigationPortalpage.click_Preferred_Contact_Time_input();
//        UiNavigationPortalpage.click_Preferred_Contact_Time_option();
//        UiNavigationPortalpage.click_Preferred_Contact_Time_input2();
//        UiNavigationPortalpage.click_Preferred_Contact_Time_option2();
//        UiNavigationPortalpage.click_Preferred_Contact_Time_input3();
//        UiNavigationPortalpage.click_Preferred_Contact_Time_option3();


//        UiNavigationPortalpage.enter_Id_Number();
//        UiNavigationPortalpage.enter_Id_Number2();
//        UiNavigationPortalpage.enter_Id_Number3();

        UiNavigationPortalpage.click_Product_Input();
        UiNavigationPortalpage.click_product_option_one();
        UiNavigationPortalpage.click_Product_Input2();
        UiNavigationPortalpage.click_product_option_two();
        UiNavigationPortalpage.click_Product_Input3();
        UiNavigationPortalpage.click_prodct_option_three();

        UiNavigationPortalpage.verify_ISP_Header();

    }
//    @Test(priority = 5)
//    void Promo_And_Discount() throws IOException, InterruptedException {
//        test = extent.createTest("Promo and Discount");
//        UiNavigationPortalpage.click_admin_tab_button();
//        UiNavigationPortalpage.click_promo_and_discount();
//        test.info("Verify Layout of Promotion Overview page");
//        UiNavigationPortalpage.verify_promotions_header();
//
//    }

    @AfterSuite
    public static void cleanup() {
        extent.flush();
        if (driver != null) {
            driver.quit();
        }
    }
}
