package com.vtiger.comcast.pomrepositorylib;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	
	public HomePage (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(linkText = "Leads")
	private WebElement Leadslink;

	public WebElement getLeadslink() {
		return Leadslink;
	}
	
		@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
		private WebElement AdministratorClk;
		public WebElement getAdministratorClk() {
			return AdministratorClk;
		}
		@FindBy(linkText = "Sign Out")
		private WebElement SignoutClk;
		
		  public WebElement getSignoutClk() {
			return SignoutClk;
		}
		public void logout() {
			Actions actions=new Actions(driver);
			actions.moveToElement(AdministratorClk).perform();
			SignoutClk.click();
		}

}


		

		
		
		

