package ZoomClientPages;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.ScreenCapture;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.testng.Assert;


import java.io.IOException;

import static Tests.ZoomClientTest.driver;
import static Tests.ZoomClientTest.*;

public class LogInPage {
    public static final String login_header = "/html/body/app-root/div/div[1]/app-login/div/div/h4";

    @SneakyThrows
    public static void loginGetTitle() {
        String expectedTitleLoginHD = "LOGIN";
        String actualTitleLoginHD = driver.findElement(By.xpath(login_header)).getText();
      Assert.assertEquals(actualTitleLoginHD,expectedTitleLoginHD);
        if (expectedTitleLoginHD.equals(actualTitleLoginHD)) {
            test.log(Status.PASS, "Test Passed for title verification");
            test.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(capture(driver)).build());
        } else if (false){
            test.fail(MediaEntityBuilder.createScreenCaptureFromBase64String("Failed Screenshot").build());
        }


    }

}

