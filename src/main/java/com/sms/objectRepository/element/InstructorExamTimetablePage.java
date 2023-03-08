package com.sms.objectRepository.element;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sms.genericutility.misc.DropdownUtility;

public class InstructorExamTimetablePage {
	
	WebDriver driver;
	@FindBy(id="grade")
	private WebElement gradeDropdown;
	
	@FindBy(id="exam")
	private WebElement examDropdown;
	
	@FindBy(xpath="//button[text()='Next']")
	private WebElement nextBtn;
	
	@FindBy(xpath="//tr[@id='12.00_2.00']/td[5]")
	private WebElement examDetails;
	
	public InstructorExamTimetablePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void selectDropdown(DropdownUtility dropdown,String examOption,String gradeOption)
	{
	
		dropdown.selectDropdown(gradeDropdown, gradeOption);
		dropdown.selectDropdown(examDropdown, examOption);
		nextBtn.click();
	}
	public String fetchExamTimetableDetails()
	{
		return examDetails.getText();
	}
	

}
