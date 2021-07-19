package com.nawaz2000.yourbirthday.service;

public class ZodiacFinder {

	public static String findZodiac(int day, String month) {
		String sign = "";
		if (month.equalsIgnoreCase("Jan")) {
			if (day < 20)
				sign = "Capricorn";
			else
				sign = "Aquarius";
		} else if (month.equalsIgnoreCase("Feb")) {
			if (day < 19)
				sign = "Aquarius";
			else
				sign = "Pisces";
		} else if (month.equalsIgnoreCase("Mar")) {
			if (day < 21)
				sign = "Pisces";
			else
				sign = "Aries";
		} else if (month.equalsIgnoreCase("Apr")) {
			if (day < 20)
				sign = "Aries";
			else
				sign = "Taurus";
		} else if (month.equalsIgnoreCase("May")) {
			if (day < 21)
				sign = "Taurus";
			else
				sign = "Gemini";
		} else if (month.equalsIgnoreCase("June")) {
			if (day < 21)
				sign = "Gemini";
			else
				sign = "Cancer";
		} else if (month.equalsIgnoreCase("Jul")) {
			if (day < 23)
				sign = "Cancer";
			else
				sign = "Leo";
		} else if (month.equalsIgnoreCase("Aug")) {
			if (day < 23)
				sign = "Leo";
			else
				sign = "Virgo";
		} else if (month.equalsIgnoreCase("Sep")) {
			if (day < 23)
				sign = "Virgo";
			else
				sign = "Libra";
		} else if (month.equalsIgnoreCase("Oct")) {
			if (day < 23)
				sign = "Libra";
			else
				sign = "Scorpio";
		} else if (month.equalsIgnoreCase("Nov")) {
			if (day < 22)
				sign = "scorpio";
			else
				sign = "Sagittarius";
		} else if (month.equalsIgnoreCase("Dec")) {
			if (day < 22)
				sign = "Sagittarius";
			else
				sign = "Capricorn";
		}
		return sign;
	}

}
