@tes
Feature: Adding a Benefciary

  Scenario: Creating a benefcicary without plan

  Given user launches TC Url2
  When users enters the Username

  When users enters the Password 
  And click on login button
  When Admin switches to broker account
  When Broker Clicks on add beneficiaries button
  And Click on single beneficiary
  When Enter FirstName
  And Enter LastName
  And Enter ZipCode
  And Enter PhoneNumber
  And Enter BeneficiaryEmail
  And Select EffectiveDate
  And Select Gender
  And Select Tobbaco Use
  And Enter Date of Birth
  And Select Income Range
  And Select Enrolled Plan
  And Click on Save and Quit