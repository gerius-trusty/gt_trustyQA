@batch
Feature: Run batch process on all beneficiaries

  Scenario Outline: Verify batch processing functionality

  Given user launches TC Url2
  When users enters the Username
  When users enters the Password 
  And click on login button
  And user selects batch processing link
  When user clicks select all
  And the user clicks continue to start a plan comparison batch
  When the user clicks the close button on the window
  And the user clicks view batch details button
  Then the batch processing details are displayed