package com.sms.objectRepository.element;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sms.genericutility.misc.WaitUtility;

public class AdminEditExamMarksPage {
	
	
	WebDriver driver;
	@FindBy(xpath="//td[@id='eSubject_td_1']/following-sibling::td[@id='eMark_td_1']/input")
	private WebElement mathsTextBox;
	
	
	@FindBy(xpath="//td[@id='eSubject_td_2']/following-sibling::td[@id='eMark_td_2']/input")
	private WebElement seleniumTextBox;
	
	@FindBy(id="btnSubmit3")
	private WebElement updateBtn;
	
	@FindBy(xpath="//div[@id='update_Success']/div/div/div/following-sibling::div")
	private WebElement message;

	@FindBy(xpath="//div[@id='duplicate_Record1']/div/div/div/button")
	private WebElement waitElement;
	
	
	/**
	 * This method is used to initilize the webelement
	 * @param driver
	 */
	public AdminEditExamMarksPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	/**
	 * This method is used to update the marks and click on update button
	 * @param mathmarks
	 * @param seleniummarks
	 */
	public void updateMark(String mathmarks,String seleniummarks)
	{
		mathsTextBox.clear();
		mathsTextBox.sendKeys(mathmarks);
		seleniumTextBox.clear();
		seleniumTextBox.sendKeys(seleniummarks);
		updateBtn.click();
	}
	/**
	 * This method is used to get the sucess message from web page
	 * @return
	 */
	public String getMessage()
	{
		return message.getText();
	}
	/**
	 * This method is used to wait till the webelement is invisible
	 * @param waitutil
	 * @param timeouts
	 * @param driver
	 */
	public void waitTillInvisible(WaitUtility waitutil,long timeouts,WebDriver driver)
	{
		waitutil.waitElementToBeInvisible(driver, timeouts, waitElement);
	}
	
	


}
