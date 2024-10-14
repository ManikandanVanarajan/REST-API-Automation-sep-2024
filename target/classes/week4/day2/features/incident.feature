Feature: Create a New Incident record

  Background: 
    Given User has Entered the BaseURI
    And User has entered the BasePath
    And User has entered authentication

  Scenario Outline: Validate the Incident record with payload
    When send the post request for the incident with <short_description> shortDescription
    And send the post request for the incident with <description> description
    Then validate the record created successfully
      #This concept is called Data table
      | status_code | status_line | content_type     |
      |         201 | Created     | application/json |

    Examples: 
      | short_description | description   |
      | RESTAPI2024       | RestPOST Call |

  Scenario: Create a new Incident without payload
    When User creating a New Incident without Payload
    Then Validate the status code is displayed as 201
