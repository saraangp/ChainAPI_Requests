package Chaining;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class CreateUser {

	@Test
       public void testCreateUser(ITestContext context) {  // for make this "id" for other test we need to 'ITestContext listener
		
		Faker faker = new Faker();   // create the dummy data using - faker class
		
		JSONObject data = new JSONObject();  // creating the request body using - JSONObject 
		
		data.put("name",faker.name().fullName());
		data.put("gender", "Male");
		data.put("email",faker.internet().emailAddress());
		data.put("Status", "inactive");
		
		String bearerToken= "c32e10e7656f1137755227bcef290e997b4v8h997a8ee254eec24aed66b06";
		
		int id= given()                                      // store the id into id variable
		    .headers("Authorization","Bearer "+bearerToken)
		    .contentType("application/json")
		    .body(data.toString())
		    
		.when()
		    .post("https://gorest.co.in/public/v2/users")
		    .jsonPath().getInt("id");                         // capture the id
		
		System.out.println("Generated the id" +id); // print the id on console
	
		context.setAttribute("user_id", id);   // creating variable - for refer the "id" to another requests
	}
	
	
}

	
	
	

