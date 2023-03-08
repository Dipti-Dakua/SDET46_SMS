package com.sms.genericutility.config;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.sms.Listeners.ListenerReport;
import com.sms.genericutility.ExternalResources.ExcelUtility;
import com.sms.genericutility.ExternalResources.PropertyUtility;
import com.sms.genericutility.WebAction.JavaUtility;
import com.sms.genericutility.WebAction.SeleniumUtility;
import com.sms.genericutility.WebAction.VerificationUtility;
import com.sms.genericutility.enums.PropertyKey;
import com.sms.genericutility.misc.DropdownUtility;
import com.sms.genericutility.misc.GetConstantValue;
import com.sms.genericutility.misc.WaitUtility;

public class BaseClassPractice extends DeclarationConfigure {
	@Parameters(value="browser")
	@BeforeClass(alwaysRun=true)
	public void setup(@Optional String browser)
	{
		
report=ListenerReport.sreport;
		 propertyUtil=new PropertyUtility(GetConstantValue.PROPERTYPATH);
		 excelUtil=new ExcelUtility(GetConstantValue.EXCELPATH);
		 seleniumUtil=new SeleniumUtility();
		 waitutil=new WaitUtility();
		 dropdownUtil=new DropdownUtility();
		verificationUtil=new VerificationUtility();
		 javaUtil=new JavaUtility();
		 // browser=	propertyUtil.getPropertyData(PropertyKey.BROWSER);
		  timeouts=Long.parseLong(propertyUtil.getPropertyData(PropertyKey.TIMEOUT));
		  
		
		String URL=	propertyUtil.getPropertyData(PropertyKey.URL);
		if(browser==null)
		{
			browser=	propertyUtil.getPropertyData(PropertyKey.BROWSER);
			
		}
		this.browser=browser;
		driver=seleniumUtil.launchBrowser(browser,"");
		System.out.println("browser is launched");
		seleniumUtil.maximize(driver);
		waitutil.implicitWait(driver, timeouts);
		//seleniumUtil.launchApplication(driver,URL);
	}
	@AfterClass(alwaysRun=true)
	public void setupTearDown()
	{
	  driver.close();
	  System.out.println("driver is closed");
	  excelUtil.close();
	  System.out.println("excel  is closed");
	}

}
