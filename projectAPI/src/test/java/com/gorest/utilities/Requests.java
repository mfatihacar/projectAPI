package com.gorest.utilities;

import com.gorest.URLHelper;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.assertj.core.util.Maps;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class Requests {

    private static final Map<String, String> headers =
            Maps.newHashMap("Authorization", URLHelper.ACCESS_TOKEN);

    public static Response getRequest(String url) {
        return given().accept(ContentType.JSON).when().get(url);
    }

    public static Response postRequest(String url, String body, boolean isAuthorised) {
        if (isAuthorised) {
            return given().contentType(ContentType.JSON)
                    .headers(headers)
                    .body(body)
                    .when()
                    .post(url);
        } else {
            return given().contentType(ContentType.JSON).body(body).when().post(url);
        }
    }

    public static Response patchRequest(String url, String body, boolean isAuthorised) {
        if (isAuthorised) {
            return given().contentType(ContentType.JSON)
                    .headers(headers)
                    .body(body)
                    .when()
                    .patch(url);
        } else {
            return given().contentType(ContentType.JSON).body(body).when().patch(url);
        }
    }

    public static Response deleteRequest(String url, boolean isAuthorised) {
        if (isAuthorised) {
            return given().accept(ContentType.JSON).headers(headers).when().delete(url);
        } else {
            return given().accept(ContentType.JSON).when().delete(url);
        }
    }
}
