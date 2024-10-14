package week3.day2;

import static io.restassured.RestAssured.given;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.http.Header;

public class DataDrivenSerialization {

	@DataProvider
	public String[][] getData() 
	{
		return new String[][] 
		{
			{"POST method with payload-1","RESTAPI2024-1","1","1"},
			{"POST method with payload-2","RESTAPI2024-2","1","1"},
			{"POST method with payload-3","RESTAPI2024-3","1","1"},
			{"POST method with payload-4","RESTAPI2024-4","1","1"},
			{"POST method with payload-5","RESTAPI2024-5","1","1"}
		};
		
	}
	
	@Test(dataProvider="getData")
	public void createNewIncident(String description, String shortDescription, String state, String urgency) 
	{		
		String url = "https://dev181577.service-now.com/api/now/table/{tableName}";			
		IncidentSerializationExample incident1 = new IncidentSerializationExample();
		incident1.setDescription(description);
		incident1.setShort_description(shortDescription);
		incident1.setState(state);
		incident1.setUrgency(urgency);
		
		given()
			.auth()
			.basic("admin", "-dGY8xu7e^WW")
			.pathParam("tableName", "incident")
			   .header(new Header("Content-Type","application/json"))
			   .log().all()
		    .when()
		       .body(incident1)
			   .post(url)
			.then()
			   .log().all()
			   .assertThat()
			   .statusCode(201); 		
			System.out.println("Incident created successfully");
			
	}
	
}
