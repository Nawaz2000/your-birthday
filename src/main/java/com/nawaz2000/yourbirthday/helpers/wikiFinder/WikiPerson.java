package com.nawaz2000.yourbirthday.helpers.wikiFinder;


public class WikiPerson {

    private final String name;

    private final String shortDesc;

    private final String fullDesc;

    public WikiPerson(String name, String shortDesc, String fullDesc) {
        this.name = name;
        this.shortDesc = shortDesc;
        this.fullDesc = fullDesc;
    }

    public String getName() {
        return name;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public String getFullDesc() {
        return fullDesc;
    }
}
