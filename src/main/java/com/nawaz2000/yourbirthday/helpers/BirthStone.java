package com.nawaz2000.yourbirthday.helpers;

import java.text.ParseException;

import org.springframework.stereotype.Component;

import com.nawaz2000.yourbirthday.service.HelpWithDate;

@Component("birthStone")
public class BirthStone {
	
	public String birthStone(String date) throws ParseException {
		
		String[] newDate = HelpWithDate.dateHelper(date);
		
		String birthStone = newDate[1];
		
	    if (birthStone.equalsIgnoreCase("Jan"))
	       return "Garnet";
	    else if (birthStone.equalsIgnoreCase("Feb"))
	    	return "Amethyst";
	    else if (birthStone.equalsIgnoreCase("Mar"))
	        return "Aquamarine";
	    else if (birthStone.equalsIgnoreCase("Apr"))
	        return "Diamond";
	    else if (birthStone.equalsIgnoreCase("May"))
	        return "Emerald";
	    else if (birthStone.equalsIgnoreCase("Jun"))
	        return "Pearl";
	    else if (birthStone.equalsIgnoreCase("Jul"))
	    	return "Ruby";
	    else if (birthStone.equalsIgnoreCase("Aug"))
	        return "Peridot";
	    else if (birthStone.equalsIgnoreCase("Sep"))
	        return "Sapphire";
	    else if (birthStone.equalsIgnoreCase("Oct"))
	        return "Opal";
	    else if (birthStone.equalsIgnoreCase("Nov"))
	        return "Citrine";
	    else if (birthStone.equalsIgnoreCase("Dec"))
	        return "Topaz";
	        
		return "Not found";
	}
	
}
