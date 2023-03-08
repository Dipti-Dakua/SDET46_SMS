package com.sms.genericutility.WebAction;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class JavaUtility {
	
	
	
	/**
	 * This method is used to fetch the current date
	 * @return
	 */
	public String getCurrentDateTime()
	{

	SimpleDateFormat sdf=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
	String modifiedDate=sdf.format(new Date());
	return modifiedDate;
	}
	

	/**
	 * This method is used to fetch the tomorrow date
	 * @return
	 */
	public String tommorrowDate()
	{
	Calendar cal=Calendar.getInstance();
	cal.add(Calendar.DAY_OF_MONTH,1);
	
	SimpleDateFormat sdf=new SimpleDateFormat("dd_MMM_yyyy");
	String modifiedDate=sdf.format(cal.getTime());
	return modifiedDate;
	}
	
	/**
	 * This method is used to Add or subtract date from current date
	 * @param date
	 * @param daycount
	 * @return
	 */
	public String requiredDate(int daycount)
	{
		SimpleDateFormat sdf=new SimpleDateFormat("dd_MMM_yyyy");
		Calendar cal=Calendar.getInstance();
			cal.add(Calendar.DAY_OF_MONTH,daycount);
		String modifiedDate=sdf.format(cal.getTime());
	return modifiedDate;
	}	
	
/**
 * This method is used to add or subtract date from given date
 * @param date
 * @param daycount
 * @return
 */
	
	
	public String requiredDate(String date,int daycount)
	{
	// String date="03-feb-2022";
		SimpleDateFormat sdf=new SimpleDateFormat("dd_MMM_yyyy");
		Calendar cal=Calendar.getInstance();
		
		try {
			cal.setTime(sdf.parse(date));
			cal.add(Calendar.DAY_OF_MONTH,daycount);
			
			
		} catch (ParseException e) {
			
		}
		String modifiedDate=sdf.format(cal.getTime());
	return modifiedDate;
	
	}
	/**
	 * This method is used to convert month name to month number
	 * we have to specify month name based on below pattern
	 * MMMM=full month name
	 * MMM=3 letter of month name
	 * @param requiredMonth
	 * @return
	 */
	
	public int getMonthNumber(String requiredMonth,String pattern)
	{
		
		int requiredMonthonthNum= DateTimeFormatter.ofPattern(pattern)
		.withLocale(Locale.ENGLISH)
		.parse(requiredMonth)
		.get(ChronoField.MONTH_OF_YEAR);
		return requiredMonthonthNum;
		
	}


	/**
	 * This method is used to create random number to make it unique
	 * @param value
	 * @return
	 */
	
	public int getRandomNum(int boundaryvalue)
	{
	Random ran =new Random();
	int num=ran.nextInt(boundaryvalue);
	return num;
	}

	/**
	 * This method is used to encrypt the data
	 * @param s
	 * @return
	 */
	public String encoder(String s)
	{
		byte[] byteA = s.getBytes();
		byte[] byteB = Base64.getEncoder().encode(byteA);
		String modifiedString=new String(byteB);
		return modifiedString;
	}
	/**
	 * This method is used to decode the data
	 * @param s
	 * @return
	 */
	public String decoder(String s)
	{
		return new String(Base64.getDecoder().decode(s.getBytes()));
	}


}
