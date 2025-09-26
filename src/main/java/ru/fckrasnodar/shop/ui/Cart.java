package ru.fckrasnodar.shop.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.fckrasnodar.shop.singleton.WebDriver;

import java.time.Duration;

public class Cart {
    private final String CART_EMPTY_TEXT = "//div[@class='s-cart-empty-wrapper']//p[@class='s-description']";
    private final String CART_EMPTY_ACTIONS_TEXT = "//div[@class='s-cart-empty-wrapper']//p[@class='s-actions-wrapper']";
    private final String HEADER_CART_TEXT = "//div[@class='s-section-header wa-flex-box full-line middle']//h2";
    private final String CART_PRODUCT_TEXT = "//div[@class='wa-details']//a";
    private final String CART_PRODUCT_SECOND_TEXT = "//div[@class='wa-details']//a[text()='Куртка детская Kappa FC Krasnodar School Jacket']";
    private final String BUTTON_DELETE_PRODUCT = "//span[@class='wa-tooltip is-inline bottom']";
    private final String PRICE_PRODUCT_TEXT = "//div[@class='wa-price-total js-product-full-price']";
    private final String PRICE_SECOND_PRODUCT_TEXT = "//div[@class='wa-product '][2]//div[@class='wa-price-total js-product-full-price']";
    private final String FIELD_PRODUCT_QUANTITY = "//div[@class='wa-product '][1]//input[@class='wa-field js-product-quantity ']";
    private final String FIELD_SECOND_PRODUCT_QUANTITY = "//div[@class='wa-product '][2]//input[@class='wa-field js-product-quantity ']";
    private final String BUTTON_PLUS_PRODUCT = "//div[@class='wa-button-wrapper']//button[@class='wa-button s-plus-button outlined js-increase']";
    private final String BUTTON_MINUS_PRODUCT = "//div[@class='wa-button-wrapper']//button[@class='wa-button s-minus-button outlined js-decrease']";
    private final String LINK_BACK = "//div[@class='s-back-link']";
    private final String DELETE_DIALOG_HEADER = "//div[@class='wa-dialog-body']//header";
    private final String BUTTON_CLOSE_DIALOG = "//span[@class='wa-close-wrapper js-close-dialog']//i";
    private final String BUTTON_CANSEL_DELETE_DIALOG = "//button[@class='wa-button blue js-focus-button js-cancel']";
    private final String BUTTON_CONFIRM_DELETE_DIALOG = "//button[@class='wa-button gray js-confirm']";
    private final String TOTAL_PRICE_CART = "//span[@class='wa-price js-price']";
    private final String CART_INFORMER_AMOUND = "//a[@id='cart-informer']//i";

    org.openqa.selenium.WebDriver driver;

    public Cart() {
        this.driver = WebDriver.getDriver();
    }

    WebDriverWait wait = new WebDriverWait(WebDriver.getDriver(), Duration.ofSeconds(5));

    public String getCartEmptyText() {
        return WebDriver.getDriver().findElement(By.xpath(CART_EMPTY_TEXT)).getText();
    }

    public String getCartEmptyActionsText() {
        return WebDriver.getDriver().findElement(By.xpath(CART_EMPTY_ACTIONS_TEXT)).getText();
    }

    public String getHeaderCartText() {
        return WebDriver.getDriver().findElement(By.xpath(HEADER_CART_TEXT)).getText();
    }

    public String getCartProductText() {
        return WebDriver.getDriver().findElement(By.xpath(CART_PRODUCT_TEXT)).getText();
    }

    public String getCartProductSecondText() {
        return WebDriver.getDriver().findElement(By.xpath(CART_PRODUCT_SECOND_TEXT)).getText();
    }


    public void clickDeleteProductInCart() {
        WebDriver.getDriver().findElement(By.xpath(BUTTON_DELETE_PRODUCT)).click();
    }

    public String getPriceProductText() {
        return WebDriver.getDriver().findElement(By.xpath(PRICE_PRODUCT_TEXT)).getText();
    }

    public String getPriceSecondProductText() {
        return WebDriver.getDriver().findElement(By.xpath(PRICE_SECOND_PRODUCT_TEXT)).getText();
    }

    public String getFieldProductQuantityText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FIELD_PRODUCT_QUANTITY)));
        return WebDriver.getDriver().findElement(By.xpath(FIELD_PRODUCT_QUANTITY)).getAttribute("value");
    }

    public String getFieldSecondProductQuantityText() {
        return WebDriver.getDriver().findElement(By.xpath(FIELD_SECOND_PRODUCT_QUANTITY)).getAttribute("value");
    }

    public void clickButtonPlusProduct() {
        WebDriver.getDriver().findElement(By.xpath(BUTTON_PLUS_PRODUCT)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BUTTON_PLUS_PRODUCT)));
    }

    public void clickButtonMinusProduct() {
        WebDriver.getDriver().findElement(By.xpath(BUTTON_MINUS_PRODUCT)).click();
    }

    public void clickLinkBack() {
        WebDriver.getDriver().findElement(By.xpath(LINK_BACK)).click();
    }

    public String getLinkBackText() {
        return WebDriver.getDriver().findElement(By.xpath(LINK_BACK)).getText();
    }

    public String getDeleteDialogHeaderText() {
        return WebDriver.getDriver().findElement(By.xpath(DELETE_DIALOG_HEADER)).getText();
    }

    public void clickButtonCloseDialog() {
        WebDriver.getDriver().findElement(By.xpath(BUTTON_CLOSE_DIALOG)).click();
    }

    public String getButtonCanselDeleteDialog() {
        return WebDriver.getDriver().findElement(By.xpath(BUTTON_CANSEL_DELETE_DIALOG)).getText();
    }

    public String getButtonConfirmDeleteDialog() {
        return WebDriver.getDriver().findElement(By.xpath(BUTTON_CONFIRM_DELETE_DIALOG)).getText();
    }

    public void clickButtonCanselDeleteDialog() {
        WebDriver.getDriver().findElement(By.xpath(BUTTON_CANSEL_DELETE_DIALOG)).click();
    }

    public String getTotalPriceCartText() {
        return WebDriver.getDriver().findElement(By.xpath(TOTAL_PRICE_CART)).getText();
    }

    public String getCartInformerAmoundText() {
        return WebDriver.getDriver().findElement(By.xpath(CART_INFORMER_AMOUND)).getText();
    }
}
