package Chaining;

import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class deleteUser {

	@Test
	void test_deleteUser(ITestContext context)
	{
        String bearerToken= "c32e10e7656f1137755227bcef290e997b4v8h997a8ee254eec24aed66b06";
		
        int id = (int) context.getAttribute("user_id");  // id is comes  from create user
		
		given()
		   .headers("Authorization","Bearer"+bearerToken)
		   .pathParam("id", id)
		
		.when()
		   .delete("https://gorest.co.in/public/v2/users/{id}")
		
		.then()
		    .statusCode(204)
		    .log().all();
		
	}
	
}
