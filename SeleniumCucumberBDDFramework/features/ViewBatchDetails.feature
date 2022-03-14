@viewbatchdetails
Feature: view batch details - ter42

Scenario: view batch details of previously ran batch process 
  
  Given user launches TC Url2
  And users enters the Username
  When users enters the Password 
  And click on login button
  When user selects batch processing link
  And the user clicks view batch details button
  Then the batch processing details are displayed
  And Close the browser