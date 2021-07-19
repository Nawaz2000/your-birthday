package com.nawaz2000.yourbirthday.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.nawaz2000.yourbirthday.service.AgeFinder;
import com.nawaz2000.yourbirthday.service.ChineseBirthYear;
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
		
		for (String x : date2)
			System.out.println(x);
		System.out.println("\n\n-------------------->");
		
		model.addAttribute("zodiac", ZodiacFinder.findZodiac(Integer.parseInt(date2[2]), date2[1]));
		  System.out.println("Zodiac sign: " + ZodiacFinder.findZodiac(Integer.parseInt(date2[2]), date2[1]));
		model.addAttribute("birthDay", date2[0]);
		  System.out.println("Birth day: " + date2[0]);
		model.addAttribute("age", AgeFinder.age(date));
		  System.out.println("Age: " + AgeFinder.age(date).get("Years") + " years "
				   + AgeFinder.age(date).get("Months") + " months " + AgeFinder.age(date).get("Days") + " days");
		
		model.addAttribute("chineseBirthAnimal", ChineseBirthYear.chineseBirthAnimal(date));
		System.out.println("Chinese birth animal: " + ChineseBirthYear.chineseBirthAnimal(date));
		
		return "redirect:/";
	}
	
	
}
