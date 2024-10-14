package week3.day1;

import static io.restassured.RestAssured.*;
import io.restassured.http.Header;

public class POSTMethodWOpayload {

	public static void main(String[] args) {
		
		String url = "https://dev181577.service-now.com/api/now/table/{tableName}";
		
		given()
		   .auth()
		   .basic("admin", "-dGY8xu7e^WW")
		   .pathParam("tableName", "incident")
		   .header(new Header("Content-Type","application/json"))
		   .log().all()
	    .when()
		   .post(url)
		.then()
		   .log().all()
		   .assertThat()
		   .statusCode(201); 		
		System.out.println("Incident created successfully");
	}
}
