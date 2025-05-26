package ZoomClientPages;

import org.openqa.selenium.By;
import static Tests.ZoomClientTest.driver;

public class RegisterPage {

    //Locators

    static String registerFirstName = "//input[@id='registerFirstName']";
    static String registerLastName = "//input[@id='registerLastName']";
    static String registerEmail = "//input[@id='registerEmail']";
    static String registerButton = "//button[contains(text(),'Register')]";

    public static void fillRegistrationForm(String fName, String lName, String email) throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath(registerFirstName)).sendKeys(fName);
        driver.findElement(By.xpath(registerLastName)).sendKeys(lName);
        driver.findElement(By.xpath(registerEmail)).sendKeys(email);
    }

    public static void submitRegistration() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath(registerButton)).click();
    }
}
