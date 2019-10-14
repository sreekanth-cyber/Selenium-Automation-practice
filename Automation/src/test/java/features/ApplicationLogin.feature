Feature: Application Login

Scenario: Home Page Login
Given user is on a landing page
When user login to the application by entering "test1" and "1234"
Then Home page is displayed
And usename displayed "true"

Scenario: Home Page Login
Given user is on a landing page
When user login to the application by entering "test2" and "4321"
Then Home page is displayed
And usename displayed "false"