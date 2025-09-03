package com.example.HeaderValidation;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.example.listners.ExtentTestNGListener;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

public class HeaderDemo {
	
	@Test(priority=1)
		void testHeaders() {
			
			given()
			
			.when()
			.get("https://www.google.com/")
			
			
			.then()
			.header("Content-Type", "text/html; charset=ISO-8859-1")
			.header("Content-Encoding", "gzip")
			.header("Server", "gws")
			.log().headers();
			
			
			
		}
		
		@Test(priority=2)
				void getHeaders1() {
					
					Response res=given()
					
					.when()
					.get("https://www.google.com/");
					
					//Get the single header information
					String headerValue=res.getHeader("Content-type");
					System.out.println("Content t-pe of the header:"+headerValue);
					
				Headers	myHeaders=res.getHeaders();
				System.out.println("Print the header information");
				for(Header hd:myHeaders) {
					System.out.println(hd.getName()+"   "+hd.getValue());
				}
					
					
					
				}
}
