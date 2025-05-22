package Tests;

import ZoomClientPages.LandingPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ZoomClientTest {

    public static WebDriver driver;
    static ExtentReports reports;
    public static ExtentTest test;
    public static ExtentReports extent = new ExtentReports();



    @BeforeSuite
    public static void Setup(){
        driver = new ChromeDriver();
        driver.get("https://stage.zoomfibre.client-interface.dev.aex.systems/landing");
        ExtentSparkReporter spark = new ExtentSparkReporter("target/ZoomClientApp.html");
        extent.attachReporter(spark);
        driver.manage().window().maximize();

    }
    //TakesScreenshots
    public static String capture(WebDriver driver) throws IOException , IOException{
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File Dest = new File("src/../ExecImages/" + System.currentTimeMillis()
        +".png");
        String errlpath = Dest.getCanonicalPath();
        FileUtils.copyFile(scrFile,Dest);
        return errlpath;
    }

    //Tests
    @Test
    void  CLIENT_APP_Open_Client_App() throws IOException, InterruptedException {
        test = extent.createTest("Open the appropriate <URL>  for the FNO", "User is presented with  the landing page");
        LandingPage.click_home_button();
        LandingPage.verify_register_button();
        test = extent.createTest("Ensure that a user can click throught the landing page buttons", "The respective page should open successfully");
        LandingPage.click_home_button();
        LandingPage.verify_product_button();
        LandingPage.click_home_button();
        //LandingPage.verify_login_button();
        LandingPage.click_home_button();

    }
    @Test
    void CLIENT_APP_Navigate_coverage_map() throws InterruptedException, IOException {
        test = extent.createTest("Ensure that the relevant options are displayed on the map", "Options are displayed: Search Text Box, Maximize Map icon, Plus Minimize Map icon Minus, Pegman icon");
        test = extent.createTest("A user can capture alphanumeric charecters", "Alphanumeric character should be accepted");
        test = extent.createTest("A user clicks on the Maximise map icon Plus", "The Map zooms in.");
        test = extent.createTest("A user clicks on the Minimise map icon Minus", "The Map zooms out.");
        test = extent.createTest("Use the CTRL button and scroller on the mouse to zoom in and out on the map", "User is able to zoom in and out on the map");
        test = extent.createTest("Move the location pin to any area on the map", "Location where the pin has been moved to displays the address of that place.");
        test = extent.createTest("Move the pegman to a desired location on the map", "Map displays the picture view of the selected area");
        test = extent.createTest("A user clicks on the Use Current Location button and does not allow site location access.", "A pop up displays \"You have disabled geolocation\"");
        test = extent.createTest("A user clicks on the Use Current Location button and  allows site location access.", "The user's curent locaton is populated on the map");

        test.info("");
        test.pass("");

        test.info("");
        test.pass("");

        test.info("");
        test.pass("");

        test.info("");
        test.pass("");

        test.info("");
        test.pass("");

    }
    @Test
    void CLIENT_APP_Filter_Package() throws InterruptedException, IOException {
        test = extent.createTest("A user selects the View Products button or the Coverage and Packages Tab.", "A User is directed to the Coverage and Package page.");
        test = extent.createTest("AUser  clicks on the Display Filter option", "The following filters are displayed: Speed, Price, Product Type");
        test = extent.createTest("A user clicks on the below filters Speed, Price", "Horizontal sliders display (Min and Max)");
        test = extent.createTest("A user can move the sliders to select the preffered Speed or Price range.", "Only the packages within the selected range displays");
        test = extent.createTest("A user clicks on the below filter Product Type", "A list of Product types displays All, Capped, Uncapped");
        test = extent.createTest("A user can select any of the product type options", "Only the selected product type packages displays");
        test = extent.createTest("User  clicks on the Hide Filter option", "The filters are hidden");

        test.info("");
        test.pass("");

        test.info("");
        test.pass("");

        test.info("");
        test.pass("");

        test.info("");
        test.pass("");

        test.info("");
        test.pass("");

        test.info("");
        test.pass("");
    }
    @Test
    void ZOOM_FIBER_CLIENT_APP_Order_Now() throws InterruptedException, IOException {
        test = extent.createTest("Validate View Product Page", "The Order now pop-up displays on the available packages.");
        test = extent.createTest("Click on the Order now button on any preffered package", "The Checkout page displays");
        test = extent.createTest("A user captures the below details on the checkout page and select the place order button: First name* , Surname*, Phone number*, Alternative number, Alternative number, Alternative number,  Alternative number, Alternative number, Alternative number, Email address*, Billing Account section, Account details section", "The card capture pop-up displays (executed in payment test pack)");
        test = extent.createTest("A user submits a valid card payment medium", "A pop up displays with a message \"Thank you for your Order\" and the Go To Account buttons.");
        test = extent.createTest("A user selects the 'Go to Account button", "The Rica Uploads page displays with the following. By uploading your files you give Net Nine Nine permission to use your personal information.Please note that you can choose to complete this at a later stage, but this has to be completed before Activation of your Fibre Line 2. Proof of address Upload prompt 3. Rica upload type textbox 4. Complete later and Next button");
        test = extent.createTest("A user selects the Rica upload textbox", "TTwo options are displayed: Proof of address Identity document");
        test = extent.createTest("A user uploads both RICA documents and select the Next button", "The Client dashboard displays");
        test = extent.createTest("A user can select the complete later button without being forced to upload rica documents", "A pop up displays with a message \"Thank you for your Order\" and  the Go To Account button");

        test.info("");
        test.pass("");

        test.info("");
        test.pass("");

        test.info("");
        test.pass("");

        test.info("");
        test.pass("");

        test.info("");
        test.pass("");

        test.info("");
        test.pass("");

        test.info("");
        test.pass("");
    }
    @Test
    void CLIENT_APP_Show_My_Interest() throws InterruptedException, IOException {
        test = extent.createTest("A user captures a premise/pins a location where Fibre is available in the area", "The Order now pop-up displays on the available packages.");
        test = extent.createTest("Click on the Order now button on any preffered package", "The Checkout page displays");
        test = extent.createTest("A user captures their details and a billing account option and select \"Place Order\" button", "The Checkout page displays");
        test = extent.createTest("A user selects the Go To Accout button", "The My packages page displays");
        test = extent.createTest("A user views the status on the package", "Status should display \" Expression of Interest\"");

        test.info("");
        test.pass("");

        test.info("");
        test.pass("");

        test.info("");
        test.pass("");

        test.info("");
        test.pass("");
    }@Test
    void CLIENT_APP_Register_Button_Order_Now() throws InterruptedException, IOException {
        test = extent.createTest("A user selects the register button.", "The register page displays");
        test = extent.createTest("A user captures valid customer details", "Customer details successfully display");
        test = extent.createTest("A user captures an address which is located within the Order Now KML and select the register button", "The client Interface dashboard displays, and no packages are visible.");
        test = extent.createTest("A user selects the Order package button.", "The coverage and packages page should display");
        test = extent.createTest("A user captures a premise within the Order now kml and select the Order now button", "The following is displayed:\n" + "Check out page displays, and the following fields should contain previously captured information. a. First Name* b. Last Name* c. Phone Number. Alternative Numbere. E-mail Address*order button");
        test = extent.createTest("A user selects the place order button", "A pop up displays with a message \"Thank you for your Order\" and the Go To Account butto");

        test.info("");
        test.pass("");

        test.info("");
        test.pass("");

        test.info("");
        test.pass("");

        test.info("");
        test.pass("");

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

        test.info("");
        test.pass("");

        test.info("");
        test.pass("");

        test.info("");
        test.pass("");

        test.info("");
        test.pass("");

        test.info("");
        test.pass("");
    }
    @Test
    void CLIENT_APP_Pre_Order() throws InterruptedException, IOException {
        test = extent.createTest("A user captures 3 or more characters.", "A list of predefined premises are listed on the address textbox containing the captured characters.");
        test = extent.createTest("A user selects any of the predefined premises setup on a Pre order location", "The Pre Order button displays on the available packages.");
        test = extent.createTest("Click on the Pre Order button on any preferred package.", "The Checkout page displays");
        test = extent.createTest("A user captures their details and a billing account option and select \"Place Order\" buttonge", "A pop up displays with a message \"Thank you for your Order\" and the Go To Account button");
        test = extent.createTest("A pop-up displays with a message \"Thank you for your Order\" and the \"Go To Account\" button", "The dashboard displays");

        test.info("");
        test.pass("");

        test.info("");
        test.pass("");

        test.info("");
        test.pass("");

        test.info("");
        test.pass("");
    }
    @Test
    void CLIENT_APP_User_Login() throws InterruptedException, IOException {
        test = extent.createTest("A user selects the Login button/ tab", "The following displays:\n" + "\n" + "Login page \n" + "\n" + "Email address text box and label \n" + "\n" + "Password textbox and label \n" + "\n" + "Login button");
        test = extent.createTest("A user enters invalid username or password", "A validation message displays:\n" + "\n" + "Incorrect Username or Password");
        test = extent.createTest("A user enters a valid username and password and select the login button", "test = extent.createTest(\"Validate View Product Page\", \"The login page should display\");");

        test.info("");
        test.pass("");

        test.info("");
        test.pass("");
    }
    @Test
    void CLIENT_APP_View_tabs() throws InterruptedException, IOException {
        test = extent.createTest("A user views the client App tabs displayed at the top of the page", "The following tabs display:\n" + "My Packages\n" + "My Profile");
        test = extent.createTest("A user views the My packages tabs", "The My Packages page displays with all the  packages assigned to the user");

        test.info("");
        test.pass("");

        test.info("");
        test.pass("");
    }
    @Test
    void CLIENT_APP_View_Packages() throws InterruptedException, IOException {
        test = extent.createTest("A user selects the View Package button", "The package details screen displays which includes the below sections:\\n\" + \"Package Information\\n\" + \"Payment History");
        test = extent.createTest("A user views the package information:\n" + "Package name", "The Package name should correspond to the one the user has selected on the coverage and packages page.");
        test = extent.createTest("A user views the package information:\n" + "Premise", "The  premise should correspond to the one the user has captured on the coverage and packages page.");
        test = extent.createTest("A user views the package information:\n" + "Account Summary", "The correct Account status displays");
        test = extent.createTest("A user views the package information:\n" + "Current status", "The correct Service status displays \"Pending ISP Application\" / New Order for Order now   \n" + "\n" + "Expression of interest for Show my interest");
        test = extent.createTest("A user views the Payment History Accordion", "The following is displayed:\\n\" + \"\\n\" + \"Purchase date\\n\" + \"\\n\" + \"Product Price\\n\" + \"\\n\" + \"Total Amount.\\n\" + \"\\n\" + \"Payment status.\\n\" + \"\\n\" + \"Payment Date\\n\" + \"\\n\" + \"Download Invoice Button\"");
        test = extent.createTest("A user selects the Back to Dashboard button.", "The Dashboard Displays");

        test.info("");
        test.pass("");

        test.info("");
        test.pass("");
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
        test = extent.createTest("A user selects the My Profile tab", "The Edit My Profile page displays");
        test = extent.createTest("A user can update the profile details", "The profile details should be updated succesfully");

    }
    @AfterSuite
    public static void cleanup(){
        extent.flush();
    }




}
