package com.nawaz2000.yourbirthday.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HelpWithDate {
	
	public static String[] dateHelper(String date) throws ParseException {
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = formatter.parse(date);
		String[] date2 = date1.toString().split("\\s+");
		return date2;
	}
	
	
	
	public static String formatDate(String date) throws ParseException {
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = formatter.parse(date);
		
		System.out.println(date1);
		SimpleDateFormat dmyFormat = new SimpleDateFormat("yyyy-MM-dd");
		String dmy = dmyFormat.format(date1);
		
		return dmy;
	}
}
