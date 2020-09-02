Feature: Automation GetNet
  In order to use the application
  As a application user
  I want to search for SuperGet

  Background:
    Given I am at the GetNet Page

  @CT001 @InvalidCredentials @SlowTest @TotalTest
  Scenario Outline: Show error message when try to search with invalid information
    When I click on the Search Field
    And I fill the textbox with "<text>"
    And I click on the Search Button
    Then I should see an error message


    Examples:
      | text        |
      | EHAUEUEHAUE |
      | 63726 99000 |
      | !@#$¨$&     |

  @CT002 @ValidSearch @SmokeTest @TotalTest
  Scenario Outline: Show Expected Result after search
    When I click on the Search Field
    And I fill the textbox with "<text>"
    And I click on the Search Button
    Then I should see the expected result

    Examples:
      | text     |
      | SuperGet |


  @CT003 @AlternativeSearch @SmokeTest @TotalTest
  Scenario Outline: Show Expected Result after search with alternative data
    When I click on the Search Field
    And I fill the textbox with "<text>"
    And I click on the Search Button
    Then I should see the expected result

    Examples:
      | text         |
      | contratar 2% |

  @CT004 @InvalidCredentials @BlankCredentials @SlowTest @TotalTest
  Scenario Outline: Show error message when try to search with invalid informations
    When I click on the Search Field
    And I fill the textbox with "<text>"
    And I click on the Search Button
    Then I should see search suggestions
    Examples:
      | text |
      |      |