package com.nawaz2000.yourbirthday.service;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.nawaz2000.yourbirthday.helpers.*;
import com.nawaz2000.yourbirthday.helpers.WikiPerson;
import io.github.fastily.jwiki.core.Wiki;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	@Autowired
	private FamousPeopleFinder fpf;
	
	public HashMap<String, String> findZodiac(int day, String month) {
		return zf.findZodiac(day, month);
	}
	
	public LinkedHashMap<String, Integer> age(String date) throws ParseException{
		return af.age(date);
	}
	
	public HashMap<String, String> chineseBirthAnimal(String date) throws NumberFormatException, ParseException {
		return cby.chineseBirthAnimal(date);
	}
	
	public String birthStone(String date) throws ParseException {
		return bs.birthStone(date);
	}
	
	public String untilNextBirthday(String date) throws ParseException {
		return af.untilNextBirthday(date);
	}

	public HashMap<String, String> aliveFor(String date) throws ParseException {
		return af.aliveFor(date);
	}

	public Set<WikiPerson> getFamousPeople (String date) {
		//get legal date
		LocalDate parsedDate = HelpWithDate.getLocalDateByStr(date);

		//get wiki obj
		Wiki wiki = new Wiki.Builder().build();

		//get text of wiki page
		String wikiTitle = parsedDate.getMonth().name().toLowerCase() + " " + parsedDate.getDayOfMonth(); //transform string to wiki title format like "october 21"
		String wikiText = wiki.getPageText(wikiTitle); //get text form wiki page

		//parse wiki text
		List<String> birthdaysFromWiki = fpf.parseWikiPageText(wikiText,parsedDate);

		//add main paragraph of wiki page if exists
		List<String> birthdaysFromWikiWithExtract = birthdaysFromWiki.stream().map(p->p+";;"+wiki.getTextExtract(p.split(";;")[1])).collect(Collectors.toList());

		//get people to represent
		Set<WikiPerson> wikiPeople = birthdaysFromWikiWithExtract.stream().map(p->fpf.birthStrToWikiPerson(p)).collect(Collectors.toSet());
		return wikiPeople;
	}
	
}
