package week3.day2;
import java.util.HashSet;
import java.util.Set;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

import io.restassured.path.json.JsonPath;

public class JsonPathPractise {

	public static void main(String[] args) {
		
		//Retrieve value from Json response by using JsonPath class which comes from restassured	
		//Example: 1
		String json = """				
				{
				    "result": {
				        "parent": "",
				        "made_sla": "true",
				        "caused_by": "",
				        "watch_list": "",
				        "upon_reject": "cancel",
				        "sys_updated_on": "2024-10-09 13:57:19",
				        "child_incidents": "0",
				        "hold_reason": "",
				        "origin_table": "",
				        "task_effective_number": "INC0010069",
				        "approval_history": "",
				        "number": "INC0010069",
				        "resolved_by": "",
				        "sys_updated_by": "admin",
				        "opened_by": {
				            "link": "https://dev181577.service-now.com/api/now/table/sys_user/6816f79cc0a8016401c5a33be04be441",
				            "value": "6816f79cc0a8016401c5a33be04be441"
				        },
				        "user_input": "",
				        "sys_created_on": "2024-10-09 13:57:19",
				        "sys_domain": {
				            "link": "https://dev181577.service-now.com/api/now/table/sys_user_group/global",
				            "value": "global"
				        },
				        "state": "1",
				        "route_reason": "",
				        "sys_created_by": "admin",
				        "knowledge": "false",
				        "order": "",
				        "calendar_stc": "",
				        "closed_at": "",
				        "cmdb_ci": "",
				        "delivery_plan": "",
				        "contract": "",
				        "impact": "3",
				        "active": "true",
				        "work_notes_list": "",
				        "business_service": "",
				        "business_impact": "",
				        "priority": "5",
				        "sys_domain_path": "/",
				        "rfc": "",
				        "time_worked": "",
				        "expected_start": "",
				        "opened_at": "2024-10-09 13:57:19",
				        "business_duration": "",
				        "group_list": "",
				        "work_end": "",
				        "caller_id": "",
				        "reopened_time": "",
				        "resolved_at": "",
				        "approval_set": "",
				        "subcategory": "",
				        "work_notes": "",
				        "universal_request": "",
				        "short_description": "RESTAPIS_29Sep2024_home assignments",
				        "close_code": "",
				        "correlation_display": "",
				        "delivery_task": "",
				        "work_start": "",
				        "assignment_group": "",
				        "additional_assignee_list": "",
				        "business_stc": "",
				        "cause": "",
				        "description": "",
				        "origin_id": "",
				        "calendar_duration": "",
				        "close_notes": "",
				        "notify": "1",
				        "service_offering": "",
				        "sys_class_name": "incident",
				        "closed_by": "",
				        "follow_up": "",
				        "parent_incident": "",
				        "sys_id": "3f8cea43c3c5d610894e98fdd4013135",
				        "contact_type": "",
				        "reopened_by": "",
				        "incident_state": "1",
				        "urgency": "3",
				        "problem_id": "",
				        "company": "",
				        "reassignment_count": "0",
				        "activity_due": "",
				        "assigned_to": "",
				        "severity": "3",
				        "comments": "",
				        "approval": "not requested",
				        "sla_due": "",
				        "comments_and_work_notes": "",
				        "due_date": "",
				        "sys_mod_count": "0",
				        "reopen_count": "0",
				        "sys_tags": "",
				        "escalation": "0",
				        "upon_approval": "proceed",
				        "correlation_id": "",
				        "location": "",
				        "category": "inquiry"
				    }
				}
						""";
				
         JsonPath jsonPath = new JsonPath(json);
         String updateBy = jsonPath.get("result.sys_updated_by");
         System.out.println(updateBy);
         
         //Example: 2
         
			String jsons = """
					         		{
					    "firstName": "John",
					    "lastName": "doe",
					    "age": 26,
					    "address": {
					        "streetAddress": "naist street",
					        "city": "Nara",
					        "postalCode": "630-0192"
					    },
					    "phoneNumbers": [
					        {
					            "type": "iPhone",
					            "number": "0123-4567-8888"
					        },
					        {
					            "type": "iPhone",
					            "number": "0123-4567-8889"
					        },
					        {
					            "type": "home",
					            "number": "0123-4567-8910"
					        },
					        {
					            "type": "home",
					            "number": "0123-4567-9001"
					        },
					        {
					            "type": "home",
					            "number": "0123-4567-9023"
					        }
					    ]
					}
         		""";
			
			JsonPath jPath = new JsonPath(jsons);
			//We can use either List or Set interface
			//List<String> phoneNumbers = jPath.getList("phoneNumbers.findAll{it.type=='iPhone'}.number";
			Set<String> phoneNumbers = new HashSet<>(jPath.getList("phoneNumbers.findAll{it.type=='iPhone'}.number"));
			String age = jPath.getString("age");
			String address = jPath.getString("address.postalCode");
			System.out.println(phoneNumbers);
			System.out.println(age);
			System.out.println(address);
         
			MatcherAssert.assertThat(phoneNumbers, Matchers.hasItems("0123-4567-8889","0123-4567-8888"));
         
	}

}
