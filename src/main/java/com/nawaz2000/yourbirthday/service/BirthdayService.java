package com.nawaz2000.yourbirthday.service;

import java.text.ParseException;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nawaz2000.yourbirthday.helpers.AgeFinder;
import com.nawaz2000.yourbirthday.helpers.BirthStone;
import com.nawaz2000.yourbirthday.helpers.ChineseBirthYear;
import com.nawaz2000.yourbirthday.helpers.ZodiacFinder;

@Service
public class BirthdayService {
	
	@Autowired
	private ZodiacFinder zf;
	
	@Autowired
	private AgeFinder af;
	
	@Autowired
	private ChineseBirthYear cby;
	
	@Autowired
	private BirthStone bs;
	
	public String findZodiac(int day, String month) {
		return zf.findZodiac(day, month);
	}
	
	public HashMap<String, Integer> age(String date) throws ParseException{
		return af.age(date);
	}
	
	public String chineseBirthAnimal(String date) throws NumberFormatException, ParseException {
		return cby.chineseBirthAnimal(date);
	}
	
	public String birthStone(String date) throws ParseException {
		return bs.birthStone(date);
	}
	
	public void untilNextBirthday(String date) throws ParseException {
		af.untilNextBirthday(date);
	}
	
}
