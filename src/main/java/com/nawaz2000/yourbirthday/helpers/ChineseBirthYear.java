package com.nawaz2000.yourbirthday.helpers;

import java.text.ParseException;
import java.util.HashMap;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.nawaz2000.yourbirthday.service.HelpWithDate;

@Component("chineseBirthYear")
public class ChineseBirthYear {
	
	private HashMap<String, String> rat = new HashMap<>();
	private HashMap<String, String> ox = new HashMap<>();
	private HashMap<String, String> tiger = new HashMap<>();
	private HashMap<String, String> rabbit = new HashMap<>();
	private HashMap<String, String> dragon = new HashMap<>();
	private HashMap<String, String> snake = new HashMap<>();
	private HashMap<String, String> horse = new HashMap<>();
	private HashMap<String, String> sheep = new HashMap<>();
	private HashMap<String, String> monkey = new HashMap<>();
	private HashMap<String, String> rooster = new HashMap<>();
	private HashMap<String, String> dog = new HashMap<>();
	private HashMap<String, String> pig = new HashMap<>();
	
	@PostConstruct
	public void mapping() {
		rat.put("Rat", "The Year of the Rat is the first zodiac sign in the Chinese zodiac cycle. According to the Chinese zodiac story, in the competition held by the Jade Emperor to decide the zodiac animals, the quick-witted rat asked the diligent ox to take him on a ride to cross the river and jumped down before the ox crossed the finish line, so the rat won the race and became the first of the zodiac animals.");
		ox.put("Ox", "Oxen used to be capable farming tools in an agricultural society, which attach to the symbol of diligence, persistence, and honesty. In Chinese culture, Ox is a faithful friend that made great contributions to the development of the society. Like the ox, people born in the Year of the Ox are industrious, cautious, hold their faith firmly, and always glad to offer help.");
		tiger.put("Tiger", "Tigers, considered to be brave, cruel, forceful, and terrifying, are the symbol of power and lordliness in Chinese culture. In ancient times, people usually compared emperors or kings with the tigers. Tigers are also considered as a patron deity for children and parents will prepare the shoes and hats with tiger designs for their babies.");
		rabbit.put("Rabbit", "For Chinese people, the rabbit is a tame creature representing hope and life for a long time. It is tender and lovely. The moon goddess Chang'e in the Chinese legend has a rabbit as her pet, which stimulates the thought that only this creature is amiable enough to match her noble beauty. Another way of saying is that the Rabbit is the incarnation of the moon goddess per se and it is always a symbol of pureness and auspiciousness.");
		dragon.put("Dragon", "Chinese Dragon is de facto an imaginary animal, also the only fictitious creature in the 12 zodiac animals, which is composed of 9 animals, including the body of a snake, the horns of a deer, the head of an ox, the mouth of a crocodile, the claws of an eagle, and the scales of a fish. The Dragon enjoys a very high reputation in Chinese culture and it represents auspiciousness and imperial power since ancient times.");
		snake.put("Snake", "Snake carries the meanings of malevolence, cattiness, mystery, as well as acumen and divination. In most cases, this animal is considered evil and the elongated legless body always scares people. However, in ancient Chinese traditions, the snake once presented a venerated image and it is one of the earliest totems of Chinese nations. Chinese mother goddess Nüwa who said to have created humanity has the body of a snake and the head of a human.");
		horse.put("Horse", "The horse was the most frequent transport means in ancient society and it is considered as No. 1 of the most important 6 animals in China. They are strong, powerful and elegant animals. In Chinese culture, horses are always the representative of heroes and talents. People born in the Year of the Horse will share some similarities with the horse and thus they are brave, strong, talented, and independent.");
		sheep.put("Goat", "Sheep (goat, or ram) is among the animals that people like most. It is docile, mellow, and timid. The white cute creature often reminds people of beautiful things. In Chinese culture, the sheep is considered auspicious since long time ago and it was often used to offer sacrifices and pray for good fortune. It was also once served as currency in ancient times, and thus the sheep represents rich and lucky.");
		monkey.put("Monkey", "The monkey is a clever, lively, and witty animal. Because of a lot of similarities to humans, the monkey is admired by people in many cultures and Chinese culture is no exception. In traditional Chinese culture, monkey has been considered a mascot to pray for the luck of official career as it pronounces the same with the Chinese character for “marquis (hou)” in ancient times. In some west areas of China, monkey is also believed to be able to protect little babies from evil spirits.");
		rooster.put("Rooster", "Back in ancient times when there was no alarm clock, rooster played an important role of waking people up. Thus the first symbolic meaning of Chinese zodiac Rooster sign is punctuality. Besides, it was believed by ancient people that its crow and blood could dispel evil spirits, and that’s why rooster is also the embodiment of good luck.");
		dog.put("Dog", "Dog is men's good friend who can understand the human spirit and obey its master, whether he is wealthy or not. Chinese people regard it as an auspicious animal. If a dog happens to come to a house, it symbolizes the coming of fortune. In Chinese legend, the invincible God Erlang has a loyal dog partner to help him capture monsters.");
		pig.put("Pig", "As the last sign of the Chinese zodiac, Pig represents wealth and luck from the ancient times. It is docile, has no plan to harm others, and can bring affluence to people. And its chubby faces and large ears also win the affection of people. However, pig sometimes is not thought to be a smart animal in China as it likes sleeping and eating and becomes fat, and thus it also features laziness and clumsiness.");
	}
	
	
	public HashMap<String, String> chineseBirthAnimal(String date) throws NumberFormatException, ParseException {
		
		int year = Integer.parseInt(HelpWithDate.dateHelper(date)[5]);
		
	    
	    switch (year % 12) {
	      case 0: return monkey;
	      case 1: return rooster;
	      case 2: return dog;
	      case 3: return pig;
	      case 4: return rat;
	      case 5: return ox;
	      case 6: return tiger;
	      case 7: return rabbit;
	      case 8: return dragon;
	      case 9: return snake;
	      case 10: return horse;
	      case 11: return sheep;
	    }
		return new HashMap<>();
	}
	
}
