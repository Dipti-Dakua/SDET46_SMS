package com.practice;

import org.testng.annotations.Test;

import com.sms.genericutility.annotation.Report;
import com.sms.genericutility.config.BaseClassPractice;

public class BatchExecution2Test extends BaseClassPractice {

	//@Report(author="Dipti")
	@Test
	public void test2()
	{
		
		driver.get("https://www.google.com/");
		System.out.println("open google");
		
		
	}
		
	}
		
	