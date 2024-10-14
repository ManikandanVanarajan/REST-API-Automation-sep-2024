package week3.day1;
import static io.restassured.RestAssured.*;
import java.util.HashMap;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.http.Header;

public class ServiceNowIncidentChainRequest extends BaseClass {
	
	@Test(priority=0)
	public void CreateNewIncident() {
		
		sys_id = given()
		    .pathParam("tableName", "incident")
			.header(new Header("Content-Type","application/json"))
			.log().all()
		.when()
			.post("/{tableName}")
		.then()
			.log().all()
			.assertThat()
			.statusCode(201)
			.statusLine(containsString("Create"))
			.contentType(ContentType.JSON)
			.extract()
			.jsonPath()
			.getString("result.sys_id");
		
		System.out.println(sys_id);
	}
	
	@Test(priority=1)
	public void validateUserGetsSingleRecord() {
			
		HashMap<String, String> path_params = new HashMap<>();
		path_params.put("tableName", "incident");
		path_params.put("sysId", sys_id);
		
		given()		   													
		   .pathParams(path_params)
		   .log().all()
		.when()
		   .get("/{tableName}/{sysId}")
		.then()
		   .assertThat()
		   .statusCode(200)
		   .statusLine(containsString("OK"))
		   .contentType(ContentType.JSON)
		   .log().all()
		   .body("result.sys_id",equalTo(sys_id));
	}
	
	@Test(priority=2)
	public void updateIncidentPUTMethod() {
		
	given()
		.pathParam("tableName","incident")
		.pathParam("sysId", sys_id)
		.header(new Header("Content-Type","application/json"))
		.log().all()
	.when()
		.put("/{tableName}/{sysId}")
	.then()
		.log().all()
		.assertThat()
		.statusCode(200)
	    .statusLine(containsString("OK"))
	    .contentType(ContentType.JSON);
	}
	
	@Test(priority=3)
	public void deleteExistingRecord() {
			
		HashMap<String, String> path_params = new HashMap<>();
		path_params.put("tableName", "incident");
		path_params.put("sysId", sys_id);
		
		given()		   													
		   .pathParams(path_params)
		   .log().all()
		.when()
		   .delete("/{tableName}/{sysId}")
		.then()
		   .assertThat()
		   .statusCode(204)
		   .statusLine(containsString("No Content"))
		   .log().all();
	}
	

	@Test(priority=4)
	public void validateExistingRecordDeletedSuccessfully() {
			
		HashMap<String, String> path_params = new HashMap<>();
		path_params.put("tableName", "incident");
		path_params.put("sysId", sys_id);
		
		given()		   													
		   .pathParams(path_params)
		   .log().all()
		.when()
		   .get("/{tableName}/{sysId}")
		.then()
		   .assertThat()
		   .statusCode(404)
		   .statusLine(containsString("Not Found"))
		   .contentType(ContentType.JSON)
		   .log().all();
	}

}
