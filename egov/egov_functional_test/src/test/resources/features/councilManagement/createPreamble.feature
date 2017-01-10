

Feature: create preamble

  As a Registered user of the system
  i want to create Preamble

  # Create Preamble #

  Scenario Outline: Register user choose to create Preamble

    Given councilCreator logs in
    When he choose to create preamble
    And he enters create preamble details as <details>
    And he will enter the approval details as <approval officer2>
    And he copies preamble number and closes the acknowledgement


  Examples:
  |details| approval officer2 |
  |abc    | commissioner1   |