package com.sms.genericutility.misc;

import com.aventstack.extentreports.ExtentTest;
/**
 * This class is used to create multiple test instance
 * @author MY PC
 *
 */
public class UtilityInstanceTransfer {
	private static ThreadLocal<ExtentTest> extentTest=new ThreadLocal<>();
/**
 * This method is used to get test instance
 * @return
 */
	public static ExtentTest getExtentTest() {
		return extentTest.get();
	}

	/**
	 * This method is used to set test instance
	 * @param setExtentTest
	 */
	public static void setExtentTest(ExtentTest setExtentTest) {
		extentTest .set(setExtentTest);
	}
	

}
