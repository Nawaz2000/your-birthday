package com.nawaz2000.yourbirthday.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

public class HelpWithDate {
	
	public static String[] dateHelper(String date) throws ParseException {
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = formatter.parse(date);
		String[] date2 = date1.toGMTString().split("\\s+");
		return date2;
	}
	
	public static HashMap<String, Integer> age(String date) throws ParseException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		formatter = formatter.withLocale( Locale.US );  // Locale specifies human language for translating, and cultural norms for lowercase/uppercase and abbreviations and such. Example: Locale.US or Locale.CANADA_FRENCH
		LocalDate dateOfBirth = LocalDate.parse(formatDate(date), formatter);
		
		
		Period period = Period.between(dateOfBirth, LocalDate.now());
		
		
		HashMap<String, Integer> age = new HashMap<>();
		age.put("Years", period.getYears());
		age.put("Months", period.getMonths());
		age.put("Days", period.getDays());
		
		return age;
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
