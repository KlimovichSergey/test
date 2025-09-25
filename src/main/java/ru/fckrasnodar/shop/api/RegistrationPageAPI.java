package ru.fckrasnodar.shop.api;

import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class RegistrationPageAPI {

    private final String URL = "https://shop.fckrasnodar.ru/signup/";
    private String body = "data%5Blastname%5D=23@#$%\n" +
            "&data%5Bfirstname%5D=\n" +
            "&data%5Bmiddlename%5D=\n" +
            "&data%5Bphone%5D=%2B0+000+000-00-00\n" +
            "&data%5Bemail%5D=test%40test007.com\n" +
            "&data%5Bbirthday%5D%5Bday%5D=1&data%5Bbirthday%5D%5Bmonth%5D=6&data%5Bbirthday%5D%5Byear%5D=988\n" +
            "&data%5Bpassword%5D=0123rR!%40%23\n" +
            "&data%5Bpassword_confirm\n" +
            "&data%5Bterms_accepted%5D=1&wa_json_mode=1&need_redirects=1&contact_type=person";
    private Response response;

    public void doRequest() {
        response = given()
                .headers(getHeaders())
                .body(body)
                .when().post(URL);
    }


    private Map<String, String> getHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("content-type", "application/x-www-form-urlencoded; charset=UTF-8");
        return headers;
    }

    private String getBody(String firstName, String middleName, String lastName, String phone, String email, String birthday, String password, String password_confirm) {
        return String.format("{\"lastname\" :\"%s\",\"firstname\":\"%s\",\"middlename\":\"%s\" ,\"phone\":\"email\":\"%s\"," +
                "\"birthday\":\"%s\",\"password\":\"%s\",\"password_confirm\":\"%s\"}", lastName, firstName, middleName, phone, email, birthday, password, password_confirm);
    }
}
