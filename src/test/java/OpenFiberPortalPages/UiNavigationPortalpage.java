package OpenFiberPortalPages;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.io.IOException;

import static Tests.OpenFiberPortalChecklist.*;
import static Tests.OpenFiberPortalChecklist.test;

public class UiNavigationPortalpage {

    //Locators
    static String main_manu ="/html/body/div[3]/header/div/div/div[2]/ul";
    static String search_services_button ="//*[@id=\"btnServiceSearch\"]";
    static String search_work_orders_button ="//*[@id=\"btnWorkOrderSearch\"]";
    static String search_users_button ="//*[@id=\"btnUserSearch\"]";
    static String serial_number_search_input ="//*[@id=\"SearchString\"]";
    static String search_serial_button ="//*[@id=\"btnSearch\"]";
    static String reports_tab ="/html/body/div[3]/header/div/div/div[2]/ul/li[9]/a";
    static String reports_overview_option ="//a[normalize-space()='Overview']";
    static String admin_tabs = "/html/body/div[3]/header/div/div/div[2]/ul/li[6]/a";
    static String address_management_op = "/html/body/div[3]/header/div/div/div[2]/ul/li[6]/ul/li[8]/a";
    static String Service_tab = "/html/body/div[3]/header/div/div/div[2]/ul/li[4]/a";
    static String Dashboard_option = "/html/body/div[3]/header/div/div/div[2]/ul/li[4]/ul/li[2]/a";
    static String Service_dashdoard_header = "/html/body/div[4]/div/div/div/header/h1";
    static String summary_accordion_element = "//*[@id=\"ui-id-1\"]";
    static String metacom_accordion_element = "//*[@id=\"ui-id-3\"]";
    static String reflexISP_accordion_element ="//*[@id=\"ui-id-5\"]";
    static String ORDER_SERVICES ="/html/body/div[3]/header/div/div/div[2]/ul/li[4]/ul/li[3]/a";
    static String select_service_provider ="//*[@id=\"ServiceProvider\"]";
    static String option_one ="//*[@id=\"ServiceProvider\"]/option[2]";
    static String Submit_Button_provoder ="//*[@id=\"btnSubmit\"]";
    static String address_input ="//*[@id=\"PredefinedPremise0\"]";
    static String address_input2 ="PredefinedPremise1";
    static String address_input3 ="PredefinedPremise2";
    static String first_name_input = "//*[@id=\"dataTable\"]/tbody/tr[1]/td[4]/input";
    static String first_name_input2 = "//*[@id=\"dataTable\"]/tbody/tr[2]/td[4]/input";
    static String first_name_input3 = "//*[@id=\"dataTable\"]/tbody/tr[3]/td[4]/input";
    static String last_name_input ="//*[@id=\"dataTable\"]/tbody/tr[1]/td[5]/input";
    static String last_name_input2 ="//*[@id=\"dataTable\"]/tbody/tr[2]/td[5]/input";
    static String last_name_input3 = "//*[@id=\"dataTable\"]/tbody/tr[3]/td[5]/input";
    static String mobile_number ="//*[@id=\"dataTable\"]/tbody/tr/td[7]/input";
    static String mobile_number2 ="//*[@id=\"dataTable\"]/tbody/tr[2]/td[7]/input";
    static String mobile_number3 ="//*[@id=\"dataTable\"]/tbody/tr[3]/td[7]/input";
    static String Id_Number ="//*[@id=\"dataTable\"]/tbody/tr/td[8]/input";
    static String Id_Number2 ="//*[@id=\"dataTable\"]/tbody/tr[2]/td[8]/input";
    static String Id_Number3 ="//*[@id=\"dataTable\"]/tbody/tr[3]/td[8]/input";
    static String Product_Input ="//*[@id=\"ProductId0\"]";
    static String Product_Input2 ="//*[@id=\"ProductId1\"]";
    static String Product_Input3 ="//*[@id=\"ProductId2\"]";
    static String product_option_one ="//*[@id=\"ProductId0\"]/option[2]";
    static String product_option_two ="//*[@id=\"ProductId1\"]/option[4]";
    static String prodct_option_three ="//*[@id=\"ProductId2\"]/option[5]";
    static String Email_input ="//*[@id=\"dataTable\"]/tbody/tr/td[6]/input";
    static String Email_input2 ="//*[@id=\"dataTable\"]/tbody/tr[2]/td[6]/input";
    static String Email_input3 ="//*[@id=\"dataTable\"]/tbody/tr[3]/td[6]/input";
    static String ISP_Header ="/html/body/div[4]/div/div/div/form/div/div/span";
    static String Service_provider_header ="/html/body/div[4]/div/div/div/form/div/div[1]/span";
    static String ADD_ROW_Button ="/html[1]/body[1]/div[4]/div[1]/form[1]/div[1]/a[2]";
    static String address_option_one ="/html[1]/body[1]/ul[1]/li[2]";
    static String address_option_two ="/html[1]/body[1]/ul[2]/li[1]";
    static String address_option_three ="/html[1]/body[1]/ul[3]/li[3]";


