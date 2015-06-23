Feature: About
 
Scenario: click on about
	Given User is on Home Page
	When user select English
	And user click about
	Then email found is mine