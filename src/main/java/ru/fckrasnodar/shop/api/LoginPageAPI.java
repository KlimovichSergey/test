package ru.fckrasnodar.shop.api;

import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;


public class LoginPageAPI {
    String URL = "https://shop.fckrasnodar.ru/login/";
    String body = "login=klimovichsergey122%40gmail.com&password=dgfdgfdfdgdg&remember=0&remember=1&wa_auth_login=1&_csrf=&wa_json_mode=1&need_redirects=1";
    private Response response;

    public void doRequest(){
         response =  given()
                 .header("content-type","application/x-www-form-urlencoded; charset=UTF-8")
                 .header("x-requested-with","XMLHttpRequest")
                 .body(body)
                 .when()
                 .post(URL);

    }

    public int getStatusCode(){
        return response.statusCode();
    }

    public String getBody(){
        return response.getBody().asPrettyString();
    }

}
