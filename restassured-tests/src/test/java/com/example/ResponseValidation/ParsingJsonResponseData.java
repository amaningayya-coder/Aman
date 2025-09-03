package com.example.ResponseValidation;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.json.JSONObject;


public class ParsingJsonResponseData {

	@Test(description="Approach1(minimal response validation)",priority=1)
	void testJsonResponseData() {
		//Approach1(minimal response validation)
		given()
		.contentType(ContentType.JSON)
		
		.when()
		.get("http://localhost:3000/store")
			
		
		.then()
		.statusCode(200)
		.header("Content-Type", "application/json")
		.body("employees[1].role",equalTo("Cashier"));
		
		
	}
	@Test(description = "Approach2(we can do all the validations)",priority=2)
	void testJsonResponseDataApproach2() {
		Response res=given()
		.contentType(ContentType.JSON)
		
		.when()
		.get("http://localhost:3000/store");
			
		
		Assert.assertEquals(res.statusCode(), 200);
		Assert.assertEquals(res.contentType(), "application/json");
		
		String roleName=res.jsonPath().get("employees[1].role").toString();
		Assert.assertEquals(roleName, "Cashier");
		System.out.println("Print the rolename:  "+roleName);
		
		
	}
	
	
	@Test(description = "Approach3(we can validate the data using jsonObject)",priority=3)
	void testJsonResponseDataApproach3() {
		Response res=given()
		.contentType(ContentType.JSON)
		
		.when()
		.get("http://localhost:3000/store");
			
		
		JSONObject ob=new JSONObject(res.asString()); //converting response to json object
		//validate the response data with unique data
		boolean status=false;
		for(int i=0;i<ob.getJSONArray("employees").length();i++){
			String empRole=ob.getJSONArray("employees").getJSONObject(i).get("role").toString();
			System.out.println(empRole);
			
			if(empRole.equals("Cashier")) {
				status=true;
				break;
			}
			
		}
		Assert.assertEquals(status, true);
		
		//validate the response price data
		double totalprice=0;
		
		for(int i=0;i<ob.getJSONArray("products").length();i++){
			String prodPrice=ob.getJSONArray("products").getJSONObject(i).get("price").toString();
			System.out.println(prodPrice);
			
			totalprice=totalprice+Double.parseDouble(prodPrice);
			
			System.out.println(totalprice);
			
		}
		Assert.assertEquals(totalprice, 49.98);
		
		
	}
	
	
}
