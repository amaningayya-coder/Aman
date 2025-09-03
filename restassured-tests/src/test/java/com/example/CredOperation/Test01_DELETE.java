package com.example.CredOperation;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class Test01_DELETE {
	@Test
	public void delete_01() {
		when().delete("https://reqres.in/api/users/2").then().statusCode(204).log().all();
	}
}
