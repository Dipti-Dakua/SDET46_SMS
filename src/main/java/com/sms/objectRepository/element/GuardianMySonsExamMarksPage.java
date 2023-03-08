package com.sms.objectRepository.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class GuardianMySonsExamMarksPage {
	
	WebDriver driver;
	String partialXpath = "//td[text()='%s']//../td[3]";
	private WebElement convertToElement(String partialXpath,String replaceData)
	{
	String xpath=String.format(partialXpath,replaceData);
	return driver.findElement(By.xpath(xpath));
	}
	
	public GuardianMySonsExamMarksPage(WebDriver driver)
	{   this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String fetchSubjectMarks(String subject1)
	{
		return convertToElement(partialXpath,subject1).getText();
	}
	


}
