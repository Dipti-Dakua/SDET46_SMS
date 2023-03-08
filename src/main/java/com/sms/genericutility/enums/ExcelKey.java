package com.sms.genericutility.enums;
/**
 * This enum is used to get the Sheet name
 * @author MY PC
 *
 */
public enum ExcelKey {
	ADMIN("Admin");
	String key;
	
	
	private  ExcelKey(String key)
	{
		this.key=key;
	}
	public String getSheetName()
	{
		return key;
	}

}
