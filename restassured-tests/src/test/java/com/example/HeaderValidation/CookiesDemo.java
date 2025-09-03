package com.example.HeaderValidation;

import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

public class CookiesDemo{

	@Test(priority=1)
	public void testCookies() {
		
		given()
		
		.when()
		.get("https://www.google.com/")
		
		
		.then()
		.cookie("AEC","AVh_V2gGJ_acFq4oNTa8Y2XXHwNN31Ulv92m3PRB7xqFfBOqjjFMY0Q0Aw")
		.log().all();
		
		
	}
@Test(priority=2)
 public void getCookiesinfo() {
	
	Response res=given()
		
		.when()
		.get("https://www.google.com/");
		
//		String cookie_value=res.getCookie("AEC");
//		System.out.println("Value of the cookie===>"+cookie_value);
		
		Map<String,String> cookies_Value=res.getCookies();
		//System.out.println(cookies_Value.keySet());
		
		for(String k:cookies_Value.keySet()) {
		String cookie_value=res.getCookie(k);
		System.out.println(k+"    "+cookie_value);	
		}
		
		
		
		
//		.then()
//		.cookie("AEC","AVh_V2gGJ_acFq4oNTa8Y2XXHwNN31Ulv92m3PRB7xqFfBOqjjFMY0Q0Aw")
//		.log().all();
		
		
	}
}
