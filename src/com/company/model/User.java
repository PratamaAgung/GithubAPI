package com.company.model;

/**
 * Created by Pratama Agung on 6/8/2017,
 * berfungsi sebagai model bagi kelas User.
 */
public class User {
    private String name;
    private String avatar;

    /**
     * Constructorr bagi kelas User.
     * @param name nama user.
     * @param avatar url ke avatar dari user.
     */
    public User(String name, String avatar){
        this.name = name;
        this.avatar = avatar;
    }

    /**
     * Methos untuk mendapatkan username dari user.
     * @return string username.
     */
    public String getName() {
        return name;
    }

    /**
     * Methos untuk mendapatkan url avatar user.
     * @return string url avatar.
     */
    public String getAvatar() {
        return avatar;
    }
}
