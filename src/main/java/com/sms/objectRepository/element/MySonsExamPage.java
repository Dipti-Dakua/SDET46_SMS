package com.sms.objectRepository.element;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sms.genericutility.misc.DropdownUtility;

public class MySonsExamPage {
	
	WebDriver driver;
	@FindBy(id="exam")
	private WebElement examDropdown;
	
	@FindBy(id="btnSubmit")
	private WebElement submitbtn;
	
	public MySonsExamPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void selectDropdown(DropdownUtility dropdown,String examOption)
	{
	
		dropdown.selectDropdown(examDropdown, examOption);
		submitbtn.click();
	}
}
	


