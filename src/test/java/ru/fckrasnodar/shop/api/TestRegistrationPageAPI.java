package ru.fckrasnodar.shop.api;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.Is.is;

public class TestRegistrationPageAPI {

    @Test
    public void testRegistrationPage(){
        String URL = "https://shop.fckrasnodar.ru/signup/";
        String body = "data%5Blastname%5D=23@#$%\n" +
                "&data%5Bfirstname%5D=\n" +
                "&data%5Bmiddlename%5D=\n" +
                "&data%5Bphone%5D=%2B0+000+000-00-00\n" +
                "&data%5Bemail%5D=test%40test007.com\n" +
                "&data%5Bbirthday%5D%5Bday%5D=1&data%5Bbirthday%5D%5Bmonth%5D=6&data%5Bbirthday%5D%5Byear%5D=988\n" +
                "&data%5Bpassword%5D=0123rR!%40%23\n" +
                "&data%5Bpassword_c\n" +
                "&data%5Bterms_accepted%5D=1&wa_json_mode=1&need_redirects=1&contact_type=person";
        given()
                .header("content-type","application/x-www-form-urlencoded; charset=UTF-8")
                .header("x-requested-with","XMLHttpRequest")
                .body(body).
                when().
                post(URL)
                .then().log().all()
                .statusCode(200)
                .body("status",is("fail"));
    }
}

