package com.vtiger.comcast.pomrepositorylib;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadInformation {
	public LeadInformation(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	    @FindBy(xpath = "//span[@class='dvHeaderText']")
		private WebElement NewleadCreatedSuccessfully;
	    
	    @FindBy(xpath = "//td[text()='Lead No']/following-sibling::td") 
       	private WebElement  leadno;

		public WebElement getLeadno() {
			return leadno;
		}
		
		public WebElement getNewleadCreatedSuccessfully() {
			return NewleadCreatedSuccessfully;
		}
		
				
			}
		
		
	


