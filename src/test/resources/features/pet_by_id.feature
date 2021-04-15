Feature: get pet information by id

  Scenario: id does not exist
    Given user has an invalid pet id
    When user makes a request to GET by id
    Then response is not found

  Scenario:
    Given user has a valid pet id
    When user makes a request to GET by id
    Then response is success
