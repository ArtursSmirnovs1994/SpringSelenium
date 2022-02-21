Feature: Contact form

  Scenario Outline: Contact form cannot be submitted with out populating required fields
    Given I am using "<device>"
    And I am on home page
    When I navigate to contacts page
    And I open contact form
    And I click on submit button
    Then mandatory non populated fields show error message
    And populating fields removes error message

    Examples:
      | device  |
      | desktop |
      | tablet  |
      | phone   |

  Scenario Outline: Form recognizes email pattern
    Given I am using "<device>"
    And I am on home page
    When I navigate to contacts page
    And I open contact form
    And I fill form with incorrect pattern email
    Then I click on submit button
    And "emailAddress" field has error message

    Examples:
      | device  |
      | desktop |
      | tablet  |
      | phone   |