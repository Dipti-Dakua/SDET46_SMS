package com.sms.objectRepository.element;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sms.genericutility.misc.DropdownUtility;
import com.sms.genericutility.misc.WaitUtility;

public class AdminTimetablePage {   
	
	

	WebDriver driver;
	@FindBy(id="grade")
	private WebElement gradeDropdown;
	
	@FindBy(xpath="//button[text()='Submit']")
	private WebElement submitbtn;
	
	@FindBy(xpath="//a[@class='btn btn-success btn-sm pull-right']")
	private WebElement addBtn;
	
	@FindBy(id="day")
	private WebElement dayDropdown;
	
	@FindBy(id="subject")
	private WebElement subjectDropdown;
	
	@FindBy(id="teacher")
	private WebElement teacherDropdown;
	
	@FindBy(id="classroom")
	private WebElement classroomDropdown;
	
	@FindBy(id="start_time")
	private WebElement startTimeTextfield;
	
	@FindBy(id="end_time")
	private WebElement endTimeTextField;
	
	@FindBy(id="btnSubmit")
	private WebElement submitButton;
	
	@FindBy(xpath="//div[@id='duplicate_Record2']/div/div/div/button")
	private WebElement waitElement;
	
	public AdminTimetablePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void selectDropdown(DropdownUtility dropdown,String gradeOption)
	{
		dropdown.selectDropdown(gradeDropdown, gradeOption);
		submitbtn.click();
	}
	public void clickAddButton()
	{
		addBtn.click();	
	}
	public void selectDayDropdown(DropdownUtility dropdown,String dayOption)
	{
		dropdown.selectDropdown(dayDropdown, dayOption);
	}
	public String selectSubjectDropdown(DropdownUtility dropdown,String subjectOption)
	{
		dropdown.selectDropdown(subjectDropdown, subjectOption);
	return	dropdown.getFirstselectedDrpdownOption(subjectDropdown);
	}
	public String selectTeacherDropdown(DropdownUtility dropdown,String teacherOption)
	{
		dropdown.selectDropdown(teacherDropdown, teacherOption);
		return dropdown.getFirstselectedDrpdownOption(teacherDropdown);
	}
	public String selectClassroomDropdown(DropdownUtility dropdown,String classroomOption)
	{
		dropdown.selectDropdown(classroomDropdown,classroomOption);
		return dropdown.getFirstselectedDrpdownOption(classroomDropdown);
	}
	public void selectStartTime(String startTimeoption)
	{
		startTimeTextfield.sendKeys(startTimeoption);
	}
	public void selectEndTime(String endTimeOption)
	{
		endTimeTextField.sendKeys(endTimeOption);
	}
	public void clickOnSubmit()
	{
		submitButton.click();
	}
	public void waitTillInvisible(WaitUtility waitutil,long timeouts,WebDriver driver)
	{
		waitutil.waitElementToBeInvisible(driver, timeouts, waitElement);
	}

}
