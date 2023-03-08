package com.sms.objectRepository.element;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class AdminHomePage {

		WebDriver driver;
		
		@FindBy(xpath="//span[text()='Exam']")
		private WebElement examtab;
		
		@FindBy(xpath="//a[@href='student_exam_marks.php']")
		private WebElement studentexammarkstab;
		
		@FindBy(xpath="//a[contains(text(),' Exam Timetable')]")
		private WebElement studentexamTimetableTab;
		
		@FindBy(xpath="//span[text()='Timetable']")
		private WebElement adminTimetabletab;
		
		@FindBy(xpath="//span[text()='Subject Routing']")
		private WebElement subjectRoutingtab;
		
		@FindBy(xpath="//span[text()='Ingenious Developer1']")
		private WebElement adminTab;
		
		@FindBy(linkText="Sign out")
		private WebElement signOutTab;
		
		public AdminHomePage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		public void clickOnExamMarksTab()
		{
			examtab.click();
			studentexammarkstab.click();
		}
		public void clickOnExamTimetableTab()
		{
			examtab.click();
			studentexamTimetableTab.click();
		}
		
		public void clickOnTimetableTab()
		{
			
			adminTimetabletab.click();
		}
		public void clickOnSubjectRoutingTab()
		{
			subjectRoutingtab.click();
		}
		
		public void logOut()
		{
			adminTab.click();
			signOutTab.click();
		}
	
	}



