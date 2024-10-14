package week3.home.assignments;

import static io.restassured.RestAssured.authentication;
import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.basic;

import org.testng.annotations.BeforeMethod;

public class BaseClassChangeRequest {
	
	@BeforeMethod
	public void setUp() {
		
		baseURI = "https://dev181577.service-now.com";
		basePath = "/api/now/table/"; 
		authentication = basic("admin", "-dGY8xu7e^WW");
	}

}
