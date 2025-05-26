package ZoomClientPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static Tests.ZoomClientTest.driver;

public class ProductPage {

    // Locators
    public static String viewProductsButton = "//button[contains(text(),'View Products')]";
    public static String filterToggleButton = "//button[contains(text(),'Display Filter')]";
    public static String hideFilterButton = "//button[contains(text(),'Hide Filter')]";
    public static String speedSlider = "//input[@id='speed-slider']";
    public static String priceSlider = "//input[@id='price-slider']";
    public static String productTypeDropdown = "//select[@id='product-type']";

    private static final By orderNowBtn = By.xpath("//button[text()='Order Now']");
    private static final By orderPopup = By.id("order-popup");



    // Actions
    public static void clickViewProducts() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath(viewProductsButton)).click();
    }

    public static void showFilters() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath(filterToggleButton)).click();
    }

    public static void hideFilters() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath(hideFilterButton)).click();
    }

    public static void adjustSliders() throws InterruptedException {
        Thread.sleep(1000);
        WebElement speed = driver.findElement(By.xpath(speedSlider));
        WebElement price = driver.findElement(By.xpath(priceSlider));

        // Simulate basic slider movement (value change)
        speed.sendKeys("50");  // Adjust to appropriate value or use JS/Actions for complex sliders
        price.sendKeys("1000");
    }

    public static void selectProductType(String type) throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath(productTypeDropdown)).sendKeys(type);
    }

    public static void selectPreferredPackage() {
        WebElement packageCard = driver.findElement(By.cssSelector(".package-card"));
        packageCard.click(); // or scroll & click
    }

    public static boolean isOrderPopupDisplayed() {
        return driver.findElement(orderPopup).isDisplayed();
    }

    public static void clickOrderNow() {
        driver.findElement(orderNowBtn).click();
    }

}
