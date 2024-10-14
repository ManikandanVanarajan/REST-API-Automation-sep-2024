package week3.day2;

import static io.restassured.RestAssured.given;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

import io.restassured.response.Response;

public class ValidateDeserializationWithArrayAsResponse {
	
	public static void main(String[] args) {
		
		String uri = "https://dev181577.service-now.com/api/now/table/{tableName}"; 
		
	Response response = given()
				   			.auth()
				   			.basic("admin", "-dGY8xu7e^WW")
				   			.pathParam("tableName", "incident")
				   			.log().all()
				   		.when()
				   			.get(uri);
	
	 MatcherAssert.assertThat(response.getStatusCode(), Matchers.equalTo(200));
	 MatcherAssert.assertThat(response.getStatusLine(), Matchers.containsString("OK"));
	 
	 Result[] results = response.getBody().jsonPath().getObject("result", Result[].class);
	 
	 for (Result result: results)
	 {
		 System.out.println(result.getSys_id());
		
	 }
	}

}
