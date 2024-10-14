package com.restsession;

import io.restassured.RestAssured;

public class RestAssured_1stScript {

	public static void main(String[] args) {
		
		String uri = "https://dev181577.service-now.com/api/now/table/{tableName}"; 
		RestAssured.given()
				   .auth()
				   .basic("admin", "-dGY8xu7e^WW")
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
