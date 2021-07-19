package com.nawaz2000.yourbirthday.helpers;

import java.text.ParseException;

import org.springframework.stereotype.Component;

import com.nawaz2000.yourbirthday.service.HelpWithDate;

@Component("chineseBirthYear")
public class ChineseBirthYear {
	
	public String chineseBirthAnimal(String date) throws NumberFormatException, ParseException {
		
		int year = Integer.parseInt(HelpWithDate.dateHelper(date)[5]);
		
	    
	    switch (year % 12) {
	      case 0: return "monkey";
	      case 1: return "rooster";
	      case 2: return "dog";
	      case 3: return "pig";
	      case 4: return "rat";
	      case 5: return "ox";
	      case 6: return "tiger";
	      case 7: return "rabbit";
	      case 8: return "dragon";
	      case 9: return "snake";
	      case 10: return "horse";
	      case 11: return "sheep";
	    }
		return "Not found";
	}
	
}
