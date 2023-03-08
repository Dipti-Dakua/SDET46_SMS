package com.sms.genericutility.config;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.sms.genericutility.ExternalResources.ExcelUtility;
import com.sms.genericutility.ExternalResources.PropertyUtility;
import com.sms.genericutility.WebAction.JavaUtility;
import com.sms.genericutility.WebAction.SeleniumUtility;
import com.sms.genericutility.WebAction.VerificationUtility;
import com.sms.genericutility.misc.DropdownUtility;
import com.sms.genericutility.misc.ReportUtility;
import com.sms.genericutility.misc.WaitUtility;
/**
 * This class is used to declare all the necessary utility
 * @author MY PC
 *
 */
public class DeclarationConfigure {
	public PropertyUtility propertyUtil;
	protected ExcelUtility excelUtil;
	public SeleniumUtility seleniumUtil;
	protected WaitUtility waitutil;
	protected DropdownUtility dropdownUtil;
	protected VerificationUtility verificationUtil;
	public JavaUtility javaUtil;
	protected String browser;
	protected long timeouts;
	public WebDriver driver;
	public ReportUtility report;
	public ExtentTest test;

}
