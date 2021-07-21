package com.nawaz2000.yourbirthday.helpers;

import java.util.HashMap;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component("zodiacFinder")
public class ZodiacFinder {
	
	private HashMap<String, String> capricorn = new HashMap<>();
	private HashMap<String, String> aquarius = new HashMap<>();
	private HashMap<String, String> pisces = new HashMap<>();
	private HashMap<String, String> aries = new HashMap<>();
	private HashMap<String, String> taurus = new HashMap<>();
	private HashMap<String, String> gemini = new HashMap<>();
	private HashMap<String, String> cancer = new HashMap<>();
	private HashMap<String, String> leo = new HashMap<>();
	private HashMap<String, String> virgo = new HashMap<>();
	private HashMap<String, String> libra = new HashMap<>();
	private HashMap<String, String> scorpio = new HashMap<>();
	private HashMap<String, String> sagittarius = new HashMap<>();

	@PostConstruct
	public void mapping() {
		capricorn.put("Capricorn", "The last earth sign of the zodiac, Capricorn is represented by the sea goat, a mythological creature with the body of a goat and the tail of a fish. Accordingly, Capricorns are skilled at navigating both the material and emotional realms.");
		aquarius.put("Aquarius", "Despite the “aqua” in its name, Aquarius is actually the last air sign of the zodiac. Aquarius is represented by the water bearer, the mystical healer who bestows water, or life, upon the land. Accordingly, Aquarius is the most humanitarian astrological sign.");
		pisces.put("Pisces", "Pisces, a water sign, is the last constellation of the zodiac. It's symbolized by two fish swimming in opposite directions, representing the constant division of Pisces' attention between fantasy and reality. As the final sign, Pisces has absorbed every lesson — the joys and the pain, the hopes and the fears — learned by all of the other signs.");
		aries.put("Aries", "Aries loves to be number one, so it’s no surprise that these audacious rams are the first sign of the zodiac. Bold and ambitious, Aries dives headfirst into even the most challenging situations.");
		taurus.put("Taurus", "Taurus is an earth sign represented by the bull. Like their celestial spirit animal, Taureans enjoy relaxing in serene, bucolic environments surrounded by soft sounds, soothing aromas, and succulent flavors.");
		gemini.put("Gemini", "Have you ever been so busy that you wished you could clone yourself just to get everything done? That’s the Gemini experience in a nutshell. Appropriately symbolized by the celestial twins, this air sign was interested in so many pursuits that it had to double itself.");
		cancer.put("Cancer", "Cancer is a cardinal water sign. Represented by the crab, this crustacean seamlessly weaves between the sea and shore representing Cancer’s ability to exist in both emotional and material realms. Cancers are highly intuitive and their psychic abilities manifest in tangible spaces.");
		leo.put("Leo", "Roll out the red carpet because Leo has arrived. Leo is represented by the lion and these spirited fire signs are the kings and queens of the celestial jungle. They’re delighted to embrace their royal status: Vivacious, theatrical, and passionate, Leos love to bask in the spotlight and celebrate themselves.");
		virgo.put("Virgo", "Virgo is an earth sign historically represented by the goddess of wheat and agriculture, an association that speaks to Virgo’s deep-rooted presence in the material world. Virgos are logical, practical, and systematic in their approach to life. This earth sign is a perfectionist at heart and isn’t afraid to improve skills through diligent and consistent practice.");
		libra.put("Libra", "Libra is an air sign represented by the scales (interestingly, the only inanimate object of the zodiac), an association that reflects Libra's fixation on balance and harmony. Libra is obsessed with symmetry and strives to create equilibrium in all areas of life.");
		scorpio.put("Scorpio", "Scorpio is one of the most misunderstood signs of the zodiac. Because of its incredible passion and power, Scorpio is often mistaken for a fire sign. In fact, Scorpio is a water sign that derives its strength from the psychic, emotional realm.");
		sagittarius.put("Sagittarius", "Represented by the archer, Sagittarians are always on a quest for knowledge. The last fire sign of the zodiac, Sagittarius launches its many pursuits like blazing arrows, chasing after geographical, intellectual, and spiritual adventures.");
		
	}
	
	public HashMap<String, String> findZodiac(int day, String month) {
		if (month.equalsIgnoreCase("Jan")) {
			if (day < 20)
				return capricorn;
			else
				return aquarius;
		} else if (month.equalsIgnoreCase("Feb")) {
			if (day < 19)
				return aquarius;
			else
				return pisces;
		} else if (month.equalsIgnoreCase("Mar")) {
			if (day < 21)
				return pisces;
			else
				return aries;
		} else if (month.equalsIgnoreCase("Apr")) {
			if (day < 20)
				return aries;
			else
				return taurus;
		} else if (month.equalsIgnoreCase("May")) {
			if (day < 21)
				return taurus;
			else
				return gemini;
		} else if (month.equalsIgnoreCase("June")) {
			if (day < 21)
				return gemini;
			else
				return cancer;
		} else if (month.equalsIgnoreCase("Jul")) {
			if (day < 23)
				return cancer;
			else
				return leo;
		} else if (month.equalsIgnoreCase("Aug")) {
			if (day < 23)
				return leo;
			else
				return virgo;
		} else if (month.equalsIgnoreCase("Sep")) {
			if (day < 23)
				return virgo;
			else
				return libra;
		} else if (month.equalsIgnoreCase("Oct")) {
			if (day < 23)
				return libra;
			else
				return scorpio;
		} else if (month.equalsIgnoreCase("Nov")) {
			if (day < 22)
				return scorpio;
			else
				return sagittarius;
		} else if (month.equalsIgnoreCase("Dec")) {
			if (day < 22)
				return sagittarius;
			else
				return capricorn;
		}
		return new HashMap<>();
	}

}
