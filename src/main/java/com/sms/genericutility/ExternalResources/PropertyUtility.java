package com.sms.genericutility.ExternalResources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.sms.genericutility.enums.PropertyKey;
/**
 * This class is used to handle the property file
 * @author MY PC
 *
 */
public class PropertyUtility {
	FileInputStream propertyFis = null;
	private Properties pobj;
	/**
	 * This constructor is used to initialize the property file
	 * @param filepath
	 */
public	PropertyUtility(String filepath)
	{

	
	try {
		propertyFis = new FileInputStream(filepath);
	} catch (FileNotFoundException e) {
		
	}
	 pobj=new Properties();
	try {
		pobj.load(propertyFis);
	} catch (IOException e) {

	}
	try {
		propertyFis.close();
	   } 
	catch (IOException e)
	{
	
	}
		
	}
public	PropertyUtility()
{
	
}
	
	
	/**
	 * This method  is used to initialize the propertyFile
	 * @param filepath
	 */
@Deprecated
	public void InitializerPropertyData(String filepath)
	{
		FileInputStream fis2 = null;
		try {
			fis2 = new FileInputStream(filepath);
		} catch (FileNotFoundException e) {
			
		}
		 pobj=new Properties();
		try {
			pobj.load(fis2);
		} catch (IOException e) {

		}
	}
	/**
	 * This mathod is used to fetch the data from propertyFile
	 * @param key
	 * @return
	 */
	
	
	public String getPropertyData(PropertyKey key)
	{
		String keyString=key.name().toLowerCase();
	String value=pobj.getProperty(keyString,"enter proper key '"+keyString+"'").trim();
	return value;
	}
	
	/**
	 * This method is used to close the property file
	 */
	public void Close()
	{
		try {
			propertyFis.close();
		} catch (IOException e) {
			
		}
	}
}
