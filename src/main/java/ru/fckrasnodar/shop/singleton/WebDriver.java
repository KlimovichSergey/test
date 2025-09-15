package ru.fckrasnodar.shop.singleton;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class WebDriver {
    private static org.openqa.selenium.WebDriver driver;

    public static org.openqa.selenium.WebDriver getDriver() {
        if (driver == null) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        }
        return driver;
    }

    public static void quit() {
        if (driver != null) {
            driver.quit();
        }
        driver = null;
    }

    public static WebElement findElement(String xpath) {
        return getDriver().findElement(By.xpath(xpath));
    }

    public static void clickElement(String xpath) {
        findElement(xpath).click();
    }

    public static void sendKeys(String xpath, String value) {
        findElement(xpath).sendKeys(value);
    }

    public static String getTextFromElement(String xpath) {
        return findElement(xpath).getText();
    }

    public static List<WebElement> findElements(String xpath) {
        return driver.findElements(By.xpath(xpath));
    }
}