package com.vtiger.genericLib;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import com.vtiger.comcast.pomrepositorylib.HomePage;
import com.vtiger.comcast.pomrepositorylib.LoginPage;


public class BaseClass {
    static WebDriver sDriver;
	public WebDriver driver;
	// Object Creation for Libraries
	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public FileUtility fileLib = new FileUtility();
	public ExcelUtility excelLib = new ExcelUtility();

	@BeforeSuite(groups = { "smokeTest", "regressionTest" })
	public void ConnectDatabase() {
		System.out.println("=========connecting to the database==================");
	}

	/*
	 * @Parameters("Browser")
	 * 
	 * @BeforeClass (groups={"smokeTest","regressionTest"})
	 * 
	 * public void ConfigBC(String Browser) throws Throwable { String
	 * Url=fileLib.getPropertyKeyValue("url");
	 * 
	 * if(Browser.equals("opera")) { driver=new OperaDriver(); }else
	 * if(Browser.equals("Chrome")) { driver = new ChromeDriver(); }else
	 * if(Browser.equals("Firefox")) { driver=new FirefoxDriver(); }
	 * 
	 * 
	 * wLib.WaitUntilPageLoad(driver); wLib.fullScreen(driver); driver.get(Url);
	 * 
	 * }
	 */

	
	  @BeforeClass public void ConfigBC() throws Throwable { 
		  String Browser = fileLib.getPropertyKeyValue("browser");
		  String url =fileLib.getPropertyKeyValue("url"); 
		  // launching browser 
		
	 if (Browser.equals("Chrome")) {
		  driver = new ChromeDriver();
		  } else if (Browser.equals("Edge")) { 
			  driver = new EdgeDriver();
			  }
	    sDriver=driver;
	  wLib.WaitUntilPageLoad(driver);
	  wLib.fullScreen(driver); 
	  driver.get(url);
	  
	  }
	 

	@BeforeMethod(groups = { "smokeTest", "regressionTest" })
	public void configBM() throws Throwable {

		String username = fileLib.getPropertyKeyValue("username");
		String password = fileLib.getPropertyKeyValue("password");
		// login to the APP
		LoginPage login = new LoginPage(driver);
		login.LoginToApp(username, password);

	}

	@AfterMethod(groups = { "smokeTest", "regressionTest" })
	public void configAm() {
		// logging out of APP
		HomePage home = new HomePage(driver);
		home.logout();
	}

	@AfterClass(groups = { "smokeTest", "regressionTest" })
	public void ConfigAC() {
		// closing the browser
		driver.quit();

	}

	@AfterSuite(groups = { "smokeTest", "regressionTest" })
	public void ClosingConnection() {
		System.out.println("closing the Connection");
	}
}