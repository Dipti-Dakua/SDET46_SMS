package com.sms.Listeners;

import org.testng.IClassListener;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestClass;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.sms.genericutility.config.ConfigureClass;



public class ListenerImplementation implements ITestListener,ISuiteListener,IClassListener{

	@Override
	public void onBeforeClass(ITestClass testClass) {
		System.out.println("on before class");
	}

	@Override
	public void onAfterClass(ITestClass testClass) {
		System.out.println("on after class");
		
	}

	@Override
	public void onStart(ISuite suite) {
		System.out.println("on start---->suite");
		
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("on finish---->suite");
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("on testStart---->test");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("on test success");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("on test failure");
		ConfigureClass.class.cast(result.getMethod().getInstance()).seleniumUtil.takeScreenshot( result.getMethod().getRealClass().getSimpleName(),
				ConfigureClass.class.cast(result.getMethod().getInstance()).javaUtil);
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	

	@Override
	public void onStart(ITestContext context) {
		System.out.println("on start---->test");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("on finish---->test");
		
	}

}
