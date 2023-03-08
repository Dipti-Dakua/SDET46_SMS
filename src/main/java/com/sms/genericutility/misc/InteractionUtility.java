package com.sms.genericutility.misc;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
/**
 * This class is used to handle mouse action
 * @author MY PC
 *
 */
public class InteractionUtility {
	private Actions act;
	/**
	 * This method is used to initialize Actions class
	 * @param driver
	 */
			public void initializeActions(WebDriver driver)
			{
				act=new Actions(driver);
			}
	/**
	 * This method is used to move the cursor to a particular element
	 * @param element
	 */
			public void mouseHover(WebElement element)
			{
			 act.moveToElement(element).perform();
			}
		/**
		 * This method is used to perform click action on a particular webelement
		 * @param element
		 */
			public void click(WebElement element)
			{
			 act.click(element).perform();
			}
		/**
		 * This method is used to perform click action
		 */
			public void click()
			{
			 act.click().perform();
			}
		/**
		 * This method is used to perform double click action on a particular webelement
		 * @param element
		 */
			public void doubleClick(WebElement element)
			{
			 act.doubleClick(element).perform();
			}
		/**
		 * This method is used to perform double click action
		 */
			public void doubleClick()
			{
			 act.doubleClick().perform();
			}
		/**
		 * This method is used to perform rightclick action on a particular webelement
		 * @param element
		 */
			public void rightClick(WebElement element)
			{
			 act.contextClick(element).perform();
			}
		/**
		 * 	This method is used to perform rightclick action
		 */
			public void rightClick()
			{
			 act.contextClick().perform();
			}
			
		/**
		 * This method is used to click and hold on a particular webelement
		 * @param element
		 */
			public void clickAndHoldAction(WebElement element)
			{
			 act.clickAndHold(element).perform();
			}
		/**
		 * This method is used to perform release action 
		 * @param element
		 */
			public void release(WebElement element)
			{
			 act.release(element).perform();
			}
		/**
    	 * This method is used to perform release action 
		 * @param element
		 * 			
		*/
 			public void release()
			{
			 act.release().perform();
			}
		/**
		 * This method is used to perform drag and drop action
		 */
			public void dragAndDropAction(WebElement source,WebElement destination)
			{
			 act.dragAndDrop(source,destination).perform();
			}
		/**
		 * This method is used to perform drag and drop /to perform slide action
		 * @param source
		 * @param xoffset
		 * @param yoffset
		 */
			public void dragAndDropByAction(WebElement source,int xoffset,int yoffset)
			{
			 act.dragAndDropBy(source,xoffset,yoffset).perform();
			}
			/**
			 * This method is used to perform enter action
			 */
			public void enter()
			{
				act.keyDown(Keys.ENTER).perform();
			}

}
