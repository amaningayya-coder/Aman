package com.example.HeaderValidation;


import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class LoggingDemo {

	@Test
	void logtest()
	{
		given()
		
		.when()
		.get("https://reqres.in/api/users?page=2")
		
		.then()
		//.log().headers();
		//.log().body();
		//.log().cookies();
		//.log().status();
		.log().all();
		
	}
}
