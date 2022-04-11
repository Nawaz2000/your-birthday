package com.nawaz2000.yourbirthday.helpers;

import com.nawaz2000.yourbirthday.helpers.wikiFinder.WikiPerson;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component("famousPeopleFinder")
public class FamousPeopleFinder {

    private Set<WikiPerson> wikiPersonSet = new HashSet<>();

    public Set<WikiPerson> getWikiPeople(String date) {
        wikiPersonSet.clear();
        wikiPersonSet.add(new WikiPerson("name1", "Short description1","Full description1"));
        wikiPersonSet.add(new WikiPerson("name2", "Short description2","Full description2"));
        wikiPersonSet.add(new WikiPerson("name3", "Short description3","Full description3"));
        return wikiPersonSet;
    }
}
