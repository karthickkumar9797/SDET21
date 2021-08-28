package com.vtiger.createnewleadTest;
import static org.testng.Assert.assertTrue;

import org.junit.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.vtiger.comcast.pomrepositorylib.CreatingNewLead;
import com.vtiger.comcast.pomrepositorylib.HomePage;
import com.vtiger.comcast.pomrepositorylib.LeadInformation;
import com.vtiger.comcast.pomrepositorylib.LeadsPage;
import com.vtiger.genericLib.BaseClass;


@Listeners(com.vtiger.genericLib.ListenerClassUtility.class)
  public class CreatingNewLead_tc_13java extends BaseClass {
	@Test (groups={"smokeTest","regressionTest"})
	
   public void  CreatingNewLeadTest()  throws Throwable {
		
   // test script Data
	int UniquLeadNo = excelLib.getDataFromExcelUniqueLeadNo("Sheet1", 1, 6);
	String expUniq = "LEA"+UniquLeadNo;
	
    String lastname = excelLib.getDataFromExcel("Sheet1", 1 , 1); 
    String companyname = excelLib.getDataFromExcel("Sheet1", 1 , 2);
    String noofemployee = excelLib.getDataFromExcel("Sheet1", 1 ,3);

    // step 2 Home Page
    HomePage home = new HomePage(driver);
	home.getLeadslink().click();

	// step3-leads page
	LeadsPage lead = new LeadsPage(driver);
	lead.getLeadsPageClk().click();

	// step4-creating new lead
	CreatingNewLead newlead = new CreatingNewLead(driver);
	newlead.createNewLead(lastname, companyname, noofemployee);
		

	// step5-lead information page
	LeadInformation leadinfo = new LeadInformation(driver);
	boolean ACTUALINFO = leadinfo.getNewleadCreatedSuccessfully().getText().contains(lastname);
	assertTrue(ACTUALINFO);
    boolean ActualLeadno = leadinfo.getLeadno().getText().contains(expUniq);
    assertTrue(ActualLeadno);	
	
	  int count= UniquLeadNo; int finalData = ++count;
	  excelLib.setDataToExcelUniqueLeadNo("Sheet1", 1, 6, finalData);
	 
}

	
	@Test (groups={"smokeTest","regressionTest"})
	public  void CreatingNewLeadInvalidTest() throws Throwable {

	
	// test script Data
		String expErrormsg="Invalid No Of Employees";
	 String lastname = excelLib.getDataFromExcel("Sheet1", 2 , 1); 
     String companyname = excelLib.getDataFromExcel("Sheet1", 2 , 2);
     String noofemployee = excelLib.getDataFromExcel("Sheet1", 2 ,3);


	 // step 2 Home Page
	 HomePage home = new HomePage(driver);
	 home.getLeadslink().click();

	 // step3-leads page
	 LeadsPage lead = new LeadsPage(driver);
	 lead.getLeadsPageClk().click();

	 // step4-creating new lead
	 CreatingNewLead newlead = new CreatingNewLead(driver);
	 newlead.createNewLead(lastname, companyname,noofemployee);
	 String actErrormsg = wLib.alert(driver);
	 wLib.acceptalert(driver);
	 
     //
	 Assert.assertEquals(actErrormsg, expErrormsg);
	}
  
	 @Test (groups={"smokeTest","regressionTest"})
     public void InValidemailTest() throws Throwable {
     // test script Data

     String lastname = excelLib.getDataFromExcel("Sheet1", 3, 1); 
     String companyname = excelLib.getDataFromExcel("Sheet1", 3 , 2);
     String primaryemail = excelLib.getDataFromExcel("Sheet1", 3 ,4);
     String secondaryemail = excelLib.getDataFromExcel("Sheet1", 3 ,5);
        
     // step 2 Home Page
      HomePage home = new HomePage(driver);
      home.getLeadslink().click();

     // step3-leads page
     LeadsPage lead = new LeadsPage(driver);
     lead.getLeadsPageClk().click();

     // step4-creating new lead
     CreatingNewLead newlead = new CreatingNewLead(driver);
     newlead.CreateNewlead(lastname, companyname, primaryemail, secondaryemail);


      // step5-lead information
      LeadInformation leadinfo = new LeadInformation(driver);
      boolean ACTUALINFO = leadinfo.getNewleadCreatedSuccessfully().getText().contains(lastname);
      assertTrue(ACTUALINFO);
	 }
	  
	  @Test(groups={"smokeTest","regressionTest"})
		public void InValidemailTest1() throws Throwable {

			
		// test script Data
		
	  String lastname = excelLib.getDataFromExcel("Sheet1", 4 , 1); 
	  String companyname = excelLib.getDataFromExcel("Sheet1", 4 , 2);
	  String primaryemail = excelLib.getDataFromExcel("Sheet1", 4 ,4);
	  String secondaryemail = excelLib.getDataFromExcel("Sheet1", 4 ,5);

		
	 // step 2 Home Page
	  HomePage home = new HomePage(driver);
	  home.getLeadslink().click();

	 // step3-leads page
	  LeadsPage lead = new LeadsPage(driver);
	  lead.getLeadsPageClk().click();

	 // step4-creating new lead
	  CreatingNewLead newlead = new CreatingNewLead(driver);
	  newlead.CreateNewlead(lastname, companyname, primaryemail, secondaryemail);
		

		// step5-lead information
		LeadInformation leadinfo = new LeadInformation(driver);
		 boolean ACTUALINFO = leadinfo.getNewleadCreatedSuccessfully().getText().contains(lastname);
		assertTrue(ACTUALINFO);
		
		}
}
