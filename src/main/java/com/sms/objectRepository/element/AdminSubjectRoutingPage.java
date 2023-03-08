package com.sms.objectRepository.element;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sms.genericutility.misc.DropdownUtility;
import com.sms.genericutility.misc.WaitUtility;

public class AdminSubjectRoutingPage {
	WebDriver driver;
	

	@FindBy(xpath="//a[@class='btn btn-success btn-sm pull-right']")
	private WebElement addButton;
	
	@FindBy(id="grade")
	private WebElement gradeDropdown;
	
	@FindBy(id="subject")
	private WebElement subjectDropdown;
	
	@FindBy(id="teacher")
	private WebElement teacherDropdown;
	
	@FindBy(id="fee")
	private WebElement feeTextField;
	
	@FindBy(id="btnSubmit")
	private WebElement submitBtn;
	
	@FindBy(xpath="//div[@id='duplicate_Record1']/div/div/div/button")
	private WebElement waitElement;
	
   
	public AdminSubjectRoutingPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnAdd()
	{
		addButton.click();
	}
	
	public void selectDropdown(DropdownUtility dropdown,String gradeOption)
	{
		dropdown.selectDropdown(gradeDropdown, gradeOption);
	}
	
	public String selectSubjectDropdown(DropdownUtility dropdown,String subjectOption)
	{
		dropdown.selectDropdown(subjectDropdown, subjectOption);
	return	dropdown.getFirstselectedDrpdownOption(subjectDropdown);
	}
	
	public void selectTeacherDropdown(DropdownUtility dropdown,String teacherOption)
	{
		dropdown.selectDropdown(teacherDropdown, teacherOption);
		
	}
	public void setFee(String feeOption)
	{
		feeTextField.sendKeys(feeOption);
	}
	
	public void clickOnSubmit()
	{
		submitBtn.click();
	}
	public void waitTillInvisible(WaitUtility waitutil,long timeouts,WebDriver driver)
	{
		waitutil.waitElementToBeInvisible(driver, timeouts, waitElement);
	}
	
	
	
}
