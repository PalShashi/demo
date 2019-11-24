Feature: Search
  As end user
  I want to search
  So that I can buy see desired product

  Scenario: Search for a product
    Given I am on homepage
    When I search for "Laptop"
    Then I should be able to see the respective product

#    Scenario Outline: Search for a product
#      Given I am on homepage
#      When I search for "<item>"
#      Then i should be able to see the respective product
#
#      Examples:
#
#      |item      |
#      |Cable     |
#      |Laptop    |
#      |harddisk  |





