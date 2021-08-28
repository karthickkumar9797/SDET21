package com.vtiger.genericLib;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class ListenerClassUtility implements ITestListener {
	
	
 public void onTestFailure(ITestResult result) {
 String TestName = result.getMethod().getMethodName();
	EventFiringWebDriver Fdriver=new EventFiringWebDriver(BaseClass.sDriver);
	File Srcfile =Fdriver.getScreenshotAs(OutputType.FILE);
	
	File destfile = new File("./ScreenShots/"+TestName+".png");
	 try {
		FileUtils.copyFile(Srcfile, destfile);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	}

}
