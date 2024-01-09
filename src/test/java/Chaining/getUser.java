package Chaining;

import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class getUser {

	
    @Test
	void test_getUser(ITestContext context)
	{
		int id = (int) context.getAttribute("user_id"); // this id is comes through createUser request
		
		String bearerToken="c32e10e7656f1137755227bcef290e997b4v8h997a8ee254eec24aed66b06";
		given()
		    .headers("Authorization","Bearer" +bearerToken)
		    .pathParam("id", id)
		.when()
		    .get("https://gorest.co.in/public/v2/users/{id}")  // id is connected with get request
		
		.then()
		    .statusCode(200)
		    .log().all();
	}
}
	
	
	

