package edu.sms.admin;

import java.util.Map;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.sms.genericutility.annotation.Report;
import com.sms.genericutility.config.ConfigureClass;
import com.sms.genericutility.enums.ExcelKey;
import com.sms.genericutility.enums.PropertyKey;
import com.sms.objectRepository.element.AdminEditExamMarksPage;
import com.sms.objectRepository.element.AdminExamPage;
import com.sms.objectRepository.element.AdminHomePage;
import com.sms.objectRepository.element.AdminViewExamMarksPage;
import com.sms.objectRepository.element.GuardianHomePage;
import com.sms.objectRepository.element.GuardianMySonsExamMarksPage;
import com.sms.objectRepository.element.LoginPage;
import com.sms.objectRepository.element.MySonsExamPage;
import com.sms.objectRepository.element.MyStudentMarksPage;

public class AddExamMarksAndVerify extends ConfigureClass{
	@Report(author="Dipti",category="sanity")
	@Test(groups="minor")
	public void addExamMarksAndVerify()
	{
		LoginPage loginUtil=new LoginPage(driver);
		AdminHomePage homeEle=new AdminHomePage(driver);
		AdminExamPage examPage=new AdminExamPage(driver);
		MyStudentMarksPage studentmarks=new MyStudentMarksPage(driver);
		AdminViewExamMarksPage adminViewExamEle=new AdminViewExamMarksPage(driver);
		AdminEditExamMarksPage editmark=new AdminEditExamMarksPage(driver);
		GuardianHomePage guardianHomeEle=new GuardianHomePage(driver);
		MySonsExamPage sonExamEle= new MySonsExamPage(driver);
		GuardianMySonsExamMarksPage guardianExamMarksEle=new GuardianMySonsExamMarksPage(driver);
		//test data
		String admin_username=propertyUtil.getPropertyData(PropertyKey.ADMIN_USERNAME);
		String admin_password=javaUtil.decoder(propertyUtil.getPropertyData(PropertyKey.ADMIN_PASSWORD));
		String guardian_username=propertyUtil.getPropertyData(PropertyKey.GUARDIAN_USERNAME);
		String guardian_password=propertyUtil.getPropertyData(PropertyKey.GUARDIAN_PASSWORD);
		String testcaseNAme="AddExamMarksAndVerify";
		String sheetName=ExcelKey.ADMIN.getSheetName();
		Map<String,String> map=	excelUtil.getData(sheetName,testcaseNAme);
		String subject1=map.get("subject1");
		String subject2=map.get("subject2");
		String gradeOption=map.get("grade_dropdown");
		String examOption=map.get("exam_dropdown");
		String mathmarks=map.get("subject1_marks");
		String seleniummarks=map.get("subject2_marks");


		Assert.assertTrue(seleniumUtil.getTitle(driver).contains("Management"));
		System.out.println("login page displayed");
		loginUtil.loginAdmin(admin_username, admin_password);
		Assert.assertTrue(seleniumUtil.getCurrentUrl(driver).contains("dashboard"));
		System.out.println("admin home  page displayed");
		//go to exam marks
		homeEle.clickOnExamMarksTab();
		Assert.assertTrue(seleniumUtil.getCurrentUrl(driver).contains("student_exam_marks.php"));
		System.out.println("student_exam_marks  page displayed");
		//select necessary fields
		examPage.selectDropdown(dropdownUtil, gradeOption, examOption);
		//add marks
		studentmarks.clickEditButton();
		editmark.updateMark(mathmarks, seleniummarks);
		String succesMessage= editmark.getMessage();
		System.out.println(succesMessage);
		editmark.waitTillInvisible(waitutil, timeouts,driver);
		//view exam marks
		studentmarks.clickViewButton();
		String actmathmarks=adminViewExamEle.fetchSubjectMarks(subject1);
		System.out.println(actmathmarks);
		String actseleniummarks=adminViewExamEle.fetchSubjectMarks(subject2);	
		System.out.println(actseleniummarks);
		//logout as admin credentials
		homeEle.logOut();
		Assert.assertTrue(seleniumUtil.getTitle(driver).contains("Management"));
		System.out.println("login page displayed");
		//login as guardian credential
		loginUtil.loginGuardian(guardian_username, guardian_password);
		Assert.assertTrue(seleniumUtil.getCurrentUrl(driver).contains("dashboard3.php"));
		System.out.println("guardian home page displayed");
		//go to son's exam marks
		guardianHomeEle.clickOnExamTab();
		//select necessary fields
		sonExamEle.selectDropdown(dropdownUtil, examOption);
		Assert.assertTrue(seleniumUtil.getCurrentUrl(driver).contains("my_sons_exam_marks.php"));
		System.out.println("my son's_exam_marks page displayed");
		//validate added marks details	
		String expmathmarks=guardianExamMarksEle.fetchSubjectMarks(subject1);
		String expseleniummarks=guardianExamMarksEle.fetchSubjectMarks(subject2);
		Assert.assertTrue(actmathmarks.contains(expmathmarks) && actseleniummarks.contains (expseleniummarks));
		System.out.println("test case is pass");
		//report.info(UtilityInstanceTransfer.getExtentTest(),"test case is pass");
	}
}
