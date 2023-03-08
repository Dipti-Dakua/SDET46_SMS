package com.practice;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShadowRootTest {
	@Test
	public void shadow()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("chrome://downloads/");
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		WebElement	webEle=(WebElement)jse.executeScript("return document.querySelector('downloads-manager').shadowRoot.querySelector('downloads-toolbar').shadowRoot.querySelector('cr-toolbar').shadowRoot.querySelector('#search').shadowRoot.querySelector('#searchInput')");
		System.out.println(webEle.getAttribute("id"));
		webEle.sendKeys("abcde");
	}

}
