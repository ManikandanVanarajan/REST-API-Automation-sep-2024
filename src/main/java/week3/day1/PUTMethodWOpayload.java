package week3.day1;
import static io.restassured.RestAssured.given;

import java.util.HashMap;

public class PUTMethodWOpayload {

	public static void main(String[] args) {
	
		String url = "https://dev181577.service-now.com/api/now/table/{tableName}/{sysId}";
		
		HashMap<String, String> path_params = new HashMap<String, String>();
		path_params.put("tableName", "incident");
		path_params.put("sysId", "9516d1f6c3411210894e98fdd4013157");
		
		HashMap<String, String> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");
		
		given()
			.auth()
			.basic("admin", "-dGY8xu7e^WW")
			.pathParams(path_params)
			.headers(headers)
			.log().all()
		.when()
			.put(url)
		.then()
			.log().all()
			.assertThat()
			.statusCode(200);
		
		System.out.println("Incident updated successfully");

	}

}
