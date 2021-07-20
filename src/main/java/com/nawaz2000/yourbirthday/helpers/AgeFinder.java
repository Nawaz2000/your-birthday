package com.nawaz2000.yourbirthday.helpers;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

import org.springframework.stereotype.Component;

import com.nawaz2000.yourbirthday.service.HelpWithDate;

@Component("ageFinder")
public class AgeFinder {
	
	public HashMap<String, Integer> age(String date) throws ParseException {
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
	
	public String untilNextBirthday(String date) throws ParseException {		
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		formatter = formatter.withLocale( Locale.US );  // Locale specifies human language for translating, and cultural norms for lowercase/uppercase and abbreviations and such. Example: Locale.US or Locale.CANADA_FRENCH
		LocalDate dateOfBirth = LocalDate.parse(HelpWithDate.formatDate(date), formatter);
		
		Calendar cal = Calendar.getInstance();

        cal.set(Calendar.DAY_OF_MONTH, dateOfBirth.getDayOfMonth());
        cal.set(Calendar.MONTH, dateOfBirth.getMonthValue());
        cal.set(Calendar.YEAR, (LocalDate.now().getYear() + 1));
        Date secondDate = cal.getTime();

        cal.set(Calendar.DAY_OF_MONTH, LocalDate.now().getDayOfMonth());
        cal.set(Calendar.MONTH, LocalDate.now().getMonthValue());
        cal.set(Calendar.YEAR, LocalDate.now().getYear());
        Date firstDate = cal.getTime();

        long diff = secondDate.getTime() - firstDate.getTime();
        
		return Long.toString(diff/ 1000 / 60 / 60 / 24);
		
	}

	public HashMap<String, String> aliveFor(String date) throws ParseException {
        

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		formatter = formatter.withLocale( Locale.US );  // Locale specifies human language for translating, and cultural norms for lowercase/uppercase and abbreviations and such. Example: Locale.US or Locale.CANADA_FRENCH
		LocalDate dateOfBirth = LocalDate.parse(HelpWithDate.formatDate(date), formatter);
		
		Calendar cal = Calendar.getInstance();

        cal.set(Calendar.DAY_OF_MONTH, LocalDate.now().getDayOfMonth());
        cal.set(Calendar.MONTH, LocalDate.now().getMonthValue());
        cal.set(Calendar.YEAR, LocalDate.now().getYear());
        Date secondDate = cal.getTime();

        cal.set(Calendar.DAY_OF_MONTH, dateOfBirth.getDayOfMonth());
        cal.set(Calendar.MONTH, dateOfBirth.getMonthValue());
        cal.set(Calendar.YEAR, dateOfBirth.getYear());
        Date firstDate = cal.getTime();

        long diff = secondDate.getTime() - firstDate.getTime();	
		      
        String hours = Long.toString(diff/1000/60/60);
        String days = Long.toString(diff/1000/60/60/24);
        String weeks = Long.toString(diff/1000/60/60/24/7);
        String months = Integer.toString((int) (Integer.parseInt(weeks) * 0.230137));
        String years = Integer.toString((int) (Integer.parseInt(months) * 0.0833334));
        
        HashMap<String, String> map = new HashMap<>();
        map.put("months", months);
        map.put("weeks", weeks);
        map.put("days", days);
        map.put("hours", hours);
        map.put("years", years);
        
		return map;
	}
	
	
}
