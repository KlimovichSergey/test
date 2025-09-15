package ru.fckrasnodar.shop.gui;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.fckrasnodar.shop.singleton.WebDriver;

import java.time.Duration;

public class ProductHandler {
    org.openqa.selenium.WebDriver driver;

    public ProductHandler(){
        this.driver = WebDriver.getDriver();
    }

    Product firstProduct = new Product("//div[@class='item'][1]",
            "Куртка детская Kappa FC Krasnodar School Jacket",
            1,
            "2 200 ₽");
    Product thirdProduct = new Product("//div[@class='item'][3]",
            "Куртка детская Puma FC Krasnodar School Reversible Jacket",
            1,
            "3 990 ₽");


    WebDriverWait wait = new WebDriverWait(WebDriver.getDriver(), Duration.ofSeconds(7));

    public void addFirstProductInCart() {
        WebDriver.getDriver().findElement(By.xpath(firstProduct.getProductXPath())).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(firstProduct.getProductXPath())));
        WebDriver.getDriver().findElement(By.xpath(firstProduct.getButtonAddToCart())).click();
        WebDriver.getDriver().findElement(By.xpath(firstProduct.getSubmitInCart())).click();
    }

    public void addThirdProductInCart() {
        WebDriver.getDriver().findElement(By.xpath(thirdProduct.getProductXPath())).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(thirdProduct.getProductXPath())));
        WebDriver.getDriver().findElement(By.xpath(thirdProduct.getButtonAddToCart())).click();
        WebDriver.getDriver().findElement(By.xpath(thirdProduct.getSubmitInCart())).click();
    }
}
