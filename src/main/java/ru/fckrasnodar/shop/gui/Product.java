package ru.fckrasnodar.shop.gui;

import org.openqa.selenium.By;
import ru.fckrasnodar.shop.singleton.WebDriver;

public class Product {
    private final String productXPath;
    private final String buttonAddToCart = "//div[@class='add-to-cart']//button";
    private final String name;
    private final String submitInCart = "//div[@class='button-block']//a";
    private final int amount;
    private final String price;

    public Product(String productXPath, String name, int amount, String price) {
        this.productXPath = productXPath;
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    public String getProductXPath() {
        return productXPath;
    }

    public String getButtonAddToCart() {
        return buttonAddToCart;
    }

    public String getName() {
        return name;
    }

    public String getSubmitInCart() {
        return submitInCart;
    }

    public int getAmount() {
        return amount;
    }

    public String getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productXPath='" + productXPath + '\'' +
                ", buttonAddToCart='" + buttonAddToCart + '\'' +
                ", name='" + name + '\'' +
                ", submitInCart='" + submitInCart + '\'' +
                ", amount=" + amount +
                ", price='" + price + '\'' +
                '}';
    }
}
