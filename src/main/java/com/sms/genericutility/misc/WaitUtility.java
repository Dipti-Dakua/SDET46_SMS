package com.sms.genericutility.misc;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	
	/**
	 * This method is used to wait for given time
	 * @param miliseconds
	 */
	
	public void pause(long miliseconds)
	{
		try {
			Thread.sleep(miliseconds);
		} catch (InterruptedException e) {
			
		}
	}
	
	/**
	 * This method is used to wait some time till element to be visible
	 * @param driver
	 * @param time
	 * @param element
	 */
			public void waitElementToBeVisible(WebDriver driver,int time,WebElement element)
			{
				WebDriverWait wait=new WebDriverWait(driver,time);
				wait.until(ExpectedConditions.visibilityOf(element));
			}
	/**
	 *This method is used to  wait till element to be clickable
	 * @param driver
	 * @param time
	 * @param element
	 */
			public void waitElementToBeClickable(WebDriver driver,int time,WebElement element)
			{
				WebDriverWait wait=new WebDriverWait(driver,time);
				wait.until(ExpectedConditions.elementToBeClickable(element));
			}
			
	/**
	 * This method is used to wait some time till page/element to be loaded
	 * @param driver
	 * @param timeout
	 */
			public void implicitWait(WebDriver driver,long timeout)
			{
				driver.manage().timeouts().implicitlyWait(timeout,TimeUnit.SECONDS);
			}
			
   /**
    * This method is used to wait till element to be invisible
    * @param driver
    * @param time
    * @param element
    */
			public void waitElementToBeInvisible(WebDriver driver,long time,WebElement element)
			{
				WebDriverWait wait=new WebDriverWait(driver,time);
				wait.until(ExpectedConditions.invisibilityOf(element));
			}

}
