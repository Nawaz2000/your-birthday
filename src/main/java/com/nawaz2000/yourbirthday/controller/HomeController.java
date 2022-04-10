package com.nawaz2000.yourbirthday.controller;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.HashMap;

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
		HashMap<String, String> zodiacSet = service.findZodiac(Integer.parseInt(date2[2]), date2[1]);
		String image = "";
		for (String temp : zodiacSet.keySet())
			image = temp;
		image = image + ".jpg";


		HashMap<String, String> chineseBY = service.chineseBirthAnimal(date);
		String chineseBYImage = "";
		for (String temp : chineseBY.keySet())
			chineseBYImage = temp;
		chineseBYImage = chineseBYImage + ".jpg";
		String birthDayImage = date2[0] + ".jpg";
		String birthStone = service.birthStone(date);
		
		System.out.println("birthday: " + birthDayImage);
		model.addAttribute("zodiac", zodiacSet);
		model.addAttribute("birthDay", date2[0]);
		model.addAttribute("age", service.age(date));
		model.addAttribute("chineseBirthAnimal", chineseBY);
		model.addAttribute("birthStone", birthStone);
		model.addAttribute("untilNextBirthDay", service.untilNextBirthday(date));
		model.addAttribute("aliveFor", service.aliveFor(date));
		model.addAttribute("image", image);
		model.addAttribute("birthDayImage", birthDayImage);
		model.addAttribute("chineseBYImage", chineseBYImage);
		model.addAttribute("birthStone", (birthStone + ".jpg"));
		model.addAttribute("famousPeople", service.getFamousPeople (date));
		System.out.println("birth stone: " + birthStone + ".jpg");
		return "result";
	}

}
