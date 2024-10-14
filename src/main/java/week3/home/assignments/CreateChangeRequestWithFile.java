package week3.home.assignments;

import static io.restassured.RestAssured.given;
import java.io.File;
import org.testng.annotations.Test;
import io.restassured.http.Header;


public class CreateChangeRequestWithFile extends BaseClassChangeRequest {
	
	@Test
	public void createNewChangeRequest() {
		
		given()
			.pathParam("tableName", "change_request")
		    .header(new Header("Content-Type","application/json"))
		    .log().all()
	   .when()
	       	.body(new File("src/main/resources/request-payload/changeRequestBody.json"))
	       	.post("/{tableName}")
		.then()
		   	.log().all()
		   	.assertThat()
		   	.statusCode(201); 	
		
		System.out.println("Change Request created successfully");
		
	}

}
