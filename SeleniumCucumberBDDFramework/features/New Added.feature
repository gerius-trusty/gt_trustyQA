@filterview
Feature: filtered view on the dashboard page  - ter-51

Scenario: Check if beneficiaries are displayed in the list when filtered.
  
  Given user launches TC Url2
  And users enters the Username
  When users enters the Password 
  And click on login button
  When the user clicks the dashboard icon
  And the user selects the lead source filter icon
  When the user selects lead builder 
  And the user selects the lead source filter icon
  When the user selects self generated
  And the user selects the lead source filter icon
  
  And the user selects a beneficiary
  When the user clicks the back button 
  Then the user clicks on the arrow (next) button
  When the user clicks view more
  And Close the browser
  