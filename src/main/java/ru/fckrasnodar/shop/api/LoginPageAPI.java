package ru.fckrasnodar.shop.api;

import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class LoginPageAPI {
    private final String URL = "https://shop.fckrasnodar.ru/login/";
    private final String BODY_DEFAULT = "login=klimovichsergey122%40gmail.com&password=dgfdgfdfdgdg&remember=0&remember=1&wa_auth_login=1&_csrf=&wa_json_mode=1&need_redirects=1";
    private Response response;

    public void doRequest() {;
        response = given()
                .headers(getHeaders())
                .body(BODY_DEFAULT)
                .when().post(URL);
    }

    public void doRequest(String email, String password) {
        String body = "login=" + email + "&password=" + password + "&remember=0&remember=1&wa_auth_login=1&_csrf=&wa_json_mode=1&need_redirects=1";
        response = given()
                .headers(getHeaders())
                .body(body)
                .when()
                .post(URL);
    }

    public int getStatusCode() {
        return response.statusCode();
    }

    public String getBody() {
        return response.getBody().asPrettyString();
    }

    public Map<String, String> getHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("content-type", "application/x-www-form-urlencoded; charset=UTF-8");
        headers.put("x-requested-with", "XMLHttpRequest");
        return headers;
    }
}
