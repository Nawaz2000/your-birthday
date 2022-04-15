package com.nawaz2000.yourbirthday.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class HelpWithDate {
	
	public static String[] dateHelper(String date) throws ParseException {
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = formatter.parse(date);
		
		String[] date2 = date1.toString().split("\\s+");
		
		if (date2[0].equalsIgnoreCase("Mon"))
			date2[0] = "Monday";
		else if (date2[0].equalsIgnoreCase("Tue"))
			date2[0] = "Tuesday";
		else if (date2[0].equalsIgnoreCase("Wed"))
			date2[0] = "Wednesday";
		else if (date2[0].equalsIgnoreCase("Thu"))
			date2[0] = "Thursday";
		else if (date2[0].equalsIgnoreCase("Fri"))
			date2[0] = "Friday";
		else if (date2[0].equalsIgnoreCase("Sat"))
			date2[0] = "Saturday";
		else if (date2[0].equalsIgnoreCase("Sun"))
			date2[0] = "Sunday";
		
		return date2;
	}
	
	
	
	public static String formatDate(String date) throws ParseException {
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = formatter.parse(date);
		
		SimpleDateFormat dmyFormat = new SimpleDateFormat("yyyy-MM-dd");
		String dmy = dmyFormat.format(date1);
		
		return dmy;
	}


	public static LocalDate getLocalDateByStr(String dateStr) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate date = LocalDate.parse(dateStr, formatter);
		return date;
	}
}
