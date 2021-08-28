package com.vtiger.comcast.pomrepositorylib;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
   public LoginPage (WebDriver  driver) {
	   PageFactory.initElements(driver, this);
   }
	@FindBy(name = "user_name")
	private WebElement UserNameEdt;
	
	@FindBy(name ="user_password")
	private WebElement PasswordEdt;
	
	@FindBy(id="submitButton")
	private WebElement SubmitBtn;
	
	public WebElement getUserNameEdt() {
		return UserNameEdt;
	}
	public WebElement getPasswordEdt() {
		return PasswordEdt;
	}
	public WebElement getSubmitBtn() {
		return SubmitBtn;
	} 
	
	public void LoginToApp(String username ,String password) {
		UserNameEdt.sendKeys(username);
		PasswordEdt.sendKeys(password);
		SubmitBtn.click();
	}

		
	}
	


