package com.nawaz2000.yourbirthday.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.nawaz2000.yourbirthday.service.BirthdayService;

import com.nawaz2000.yourbirthday.service.HelpWithDate;

// added
// star sign
// Day of birth
// exact age
// chinese birth year
// until next birthday
// birthstone
// alive for
// 

@Controller
public class HomeController {

	@Autowired
	BirthdayService service;

	@GetMapping("/")
	public String showHome(Model model) { 
		model.addAttribute("localDate", LocalDate.now());
		return "home";
	}
	

	@GetMapping("/birthdayInfo")
	public String getBInfo(@PathParam(value = "date") String date, Model model) throws ParseException {

		String[] date2 = HelpWithDate.dateHelper(date);

		model.addAttribute("zodiac", service.findZodiac(Integer.parseInt(date2[2]), date2[1]));
//		  System.out.println("Zodiac sign: " + service.findZodiac(Integer.parseInt(date2[2]), date2[1]));
		model.addAttribute("birthDay", date2[0]);
//		  System.out.println("Birth day: " + date2[0]);
		model.addAttribute("age", service.age(date));
//		  System.out.println("Age: " + service.age(date).get("Years") + " years "
//				   + service.age(date).get("Months") + " months " + service.age(date).get("Days") + " days");

		model.addAttribute("chineseBirthAnimal", service.chineseBirthAnimal(date));
//		  System.out.println("Chinese birth animal: " + service.chineseBirthAnimal(date));

		model.addAttribute("birthStone", service.birthStone(date));
//		  System.out.println("Birthstone: " + service.birthStone(date));

		model.addAttribute("untilNextBirthDay", service.untilNextBirthday(date));

		model.addAttribute("aliveFor", service.aliveFor(date));

		System.out.println(LocalDate.now());
		return "result";
	}

}
