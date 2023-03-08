package com.sms.genericutility.WebAction;

import org.openqa.selenium.WebDriver;

public class VerificationUtility {
	
	
	public void exactVerify(String actelement1,String expelement1 )
	{
		if(actelement1 .equals (expelement1) )
		{
			System.out.println("test case is pass");
		}
	else
		{
			System.out.println("test case is fail");
		}
	}
	
	
	/**
	 * This method is used to validate complete actual element with complete expected element
	 * @param actelement1
	 * @param expelement1
	 * @param actelement2
	 * @param expelement2
	 */
	public void exactVerify(String actelement1,String expelement1 ,String actelement2,String expelement2)
	{
		if(actelement1 .equals (expelement1)  &&   actelement2.equals (expelement2))
		{
			System.out.println("test case is pass");
		}
	else
		{
			System.out.println("test case is fail");
		}
	}
	
	/**
	 * This method is used to validate  actual element with partial  expected element
	 * @param actelement1
	 * @param expelement1
	 * @param actelement2
	 * @param expelement2
	 */
	
	public void partialVerify(String actelement1,String expelement1 ,String actelement2,String expelement2)
	{
		if(actelement1 .contains (expelement1)  &&   actelement2.contains (expelement2))
		{
			System.out.println("test case is pass");
		}
	else
		{
			System.out.println("test case is fail");
		}
	}
	/**
	 * This method is used to verification by using partial value
	 * @param actelement1
	 * @param expelement1
	 * @param actelement2
	 * @param expelement2
	 * @param actelement3
	 * @param expelement3
	 */
	
	public void partialVerify(String actelement1,String expelement1 ,String actelement2,String expelement2,String actelement3,String expelement3)
	{
		if(actelement1 .contains (expelement1)  &&   actelement2.contains (expelement2) && actelement3.contains (expelement3))
		{
			System.out.println("test case is pass");
		}
	else
		{
			System.out.println("test case is fail");
		}
	}
	/**
	 * This method is used to verification of login page
	 * @param expTitle
	 * @param actTitle
	 */
	public void loginPageVerify(String expLoginTitle,WebDriver driver)
	{
		String actLoginTitle=driver.getTitle();
		if(actLoginTitle .contains (expLoginTitle) )
		{
			System.out.println("login page displayed");
		}
	else
		{
			System.out.println("login page not displayed");
		}
	
	}
	/**
	 * This method is used to verification of home page
	 * @param expHomeTitle
	 * @param actHomeTitle
	 */
	public void PageVerify(String expTitle,WebDriver driver,String page)
	{  String actTitle=driver.getCurrentUrl();
		if( actTitle.contains (expTitle) )
		{
			System.out.println(page+" page displayed");
		}
	else
		{
			System.out.println(page+" page not displayed");
		}
	
	}
	
	

}
