package com.company;

/**
 * Created by Pratama Agung on 6/22/2017.
 */
public class Repo {
    private String name;
    private String description;
    private String url;

    public Repo(String name, String desc, String url) {
        this.name = name;
        this.description = desc;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }
}
