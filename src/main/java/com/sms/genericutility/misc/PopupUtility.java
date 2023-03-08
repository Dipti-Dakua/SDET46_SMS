package com.sms.genericutility.misc;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
/**
 * This class is used to handle the popup
 * @author MY PC
 *
 */
public class PopupUtility {
	/**
	 * This method is used to click ok on alert popup
	 * @param driver
	 */
			public void acceptAlert(WebDriver driver)
			{
				Alert alt=driver.switchTo().alert();
				alt.accept();
				
			}
		/**
		 * This method is used to click cancel on alert popup
		 * @param driver
		 */
			public void cancelAlert(WebDriver driver)
			{
				Alert alt=driver.switchTo().alert();
				alt.dismiss();
	/**
	 * This method is used to pass value on alert popup		
	 */
			}
			public void setDataAlert(WebDriver driver,String value)
			{
				Alert alt=driver.switchTo().alert();
				alt.sendKeys(value);	
			}
	/**
	 * This method is used to fetch msg from alert popup
	 * @param driver
	 * @return
	 */
			public String getDataAlert(WebDriver driver)
			{
				Alert alt=driver.switchTo().alert();
				String value=alt.getText();
				return value;
			}
	/**
	 * This method is used to switch the frame by using index
	 * @param driver
	 * @param index
	 */
			public void switchFrame(WebDriver driver,int index)
			{
			 driver.switchTo().frame(index);	
			}
	/**
	 * This method is used to switch the frame by using web element
	 * @param driver
	 * @param element
	 */
			public void switchFrame(WebDriver driver,WebElement element)
			{
			 driver.switchTo().frame(element);	
			}
	/**
	 * This method is used to switch frame popup by using id or name attribute
	 * @param driver
	 * @param attribute_value
	 */
			public void switchFrame(WebDriver driver,String attribute_value)
			{
			 driver.switchTo().frame(attribute_value);	
			}
	/**
	 * This method is used to switch the frame to parentframe
	 * @param driver
	 */
		public void switchtoParentframe(WebDriver driver)
			{
			 driver.switchTo().parentFrame();	
			}
	/**
	 * This method is used to switch the frame to main page
	 * @param driver
	 */
		public void switchFrameToMainPage(WebDriver driver)
			{
			 driver.switchTo().defaultContent();	
			}
		
		
/**
* This method is used to switch the child browser based on window title
* @param driver
* @param partilWinTitle
*/
		public void switchToWindow(WebDriver driver,String partilWinTitle)
		{
			Set<String> allwindows=driver.getWindowHandles();
			{
				for(String indwindow:allwindows)
				{
					String currentWinTitle=driver.switchTo().window(indwindow).getTitle();
					if((currentWinTitle).contains(partilWinTitle))
					{
						break;
					}
				}
			}
			
		 }
/**
* this method is use to switch the window based on url
* @param driver
* @param partilWinurl
*/
		public void switchToWindow(String partilUrl,WebDriver driver)
		{
			Set<String> allwindows=driver.getWindowHandles();
			{
				for(String indwindow:allwindows)
				{
					String currentWinUrl=driver.switchTo().window(indwindow).getCurrentUrl();
					if((currentWinUrl).contains(partilUrl))
					{
						break;
					}
				}
			}
			
		 }


}
