package edu.sms.admin;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sms.genericutility.annotation.Report;
import com.sms.genericutility.config.ConfigureClass;
import com.sms.genericutility.enums.ExcelKey;
import com.sms.genericutility.enums.PropertyKey;
import com.sms.objectRepository.element.AdminHomePage;
import com.sms.objectRepository.element.AdminTimetablePage;
import com.sms.objectRepository.element.InstructorHomePage;
import com.sms.objectRepository.element.InstructorTimetablePage;
import com.sms.objectRepository.element.LoginPage;

public class AddAndVerifyTimetable extends ConfigureClass {
	@Report(author="Dipti",category="sanity")
	@Test(groups="major")
	public void addAndVerifyTimetable()
	{
		LoginPage loginUtil=new LoginPage(driver);
		AdminHomePage adminhomeEle=new AdminHomePage(driver);
		AdminTimetablePage adminTimetableEle=new AdminTimetablePage(driver);
		InstructorHomePage instructorHomeEle=new InstructorHomePage(driver);
		InstructorTimetablePage instructorTimetableEle= new InstructorTimetablePage(driver);
		//test data
		String admin_username=propertyUtil.getPropertyData(PropertyKey.ADMIN_USERNAME);
		String admin_password=javaUtil.decoder(propertyUtil.getPropertyData(PropertyKey.ADMIN_PASSWORD));
		String instructor_username=	propertyUtil.getPropertyData(PropertyKey.INSTRUCTOR_USERNAME);
		String instructor_password=	propertyUtil.getPropertyData(PropertyKey.INSTRUCTOR_PASSWORD);
		String testcaseNAme="AddAndVerifyTimetable";
		String sheetName=ExcelKey.ADMIN.getSheetName();
		Map<String,String> map=	excelUtil.getData(sheetName,testcaseNAme);
		String gradeOption=map.get("grade_dropdown");
		String dayOption=map.get("day_dropdown");
		String subjectOption=map.get("subject_dropdown");
		String teacherOption=map.get("teacher_dropdown");
		String classroomOption=map.get("classroom_dropdown");
		String startTimeoption=map.get("Start_time");
		String endTimeOption=map.get("End_time");
		
		Assert.assertTrue(seleniumUtil.getTitle(driver).contains("Management"));
		System.out.println("login page displayed");
		//admin login
		loginUtil.loginAdmin(admin_username, admin_password);
		Assert.assertTrue(seleniumUtil.getCurrentUrl(driver).contains("dashboard"));
		System.out.println("admin home page is displayed");
		//go to timetable
		adminhomeEle.clickOnTimetableTab();
		Assert.assertTrue(seleniumUtil.getCurrentUrl(driver).contains("timetable.php"));
		System.out.println("admin timetable page is displayed");
		
		//select grade 
		adminTimetableEle.selectDropdown(dropdownUtil, gradeOption);
		adminTimetableEle.clickAddButton();
		//add timetable details
		adminTimetableEle.selectDayDropdown(dropdownUtil, dayOption);
		String actsubject=adminTimetableEle.selectSubjectDropdown(dropdownUtil, subjectOption);
		String actTeacher=adminTimetableEle.selectTeacherDropdown(dropdownUtil, teacherOption);
		String actClassroom=adminTimetableEle.selectClassroomDropdown(dropdownUtil, classroomOption);
		adminTimetableEle.selectStartTime(startTimeoption);
		adminTimetableEle.selectEndTime(endTimeOption);
		adminTimetableEle.clickOnSubmit();
		//Explicit Wait
		adminTimetableEle.waitTillInvisible(waitutil,timeouts,driver);
		//logout as admin credential
		adminhomeEle.logOut();
		Assert.assertTrue(seleniumUtil.getTitle(driver).contains("Management"));
		System.out.println("login page displayed");
		//login as instructor credential
		loginUtil.loginInstructor(instructor_username, instructor_password);
		Assert.assertTrue(seleniumUtil.getCurrentUrl(driver).contains("dashboard2.php"));
		System.out.println("instructor home page is displayed");
		//go to my timetable
		instructorHomeEle.clickOnMyTimetableTab();
		Assert.assertTrue(seleniumUtil.getCurrentUrl(driver).contains("my_timetable2.php"));
		System.out.println("instructor timetable page is displayed");
		//validate added timetable details
		String expresult=instructorTimetableEle.fetchTimetableDetails();
		Assert.assertTrue(expresult.contains(actsubject) && expresult.contains(actTeacher) && expresult.contains(actClassroom));
		System.out.println("test case is pass");	
}



}
