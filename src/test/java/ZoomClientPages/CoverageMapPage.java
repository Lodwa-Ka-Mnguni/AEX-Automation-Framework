package ZoomClientPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static Tests.ZoomClientTest.driver;

public class CoverageMapPage {

    private static final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    private static final Actions actions = new Actions(driver);

    // Locators (replace these with real IDs/classes)
    private static final By searchBox = By.id("search-box");
    private static final By zoomInBtn = By.id("map-zoom-in");
    private static final By zoomOutBtn = By.id("map-zoom-out");
    private static final By pegman = By.id("pegman");
    private static final By locationPin = By.id("map-pin");
    private static final By useLocationBtn = By.id("use-current-location");
    private static final By geoErrorPopup = By.id("geo-error");

    public static boolean isMapControlsVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox)).isDisplayed()
                && driver.findElement(zoomInBtn).isDisplayed()
                && driver.findElement(zoomOutBtn).isDisplayed()
                && driver.findElement(pegman).isDisplayed();
    }

    public static void zoomIn() {
        wait.until(ExpectedConditions.elementToBeClickable(zoomInBtn)).click();
    }

    public static void zoomOut() {
        wait.until(ExpectedConditions.elementToBeClickable(zoomOutBtn)).click();
    }

    public static void moveLocationPin() {
        WebElement pin = wait.until(ExpectedConditions.visibilityOfElementLocated(locationPin));
        actions.clickAndHold(pin).moveByOffset(100, 50).release().perform();
    }

    public static void movePegmanToMap() {
        WebElement peg = wait.until(ExpectedConditions.visibilityOfElementLocated(pegman));
        WebElement map = driver.findElement(By.id("map-canvas")); // adjust if needed
        actions.clickAndHold(peg).moveToElement(map, 200, 200).release().perform();
    }

    public static void clickUseCurrentLocation() {
        wait.until(ExpectedConditions.elementToBeClickable(useLocationBtn)).click();
    }

    public static boolean isGeolocationDeniedMessageVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(geoErrorPopup))
                .getText().contains("You have disabled geolocation");
    }


}
