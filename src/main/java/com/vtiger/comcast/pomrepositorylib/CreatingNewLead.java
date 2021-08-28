package com.vtiger.comcast.pomrepositorylib;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewLead {
	WebDriver driver;
  public CreatingNewLead(WebDriver driver){
	  this.driver=driver;
	  PageFactory.initElements(driver, this);  
  }
  
  @FindBy (name = "lastname")
  private WebElement LastnameEdt;
  
  @FindBy(name = "company")
  private WebElement CompanynameEdt;
  
  @FindBy(id = "noofemployees")
  private WebElement EmployeeEdt;
  
  @FindBy(id = "email")
  private WebElement PrimaryEmailTf;
  @FindBy(id = "secondaryemail")
  private WebElement SecondaryEmailTf;
  
  @FindBy(xpath = "//input[@title='Save [Alt+S]']")
  private WebElement saveBtn;
 

public WebElement getLastnameEdt() {
	return LastnameEdt;
}

public WebElement getCompanynameEdt() {
	return CompanynameEdt;
}

public WebElement getEmployeeEdt() {
	return EmployeeEdt;
}
public WebElement getPrimaryEmailTf() {
	return PrimaryEmailTf;
}

public WebElement getSecondaryEmailTf() {
	return SecondaryEmailTf;
}
public WebElement getSaveBtn() {
	return saveBtn;
}

public void createNewLead(String lastname, String companyname,  String noofemployee) {
	 LastnameEdt.sendKeys(lastname);
	 CompanynameEdt.sendKeys(companyname);
	 EmployeeEdt.sendKeys(noofemployee);
	 getSaveBtn().click();
}
public void CreateNewlead(String lastname, String companyname,String primaryemail,String secondaryemail) {
	LastnameEdt.sendKeys(lastname);
	 CompanynameEdt.sendKeys(companyname);
	 PrimaryEmailTf.sendKeys(primaryemail);
	 SecondaryEmailTf.sendKeys(secondaryemail);
	 getSaveBtn().click();
}

}

