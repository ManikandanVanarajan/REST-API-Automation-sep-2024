Feature: Creating a New Incident in Service now application

Background: 
Given User has Entered the BaseURI
And User has entered the BasePath
And User has entered authentication

Scenario: Create a new Incident without payload
When User creating a New Incident without Payload
Then Validate the status code is displayed as 201

Scenario: Create a new Incident with payload
When User creating a New Incident with Payload as '{"short_description": "RESTAPIS_21Sep2024"}'
Then Validate the status code is displayed as 201