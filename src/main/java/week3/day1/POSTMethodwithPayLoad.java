package week3.day1;
import static io.restassured.RestAssured.given;

import java.io.File;

import io.restassured.http.Header;

public class POSTMethodwithPayLoad {

	public static void main(String[] args) {
		
		String url = "https://dev181577.service-now.com/api/now/table/{tableName}";	
		String payload = """
				{
		       		"description": "Create POST with payload",
		       		"short_description": "REST API 2024",
		       		"state": "1",
		       		"urgency": "1"
		       	}
		
				""";
		
		Incident incident = new Incident();
		incident.setDescription("Call POST with payload");
		incident.setShort_description("REST API 2024 SEP");
		incident.setState("1");
		incident.setUrgency("1");
		
		given()
			.auth()
			.basic("admin", "-dGY8xu7e^WW")
			.pathParam("tableName", "incident")
			   .header(new Header("Content-Type","application/json"))
			   .log().all()
		    .when()
		       .body(incident)
			   .post(url)
			.then()
			   .log().all()
			   .assertThat()
			   .statusCode(201); 		
			System.out.println("Incident created successfully");
			

	}

}
