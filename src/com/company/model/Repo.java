package com.company.model;

/**
 * Created by Pratama Agung on 6/22/2017.,
 * berfungsi sebagai model untuk data repository.
 */
public class Repo {
    private String name;
    private String description;
    private String url;

    /**
     * Constructor untuk kelas Repo.
     * @param name nama repo.
     * @param desc deskripsi dari repo.
     * @param url url repo tersebut.
     */
    public Repo(String name, String desc, String url) {
        this.name = name;
        this.description = desc;
        this.url = url;
    }

    /**
     * Method untuk mendapatkan nama repository.
     * @return nama repository.
     */
    public String getName() {
        return name;
    }

    /**
     * Method untuk mendapatkan deskripsi dari repository.
     * @return string deskripsi repository.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Method untuk mendapatkan url dari repository.
     * @return string url repository.
     */
    public String getUrl() {
        return url;
    }
}
