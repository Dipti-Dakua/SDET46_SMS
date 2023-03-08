package com.sms.Listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.sms.genericutility.annotation.Report;
import com.sms.genericutility.config.ConfigureClass;
import com.sms.genericutility.misc.ReportUtility;
import com.sms.genericutility.misc.UtilityInstanceTransfer;
/**
 * this class contains various methord in order to generate extent report
 * @author MY PC
 *
 */
public class ListenerReport  implements ITestListener,ISuiteListener{
	private ReportUtility report;
	public static ReportUtility sreport;
	
	/**
	 * This method will excute before execution of @beforesuite method
	 *  
	 */
	@Override
	public void onStart(ISuite suite) {
		System.out.println("on start-->test");
		report=new ReportUtility();
		sreport=report;
		
	}
/**
 * This method is used to save the extent report
 */
	@Override
	public void onFinish(ISuite suite) {
		System.out.println("on finish--->suite");
		report.saveReport();
		
	}
	/**
	 * This method will execute before execution of @beforetest
	 */
	@Override
	public void onStart(ITestContext context) {
		System.out.println("on start-->test");
		
	}
	/**
	 * This method will execute before execution of test script
	 * This method is used to create the test and add author and catagory to the report
	 */
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("ontestStart");
		report.createTest(result.getMethod().getMethodName());
		Report reportAnnotation=result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Report.class);
		System.out.println(reportAnnotation.author());
		System.out.println(reportAnnotation.category());
		report.addAuthor(UtilityInstanceTransfer.getExtentTest(),reportAnnotation.author());
		report.addCatagory(UtilityInstanceTransfer.getExtentTest(),reportAnnotation.category());
		
		
	}
/**
 * This method will execute if the test script got pass
 * This method is used to call pass method and print the passed message
 */
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("OnTest Success");
		report.pass(UtilityInstanceTransfer.getExtentTest(),result.getMethod().getMethodName()+"is pass");
		
	}
/**
 * This method will execute if the test script got fail
 * This method is used to throw the error message and exception and take the screenshot of failed test script
 */
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("OnTest Failure");
		report.fail(UtilityInstanceTransfer.getExtentTest(),result.getMethod().getMethodName()+"is failed");
		report.fail(UtilityInstanceTransfer.getExtentTest(),result.getThrowable());
		
		String screenshotPath=null;
		
		screenshotPath=ConfigureClass.class.cast(result.getMethod().getInstance()).seleniumUtil.takeScreenshot();
	report.attachScreenshot(UtilityInstanceTransfer.getExtentTest(),screenshotPath, result.getMethod().getMethodName(), "base64");
	}
/**
 * This method will execute if the test script got skip
 * This method is used to throw the error message and exceptions 
 */
	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("OnTestSkipped");
		report.skip(UtilityInstanceTransfer.getExtentTest(),result.getMethod().getMethodName()+"is skipped");
		report.skip(UtilityInstanceTransfer.getExtentTest(),result.getThrowable());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("onTestFailedButWithinSuccessPercentage");
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("onTestFailedWithTimeout");
		
	}

	
/**
 * This method will execute before execution 
 */
	@Override
	public void onFinish(ITestContext context) {
		System.out.println("on finish");
		
	}

}