    public static void enter_address_input22() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.id(address_input2)).sendKeys("Fire Shed, Gateway Theatre of Shopping, Umhlanga Ridge, Durban, KwaZulu-Natal");
        Thread.sleep(2000);
        driver.findElement(By.id(address_input2)).click();
        driver.findElement(By.xpath(address_option_two)).click();
    }
    public static void enter_address_input3() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.id(address_input3)).sendKeys("Fire Shed, Gateway Theatre of Shopping, Umhlanga Ridge, Durban, KwaZulu-Natal");
        Thread.sleep(2000);
        driver.findElement(By.id(address_input3)).click();
        driver.findElement(By.xpath(address_option_three)).click();
    }
    public static void click_ADD_ROW_Button() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(ADD_ROW_Button)).click();
    }
    public static void verify_Service_provider_header() throws IOException, InterruptedException {
        Thread.sleep(2000);
        String expectedTitleProvider = "Service Provider:";
        String actualTitleProvider = driver.findElement(By.xpath(Service_provider_header)).getText();
        Assert.assertEquals(actualTitleProvider, expectedTitleProvider);
        String screenshotPath = captureScreenshot(driver);
        if (expectedTitleProvider.equals(actualTitleProvider)) {
            test.log(Status.PASS, "Verify the Service Provider Screen");
            test.pass("Actual Result",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        } else {
            test.log(Status.FAIL, "Landing page title mismatch. Expected: " + expectedTitleProvider + " but found: " + actualTitleProvider);
            test.fail("Failure Screenshot",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
    }
    public static void enter_Email_input() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(Email_input)).sendKeys("nyamuka@gmail.com");
    }
    public static void enter_Email_input2() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(Email_input2)).sendKeys("muthundia@gmail.com");
    }
    public static void enter_Email_input3() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(Email_input3)).sendKeys("vhuhonee@gmail.com");
    }
    public static void verify_ISP_Header() throws IOException, InterruptedException {
        Thread.sleep(2000);
        String expectedTitleISPH = "Accelerit";
        String actualTitleISPH = driver.findElement(By.xpath(ISP_Header)).getText();
        Assert.assertEquals(actualTitleISPH, expectedTitleISPH);
        String screenshotPath = captureScreenshot(driver);
        if (expectedTitleISPH.equals(actualTitleISPH)) {
            test.log(Status.PASS, "Verify the ISP Header.");
            test.pass("Actual Result",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        } else {
            test.log(Status.FAIL, "Landing page title mismatch. Expected: " + expectedTitleISPH + " but found: " + actualTitleISPH);
            test.fail("Failure Screenshot",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
    }
    public static void click_prodct_option_three() throws IOException, InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath(prodct_option_three)).click();
        Thread.sleep(2000);
        String screenshotPath = captureScreenshot(driver);
        test.pass("Actual Result",
                MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
    }
    public static void click_product_option_two() throws IOException, InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath(product_option_two)).click();
        Thread.sleep(2000);
        String screenshotPath = captureScreenshot(driver);
        test.pass("Actual Result",
                MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
    }

    public static void click_product_option_one() throws IOException, InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath(product_option_one)).click();
        Thread.sleep(2000);
        String screenshotPath = captureScreenshot(driver);
        test.pass("Actual Result",
                MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
    }

    public static void click_Product_Input() throws IOException, InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath(Product_Input)).click();
        Thread.sleep(2000);
        String screenshotPath = captureScreenshot(driver);
        test.pass("Actual Result",
                MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
    }
    public static void click_Product_Input2() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(Product_Input2)).click();
        Thread.sleep(2000);
        String screenshotPath = captureScreenshot(driver);
        test.pass("Actual Result",
                MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
    }
    public static void click_Product_Input3() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(Product_Input3)).click();
        Thread.sleep(2000);
        String screenshotPath = captureScreenshot(driver);
        test.pass("Actual Result",
                MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
    }
    public static void enter_Id_Number() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(Id_Number)).sendKeys("911211588802");
    }
    public static void enter_Id_Number2() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(Id_Number2)).sendKeys("921211588802");
    }
    public static void enter_Id_Number3() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(Id_Number3)).sendKeys("931211588802");
    }
    public static void enter_address_input() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(address_input)).sendKeys("Toy Kingdom, Gateway Theatre of Shopping, Umhlanga Ridge, Durban, KwaZulu-Natal");
        Thread.sleep(2000);
        driver.findElement(By.xpath(address_input)).click();
        driver.findElement(By.xpath(address_option_one)).click();
    }
    public static void enter_mobile_number() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(mobile_number)).sendKeys("0000000000");
    }
    public static void enter_mobile_number2() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(mobile_number2)).sendKeys("0000001000");
    }
    public static void enter_mobile_number3() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(mobile_number3)).sendKeys("0002000000");
    }
    public static void enter_last_name_input() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(last_name_input)).sendKeys("Ramarumo");
    }
    public static void enter_last_name_input2() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(last_name_input2)).sendKeys("Rumo");
    }
    public static void enter_last_name_input3() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(last_name_input3)).sendKeys("Manenzhe");
    }
    public static void enter_first_name_input() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(first_name_input)).sendKeys("Tendani");
    }
    public static void enter_first_name_input2() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(first_name_input2)).sendKeys("Tens");
    }
    public static void enter_first_name_input3() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(first_name_input3)).sendKeys("Lucky");
    }

    public static void click_Submit_Button_provoder() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(Submit_Button_provoder)).click();
        Thread.sleep(2000);
        String screenshotPath = captureScreenshot(driver);
        test.pass("Actual Result",
                MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
    }
    public static void click_option_one() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(option_one)).click();
        Thread.sleep(2000);
        String screenshotPath = captureScreenshot(driver);
        test.pass("Actual Result",
                MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
    }
    public static void click_select_service_provider() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(select_service_provider)).click();
        Thread.sleep(2000);
        String screenshotPath = captureScreenshot(driver);
        test.pass("Actual Result",
                MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
    }
    public static void click_ORDER_SERVICES() throws IOException, InterruptedException {
        Thread.sleep(10000);
        driver.findElement(By.xpath(ORDER_SERVICES)).click();
        Thread.sleep(2000);
        String screenshotPath = captureScreenshot(driver);
        test.pass("Actual Result",
                MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
    }

    public static void click_search_service_button() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(search_services_button)).click();
        Thread.sleep(2000);
        String screenshotPath = captureScreenshot(driver);
        test.pass("Actual Result",
                MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
    }

    public static void click_work_orders_button() throws IOException, InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath(search_work_orders_button)).click();
        Thread.sleep(2000);
        String screenshotPath = captureScreenshot(driver);
        test.pass("Actual Result",
                MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
    }

    public static void click_search_users_button() throws IOException, InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath(search_users_button)).click();
        Thread.sleep(2000);
        String screenshotPath = captureScreenshot(driver);
        test.pass("Actual Result",
                MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
    }

    public static void click_admin_tab_button() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(admin_tabs)).click();
        Thread.sleep(2000);
        String screenshotPath = captureScreenshot(driver);
        test.pass("Actual Result",
                MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
    }

    public static void click_address_management_option() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(address_management_op)).click();
        Thread.sleep(2000);
        String screenshotPath = captureScreenshot(driver);
        test.pass("Actual Result",
                MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
    }

    public static void click_reports_tab_button() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(reports_tab)).click();
        Thread.sleep(2000);
        String screenshotPath = captureScreenshot(driver);
        test.pass("Actual Result",
                MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
    }

    public static void click_reports_overview_option_button() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(reports_overview_option)).click();
        Thread.sleep(2000);
        String screenshotPath = captureScreenshot(driver);
        test.pass("Actual Result",
                MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
    }

    public static void verify_summary_accordion_element() throws IOException, InterruptedException {
        Thread.sleep(2000);
        String expectedTitleMAP = "Summary";
        String actualTitleMAP = driver.findElement(By.xpath(summary_accordion_element)).getText();
        Assert.assertEquals(actualTitleMAP, expectedTitleMAP);
        String screenshotPath = captureScreenshot(driver);
        if (expectedTitleMAP.equals(actualTitleMAP)) {
            test.log(Status.PASS, "Verify the summary accordion element and the count bubbles.");
            test.pass("Actual Result",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        } else {
            test.log(Status.FAIL, "Landing page title mismatch. Expected: " + expectedTitleMAP + " but found: " + actualTitleMAP);
            test.fail("Failure Screenshot",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
    }
    public static void verify_metacom_accordion_element() throws IOException, InterruptedException {
        Thread.sleep(2000);
        String expectedTitleMAP = "Metacom";
        String actualTitleMAP = driver.findElement(By.xpath(metacom_accordion_element)).getText();
        Assert.assertEquals(actualTitleMAP, expectedTitleMAP);
        String screenshotPath = captureScreenshot(driver);
        if (expectedTitleMAP.equals(actualTitleMAP)) {
            test.log(Status.PASS, "Verify the metacom accordion element and the count bubbles.");
            test.pass("Actual Result",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        } else {
            test.log(Status.FAIL, "Landing page title mismatch. Expected: " + expectedTitleMAP + " but found: " + actualTitleMAP);
            test.fail("Failure Screenshot",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
    }

    public static void verify_reflexISP_accordion_element() throws IOException, InterruptedException {
        Thread.sleep(2000);
        String expectedTitleMAP = "Service Dashboard";
        String actualTitleMAP = driver.findElement(By.xpath(Service_dashdoard_header)).getText();
        Assert.assertEquals(actualTitleMAP, expectedTitleMAP);
        String screenshotPath = captureScreenshot(driver);
        if (expectedTitleMAP.equals(actualTitleMAP)) {
            test.log(Status.PASS, "Verify the reflex ISP accordion element and the count bubbles.");
            test.pass("Actual Result",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        } else {
            test.log(Status.FAIL, "Landing page title mismatch. Expected: " + expectedTitleMAP + " but found: " + actualTitleMAP);
            test.fail("Failure Screenshot",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
    }
    public static void click_Service_tab() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(Service_tab)).click();
        Thread.sleep(2000);
        String screenshotPath = captureScreenshot(driver);
        test.pass("Actual Result",
                MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
    }

    public static void click_Dashboard_option() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(Dashboard_option)).click();
        Thread.sleep(2000);
        String screenshotPath = captureScreenshot(driver);
        test.pass("Actual Result",
                MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
    }

    public static void click_metacom_accordion_element() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(metacom_accordion_element)).click();
    }
    public static void click_summary_accordion_element() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(summary_accordion_element)).click();
    }
    public static void click_reflexISP_accordion_element() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(reflexISP_accordion_element)).click();
    }
}
