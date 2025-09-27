package ru.fckrasnodar.shop.api;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Logger;

import static org.junit.jupiter.api.Assertions.*;

public class TestLoginPageAPI extends BaseTest {
    private final Gson gson = new Gson();
    private static final Logger log = LogManager.getLogger();

    @Test
    @DisplayName("Unauthorized user login")
    public void openLoginPageInputEmailAndPassword() {
        log.info("Start test:Unauthorized user login");
        service.doRequest();

        JsonObject jsonResponse = gson.fromJson(service.getBody(), JsonObject.class);
        List<String> keys = new ArrayList<>(jsonResponse.keySet());
        log.info(jsonResponse);

        assertAll(
                () -> assertEquals(200, service.getStatusCode()),
                () -> assertEquals("status", keys.get(0)),
                () -> assertEquals("fail", jsonResponse.get("status").getAsString()),
                () -> assertEquals("errors", keys.get(1)),
                () -> assertEquals("auth", jsonResponse.getAsJsonObject("errors").keySet().iterator().next()),
                () -> assertEquals("Неправильное имя пользователя или пароль.", jsonResponse.getAsJsonObject("errors").get("auth").getAsString()),
                () -> assertEquals("data", keys.get(2)),
                () -> assertTrue(jsonResponse.getAsJsonArray("data").isEmpty(), "it is not an empty array")
        );
        log.info("End test: Unauthorized user login");
    }

    @Test
    @DisplayName("User login without Email")
    public void openLoginPageInputPassword() {
        log.info("Start test:User login without Email");
        service.doRequest("", "asd1##34354544");

        JsonObject jsonResponse = gson.fromJson(service.getBody(), JsonObject.class);
        log.info(jsonResponse);

        assertAll(
                () -> assertEquals(200, service.getStatusCode()),
                () -> assertEquals("fail", jsonResponse.get("status").getAsString()),
                () -> assertEquals("login", jsonResponse.getAsJsonObject("errors").keySet().iterator().next()),
                () -> assertEquals("Логин обязателен", jsonResponse.getAsJsonObject("errors").get("login").getAsString()),
                () -> assertTrue(jsonResponse.getAsJsonArray("data").isEmpty(), "it is not an empty array")
        );
        log.info("End test:User login without Email");
    }

    @Test
    @DisplayName("Create an empty login form")
    public void openLoginFormSubmitEmpty() {
        log.info("Start test:Create an empty login form");
        service.doRequest("", "");

        JsonObject jsonResponse = gson.fromJson(service.getBody(), JsonObject.class);
        List<String> keys = new ArrayList<>(jsonResponse.getAsJsonObject("errors").keySet());
        log.info(jsonResponse);

        assertAll(
                () -> assertEquals(200, service.getStatusCode()),
                () -> assertEquals("fail", jsonResponse.get("status").getAsString()),
                () -> assertEquals("login", keys.get(0)),
                () -> assertEquals("Логин обязателен", jsonResponse.getAsJsonObject("errors").get("login").getAsString()),
                () -> assertEquals("password", keys.get(1)),
                () -> assertEquals("Пароль обязателен", jsonResponse.getAsJsonObject("errors").get("password").getAsString()),
                () -> assertTrue(jsonResponse.getAsJsonArray("data").isEmpty(), "it is not an empty array")
        );
        log.info("End test:Create an empty login form");
    }

    @Test
    @DisplayName("Authorized user login")
    public void openFormAuthorizedUser() {
        log.info("Start test:Authorized user login");
        service.doRequest("test@test10.com", "123");

        JsonObject jsonResponse = gson.fromJson(service.getBody(), JsonObject.class);
        List<String> keys = new ArrayList<>(jsonResponse.keySet());
        List<String> keysData = new ArrayList<>(jsonResponse.getAsJsonObject("data").keySet());
        log.info(jsonResponse);

        assertAll(
                () -> assertEquals(200, service.getStatusCode()),
                () -> assertEquals("ok", jsonResponse.get("status").getAsString()),
                () -> assertEquals("data", keys.get(1)),
                () -> assertEquals("redirect_url", keysData.get(0)),
                () -> assertEquals("/my/", jsonResponse.getAsJsonObject("data").get("redirect_url").getAsString()),
                () -> assertEquals("redirect_code", keysData.get(1)),
                () -> assertTrue(jsonResponse.getAsJsonObject("data").get("redirect_code").isJsonNull(), "This value is not null")
        );
        log.info("End test:Authorized user login");
    }
}
