package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import CommonMethods.CommonMethod;

public class ProducerListView {

WebDriver driver;
CommonMethod cm;

public ProducerListView (WebDriver driver) {
this.driver = driver;
PageFactory.initElements(driver, this);
cm = new CommonMethod(driver);
}


 public By AdminViewIcon = By.xpath("//*[contains(text(), 'Admin View')]");

 public By SwitchBrokerViewButton = By.xpath("//*[contains(text(), 'Switch to Broker View')]");  //ask this doesn't show
 
 public By SignoutButton = By.xpath("//*[contains(text(), 'Sign Out')]");
 
 public By NotificationBellIcon = By.xpath("//*[@fill='primary']");
 
 public By SearchByDropdown = By.xpath("//div[@id='searchBy']");
 
 public By SelectSearchByLastName = By.xpath("//div[contains(text(), 'Last Name')]");
 
 //public By SelectSearchByFirstName = ; ///*[@id="seatchByText"]/../div/div[contains(text(),'First Name')]
 
 //public By EnterLastNameInSearch = By.xpath("//input[@id='seatchByText']");
 
 ////public By EnterLastNameInSearch =;
 
 
 public By AddProducerdropdown = By.xpath("//div[@id='producerDropdown']");
 
 public By AddSingleProducerButton = By.xpath("//div[contains(text(),'Single')]");
 
 public By CarrierTab = By.xpath("//span[contains(text(),'CARRIER')]");
 
 public By StateTab = By.xpath("//span[contains(text(),'STATE')]");
 
 public By AHIPTab = By.xpath("//span[contains(text(),'AHIP')]");
 
 public By DefaultTab = By.xpath("//span[contains(text(),'DEFAULT')]");
 
 
 
 public void clickOnAdminViewIcon () throws Exception {

cm.findElement(AdminViewIcon).click();
 }
 
 public void ClickOnSwitchBrokerViewButton () throws Exception {

cm.findElement(SwitchBrokerViewButton).click();
 }
 
 public void ClickOnSignoutButton () throws Exception {

cm.findElement(SignoutButton).click();
 }
 
 public void ClickOnNotificationBellIcon () throws Exception {

cm.findElement(NotificationBellIcon).click();
 }
 
 public void ClickOnSearchByDropdown () throws Exception {

cm.findElement(SearchByDropdown).click();
 }
 
 public void ClickOnSelectSearchByLastName () throws Exception {

cm.findElement(SelectSearchByLastName).click();

 }
 
 /*public void EnterSearchByLastName (String lastname) throws Exception {

cm.findElement(EnterLastNameInSearch).sendKeys(lastname);
 }*/
 
 public void ClickOnAddProducerdropdown () throws Exception {

cm.findElement(AddProducerdropdown).click();
 }
 
 public void ClickonAddSingleProducer () throws Exception {

cm.findElement(AddSingleProducerButton).click();
 }
 public void ClickOnClickOnCarrierTab () throws Exception {

cm.findElement(CarrierTab).click();
 }
 
 public void ClickOnClickOnStateTab () throws Exception {
cm.findElement(StateTab).click();
 }
 
 public void ClickOnClickOnAHIPTab () throws Exception {

cm.findElement(AHIPTab).click();

 }
 
 public void ClickOnDefaultTab () throws Exception {

cm.findElement(DefaultTab).click();
 }
 
}
