package com.nawaz2000.yourbirthday.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.nawaz2000.yourbirthday.service.HelpWithDate;
import com.nawaz2000.yourbirthday.service.ZodiacFinder;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	
	@GetMapping("/birthdayInfo")
	public String getBInfo(@PathParam(value = "date") String date, Model model) throws ParseException {
		String[] date2 = HelpWithDate.dateHelper(date);
		model.addAttribute("zodiac", ZodiacFinder.findZodiac(Integer.parseInt(date2[2]), date2[1]));
		model.addAttribute("birthDay", date2[0]);
		
		HelpWithDate.age(date);
		
		return "redirect:/";
	}
	
	
}
