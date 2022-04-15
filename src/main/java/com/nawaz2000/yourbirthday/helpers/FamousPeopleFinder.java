package com.nawaz2000.yourbirthday.helpers;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Component("famousPeopleFinder")
public class FamousPeopleFinder {

    public List<String> parseWikiPageText (String wikiPageText, LocalDate date) {

        //get section of births on wiki page
        int birthsStartsAt = wikiPageText.indexOf("==Births=="); //start of the Births section
        int birthsEndAt = wikiPageText.indexOf("==Deaths==", birthsStartsAt); //end of the Births section
        String wikiBirthsSection = wikiPageText.substring(birthsStartsAt, birthsEndAt); //Section with births on wiki page

        //remove garbage and get only required births
        return wikiBirthsSection.lines().filter(f -> f.startsWith("*")) //only req strings (starts with "*")
                .map(p -> p.trim().replaceAll("(^\\*)|([\\[\\]]|(<ref.*))", "")) // remove garbage "*", "[", "]","<ref/>" tag
                .map(p -> p.replaceAll("(\\s*&ndash;\\s*)", ";;")) // transform &ndash" to separator ";"
                .map(p -> p.replaceFirst(",\\s+",";;").trim()) //req separator between name and short desc
                .filter(p -> p.startsWith(String.valueOf(date.getYear()))) //get only required year
                .collect(Collectors.toList()); //to List
    }

    //input format "[year];[name];[short desc];[full desc]".
    public WikiPerson birthStrToWikiPerson(String birthStr) {

        String name;
        String shortDesc;
        String fullDesc;

        //split birthday string
        String[] splitter = birthStr.split(";;");
        name = splitter[1];
        shortDesc = splitter[2];
        fullDesc = splitter[3]; //head paragraph from wiki (if exists)

        //get WikiPerson
        return new WikiPerson(name, shortDesc, fullDesc);
    }
}