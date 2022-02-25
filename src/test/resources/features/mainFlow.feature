#language: en
#author: carlos.cesar

  @mainFlow
  Feature: : record in the agenda

    @ct001
    Scenario Outline: fill schedule
      Given that I click on add
      And that I enter the name "<register>"
      And fill in your phone as "40028922"
      And click add to add record
      Then registration must be registered "<register>"

      Examples:
      |register|
      |Carlos  |
      |Cesar   |


    @ct002
    Scenario Outline: Delete calendar record
      Given that I delete record "<name>"
      Then the agenda must not be registered with the name "<name>"

      Examples:
      |name   |
      |Cesar  |
      |Carlos |
