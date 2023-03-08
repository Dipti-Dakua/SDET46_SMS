package com.sms.objectRepository.element;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyStudentMarksPage {
	
	WebDriver driver;
	@FindBy(xpath="//td[@class='sorting_1']/following-sibling::td[@id='td1_31']/following-sibling::td/a[@class=' btn btn-success btn-xs']")
	private WebElement editbutton;
	
	@FindBy(xpath="//td[@class='sorting_1']/following-sibling::td[@id='td1_31']/following-sibling::td/a[@class=' btn btn-primary btn-xs']")
	private WebElement viewMarkbutton;
	
	
	public MyStudentMarksPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickEditButton()
	{
		editbutton.click();
		
	}
	public void clickViewButton()
	{
		viewMarkbutton.click();
		
	}

}
