package Tests;

import ZoomClientPages.LandingPage;
import ZoomClientPages.LogInPage;
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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ZoomClientTest {

    public static WebDriver driver;
    static ExtentReports report;
    public static ExtentTest test;
    static ExtentReports extent = new ExtentReports();
    private static File File;


    @BeforeSuite
    public static void Setup(){
        driver = new ChromeDriver();
        driver.get("https://stage.zoomfibre.client-interface.dev.aex.systems/landing");
        ExtentSparkReporter spark = new ExtentSparkReporter("target/ZoomClientApp.html");
        extent.attachReporter(spark);
        driver.manage().window().maximize();

    }
    public static String capture(WebDriver driver) throws IOException {
        String scriFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
        test.addScreenCaptureFromBase64String(scriFile, "Screenshot");
        File Dest = new File("src/../ExecImages/" + System.currentTimeMillis()
        + ".png");
        String errflpath = Dest.getAbsolutePath();
        FileUtils.copyFile(File, new File("src/../ExecImages/"));
        return  errflpath;
    }

    @Test
    void  Login() throws InterruptedException, IOException {
        test = extent.createTest("Validate login Title on Login Page","The following displays: Login page, Email address text box, and label Password textbox and label Login button");
        LandingPage.click_login_button();
        LogInPage.login_getTitle();

    }

    @Test
    void Register() throws InterruptedException {
        test = extent.createTest("Validate login Title on Register Page","The following displays: Login page, Email address text box, and label Password textbox and label Login button");
        LandingPage.click_register_button();

    }

    @Test
    void ViewProducts() throws InterruptedException {
        test = extent.createTest("Validate login Title on Register Page","The following displays: Login page, Email address text box, and label Password textbox and label Login button");
        LandingPage.click_view_products_button();


    }
@AfterSuite
    public static void cleanup(){
    extent.flush();
}

}
