package com.example.HealthcheckAPITest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class ReqRespHealthcheck {
	 @BeforeClass
	    public void setup() {
	        RestAssured.baseURI = "https://reqres.in";
	    }

	    // 🔹 Health check by hitting a known public endpoint
	    @Test
	    public void healthCheck() {
	        given()
	        .header("x-api-key", "reqres-free-v1")
	        .when()
	            .get("/api/users?page=2")
	        .then()
	            .statusCode(200); // API is healthy if we get 200 OK
	    }

	    // 🔹 Optional: validate expected response structure
	    @Test
	    public void validateHealthResponse() {
	        given()
	        .header("x-api-key", "reqres-free-v1")
	        .when()
	            .get("/api/users/2")
	        .then()
	            .statusCode(200)
	            .body("data.id", equalTo(2)); // checks if API returns expected data
	    }
}
