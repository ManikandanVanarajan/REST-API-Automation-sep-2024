package week3.day2;

import static io.restassured.RestAssured.given;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

import io.restassured.http.Header;
import io.restassured.response.Response;

public class ValidateDeserialization {

	public static void main(String[] args) {
		
		String url = "https://dev181577.service-now.com/api/now/table/{tableName}";	
		String payload = """
				{
		       		"description": "Create POST with payload",
		       		"short_description": "REST API 2024",
		       		"state": "1",
		       		"urgency": "1",
		       		"company": {
				            "link": "https://dev181577.service-now.com/api/now/table/core_company/31bea3d53790200044e0bfc8bcbe5dec",
				            "value": "31bea3d53790200044e0bfc8bcbe5dec"
				        		}
		       	}
		
				""";
		
		Response response = given()
			.auth()
			.basic("admin", "-dGY8xu7e^WW")
			.pathParam("tableName", "incident")
			   .header(new Header("Content-Type","application/json"))
			   .log().all()
		    .when()
		       .body(payload)
			   .post(url);
		
		System.out.println(response.asPrettyString());
		
		Result result = response.getBody().jsonPath().getObject("result", Result.class);
		System.out.println(result.getSys_id());	
		System.out.println(result.getDescription());
		System.out.println(result.getShort_description());
		System.out.println(result.getNumber());
		System.out.println(result.getCompany().getLink());
			System.out.println(result.getCompany().getValue());
		 
		
		MatcherAssert.assertThat("Create POST with payload", Matchers.equalTo(result.getDescription()));
		System.out.println("Incident created successfully");
			
	 }
}
