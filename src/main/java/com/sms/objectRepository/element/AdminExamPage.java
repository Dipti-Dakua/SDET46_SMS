
package com.sms.objectRepository.element;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

import com.sms.genericutility.misc.DropdownUtility;

	
	public class AdminExamPage {

		WebDriver driver;
		@FindBy(name="grade")
		private WebElement gradeDropdown;
		
		@FindBy(id="exam")
		private WebElement examDropdown;
		
		@FindBy(id="btnSubmit")
		private WebElement submitbtn;
		/**
		 * this method is used to initialize the webelement
		 * @param driver
		 */
		public AdminExamPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		/**
		 * this method is used to select the dropdown and click on submit button
		 * @param dropdown
		 * @param gradeOption
		 * @param examOption
		 */
		public void selectDropdown(DropdownUtility dropdown,String gradeOption,String examOption)
		{
			dropdown.selectDropdown(gradeDropdown, gradeOption);
			dropdown.selectDropdown(examDropdown, examOption);
			submitbtn.click();
		}
	}



