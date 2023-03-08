package com.sms.objectRepository.element;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InstructorHomePage {
	WebDriver driver;
	
	@FindBy(xpath="//span[text()='Timetable']")
	private WebElement TimetableTab;
	
	@FindBy(xpath="//a[@href='my_timetable2.php']")
	private WebElement myTimetableTab;
	
	@FindBy(xpath="//span[text()='Exam']")
	private WebElement examTab;
	
	@FindBy(xpath="//a[text()='Exam Timetable']")
	private WebElement examTimetableTab;
	
	@FindBy(xpath="//span[text()='Subject']")
	private WebElement subjectTab;
	
	@FindBy(xpath="//a[@href='my_subject2.php']")
	private WebElement mySubjectTab;
	
	public InstructorHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnMyTimetableTab()
	{
		
		TimetableTab.click();
		myTimetableTab.click();
	}
	public void clickOnExamTimetableTab()
	{
		
		examTab.click();
		examTimetableTab.click();
	}
	public void clickMySubjectTab()
	{
		
		subjectTab.click();
		mySubjectTab.click();
	}


}
