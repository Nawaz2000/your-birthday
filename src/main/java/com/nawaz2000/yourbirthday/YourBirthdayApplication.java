package com.nawaz2000.yourbirthday;

import io.github.fastily.jwiki.core.WParser;
import io.github.fastily.jwiki.core.Wiki;
import io.github.fastily.jwiki.dwrap.PageSection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class YourBirthdayApplication {

	public static void main(String[] args) {

//		Wiki wiki = new Wiki.Builder().build();

		SpringApplication.run(YourBirthdayApplication.class, args);
//		//List<PageSection> pst;
//		//pst = wiki.splitPageByHeader("October 21");
//
//		//pst.forEach(p-> System.out.println(p.header));
//		//pst.stream().filter(p->p.header == "Purpose").forEach(p->System.out.println(p.header+" "+p.level+ " "+p.text));
//		//pst.stream().filter(p->p.level!=-1).filter(p->p.header.equals("1901–present")).forEach(p->System.out.println(p.text));
////		WParser.WikiText w = new WParser.WikiText();
////		w= WParser.parsePage(wiki,"Pet door");
////		System.out.println(w.toString());
////		w.
//		System.out.println(wiki.getPageText("October 21"));
//		System.out.println(wiki.getTextExtract("Almen Abdi"));
	}

}
