package com.example.CredOperation;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

/*
 *given()
 *content type,set cockies add auth,add param,set headers info etc....
 *when()
 *get, post put delete
 *then()
 *validate status code,extract response,extract headers cockies & response body
 */
public class CREDOperation {
	
	int id;
	@Test(priority=1)
	void getUsers() {
		
		given().when().get("https://reqres.in/api/users?page=2")
		
		.then().statusCode(200)
		.body("page",equalTo(2))
		.log().all();
	}
	@Test(priority=2)
	void CreateUsers() {
		
		Map requestBody = new HashMap<Object, Object>();
		requestBody.put("name", "Aman");
		requestBody.put("job", "QA Engineer");
		
		id=given()
		.header("content-type", "application/json")
		.header("x-api-key", "reqres-free-v1")
	    .body(requestBody)
		
		.when()
		.post("https://reqres.in/api/users")
		.jsonPath().getInt("id");
		
		
//		.then()
//		.statusCode(201)
//		.log().all();
		
		
		
	}
	@Test(priority=3, dependsOnMethods = {"CreateUsers"})
	void UpdateUser() {
		Map requestBody = new HashMap();
		requestBody.put("name", "Amayya Hiremath");
		requestBody.put("job", "Automation Tester");
		
		String courseArr[]= {"c","c++"};
		requestBody.put("courses", courseArr);
		
		
		given()
		.header("content-type", "application/json")
		.header("x-api-key", "reqres-free-v1")
	    .body(requestBody)
		
		.when()
		.put("https://reqres.in/api/users/"+id)
		
		.then()
		
		.statusCode(200)
		.body("name", equalTo("Amayya Hiremath"))
		.body("job", equalTo("Automation Tester"))
		.body("courses[0]", equalTo("c"))
		.body("courses[1]", equalTo("c++"))
		.header("Content-Type", "application/json; charset=utf-8")
		.log().all();
		
	}
	@Test(priority=4)
	void Deleteuser() {
		given()
		.header("content-type", "application/json")
		.header("x-api-key", "reqres-free-v1")
		
		.when()
		.delete("https://reqres.in/api/users/"+id)
		
		.then()
		.statusCode(204)
		.log().all();
	}

}
