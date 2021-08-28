package com.vtiger.genericLib;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.Random;
/**
 * 
 *
 * @author karth
 *
 */
public class JavaUtility {
	/**
	 * 
	 * this method is to get integer random number within 1 to 1000
	 * @return
	 */

	public int getRandomNumber() {
	
		Random random =new Random();
		int randomNum=random.nextInt(1000);
		return randomNum;
	}
	/**
	 * This method is to get the system date and time
	 * @return
	 */
	public String getSystemDate() {
		
		Date date=new Date();
		String SystemDateandTime=date.toString();
		return SystemDateandTime;
	}
	/**
	 * This method is  to get current System date with YYYY_MM_DD format
	 * @return
	 */
	public String getSystemdate_YYYY_MM_DD() {
		Date date =new Date();
		String SystemDateandTime = date.toString();
		String[]arr=SystemDateandTime.split("");
		String DD= arr[2];
		String YYYY=arr[5];
		int MM=date.getMonth()+1;
		String finalformat =YYYY+"-"+MM+"-"+DD;
		return finalformat;
	}
	/**
	 * This method is to pass Virtual key to OS
	 * @return
	 * @throws Throwable 
	 */
		public void PressVirtualKey() throws Throwable {
			Robot robot =new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		}
	}
	
	


