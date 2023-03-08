package com.sms.Listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
/**
 * This class is used to retry the failed test script
 * @author MY PC
 *
 */
public class RetryImplementation implements IRetryAnalyzer{
int count;
	@Override
	public boolean retry(ITestResult result) {
		int maxCount=2;
		if(count<maxCount)
		{
			count++;
			return true;
		}
		return false;
	}

}
