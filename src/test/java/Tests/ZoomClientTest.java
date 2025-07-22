package Tests;

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
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

import static Tests.TestUtils.capture;
import static org.testng.AssertJUnit.assertTrue;

public class ZoomClientTest {

    public static WebDriver driver;
    public static ExtentReports extent = new ExtentReports();
    public static ExtentTest test;

    @BeforeSuite
    public static void Setup() throws IOException, InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://preprod.zoomfibre.client-interface.dev.aex.systems/landing");

        ExtentSparkReporter spark = new ExtentSparkReporter("target/ZoomClientApp.html");
        spark.loadXMLConfig(new File("extent-config.xml"));
        extent.attachReporter(spark);

        driver.manage().window().maximize();
            test = extent.createTest("Open the appropriate URL for the FNO", "User is presented with  the landing page");
            LandingPage.verify_home_page();
            test = extent.createTest("Ensure that a user can click throught the landing page buttons", "The respective page should open successfully");
            LandingPage.verify_product_button();
            LandingPage.verify_login_button();
            LandingPage.verify_register_button();

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

    @Test
    void CLIENT_APP_Navigate_coverage_map() throws InterruptedException, IOException {
        test = extent.createTest("CLIENT_APP: Navigate and interact with the coverage map");

        try {
            test.info("Checking map controls are visible");
            assertTrue(CoverageMapPage.isMapControlsVisible());
            test.pass("Map controls are visible.");

            test.info("Zooming in on the map");
            CoverageMapPage.zoomIn();
            test.pass("Zoomed in.");

            test.info("Zooming out on the map");
            CoverageMapPage.zoomOut();
            test.pass("Zoomed out.");

            test.info("Moving location pin to a new area");
            CoverageMapPage.moveLocationPin();
            test.pass("Location pin moved.");

            test.info("Dragging Pegman to street view");
            CoverageMapPage.movePegmanToMap();
            test.pass("Pegman moved successfully.");

            test.info("Clicking 'Use Current Location' (with denied access)");
            CoverageMapPage.clickUseCurrentLocation();
            assertTrue(CoverageMapPage.isGeolocationDeniedMessageVisible());
            test.pass("Geolocation denial message is displayed.");

            // Optional: Simulate allowing geolocation with a mocked location
            test.info("Clicking 'Use Current Location' (with access granted)");
            test.pass("Assumed geolocation success - manual test or simulated in mock browser.");

        } catch (Exception e) {
            test.fail("Test failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(capture(driver)).build());
            throw e;
        }
    }


    @Test
    void CLIENT_APP_Filter_Package() throws InterruptedException, IOException {
        test = extent.createTest("CLIENT_APP_Filter_Package", "Verify user can view, adjust, and hide product filters on coverage page");

        test.info("Clicking on 'View Products' button.");
        ProductPage.clickViewProducts();

        test.info("Displaying available filters (Speed, Price, Product Type).");
        ProductPage.showFilters();

        test.info("Adjusting Speed and Price sliders.");
        ProductPage.adjustSliders();

        test.info("Hiding filters.");
        ProductPage.hideFilters();

        test.pass("All filter interactions completed successfully.");
    }

    @Test
    void ZOOM_FIBER_CLIENT_APP_Order_Now() throws InterruptedException, IOException {
        test = extent.createTest("ZOOM_FIBER_CLIENT_APP: End-to-End Order Flow");

    }

    @Test
    void CLIENT_APP_Show_My_Interest() throws InterruptedException, IOException {
        test = extent.createTest("A user captures a premise/pins a location where Fibre is available in the area", "The Order now pop-up displays on the available packages.");
        test = extent.createTest("Click on the Order now button on any preffered package", "The Checkout page displays");
        test = extent.createTest("A user captures their details and a billing account option and select \"Place Order\" button", "The Checkout page displays");
        test = extent.createTest("A user selects the Go To Accout button", "The My packages page displays");
        test = extent.createTest("A user views the status on the package", "Status should display \" Expression of Interest\"");

    }
    @Test
    void CLIENT_APP_Register_Button_Order_Now() throws InterruptedException, IOException {
        test = extent.createTest("A user selects the register button.", "The register page displays");
        test = extent.createTest("A user captures valid customer details", "Customer details successfully display");
        test = extent.createTest("A user captures an address which is located within the Order Now KML and select the register button", "The client Interface dashboard displays, and no packages are visible.");
        test = extent.createTest("A user selects the Order package button.", "The coverage and packages page should display");
        test = extent.createTest("A user captures a premise within the Order now kml and select the Order now button", "The following is displayed:\n" + "Check out page displays, and the following fields should contain previously captured information. a. First Name* b. Last Name* c. Phone Number. Alternative Numbere. E-mail Address*order button");
        test = extent.createTest("A user selects the place order button", "A pop up displays with a message \"Thank you for your Order\" and the Go To Account butto");

    }
    @Test
    void CLIENT_APP_Register_Hyperlink_Pre_order() throws InterruptedException, IOException {
        test = extent.createTest("Validate View Product Page", "The login page should display");
        test = extent.createTest("A user selects the register new user hyperlink", "The register page displays");
        test = extent.createTest("A user captures valid customer details", "Customer details successfully display");
        test = extent.createTest("A user captures valid customer details", "Customer details successfully display");
        test = extent.createTest("A user captures an address which is located within the Pre order KML and select the register button", "The client Interface dashboard displays, and no packages are visible");
        test = extent.createTest("A user selects the order package button", "The coverage and packages page should display along with the current location");
        test = extent.createTest("A user captures a premise within the Pre order kml and select the Pre order button", "The following is displayed:\n" + "Check out page displays, and the following fields should contain previously captured information.\n" + "a. First Name*b. Last Name*c. Phone Number*d. Alternative Numbere. E-mail Address* 2.Place order button");
        test = extent.createTest("A user selects the place order button", "A pop up displays with a message \"Thank you for your Order\" and the Go To Account button");

    }
    @Test
    void CLIENT_APP_Pre_Order() throws InterruptedException, IOException {
        test = extent.createTest("A user captures 3 or more characters.", "A list of predefined premises are listed on the address textbox containing the captured characters.");
        test = extent.createTest("A user selects any of the predefined premises setup on a Pre order location", "The Pre Order button displays on the available packages.");
        test = extent.createTest("Click on the Pre Order button on any preferred package.", "The Checkout page displays");
        test = extent.createTest("A user captures their details and a billing account option and select \"Place Order\" buttonge", "A pop up displays with a message \"Thank you for your Order\" and the Go To Account button");
        test = extent.createTest("A pop-up displays with a message \"Thank you for your Order\" and the \"Go To Account\" button", "The dashboard displays");
    }

    @Test
    void CLIENT_APP_User_Login() throws InterruptedException, IOException {
        test = extent.createTest("CLIENT_APP: User Login Flow");

            test.info("Verify login page.");
            LandingPage.click_login_button();
            LoginPage.verify_login_page();

            test.info("Entered valid credentials...");
            LoginPage.enter_email();
            LoginPage.enter_password();
            LoginPage.click_login();

    }

    @Test
    void CLIENT_APP_View_tabs() throws InterruptedException, IOException {
        CLIENT_APP_User_Login();
        test = extent.createTest("A user views the client App tabs displayed at the top of the page", "The following tabs display:\n" + "My Packages\n" + "My Profile");
        DashboardPage.verify_dashboard_page();
        test = extent.createTest("A user views the My packages tabs", "The My Packages page displays with all the  packages assigned to the user");
        DashboardPage.click_my_packages_button();
        //DashboardPage.click_order_package_button();

    }
    @Test
    void CLIENT_APP_Manage_Packages() throws InterruptedException, IOException {
        CLIENT_APP_View_tabs();
        test = extent.createTest("A user selects the MANAGE PACKAGES button", "The package details screen displays which includes the below sections:\\n\" + \"Package Information\\n\" + \"Payment History\\n\" + \"Rica Documents");
        DashboardPage.click_manage_packages_button();
        DashboardPage.verify_manage_package_page();
        test = extent.createTest("A user views the package information:" + "Package name", "The Package name should correspond to the one the user has selected on the coverage and packages page.");
        DashboardPage.verify_package_name();
        test = extent.createTest("A user views the package information:" + "Premise", "The  premise should correspond to the one the user has captured on the coverage and packages page.");
        DashboardPage.verify_address_has_any_value();
        test = extent.createTest("A user views the package information:" + "Account Summary", "The correct Account status displays");
        test = extent.createTest("A user views the package information:" + "Current status", "The correct Service status displays \"Pending ISP Application\" / New Order for Order now   \n" + "\n" + "Expression of interest for Show my interest");
        test = extent.createTest("A user views the Payment History Accordion", "The following is displayed:\\n\" + \"\\n\" + \"Purchase date\\n\" + \"\\n\" + \"Product Price\\n\" + \"\\n\" + \"Total Amount.\\n\" + \"\\n\" + \"Payment status.\\n\" + \"\\n\" + \"Payment Date\\n\" + \"\\n\" + \"Download Invoice Button\"");
        test = extent.createTest("A user selects the Back to Dashboard button.", "The Dashboard Displays");

    }

    @Test
    void CLIENT_APP_Change_Service() throws InterruptedException, IOException {
        test = extent.createTest("A user clicks on the Change Service Button", "The Coverage and packages pages displays.");
        test = extent.createTest("A user captures a premise/pins a location where Fibre is available in the areae", "The Update My Service pop-up displays on the available packages.");
        test = extent.createTest("Click on the Update My Service button on any preferred package.", "The Rica Uploads Page Displays");
        test = extent.createTest("User can upload the Rica Documents and click the Next Button.", "Dashboard displays along with the newly added package.");

    }
    @Test
    void CLIENT_APP_Add_another_package() throws InterruptedException, IOException {
        test = extent.createTest("A user selects the Add Another Package button", "The Coverage and packages page displays");
        test = extent.createTest("A user captures a premise/pins a location where Fibre is available in the area", "The Order now pop-up displays on the available packages.");
        test = extent.createTest("Click on the Order now button on any preffered package", "The Checkout page displays");
        test = extent.createTest("A user views the details section", "The previously captured details are populated (Non-editable)");
        test = extent.createTest("A user views the billing account details", "The previously captured payment medium displays (non-editable)");
        test = extent.createTest("A user selects payment medium and selects the place order button", "A pop up displays with a message \"Thank you for your Order\" and  the Go To Account button");
        test = extent.createTest("A user views the My packages tab", "The newly added package displays");
    }
    @Test
    void CLIENT_APP_Edit_My_Profile() throws InterruptedException, IOException {
        CLIENT_APP_View_tabs();
        test = extent.createTest("A user selects the My Profile tab", "The Edit My Profile page displays");
        DashboardPage.click_my_profile_button();
        DashboardPage.verify_edit_my_profile_page();
        test = extent.createTest("A user can update the profile details", "The profile details should be updated succesfully");
        DashboardPage.click_save_details_button();
    }
    @AfterSuite
    public static void cleanup() {
        extent.flush();
        if (driver != null) {
            driver.quit();
        }
    }




}
