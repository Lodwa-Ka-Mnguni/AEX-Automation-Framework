package ZoomClientPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Tests.ZoomClientTest.driver;

public class LandingPage {

    public static String login_button ="/html/body/app-root/div/div[1]/app-landing/div/div/div/div[3]/app-landing-card/div/div[3]/div/button";
    public static String view_products_button ="/html/body/app-root/div/div[1]/app-landing/div/div/div/div[1]/app-landing-card/div/div[3]/div/button";
    public static String register_button ="/html/body/app-root/div/div[1]/app-landing/div/div/div/div[2]/app-landing-card/div/div[3]/div/button";
    public static String homepage_zoom_log ="/html/body/app-root/div/app-header/div/nav/div[1]/div[1]";

    public static void click_view_products_button() throws InterruptedException {
        Thread.sleep(2000);
      driver.findElement(By.xpath(view_products_button)).click();
    }
    public static void click_register_button() throws InterruptedException {
        Thread.sleep(2000);
       driver.findElement(By.xpath(register_button)).click();
    }
    public static void click_login_button() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(login_button)).click();
    }

//    public static void click_homepage_zoom_log() throws InterruptedException {
//        Thread.sleep(2000);
//        driver.findElement(By.xpath(homepage_zoom_log)).click();
//        }
    }

