package ru.fckrasnodar.shop.api;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {
    protected LoginPageAPI service;

    @BeforeEach
    public void setUp(){
        service = new LoginPageAPI();
    }
    @AfterEach
    public void tearDown(){
        service = null;
    }
}
