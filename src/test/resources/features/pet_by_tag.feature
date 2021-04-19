Feature: able to find pet by tag

  Scenario: valid tag name
    Given pet with tag name 'tag2'
    When GET request to 'pet/findByTags?tags='
    Then response is success