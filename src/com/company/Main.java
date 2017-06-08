package com.company;

public class Main {
    public static void main(String[] args) {
        User[] userList;
        userList = Search.Search("https://api.github.com/search/users?q=tom+repos:%3E42+followers:%3E1000");
        for (int i = 0; i < userList.length; i++){
            System.out.println("Username : " + userList[i].getName() + " Avatar: " + userList[i].getAvatar());
        }
    }
}
