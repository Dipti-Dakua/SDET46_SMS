package com.sms.objectRepository.element;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class LoginPage {

		WebDriver driver;
		
		@FindBy(id="email")
		private WebElement UNtextfield;
		
		@FindBy(id="password")
		private WebElement PWDtextfield;
		
		@FindBy(id="btnSubmit")
		private WebElement lgnButton;
		
		public LoginPage(WebDriver driver)
		{
			PageFactory.initElements(driver,this);
		}
		
		public void loginAdmin(String admin_un,String admin_pwd)
		{
			UNtextfield.sendKeys(admin_un);
			PWDtextfield.sendKeys(admin_pwd);
			lgnButton.click();
		}
		
		public void loginGuardian(String guardian_un,String guardian_pwd)
		{
			UNtextfield.sendKeys(guardian_un);
			PWDtextfield.sendKeys(guardian_pwd);
			lgnButton.click();
		}
		
		public void loginInstructor(String instructor_un,String instructor_pwd)
		{
			UNtextfield.sendKeys(instructor_un);
			PWDtextfield.sendKeys(instructor_pwd);
			lgnButton.click();
		}
		
	}



