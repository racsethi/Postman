package restapi;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

public class PostRequestwithJsonFile {

	 @Test
	 public void PostCall () {
		
		 RestAssured.baseURI = "http://localhost:7000";
		 RequestSpecification request = RestAssured.given();
		 String ResponseBody = response.body().asString();
		 System.out.println(ResponseBody);
		 int ActResponse = response.statusCode();
		 int ExpResponse =201;
		 
		 Assert.assertEquals(ActResponse,ExpResponse);
		 JsonPath jpath = response.JsonPath();
		 String ActName = jpath.get("name");
		 String Expname ="James";
		 Assert.assertEquals(ActName, ExpName);
		 
}

	 public String ReadJsonFile(String FileName) throws IOException {
		 String data = new String(Files.readAllBytes(Paths.get(FileName)));
		 return data;
	 }
	 }