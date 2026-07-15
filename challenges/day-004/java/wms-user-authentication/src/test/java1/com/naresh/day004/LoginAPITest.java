package com.naresh.day004;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class LoginAPITest {

    @BeforeClass
    public void setup() {
        // Base URL config kar rahe hain taaki har test me baar-baar na likhna pade
        RestAssured.baseURI = "http://localhost:8080";
    }

    @Test(priority = 1, description = "Valid credentials ke saath successful login test")
    public void testSuccessfulLogin() {
        // Correct Username aur Password jo aapke MySQL database me ho (Jaise 'amit' aur 'hash123')
        String validPayload = "{\"username\": \"amit\", \"password\": \"hash123\"}";

        System.out.println("--- Running: Successful Login Test ---");

        given()
            .contentType(ContentType.JSON)
            .body(validPayload)
        .when()
            .post("/api/users/login")
        .then()
            .statusCode(200) // Expecting HTTP 200 OK
            .contentType(ContentType.JSON)
            .body("status", equalTo("SUCCESSFUL"))
            .body("message", equalTo("Login Successful"))
            .body("user.username", equalTo("amit"))
            .log().all(); // Pure response ko console par dekhne ke liye
    }

    @Test(priority = 2, description = "Wrong credentials ke saath login failure test")
    public void testFailedLogin() {
        // Galat password wala payload
        String invalidPayload = "{\"username\": \"amit\", \"password\": \"wrongpassword\"}";

        System.out.println("\n--- Running: Failed Login Test ---");

        given()
            .contentType(ContentType.JSON)
            .body(invalidPayload)
        .when()
            .post("/api/users/login")
        .then()
            .statusCode(401) // Expecting HTTP 401 Unauthorized
            .contentType(ContentType.JSON)
            .body("status", equalTo("FAILED"))
            .body("message", equalTo("Invalid Username or Password"))
            .log().all();
    }
}