package com.vtiger.createnewleadTest;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.vtiger.comcast.pomrepositorylib.CreatingNewLead;
import com.vtiger.comcast.pomrepositorylib.HomePage;
import com.vtiger.comcast.pomrepositorylib.LeadsPage;
import com.vtiger.genericLib.BaseClass;

public class CreatingNewLead_tc_17java extends BaseClass{


		

			
			   @Test(groups={"smokeTest"})
				public void InValidemailnameTest() throws Throwable {
						
				String expErrormsg="Please enter a valid Email (EMAIL)";

			    // test script Data

				 String lastname = excelLib.getDataFromExcel("Sheet1", 5, 1); 
			     String companyname = excelLib.getDataFromExcel("Sheet1", 5 , 2);
			     String primaryemail = excelLib.getDataFromExcel("Sheet1", 5 ,4);
			     String secondaryemail = excelLib.getDataFromExcel("Sheet1", 5 ,5);

				    
			     // step 2 Home Page
			     HomePage home = new HomePage(driver);
			     home.getLeadslink().click();

			     // step3-leads page
				 LeadsPage lead = new LeadsPage(driver);
				 lead.getLeadsPageClk().click();

			     // step4-creating new lead
				 CreatingNewLead newlead = new CreatingNewLead(driver);
				 newlead.CreateNewlead(lastname, companyname, primaryemail, secondaryemail);
				 String actErrormsg = wLib.alert(driver);
				 wLib.acceptalert(driver);
				   AssertJUnit.assertEquals(actErrormsg, expErrormsg);
				
				
	   

	}

}
