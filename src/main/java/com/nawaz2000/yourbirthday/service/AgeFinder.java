package com.nawaz2000.yourbirthday.service;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Locale;

public class AgeFinder {
	
	public static HashMap<String, Integer> age(String date) throws ParseException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		formatter = formatter.withLocale( Locale.US );  // Locale specifies human language for translating, and cultural norms for lowercase/uppercase and abbreviations and such. Example: Locale.US or Locale.CANADA_FRENCH
		LocalDate dateOfBirth = LocalDate.parse(HelpWithDate.formatDate(date), formatter);
		
		
		Period period = Period.between(dateOfBirth, LocalDate.now());
		
		
		HashMap<String, Integer> age = new HashMap<>();
		age.put("Years", period.getYears());
		age.put("Months", period.getMonths());
		age.put("Days", period.getDays());
		
		return age;
	}
	
}
