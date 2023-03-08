package edu.sms.admin;
import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.sms.genericutility.annotation.Report;
import com.sms.genericutility.config.ConfigureClass;
import com.sms.genericutility.enums.ExcelKey;
import com.sms.genericutility.enums.PropertyKey;
import com.sms.objectRepository.element.AdminExamTimetablePage;
import com.sms.objectRepository.element.AdminHomePage;
import com.sms.objectRepository.element.InstructorExamTimetablePage;
import com.sms.objectRepository.element.InstructorHomePage;
import com.sms.objectRepository.element.LoginPage;

  public class AddExamTimetableAndVerify extends ConfigureClass {	
	  @Report(author="Dipti",category="sanity")
		@Test(groups="major")
		public void addExamTimetableAndVerify()
		{
			  
			LoginPage loginUtil=new LoginPage(driver);
			AdminHomePage adminHomeEle=new AdminHomePage(driver);
			AdminExamTimetablePage adminExamTimetableEle=new AdminExamTimetablePage(driver);
			InstructorHomePage instructorHomeEle=new InstructorHomePage(driver);
			InstructorExamTimetablePage instructorExamTimetableEe=new InstructorExamTimetablePage(driver);
			
		  //test data
			String admin_username=propertyUtil.getPropertyData(PropertyKey.ADMIN_USERNAME);
			String admin_password=javaUtil.decoder(propertyUtil.getPropertyData(PropertyKey.ADMIN_PASSWORD));
			String instructor_username=	propertyUtil.getPropertyData(PropertyKey.INSTRUCTOR_USERNAME);
			String instructor_password=	propertyUtil.getPropertyData(PropertyKey.INSTRUCTOR_PASSWORD);
			String testcaseNAme="AddExamTimetableAndVerify";
			String sheetName=ExcelKey.ADMIN.getSheetName();
			Map<String,String> map=	excelUtil.getData(sheetName,testcaseNAme);
			
			String gradeOption=map.get("grade_dropdown");
			String examOption=map.get("exam_dropdown");
			String dayOption=map.get("day_dropdown");
			String subjectOption=map.get("subject_dropdown");
			String classroomOption=map.get("classroom_dropdown");
			String startTimeoption=map.get("Start_time");
			String endTimeOption=map.get("End_time");
			SoftAssert sa=new SoftAssert();
		//admin login	
			sa.assertTrue(seleniumUtil.getTitle(driver).contains("Management"));
		System.out.println("login page displayed");
		loginUtil.loginAdmin(admin_username, admin_password);
		sa.assertTrue(seleniumUtil.getCurrentUrl(driver).contains("dashboard"));
		System.out.println("admin home page is displayed");
		//go to exam timetable
		adminHomeEle.clickOnExamTimetableTab();
		//select all necessary fields
		sa.assertTrue(seleniumUtil.getCurrentUrl(driver).contains("exam_timetable.php"));
		System.out.println("admin exam tmetable page is displayed");
		adminExamTimetableEle.selectDropdown(dropdownUtil, gradeOption,examOption);
		//add exam timetable
		adminExamTimetableEle.clickAddExamTimetable();
		adminExamTimetableEle.selectDayDropdown(dropdownUtil, dayOption);
		String	actsubject=adminExamTimetableEle.selectSubjectDropdown(dropdownUtil, subjectOption);
		System.out.println(actsubject);
		String actClassroom=adminExamTimetableEle.selectClassroomDropdown(dropdownUtil, classroomOption);
		System.out.println(actClassroom);
		adminExamTimetableEle.selectStartTime(startTimeoption);
		adminExamTimetableEle.selectEndTime(endTimeOption);	
		adminExamTimetableEle.clickOnSubmit();
        //Explicit Wait
		adminExamTimetableEle.waitTillInvisible(waitutil, timeouts, driver);
		//logout as admin credentials
		adminHomeEle.logOut();
		sa.assertTrue(seleniumUtil.getTitle(driver).contains("Management"));
		System.out.println("login page displayed");
		//login as instructor credentials
		loginUtil.loginInstructor(instructor_username, instructor_password);
		sa.assertTrue(seleniumUtil.getCurrentUrl(driver).contains("dashboard2.php"));
		System.out.println("instructor home page is displayed");
		//go to exam timetable
		instructorHomeEle.clickOnExamTimetableTab();
		sa.assertTrue(seleniumUtil.getCurrentUrl(driver).contains("exam_timetable2.php"));
		System.out.println("instructor exam timetable page is displayed");
		//select necessary fields 
		instructorExamTimetableEe.selectDropdown(dropdownUtil, examOption, gradeOption);
		//validate added timetable details
		String expresult=instructorExamTimetableEe.fetchExamTimetableDetails();
		sa.assertTrue(expresult .contains(actsubject) && expresult.contains(actClassroom));		
		System.out.println("test case is pass");
		sa.assertAll();
	}	
					
	}






