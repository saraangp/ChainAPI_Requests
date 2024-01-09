package Chaining;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class updateUser {

	@Test
	void test_updateUser(ITestContext context)
	{
        Faker faker = new Faker();   
		
		JSONObject data = new JSONObject();  
		
		data.put("name",faker.name().fullName());
		data.put("gender", "Male");
		data.put("email",faker.internet().emailAddress());
		data.put("Status", "active");
		
		String bearerToken= "c32e10e7656f1137755227bcef290e997b4v8h997a8ee254eec24aed66b06";
		
		int id = (int) context.getAttribute("user_id");  // this id comes from create user
		
		    given()  
		    .headers("Authorization","Bearer "+bearerToken)
		    .contentType("application/json")
		    .pathParam("id", id)
		    .body(data.toString())
		    
		.when()
		    .put("https://gorest.co.in/public/v2/users/{id}")
		   
		.then()   
		    .statusCode(200)
		    .log().all();
		
	}
	
	
	
	
	
	
	
}
