package com.sms.genericutility.misc;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownUtility {
	
	/**
	 * This method is used to fetch the data from dropdown by using visible text
	 * @param text
	 */
			public void selectDropdown(WebElement element,String text)
			{
				Select s=new Select(element);
				s.selectByVisibleText(text);
			}
	/**
	 * This method is used to fetch the data from dropdown by using index number
	 * @param index
	 */
			public void selectDropdown(WebElement element,int index)
			{
				Select s=new Select(element);
				s.selectByIndex(index);
			}
	/**
	 * This method is used to fetch the data from dropdown by using value
	 * @param value
	 */
			public void selectDropdown(String value,WebElement element)
			{ Select s=new Select(element);
				s.selectByValue(value);
			}
	/**
	 * This method is used to deselect the data from the dropdown by using visible text
	 * @param text
	 */
			public void deselectDropdown(WebElement element,String text)
			{
				Select s=new Select(element);
				s.deselectByVisibleText(text);
			}
  /**
   * This method is used to deselect the data from the dropdown by using value
   * @param value
   */
			public void deselectDropdown(String value,WebElement element)
			{Select s=new Select(element);
				s.deselectByValue(value);
			}
	/**
	 * This method is used to deselect the data from the dropdown by using inndex number
	 * @param index
	 */
			public void deselectDropdown(WebElement element,int index)
			{
				Select s=new Select(element);
				s.deselectByIndex(index);
			}
   /**
    * This method is used to deselect all the selected data from dropdown
    * @param element
    */
			public void deselectAll(WebElement element)
			{
				Select s=new Select(element);
				s.deselectAll();
			}
			
	/**
	 * This method is used to get all the data from the dropdown
	 * @return
	 */
			public List<String> getAlldrpdwonOption(WebElement element)
			{
				
				Select s=new Select(element);
				List<String> data=new ArrayList<>();
			List<WebElement>allopt=	s.getOptions();
				for(WebElement option:allopt)
					{
					  String  alloptions=option.getText();
					    data.add(alloptions);
					}
				return data;
			}
	/**
	 * This method is used to get all selected data from the dropdown
	 * @param element
	 * @return
	 */
			public List<String> getAllselectedDrpdown(WebElement element)
			{
				Select s=new Select(element);
				List<String> data=new ArrayList<>();
			List<WebElement>allopt=	s.getOptions();
				for(WebElement option:allopt)
					{
					String  allselectedoptions=option.getText();
					    data.add(allselectedoptions);
					}
				return data;
			}
	/**
	 * This method is used to get first selected data from the dropdown
	 * @param element
	 * @return
	 */
		public String getFirstselectedDrpdownOption(WebElement element)
			{
				Select s=new Select(element);
				WebElement opt=s.getFirstSelectedOption();
				
					    String firstselectedoptions=opt.getText();
				
				return firstselectedoptions;
			}
		

}
