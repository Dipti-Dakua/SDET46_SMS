package com.practice;

import org.testng.annotations.Test;

public class MavenPracticeTest {
	@Test
	public void mavenPractice()
	{
	String url=	System.getProperty("url");
	String browser=System.getProperty("browser");
	System.out.println(url);
	System.out.println(browser);
	}

}
