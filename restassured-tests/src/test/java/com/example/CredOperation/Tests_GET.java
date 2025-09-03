package com.example.CredOperation;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Tests_GET {
	@Test
	void test_01() {
		given().get("https://reqres.in/api/users?page=2").then().statusCode(200).body("data.id[1]", equalTo(8))
				.body("support.url", equalTo("https://reqres.in/#support-heading"))
				.body("data.first_name", hasItems("Michael", "Lindsay", "Tobias", "Byron"))
				.body("data.email",
						hasItems("george.edwards@reqres.in", "rachel.howell@reqres.in", "byron.fields@reqres.in",
								"tobias.funke@reqres.in"))
				.body("data.last_name", hasItems("Lawson", "Howell", "Edwards", "Funke", "Fields"))
				.body("support.text",
						equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"))
				.log().all();
	}

}
