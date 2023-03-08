package edu.sms.admin;
import java.util.Map;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.sms.genericutility.annotation.Report;
import com.sms.genericutility.config.ConfigureClass;
import com.sms.genericutility.enums.ExcelKey;
import com.sms.genericutility.enums.PropertyKey;
import com.sms.objectRepository.element.AdminHomePage;
import com.sms.objectRepository.element.AdminSubjectRoutingPage;
import com.sms.objectRepository.element.InstructorHomePage;
import com.sms.objectRepository.element.InstructorMySubjectPage;
import com.sms.objectRepository.element.LoginPage;

public class AssignSubject extends ConfigureClass {
	@Report(author="Dipti",category="sanity")
	@Test(groups="major")
	public void assignSubject()
	{
		LoginPage loginUtil=new LoginPage(driver);
		AdminHomePage adminHomeEle=new AdminHomePage(driver);
		InstructorHomePage instructorHomeEle=new InstructorHomePage(driver);
		InstructorMySubjectPage instructorSubjectEle=new InstructorMySubjectPage(driver);
		AdminSubjectRoutingPage adminSubjectRoutingEle=new AdminSubjectRoutingPage(driver);
		SoftAssert sa=new SoftAssert();
		
		String admin_username=propertyUtil.getPropertyData(PropertyKey.ADMIN_USERNAME);
		String admin_password=javaUtil.decoder(propertyUtil.getPropertyData(PropertyKey.ADMIN_PASSWORD));
		String instructor_username=	propertyUtil.getPropertyData(PropertyKey.INSTRUCTOR_USERNAME);
		String instructor_password=	propertyUtil.getPropertyData(PropertyKey.INSTRUCTOR_PASSWORD);
		String testcaseNAme="AssignSubject";
		String sheetName=ExcelKey.ADMIN.getSheetName();
		Map<String,String> map=	excelUtil.getData(sheetName,testcaseNAme);
	    String actsubject=map.get("subject");
	    String gradeOption=map.get("grade_dropdown");
	    String subjectOption=map.get("subject_dropdown");
	    String teacherOption=map.get("teacher_dropdown");
	    String feeOption=map.get("fee");
	    //admin login
	    String loginPageTitle=seleniumUtil.getTitle(driver);
	    sa.assertTrue(loginPageTitle.contains("Management"));
		System.out.println("login page displayed");
		loginUtil.loginAdmin(admin_username, admin_password);
		String adminHomePageurl= seleniumUtil.getCurrentUrl(driver);
		sa.assertTrue(adminHomePageurl.contains("dashboard"));
		System.out.println("admin home page is displayed");
		//go to subject routing
		adminHomeEle.clickOnSubjectRoutingTab();
		sa.assertTrue(seleniumUtil.getCurrentUrl(driver).contains("subject_routing.php"));
		System.out.println("admin subject routing page is displayed");
		adminSubjectRoutingEle.clickOnAdd();
		//add subject routing
		adminSubjectRoutingEle.selectDropdown(dropdownUtil, gradeOption);
		String	selectedSubject=adminSubjectRoutingEle.selectSubjectDropdown(dropdownUtil, subjectOption);
		System.out.println(selectedSubject);
		adminSubjectRoutingEle.selectTeacherDropdown(dropdownUtil, teacherOption);
		adminSubjectRoutingEle.setFee(feeOption);
		adminSubjectRoutingEle.clickOnSubmit();
		//Explicit Wait
		adminSubjectRoutingEle.waitTillInvisible(waitutil, timeouts, driver);
		//logout as admin credentials
		adminHomeEle.logOut();
		sa.assertTrue(loginPageTitle.contains("Management"));
		System.out.println("login page displayed");
		//login as instructor credentials
		loginUtil.loginInstructor(instructor_username, instructor_password);
		String instructorHomePageurl= seleniumUtil.getCurrentUrl(driver);
		sa.assertTrue(instructorHomePageurl.contains("dashboard2.php"));
		System.out.println("instructor home page is displayed");
		//go to my subject
		instructorHomeEle.clickMySubjectTab();
		sa.assertTrue(seleniumUtil.getCurrentUrl(driver).contains("my_subject2.php"));
		System.out.println("instructor my subject page is displayed");
		String expSubject=instructorSubjectEle.fetchSubject(actsubject);
		System.out.println(expSubject);
		sa.assertEquals(selectedSubject, expSubject);
		System.out.println("Test case is pass");
		sa.assertAll();
	
}
		

}
