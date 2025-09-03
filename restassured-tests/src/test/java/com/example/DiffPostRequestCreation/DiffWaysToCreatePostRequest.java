package com.example.DiffPostRequestCreation;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

/*
 Different ways to create post request body
 1)post request body using hashmap
 2)Post request body creation using org.json
 3)post request body creation using POJO class
 4)post request body creation using Json file data
 */
public class DiffWaysToCreatePostRequest {
	int id;

	@Test(description = "post request body using hashmap", priority = 1)
	public void testPostRequestUsingHashMap() {
		HashMap data = new HashMap();
		data.put("name", "Amaningayya");
		data.put("Location", "Bangalore");
		data.put("phone", "7540019837");

		String courseArr[] = { "c#", "Java" };
		data.put("courses", courseArr);

		given().header("content-type", "application/json").header("x-api-key", "reqres-free-v1").body(data)

				.when().post("https://reqres.in/api/users")

				.then().statusCode(201).body("name", equalTo("Amaningayya")).body("Location", equalTo("Bangalore"))
				.body("phone", equalTo("7540019837")).body("courses[0]", equalTo("c#"))
				.body("courses[1]", equalTo("Java")).header("Content-Type", "application/json; charset=utf-8").log()
				.all();
	}

	@Test(description = "Post request body creation using org.json", priority = 2)
	public void testPostRequestUsingJsonLibrary() {

		JSONObject data = new JSONObject();
		data.put("name", "Scott");
		data.put("Location", "France");
		data.put("phone", "125487499");

		String courseArr[] = { "c", "c++" };
		data.put("courses", courseArr);

		id = given().header("content-type", "application/json").header("x-api-key", "reqres-free-v1")
				.body(data.toString())

				.when().post("https://reqres.in/api/users").body().jsonPath().getInt("id");
	}

	@Test(priority = 3, dependsOnMethods = { "testPostRequestUsingJsonLibrary" })
	public void Deleteuser() {
		given().header("content-type", "application/json").header("x-api-key", "reqres-free-v1")

				.when().delete("https://reqres.in/api/users/" + id)

				.then().statusCode(204).log().all();
	}

	@Test(description = "Post request body creation using POJO class", priority = 4)
	public void testPostPOJOClass() {

		Pojo_Postrequest data = new Pojo_Postrequest();
		data.setName("Scott");
		data.setLocation("France");
		data.setPhone("125487499");

		String courseArr[] = { "c", "c++" };
		data.setCourses(courseArr);

		id = given().header("content-type", "application/json").header("x-api-key", "reqres-free-v1").body(data)

				.when().post("https://reqres.in/api/users").body().jsonPath().getInt("id");
	}

	@Test(priority = 5, dependsOnMethods = { "testPostPOJOClass" })
	public void UpdateUser() {
		Pojo_Postrequest data = new Pojo_Postrequest();
		data.setName("Tiger");
		data.setLocation("Bangalore");
		data.setPhone("45764763883");

		String courseArr[] = { "C#", "JAVA" };
		data.setCourses(courseArr);

		given().header("content-type", "application/json").header("x-api-key", "reqres-free-v1").body(data)

				.when().put("https://reqres.in/api/users/" + id)

				.then()

				.statusCode(200).body("name", equalTo("Tiger")).body("location", equalTo("Bangalore"))
				.body("phone", equalTo("45764763883")).body("courses[0]", equalTo("C#"))
				.body("courses[1]", equalTo("JAVA")).header("Content-Type", "application/json; charset=utf-8").log()
				.all();

	}

	@Test(priority = 6, dependsOnMethods = { "UpdateUser" })
	public void DeletePojoUser() {
		given().header("content-type", "application/json").header("x-api-key", "reqres-free-v1")

				.when().delete("https://reqres.in/api/users/" + id)

				.then().statusCode(204).log().all();
	}

	@Test(description = "post request body creation using Json file data", priority = 1)

	public void testPostReqUsingExternalJsonFile() throws FileNotFoundException {

		File f = new File(".\\body.json");

		FileReader fr = new FileReader(f);

		JSONTokener jt = new JSONTokener(fr);

		JSONObject data = new JSONObject(jt);

		id = given().header("content-type", "application/json").header("x-api-key", "reqres-free-v1")
				.body(data.toString())

				.when().post("https://reqres.in/api/users").body().jsonPath().getInt("id");
	}

	@Test(priority = 2, dependsOnMethods = { "testPostReqUsingExternalJsonFile" })
	public void UpdateJsonUser() throws FileNotFoundException {
		File f = new File(".\\body.json");

		FileReader fr = new FileReader(f);

		JSONTokener jt = new JSONTokener(fr);

		JSONObject data = new JSONObject(jt);

		given().header("content-type", "application/json").header("x-api-key", "reqres-free-v1").body(data.toString())

				.when().put("https://reqres.in/api/users/" + id)

				.then()

				.statusCode(200).body("name", equalTo("Tiger")).body("location", equalTo("Bangalore"))
				.body("phone", equalTo("45764763883")).body("courses[0]", equalTo("C#"))
				.body("courses[1]", equalTo("JAVA")).header("Content-Type", "application/json; charset=utf-8").log()
				.all();

	}

	@Test(priority = 3, dependsOnMethods = { "UpdateJsonUser" })
	public void DeleteJsonFileUser() {
		given().header("content-type", "application/json").header("x-api-key", "reqres-free-v1")

				.when().delete("https://reqres.in/api/users/" + id)

				.then().statusCode(204).log().all();
	}

}
