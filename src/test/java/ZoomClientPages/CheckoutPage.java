package ZoomClientPages;

import org.openqa.selenium.By;
import static Tests.ZoomClientTest.driver;

public class CheckoutPage {
    static String firstName = "//input[@id='firstName']";
    static String lastName = "//input[@id='lastName']";
    static String phone = "//input[@id='phoneNumber']";
    static String email = "//input[@id='email']";
    static String placeOrderButton = "//button[contains(text(),'Place Order')]";
    private static final By placeOrderBtn = By.id("place-order");

    public static void fillCheckoutForm(String fName, String lName, String phoneNum, String emailAddr) throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath(firstName)).sendKeys(fName);
        driver.findElement(By.xpath(lastName)).sendKeys(lName);
        driver.findElement(By.xpath(phone)).sendKeys(phoneNum);
        driver.findElement(By.xpath(email)).sendKeys(emailAddr);
    }

    public static void submitOrder() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath(placeOrderButton)).click();
    }

    public static boolean isCheckoutPageVisible() {
        return driver.getCurrentUrl().contains("checkout");
    }

    public static void enterClientInformation(String firstName, String lastName, String phone,
                                              String alt1, String alt2, String alt3, String alt4,
                                              String alt5, String alt6, String email) {
        driver.findElement(By.id("first-name")).sendKeys(firstName);
        driver.findElement(By.id("surname")).sendKeys(lastName);
        driver.findElement(By.id("phone")).sendKeys(phone);
        driver.findElement(By.id("email")).sendKeys(email);
        // Fill in alternative numbers if needed
    }

    public static void clickPlaceOrder() {
        driver.findElement(placeOrderBtn).click();
    }

    public static boolean isCardPopupDisplayed() {
        return driver.findElement(By.id("card-popup")).isDisplayed();
    }
}
