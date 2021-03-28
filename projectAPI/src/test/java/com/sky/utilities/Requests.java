package com.sky.utilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Requests {

    public static Response getRequest(String url) {

        return given().accept(ContentType.JSON).when().get(url);
    }

    public static Response postRequest(String url, String body) {

        return given().contentType(ContentType.JSON).body(body).when().post(url);
    }

    public static Response deleteRequest(String url) {
        return given().accept(ContentType.JSON).when().delete(url);
    }
}
