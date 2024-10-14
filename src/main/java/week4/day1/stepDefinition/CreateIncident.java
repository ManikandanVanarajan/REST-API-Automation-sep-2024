package week4.day1.stepDefinition;

import static io.restassured.RestAssured.authentication;
import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.basic;
import static io.restassured.RestAssured.given;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;


public class CreateIncident {
	
	Response response;
	
	@Given("User has Entered the BaseURI")
	public void user_has_entered_the_base_uri() {
	   baseURI = "https://dev181577.service-now.com/";
	}
	@Given("User has entered the BasePath")
	public void user_has_entered_the_base_path() {
		basePath = "api/now/table/{tableName}";
	}
	@Given("User has entered authentication")
	public void user_has_entered_authentication() {
	    authentication = basic("admin","-dGY8xu7e^WW");
	}
	@When("User creating a New Incident without Payload")
	public void user_creating_a_new_incident_without_payload() {
	  
		response = given()
			.pathParam("tableName", "/incident")
			.header("Content-Type","application/json")
			.log().all()
		.when()
			.post();					
		
	}
	@When("User creating a New Incident with Payload as {string}")
	public void user_creating_a_new_incident_with_payload_as(String inputPayload) {
		response = given()
				.pathParam("tableName", "/incident")
				.header("Content-Type","application/json")
				.log().all()
			.when()
				.body(inputPayload)
				.post();	
	}
	@Then("Validate the status code is displayed as {int}")
	public void validate_the_status_code_is_displayed_as(Integer statusCode) {
		response.then().log().all().assertThat().statusCode(statusCode);
	   
	}

}
