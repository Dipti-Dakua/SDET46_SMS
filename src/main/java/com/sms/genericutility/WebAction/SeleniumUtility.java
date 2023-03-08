package com.sms.genericutility.WebAction;

import java.io.File;

import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Optional;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumUtility {
	WebDriver driver=null;
	/**
	 * This method is used to launch the browser
	 * This method also handles notification pop up by providing the String option
	 * @param browser
	 * @param s
	 * @return
	 */
	public WebDriver  launchBrowser(String browser, @Optional String s)
	{
		
		switch(browser)
		{
		case "chrome":
			if(s!=null)
			{
				ChromeOptions opt= new ChromeOptions();
			opt.addArguments("--disable-notifications");
			 WebDriverManager.chromedriver().setup();
				 driver=new ChromeDriver(opt);
	    	}
			else
			{
				WebDriverManager.chromedriver().setup();
				 driver=new ChromeDriver();
			}
				
				 break;
		case "firefox":
			if(s!=null)
			{
				FirefoxOptions opt = new FirefoxOptions();
			opt.addArguments("--disable-notifications");
			 WebDriverManager.firefoxdriver().setup();
				 driver=new FirefoxDriver();
	    	}
			else
			{
				WebDriverManager.firefoxdriver().setup();
				 driver=new FirefoxDriver();
			}
			 
				 break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			 driver=new EdgeDriver();
				 break;
		default:
			System.out.println("enter proper browser");
		}
		return driver;
	}
	
	
	/**
	 * This method is used to maximize the window
	 * @param driver
	 */
	public void maximize(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * This method is used to fetch all the source code
	 * @param driver
	 * @return
	 */
		public String getSourceCode(WebDriver driver)
		{
			String sourceCode=driver.getPageSource();
				return sourceCode;
		}
	
	/**
	 * This method is used to launch the application	
	 * @param driver
	 * @param url
	 */
			public void launchApplication(WebDriver driver,String url)
			{
				driver.get(url);
			}
	
/**
 * This method is used to get current url of web page
 * @param driver
 * @return
 */
		public String getCurrentUrl(WebDriver driver)
			{
				String url=driver.getCurrentUrl();
				return url;
			}
		
	/**
	 * This method is used to get title of web page
	 * @param driver
	 * @return
	 */
				public String getTitle(WebDriver driver)
				{
					String title=driver.getTitle();
					return title;
				}

	/**
	 * This method is used to close the browser
	 * @param driver
	 */
	public void close(WebDriver driver)
	{
		
		driver.close();
	}
	
	
	
	/**
	 * This method is used to take screenshot of whole webpage
	 * @param driver
	 * @param filename
	 * @throws IOException
	 */
			public String takeScreenshot(String testCaseName,JavaUtility javaUtil) 
				{
					TakesScreenshot ts=(TakesScreenshot) driver;
					File src=ts.getScreenshotAs(OutputType.FILE);
					File trg=new File("./screenshot/"+testCaseName+"_"+javaUtil.getCurrentDateTime()+".png");
					try {
						FileUtils.copyFile(src, trg);
					} catch (IOException e) {
					
					}	
					return trg.getAbsolutePath();
				}
			
			/**
			 * This method is used to take screenshot  in base 64 type
			 * @return
			 */
			
			
			public String takeScreenshot() 
			{
				TakesScreenshot ts=(TakesScreenshot) driver;
			 String path = ts.getScreenshotAs(OutputType.BASE64);
				
		
				return path;
			}
		/**
		 * This method is used to take screenshot of particular webelement	
		 * @param element
		 * @param testCaseName
		 * @param javaUtil
		 * @return
		 */
			
			public String takeScreenshot(WebElement element,String testCaseName,JavaUtility javaUtil)
			{
				//TakesScreenshot ts=(TakesScreenshot) driver;
				File src=element.getScreenshotAs(OutputType.FILE);
				File trg=new File("./screenshot/"+testCaseName+"_"+javaUtil.getCurrentDateTime()+".png");
				try {
					FileUtils.copyFile(src, trg);
				} catch (IOException e) {
					
				}	
				return trg.getAbsolutePath();
			}
	/**
	 * This method is used to quit the browser
	 * @param driver
	 */
			public void quit(WebDriver driver)
				{
			    	driver.quit();
				}
		/**
		 * This method is used to validate checkbox is selected 
		 * @param element
		 */
			public void checkBoxValidation(WebElement element)
			{
				if(element.isSelected())
				{
					System.out.println("checkbox is selected");
				}
				else
				{
					System.out.println("checkbox is not selected");
				}
			}
		
}
