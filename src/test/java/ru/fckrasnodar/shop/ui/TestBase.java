package ru.fckrasnodar.shop.ui;

import org.junit.jupiter.api.AfterEach;
import ru.fckrasnodar.shop.singleton.WebDriver;

public class TestBase {
    @AfterEach
    public void closeBrowser(){
        WebDriver.quit();
    }
}
