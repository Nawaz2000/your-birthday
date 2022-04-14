package com.nawaz2000.yourbirthday;

import com.nawaz2000.yourbirthday.helpers.FamousPeopleFinder;
import io.github.fastily.jwiki.core.WParser;
import io.github.fastily.jwiki.core.Wiki;
import io.github.fastily.jwiki.dwrap.PageSection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class YourBirthdayApplication {

	public static void main(String[] args) {
		//SpringApplication.run(YourBirthdayApplication.class, args);

		Wiki wiki = new Wiki.Builder().build();
		System.out.println(wiki.getPageText("October 21"));
	}

}
