package com.sms.objectRepository.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class InstructorMySubjectPage {
	

	WebDriver driver;
	String partialXpath = "//tr[@role='row']//td[text()='Grade 1']/following-sibling::td[text()='%s']";
	private WebElement convertToElement(String partialXpath,String replaceData)
	{
	String xpath=String.format(partialXpath,replaceData);
	return driver.findElement(By.xpath(xpath));
	}
	
	public InstructorMySubjectPage(WebDriver driver)
	{   this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String fetchSubject(String actsubject)
	{
		return convertToElement(partialXpath,actsubject).getText();
	}

}
