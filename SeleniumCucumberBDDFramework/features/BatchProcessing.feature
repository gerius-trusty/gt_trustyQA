@batchprocessing
Feature: run batch - ter

Scenario: execute a batch process on multiple beneficiaries 
  
  Given user launches TC Url2
  And users enters the Username
  When users enters the Password 
  And click on login button
  When user selects batch processing link
  And user clicks select all
  When user clicks start plan comparison batch button
  And the user clicks continue to start a plan comparison batch
  When the user clicks the close button on the window
  And the user clicks view batch details button
  Then the batch processing details are displayed
  And Close the browser