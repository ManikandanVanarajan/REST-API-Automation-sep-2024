package week3.day2;
import static io.restassured.RestAssured.given;
import java.util.HashMap;
import org.testng.annotations.Test;

public class CreateOAuthToken {
	
	private String access_token;

	@Test
	public void createOAuthToken() {
		
		String uri = "https://dev181577.service-now.com/oauth_token.do";
		
		HashMap<String, String> form_params = new HashMap<>();
		form_params.put("grant_type", "password");
		form_params.put("client_id", "80e32e5996774df09f695050151fa1db");
		form_params.put("client_secret", "Zu{TKji0N:");
		form_params.put("username", "admin");
		form_params.put("password", "-dGY8xu7e^WW");
		
		access_token = given()
			.header("Content-Type","application/x-www-form-urlencoded")
			.log().all()
		.when()
			.formParams(form_params)
			.post(uri)
		.then()
			.log().all()
			.extract()
			.jsonPath()
			.getString("access_token");
		System.out.println(access_token);
	}
	
	@Test
	public void validateGetCallWithBearerToken() {
		
		String uri = "https://dev181577.service-now.com/api/now/table/{tableName}"; 
		
		       given()
		       	   .header("Authorization","Bearer " + access_token)
				   .pathParam("tableName", "incident")
				   .log().all()
			   .when()
				   .get(uri)
			   .then()
				   .assertThat()
				   .statusCode(200)
				   .log().all();
	}

}
