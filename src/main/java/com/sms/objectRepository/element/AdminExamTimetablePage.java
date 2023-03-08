package com.sms.objectRepository.element;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sms.genericutility.misc.DropdownUtility;
import com.sms.genericutility.misc.WaitUtility;

public class AdminExamTimetablePage {
	
	WebDriver driver;
	@FindBy(name="grade")
	private WebElement gradeDropdown;
	
	@FindBy(name="exam")
	private WebElement examDropdown;
	
	@FindBy(xpath="//button[text()='Next']")
	private WebElement nextBtn;
	
	@FindBy(xpath="//a[@class='btn btn-success btn-sm pull-right']")
	private WebElement addBtn;
	
	@FindBy(id="day")
	private WebElement dayDropdown;
	
	@FindBy(id="subject")
	private WebElement subjectDropdown;
	
	@FindBy(id="classroom")
	private WebElement classroomDropdown;
	
	@FindBy(id="start_time")
	private WebElement startTimeTextfield;
	
	@FindBy(id="end_time")
	private WebElement endTimeTextField;
	
	@FindBy(id="btnSubmit")
	private WebElement submitButton;
	
	@FindBy(xpath="//div[@id='insert_Success']/div/div/div/button")
	private WebElement waitElement;
	/**
	 * This method is used to initialize the webelement
	 * @param driver
	 */
	public AdminExamTimetablePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	/**
	 * This method is used to select grade and exam dropdown and click on next button
	 * @param dropdown
	 * @param gradeOption
	 * @param examOption
	 */
	public void selectDropdown(DropdownUtility dropdown,String gradeOption,String examOption)
	{
		dropdown.selectDropdown(gradeDropdown, gradeOption);
		dropdown.selectDropdown(examDropdown, examOption);
		nextBtn.click();
	}
	public void clickAddExamTimetable()
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
