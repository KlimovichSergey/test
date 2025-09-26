package ru.fckrasnodar.shop.ui;

import org.openqa.selenium.By;
import ru.fckrasnodar.shop.singleton.WebDriver;

public class HomePage {
    private final String URL = "https://shop.fckrasnodar.ru/";
    private final String LINK_USER_ACCOUNT = "//a[@class='userhome-link']";
    private final String LINK_SEARCH_ICON = "//header[@id='header']//i[@class='search-icon']";
    private final String LINK_CART_INFORMER = "//header[@id='header']//a[@id='cart-informer']";

    public HomePage(){

    }

    public  void openSite(){
        WebDriver.getDriver().navigate().to(URL);
    }

    public void clickLinkUserAccount(){
        WebDriver.getDriver().findElement(By.xpath(LINK_USER_ACCOUNT)).click();
    }

    public void clickLinkSearchIcon(){
        WebDriver.getDriver().findElement(By.xpath(LINK_SEARCH_ICON)).click();
    }

    public void clickLinkCartInformer(){
        WebDriver.getDriver().findElement(By.xpath(LINK_CART_INFORMER)).click();
    }
}
