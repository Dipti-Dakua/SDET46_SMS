package com.practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sms.genericutility.annotation.Report;
import com.sms.genericutility.config.BaseClassPractice;

public class BatchExecution3Test extends BaseClassPractice {
@Report(author="Jyoti")
@Test
	public void test3()
	{
		
		driver.get("https://www.flipkart.com/");
		System.out.println("open flipkart");
		//Assert.fail();
		
	}


}
