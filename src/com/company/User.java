package com.company;

/**
 * Created by Pratama Agung on 6/8/2017.
 */
public class User {
    private String name;
    private String avatar;
    public User(String name, String avatar){
        this.name = name;
        this.avatar = avatar;
    }
    public String getName() {
        return name;
    }

    public String getAvatar() {
        return avatar;
    }
}
