package ru.fckrasnodar.shop.api;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;

public class TestLoginPageAPI extends BaseTest {
    private final Gson gson = new Gson();

    @Test
    @DisplayName("unauthorized user login")
    public void openLoginPageInputEmailAndPassword() {
        service.doRequest();

        JsonObject jsonResponse = gson.fromJson(service.getBody(), JsonObject.class);
        List<String> keys = new ArrayList<>(jsonResponse.keySet());

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
    }

    @Test
    @DisplayName("User login without Email")
    public void openLoginPageInputPassword() {
        service.doRequest("", "asd1##34354544");

        JsonObject jsonResponse = gson.fromJson(service.getBody(), JsonObject.class);

        assertAll(
                () -> assertEquals(200, service.getStatusCode()),
                () -> assertEquals("fail", jsonResponse.get("status").getAsString()),
                () -> assertEquals("login", jsonResponse.getAsJsonObject("errors").keySet().iterator().next()),
                () -> assertEquals("Логин обязателен", jsonResponse.getAsJsonObject("errors").get("login").getAsString()),
                () -> assertTrue(jsonResponse.getAsJsonArray("data").isEmpty(), "it is not an empty array")
        );
    }

    @Test
    @DisplayName("Create an empty login form")
    public void openLoginFormSubmitEmpty() {
        service.doRequest("", "");

        JsonObject jsonResponse = gson.fromJson(service.getBody(), JsonObject.class);
        List<String> keys = new ArrayList<>(jsonResponse.getAsJsonObject("errors").keySet());

        assertAll(
                () -> assertEquals(200, service.getStatusCode()),
                () -> assertEquals("fail", jsonResponse.get("status").getAsString()),
                () -> assertEquals("login", keys.get(0)),
                () -> assertEquals("Логин обязателен", jsonResponse.getAsJsonObject("errors").get("login").getAsString()),
                () -> assertEquals("password", keys.get(1)),
                () -> assertEquals("Пароль обязателен", jsonResponse.getAsJsonObject("errors").get("login").getAsString()),
                () -> assertTrue(jsonResponse.getAsJsonArray("data").isEmpty(), "it is not an empty array")
        );
    }

    @Test
    @DisplayName("Authorized user login")
    public void openFormAuthorizedUser() {
        service.doRequest("test@test10.com", "123");

        JsonObject jsonResponse = gson.fromJson(service.getBody(), JsonObject.class);
        List<String> keys = new ArrayList<>(jsonResponse.keySet());
        List<String> keysData = new ArrayList<>(jsonResponse.getAsJsonObject("data").keySet());

        assertAll(
                () -> assertEquals(200, service.getStatusCode()),
                () -> assertEquals("ok", jsonResponse.get("status").getAsString()),
                () -> assertEquals("data", keys.get(1)),
                () -> assertEquals("redirect_url", keysData.get(0)),
                () -> assertEquals("/my/", jsonResponse.getAsJsonObject("data").get("redirect_url").getAsString()),
                () -> assertEquals("redirect_code", keysData.get(1)),
                () -> assertTrue(jsonResponse.getAsJsonObject("data").get("redirect_code").isJsonNull(), "This value is not null")
        );
    }
}
