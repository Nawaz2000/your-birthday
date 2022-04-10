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
        wikiPersonSet.add(new WikiPerson("link", "name","description"));
        wikiPersonSet.add(new WikiPerson("link2", "name2","description2"));
        wikiPersonSet.add(new WikiPerson("link3", "name3","description3"));
        return wikiPersonSet;
    }
}
