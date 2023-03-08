package com.sms.genericutility.misc;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.sms.genericutility.ExternalResources.PropertyUtility;
import com.sms.genericutility.WebAction.JavaUtility;
import com.sms.genericutility.enums.PropertyKey;
/**
 * This class is used to handle Extent report
 * @author MY PC
 *
 */
public class ReportUtility {
	public ExtentReports report;
	/**
	 * This constructor is used to call init method
	 */
	public ReportUtility()
	{
		init();
	}
	/**
	 * This method is used to initialize the report
	 */
	public void init()
	{
		
		PropertyUtility propertyUtil=null;
		propertyUtil=new PropertyUtility(GetConstantValue.EXTENTREPORT_PROPERTYPATH);
		
		String overrideOrNot=propertyUtil.getPropertyData(PropertyKey.OVERRIDEREPORT);
		String randomName="";
		if(overrideOrNot.equals("no"))
		{
			randomName="_"+new JavaUtility().getCurrentDateTime();
		}
		
		ExtentSparkReporter spark=new ExtentSparkReporter(GetConstantValue.EXTENTREPORTFOLDERPATH+"extentReport"+randomName+".html");
		spark.config().setDocumentTitle(propertyUtil.getPropertyData(PropertyKey.EXTENTREPORT_TITLE));
		spark.config().setReportName(propertyUtil.getPropertyData(PropertyKey.EXTENTREPORT_NAME));
		spark.config().setTheme(Theme.DARK);
		
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Browser",(propertyUtil.getPropertyData(PropertyKey.EXTENTREPORT_BROWSER)));
		report.setSystemInfo("OS", System.getProperty("os.name"));
	}
	/**
	 * This method is used to create tab in report
	 * @param testName
	 */
	public void createTest(String testName)
	{
		ExtentTest test=report.createTest(testName);
		UtilityInstanceTransfer.setExtentTest(test);
	}
	/**
	 * This method is used to add a author into the report
	 * @param test
	 * @param author
	 */
	public void addAuthor(ExtentTest test,String...author)
	{
		test.assignAuthor(author);
	}
	/**
	 * This method is used to add catagory into the report
	 * @param test
	 * @param catagory
	 */
	public void addCatagory(ExtentTest test,String...catagory)
	{
		test.assignCategory(catagory);
	}
	/**
	 * This method is used to print the pass messeage in the report
	 * @param test
	 * @param message
	 */
	public void pass(ExtentTest test,String message)
	{
		test.pass(message);
		System.out.println(message);
	}
	/**
	 * This method is used to pass information into the report
	 * @param test
	 * @param message
	 */
	public void info(ExtentTest test,String message)
	{
		test.info(message);
		System.out.println(message);
	}
	/**
	 * This method is used to pass the failed message into the report
	 * @param test
	 * @param message
	 */
	public void fail(ExtentTest test,String message)
	{
		test.fail(message);
		System.out.println(message);
	}
	/**
	 * This method is used to show all the exception in the report
	 * @param test
	 * @param errmessage
	 */
	public void fail(ExtentTest test,Throwable errmessage)
	{
		test.fail(errmessage);
		System.out.println(errmessage);
	}
	/**
	 * This method is used to skipped message
	 * @param test
	 * @param message
	 */
	public void skip(ExtentTest test,String message)
	{
		test.skip(message);
		System.out.println(message);
	}
	/**
	 * This menthod is used to throw the exception into the report
	 */
	public void skip(ExtentTest test,Throwable errmessage)
	{
		test.skip(errmessage);
		System.out.println(errmessage);
	}
	/**
	 * This method is used to pass warning message into the report
	 * @param test
	 * @param message
	 */
	public void warn(ExtentTest test,String message)
	{
		test.warning(message);
		System.out.println(message);
	}
	/**
	 * This method is used to save the report
	 */
	public void saveReport()
	{
		report.flush();
	}
	/**
	 * This method is used to attach screenshot into the report
	 * @param test
	 * @param Screenshotpath
	 * @param title
	 * @param strategy
	 */
	public void attachScreenshot(ExtentTest test,String Screenshotpath,String title,String strategy)
	{
		if(strategy.equals("base64"))
		{
			test.addScreenCaptureFromBase64String(Screenshotpath, title);
		}
		else
		{
			test.addScreenCaptureFromPath(Screenshotpath, title);
		}
		
	}
	

}
