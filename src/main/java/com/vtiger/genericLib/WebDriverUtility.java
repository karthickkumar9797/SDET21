package com.vtiger.genericLib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * @author karth
 *
 */
public class WebDriverUtility {
	/**
	 * This method will wait for 20 seconds for page loading
	 * @return
	 */

	public void WaitUntilPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	/**
	 * This method wait for Element to visible
	 * 
	 */
	public void WaitForElementVisibility(WebDriver driver , WebElement element) {
		WebDriverWait wait= new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * @throws Throwable 
	 * 
	 * 
	 * 
	 */
	public void WaitAndClick(WebElement element) throws Throwable {
		int count=0;
		while (count < 20 ) {
			try {
				element.click();
				break;
			}
			catch(Throwable e) {
				Thread.sleep(2000);
				count++;
			}
			
			}
		}
		
	   public void select(WebElement element, int index)
	   {
		   Select select=new Select(element);
		   select.selectByIndex(index);   
	   }
	   
	   /**
	    * This method will perform mouse over action
	    * @param driver
	    * @param element
	    */
	   
	   public void mouseOver(WebDriver driver,WebElement element)
	   {
		   Actions act = new Actions(driver);
		   act.moveToElement(element).perform();
		   
	   }
	   
	   public void acceptalert(WebDriver driver) {
		   driver.switchTo().alert().accept();
	   }
	   
	   public void cancelalert(WebDriver driver) {
		   driver.switchTo().alert().dismiss();
		   
	   }
	   
	   /**
	    * This method performs right click operation 
	    * @param driver
	    * @param element
	    */
	   public void rightClick(WebDriver driver,WebElement element)
	   {
		   Actions act = new Actions(driver);
		   act.contextClick(element).perform();
	   }
	   /**
	    * this method will maximize the browser window
	    * @param driver
	    */
     public void fullScreen(WebDriver driver) {
    	 driver.manage().window().maximize();
     }
    

	public String alert(WebDriver driver) {
	String text = driver.switchTo().alert().getText();
	return text;
	}
	
	
}



