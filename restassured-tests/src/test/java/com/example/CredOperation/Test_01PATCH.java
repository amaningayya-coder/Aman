package com.example.CredOperation;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Test_01PATCH {
	@Test
	public void Patch_01() {
		JSONObject request = new JSONObject();
		request.put("name", "Aman");
		request.put("job", "Software Engineer");
		System.out.println(request.toJSONString());

		given().header("Content-Type", "Application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(request.toJSONString()).when().patch("https://reqres.in/api/users/2").then().statusCode(401).log()
				.all();
	}
}
