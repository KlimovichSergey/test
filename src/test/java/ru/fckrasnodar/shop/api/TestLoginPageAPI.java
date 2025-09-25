package ru.fckrasnodar.shop.api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;

public class TestLoginPageAPI {

    @Test
    @DisplayName("unauthorized user login")
    public void openLoginPageInputEmailAndPassword(){
        String URL = "https://shop.fckrasnodar.ru/login/";
        String body = "login=klimovichsergey122%40gmail.com&password=dgfdgfdfdgdg&remember=0&remember=1&wa_auth_login=1&_csrf=&wa_json_mode=1&need_redirects=1";

        given()
                .header("content-type","application/x-www-form-urlencoded; charset=UTF-8")
                .header("x-requested-with","XMLHttpRequest")
                .body(body)
        .when()
                .post(URL)
        .then()
                .log().all()
                .statusCode(200)
                .body("status",is("fail"))
                .body("errors.auth[0]",equalTo("Неправильное имя пользователя или пароль."))
                .body("data",hasSize(0));
    }

    @Test
    @DisplayName("User login without Email")
    public void openLoginPageInputPassword(){
        String URL = "https://shop.fckrasnodar.ru/login/";
        String body = "login=&password=dgfdgfdfdgdg&remember=0&remember=1&wa_auth_login=1&_csrf=&wa_json_mode=1&need_redirects=1";

        given()
                .header("content-type","application/x-www-form-urlencoded; charset=UTF-8")
                .header("x-requested-with","XMLHttpRequest")
                .body(body)
        .when()
                .post(URL)
        .then()
                .log().all()
                .statusCode(200)
                .body("status",is("fail"))
                .body("errors.login[0]",equalTo("Логин обязателен"))
                .body("data",hasSize(0));
    }

    @Test
    @DisplayName("Create an empty login form")
    public void openLoginFormSubmitEmpty(){
        String URL = "https://shop.fckrasnodar.ru/login/";
        String body = "login=&password=&remember=0&remember=1&wa_auth_login=1&_csrf=&wa_json_mode=1&need_redirects=1";

        given()
                .header("content-type","application/x-www-form-urlencoded; charset=UTF-8")
                .header("x-requested-with","XMLHttpRequest")
                .body(body)
        .when()
                .post(URL)
        .then()
                .log().all()
                .statusCode(200)
                .body("status",is("fail"))
                .body("errors.login[0]",equalTo("Логин обязателен"))
                .body("errors.password[0]",equalTo("Пароль обязателен"))
                .body("data",hasSize(0));
    }

    @Test
    @DisplayName("Authorized user login")
    public void openFormAuthorizedUser(){
        String URL = "https://shop.fckrasnodar.ru/login/";
        String body = "login=test@test10.com&password=123&remember=0&remember=1&wa_auth_login=1&_csrf=&wa_json_mode=1&need_redirects=1";

        given()
                .header("content-type","application/x-www-form-urlencoded; charset=UTF-8")
                .header("x-requested-with","XMLHttpRequest")
                .body(body)
        .when()
                .post(URL)
        .then()
                .log().all()
                .statusCode(200)
                .body("status",is("ok"))
                .body("data.redirect_url",equalTo("/my/"))
                .body("data.redirect_code",equalTo(null));

    }
}
