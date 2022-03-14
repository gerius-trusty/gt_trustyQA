@test
Feature: run batch  

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


  #Given user launches TC Url1
  #When users enters the Username
  #When users enters the Password 
  #And click on login button
  #When Broker Clicks on add beneficiaries button
  #And Click on single beneficiary
  #When Enter FirstName
  #And Enter LastName
  #And Enter ZipCode
  #And Enter PhoneNumber
  #And Enter BeneficiaryEmail
  #And Select EffectiveDate
  #And Select Gender
  #And Select Tobbaco Use
  #And Enter Date of Birth
  #And Select Income Range
  #And Select Enrolled Plan
  #And Click on Save and continue
  #And Click on Next Button
  #And Select Plan on Plan Recomendation Page
  #And click Save on Plan Recomendation Overview Page
  
  
	

 

 





  