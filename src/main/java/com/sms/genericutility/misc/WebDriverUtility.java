package com.sms.genericutility.misc;

import java.awt.AWTException;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
//maximize the window
public class WebDriverUtility {
	Select s;
	Actions act;
	String alloptions;
	String allselectedoptions;
	
	
	
	

	
	//fullscreen the window
		public void fullscreenBrowser(WebDriver driver)
		{
			driver.manage().window().fullscreen();
		}

	//to perform scroll action by using javascript
		public void scrollAction(WebDriver driver)
		{
			JavascriptExecutor jse=(JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,500);");
			
		}
	//to perform scroll action to a partiular webeement
		public void scrollToElementAction(WebDriver driver,WebElement element)
		{
			JavascriptExecutor jse=(JavascriptExecutor)driver;
			int y=element.getLocation().getY();
			jse.executeScript("window.scrollBy(0,"+y+")",element);
			
		}
   //to perform scrolldown action by using robot class
		public void scrollDownByRobot() throws AWTException
		{
			Robot r=new Robot();
			r.keyPress(KeyEvent.VK_PAGE_DOWN);
			r.keyRelease(KeyEvent.VK_PAGE_DOWN);
		}
	//to perform scroll up action by using robot class
		public void scrollUpByRobot() throws AWTException
		{
			Robot r=new Robot();
			r.keyPress(KeyEvent.VK_PAGE_UP);
			r.keyRelease(KeyEvent.VK_PAGE_UP);
		}
	//to perform enter by using robot class
		public void enterActionByRobot() throws AWTException
		{
			Robot r=new Robot();
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
		}
	//to perform selectall action by using robot class
		public void selectActionByRobot() throws AWTException
		{
			Robot r=new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_A);
			r.keyRelease(KeyEvent.VK_CONTROL);
			r.keyRelease(KeyEvent.VK_A);
		}
	//to perform copy action by using robot class
		public void copyActionByRobot() throws AWTException
		{
			Robot r=new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_C);
			r.keyRelease(KeyEvent.VK_CONTROL);
			r.keyRelease(KeyEvent.VK_C);
		}
	//to perform spaste action by using robot class
		public void pasteActionByRobot() throws AWTException
		{
			Robot r=new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_CONTROL);
			r.keyRelease(KeyEvent.VK_V);
		}
		
		
		
}
