package com.nawaz2000.yourbirthday.helpers;

import io.github.fastily.jwiki.core.Wiki;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Component("famousPeopleFinder")
public class FamousPeopleFinder {

    private Wiki wiki = new Wiki.Builder().build();

    private Set<WikiPerson> wikiPersonSet = new HashSet<>();

    private List<String> getBirthdaysFromWiki(String dateStr) {

        //date to wiki title (like '2022-12-04' to 'april 12')
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dateStr, formatter);
        String wikiTitle = date.getMonth().name().toLowerCase() + " " + date.getDayOfMonth();

        //get text of wiki page
        String wikiPageText = wiki.getPageText(wikiTitle);

        //get section of births on wiki page
        int birthsStartsAt = wikiPageText.indexOf("==Births=="); //start of the Births section
        int birthsEndAt = wikiPageText.indexOf("==Deaths==", birthsStartsAt); //end of the Births section
        String wikiBirthsSection = wikiPageText.substring(birthsStartsAt, birthsEndAt); //Section with births on wiki page


        //remove garbage and get only requierd births
        return wikiBirthsSection.lines().filter(f -> f.startsWith("*")) //only req strings (starts with "*")
                .map(p -> p.trim().replaceAll("(^\\*)|([\\[\\]]|(<ref.*))", "")) // remove garbage "*", "[", "]","<ref/>" tag
                .map(p -> p.replaceAll("(\\s*&ndash;\\s*)", ";")) // transform &ndash" to separator ";"
                .map(p -> p.replaceFirst(",\\s+",";").trim()) //req separartor between name and short desc
                .filter(p -> p.startsWith(String.valueOf(date.getYear()))) //get only required year
                .collect(Collectors.toList()); //to List
    }

    //transoform strings to WikiPerson Obj
    private Set<WikiPerson> transformBirthdayStrToPeople(List<String> birthdaysFromWiki) {
        return birthdaysFromWiki.stream().map(p->birthStrToWikiPerson(p)).collect(Collectors.toSet());
    }

    //input format "[year];[name];[short desc]".
    private WikiPerson birthStrToWikiPerson(String birthStr) {

        String name;
        String shortDesc;
        String fullDesc;

        //split birthday string
        String[] splitter = birthStr.split(";");
        name = splitter[1];
        shortDesc = splitter[2];
        fullDesc = wiki.getTextExtract(name); //head paragraph from wiki (if exists)

        //get WikiPerson
        return new WikiPerson(name, shortDesc, fullDesc);
    }
    //public API :)
    public Set<WikiPerson> getWikiPeople(String date) {
        return transformBirthdayStrToPeople(getBirthdaysFromWiki(date));
    }
}