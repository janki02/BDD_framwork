Feature: Login Page Feature

Scenario: Verfiying with valid credential
Given Enter the valid Email and Password
When The use click on Signin button
Then The user should able to Sigin Succesfully

Scenario Outline: Verfiying with invalid credential

Given Enter the invalid "Email" and "Password"
When The use click on login button
Then The user should  get "ErrorMessage"

Examples:
 | Username | Password |   ErrorMessage    |
 | janaki1@gmil.com    | 123456   |Invalid password.|
 |jatin12@gamil   | 12348qq  |Invalid email address|
 