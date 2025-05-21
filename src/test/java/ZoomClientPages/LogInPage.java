package ZoomClientPages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.Assert;


import java.io.IOException;

import static Tests.ZoomClientTest.driver;
import static Tests.ZoomClientTest.*;

public class LogInPage {
    public static String login_header ="/html/body/app-root/div/div[1]/app-login/div/div/h4";

    public static void login_getTitle() throws IOException {
        String expectedTitleLogin ="LOGIN";
        String actualTleLogin = driver.findElement(By.xpath(login_header)).getText();
        Assert.assertEquals(actualTleLogin,expectedTitleLogin);
        if(expectedTitleLogin.equals(expectedTitleLogin)){
            test.log(Status.PASS,"Test Passed for title verification");
            test.log(Status.PASS,test.addScreenCaptureFromPath(capture(driver))+ "Test Passed");
        }
        else {
            test.log(Status.FAIL,"Test Failed for title verification");
        }

    }
}
