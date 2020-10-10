Feature: Celo QA Test
  Background:
    This feature is created as a challenge for QA engineer role at Celo.
    This tests for a user path for sending message through the application.

    Scenario: This tests for functionality of user login, sending message, and logging out.
      Given User logs in to page
      When I login with credentials "qa.candidate+01@celohealth.com" and "3tQp+,/Q"
      And I enter passcode "3355"
      Then I send a text "sample" to " Admin QA "
      And I log out from the application

