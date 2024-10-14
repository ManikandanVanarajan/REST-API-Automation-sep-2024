package week3.day1;

import static io.restassured.RestAssured.*;
import java.util.HashMap;
import org.testng.annotations.Test;

public class ServiceNowIncident extends BaseClass {
	
	@Test
	public void validateUserGetsAllRecrds() {
		
				given()
				   .pathParam("tableName", "incident")
				   .log().all()
				.when()
				   .get("/{tableName}")
				.then()
				   .assertThat()
				   .statusCode(200)
				   .log().all();	
		
	}
	
	@Test
	public void validateUserGetsSingleRecord() {
			
		HashMap<String, String> path_params = new HashMap<>();
		path_params.put("tableName", "incident");
		path_params.put("sysId", "f12ca184735123002728660c4cf6a7ef");
		
		given()		   													
		   .pathParams(path_params)
		   .log().all()
		.when()
		   .get("/{tableName}/{sysId}")
		.then()
		   .assertThat()
		   .statusCode(200)
		   .log().all();
	}

}
