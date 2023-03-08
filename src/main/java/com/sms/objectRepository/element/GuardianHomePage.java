package com.sms.objectRepository.element;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GuardianHomePage {
	
	WebDriver driver;
	
	@FindBy(xpath="//span[text()='Exam']")
	private WebElement examtab;
	
	@FindBy(xpath="//a[@href='my_sons_exam_marks.php']")
	private WebElement myStuentExammarkstab;
	
	@FindBy(xpath="//span[text()='Ingenious Developer1']")
	private WebElement adminTab;
	
	@FindBy(linkText="Sign out")
	private WebElement signOutTab;
	
	public GuardianHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnExamTab()
	{
		examtab.click();
		myStuentExammarkstab.click();
	}
	
	public void logOut()
	{
		adminTab.click();
		signOutTab.click();
	}

}



