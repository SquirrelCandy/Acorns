Feature: Select Options from CMS Dropdowns page

Background: User launches Chrome browser
	Given User launches Chrome browser
	
@dropdown
Scenario: Successful selection of option 3 on CMS Dropdowns page
	Given User is on CMS Dropdowns page
	When User selects option 3 in first dropdown
	Then Option 3 is selected
