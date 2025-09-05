package com.example.CredOperation;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Test01_POST {
	@Test
	public void Test01() {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "Aman");
		map.put("job", "Software Engineer");

		System.out.println(map);
		JSONObject request = new JSONObject(map);
		System.out.println(request);

	}

	@Test
	public void Test02_POST() {
		JSONObject request = new JSONObject();
		request.put("name", "Aman");
		request.put("job", "Software Engineer");
		System.out.println(request.toJSONString());

		given().header("Content-Type", "Application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(request.toJSONString()).when().post("https://reqres.in/api/users").then().statusCode(401).log()
				.all();
	}

}
