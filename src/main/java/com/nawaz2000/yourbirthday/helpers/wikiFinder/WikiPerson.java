package com.nawaz2000.yourbirthday.helpers.wikiFinder;


public class WikiPerson {

    private final String link;

    private final String name;

    private final String desc;

    public WikiPerson(String link, String name, String desc) {
        this.link = link;
        this.name = name;
        this.desc = desc;
    }

    public String getLink() {
        return link;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }
}
