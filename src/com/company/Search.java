package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.MalformedURLException;

import jdk.nashorn.internal.parser.JSONParser;
import org.json.*;

/**
 * Created by Pratama Agung on 6/8/2017.
 */
public class Search {
    public User[] userSearch(String target){
        User[] userList;
        try {

            URL url = new URL(target);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            output = br.readLine();
            conn.disconnect();

            JSONObject obj = new JSONObject(output);
            int nbUser = obj.getInt("total_count");
            JSONArray arrUser = obj.getJSONArray("items");
            userList = new User[nbUser];
            for (int i = 0; i < nbUser; i++) {
                String username = arrUser.getJSONObject(i).getString("login");
                String avatar = arrUser.getJSONObject(i).getString("avatar_url");
                userList[i] = new User(username, avatar);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
            userList = null;
        } catch (IOException e) {
            e.printStackTrace();
            userList = null;
        }
        return userList;
    }

    public String urlUserBuilder(String user, boolean isFollower, int followMax, int followMin, boolean isRepo, int repoMax, int repoMin){
        String result = "https://api.github.com/search/";
        if isFollower {

        }
    }
}
