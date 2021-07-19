package com.nawaz2000.yourbirthday.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	
	@GetMapping("/birthdayInfo")
	public String getBInfo(@PathParam(value = "date") String date) throws ParseException {
		System.out.println("unformatted: " + date);
		String formattedDate = formatDate(date);
		System.out.println("formatted: " + formattedDate);
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
