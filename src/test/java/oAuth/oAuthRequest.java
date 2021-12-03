package oAuth;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class oAuthRequest {
	@Test
	public void PostCall() {
		
	
		RestAssured.given()
		                 .auth()
		                 .oauth2("123")
		                 .contentType(ContentType.JSON)
		                 .accept(ContentType.JSON)
		                 .body("{\n"  +
		                   "    \"name\": \"PostmanTest\",\n" +
		                   "    \"desription\": \"Test Repo\",\n" +
		                   "	   \"homepage\" : \"https://github.com/\", \n" +
		                   "	  \"has__issues\": true,\n" +
		                   "   \"has_projects\": true,\n" +
		                  "	    \"has_wiki\": true,\n" +
		                  "	}")
		                 .when()
		                 .post("/user/repos")
		                 .then()
		                 .statusCode(201)
		                 .log()
		                 .all();
	}

}
