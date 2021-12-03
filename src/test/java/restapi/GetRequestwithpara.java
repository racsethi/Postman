package restapi;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequestwithpara {

	 @Test
	 public void GetCall () {
		
		 RestAssured.baseURI = "http://localhost:7000";
		 RequestSpecification request = RestAssured.given();
		 Response response = request.param("id","1").get("/employees");
		 String  ResponseBody = response.body().asString();
		 System.out.println(ResponseBody);
		 
		 //    verify response code +++++++++++++++++++++++++++
		 
		 int ActResponse = response.statusCode();
		 int ExpResponse =200;
		 Assert.assertEquals(ActResponse,ExpResponse);
		 
		  /// ====== verfiy the headers ===================
		 
		 System.out.println(response.getHeaders());             // will give all headers
		 String ActHeader = response.getHeader("Content-Type");   // will give specific header
		 String ExpHeader = "application/json; charset = utf-8";
		 Assert.assertEquals(ActHeader, ExpHeader);
	 }
}
