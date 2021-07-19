package com.nawaz2000.yourbirthday.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.nawaz2000.yourbirthday.service.ZodiacFinder;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	
	@GetMapping("/birthdayInfo")
	public String getBInfo(@PathParam(value = "date") String date) throws ParseException {
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = formatter.parse(date);
		String[] date2 = date1.toGMTString().split("\\s+");
		System.out.println(ZodiacFinder.findZodiac(date1.getDay(), date2[1]));
		
		
		
		String formattedDate = formatDate(date);
		return "redirect:/";
	}
	
	public String formatDate(String date) throws ParseException {
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = formatter.parse(date);
		
		System.out.println(date1);
		SimpleDateFormat dmyFormat = new SimpleDateFormat("dd-MM-yyyy");
		String dmy = dmyFormat.format(date1);
		
		return dmy;
	}
}
