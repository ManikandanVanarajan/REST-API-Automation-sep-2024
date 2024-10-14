package week4.day2.stepDefinitions;

import java.util.List;

import org.hamcrest.Matchers;

import com.google.gson.Gson;

import static io.restassured.RestAssured.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import week4.day2.runner.PojoSerialization;

public class IncidentService {
	
	PojoSerialization pojo = new PojoSerialization();
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
	@When("/^send the post request for the incident with (.*) shortDescription$/")
	public void send_the_post_request_for_the_incident_with_restapi2024_short_description(String shortDescription) {
	    
		pojo.setShort_description(shortDescription);
	}
	@When("/^send the post request for the incident with (.*) description$/")
	public void send_the_post_request_for_the_incident_with_rest_post_call_description(String description) {
	    
		pojo.setDescription(description);
		
		response = given()
				.pathParam("tableName", "/incident")
				.header("Content-Type","application/json")
				.log().all()
			.when()
				.body(new Gson().toJson(pojo))
				.post();
	}
	@Then("validate the record created successfully")
	public void validate_the_record_created_successfully(io.cucumber.datatable.DataTable dataTable) {
	   
		List<List<String>> cells = dataTable.cells();		
		for(int i=1; i<cells.size();i++)
		{
			response.then()
					.assertThat()
					.statusCode(Integer.parseInt(cells.get(i).get(0)))
					.statusLine(Matchers.containsString(cells.get(i).get(1)))
					.contentType(cells.get(i).get(2));
		}
	}
	
	@Then("Validate the status code is displayed as {int}")
	public void validate_the_status_code_is_displayed_as(Integer statusCode) {
		response.then().log().all().assertThat().statusCode(statusCode);
	   
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

}
