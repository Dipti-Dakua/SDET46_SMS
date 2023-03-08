package com.practice;

import org.testng.Assert;

import org.testng.annotations.Test;

import com.sms.genericutility.annotation.Report;
import com.sms.genericutility.config.BaseClassPractice;

//@Listeners(edu.sms.practice.listener.SetTestParameter.class)
public class BatchExecution1Test extends BaseClassPractice {

	
	@Report(author="Dipti",category="sanity")
	@Test
	public void test1()
	{
		
		driver.get("https://www.youtube.com/");
		System.out.println("open youtube");
		//Assert.fail();
	
	}

}
