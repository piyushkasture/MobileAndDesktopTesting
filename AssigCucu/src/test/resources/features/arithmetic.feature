Feature: Arithmetic operations

  Scenario: Addition
    Given I have numbers 10 and 5
    When I add them
    Then result should be 15

  Scenario: Multiplication
    Given I have numbers 6 and 7
    When I multiply them
    Then result should be 42

  Scenario: Division
    Given I have numbers 20 and 4
    When I divide them
    Then result should be 5
