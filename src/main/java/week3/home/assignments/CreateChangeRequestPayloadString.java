package week3.home.assignments;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateChangeRequestPayloadString {
	
	public static void main(String[] args) {
        // Base URI and authentication setup
        baseURI = "https://dev181577.service-now.com";
        authentication = basic("admin", "-dGY8xu7e^WW");
        
        // Create a new change request
        createChangeRequest();
    }

    public static void createChangeRequest() {
        // Change request Payload
        String changeRequestPayload = """
        	{	
        		"short_description": "Test Change Request",
                "description": "Created via RestAssured"
            }          
        		""";

        // Sending POST request to create change request
        Response response = 
        given()
                .contentType(ContentType.JSON)
                .body(changeRequestPayload)
                .post("/api/now/table/change_request");

        // Print response to console
        System.out.println("Create Change Request Response: ");
        response.prettyPrint();
    }


}
