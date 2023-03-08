package com.sms.objectRepository.element;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InstructorTimetablePage {
	WebDriver driver;
	@FindBy(xpath="//tr[@id='3.00_4.00']/td[5]")
	private WebElement timetableDetails;

	
	
	public InstructorTimetablePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public String fetchTimetableDetails()
	{
		return timetableDetails.getText();
	}
	
}

