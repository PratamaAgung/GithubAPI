package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.MalformedURLException;

import com.company.model.Repo;
import com.company.model.User;
import org.json.*;

/**
 * Created by Pratama Agung on 6/8/2017,
 * berfungsi untuk melakukan search dan berkomunikasi langsung dengan API.
 */
public class Search {
    /**
     * Method untuk melakukan search user.
     * @param target url untuk melakukan search.
     * @return list user hasil search.
     */
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
            int nbUser;
            if (obj.getInt("total_count") <= 30) {
                nbUser = obj.getInt("total_count");
            } else {
                nbUser = 30;
            }
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

    /**
     * Method untuk menlakukan search repository dari suatu user.
     * @param target url yang dituju.
     * @return list repository dari user.
     */
    public Repo[] searchUserRepo(String target) {
        Repo [] repos;
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

            JSONArray arrRepo = new JSONArray(output);
            int nbRepo;
            if (arrRepo.length() < 30) {
                nbRepo = arrRepo.length();
            } else {
                nbRepo = 30;
            }
            repos = new Repo[nbRepo];
            for (int i = 0; i < nbRepo; i++) {
                String name = arrRepo.getJSONObject(i).getString("name");

                String desc;
                if (arrRepo.getJSONObject(i).get("description").equals(null)){
                    desc = "";
                } else {
                    desc = arrRepo.getJSONObject(i).getString("description");
                }

                String html_url = arrRepo.getJSONObject(i).getString("html_url");
                repos[i] = new Repo(name, desc, html_url);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
            repos = null;
        } catch (IOException e) {
            e.printStackTrace();
            repos = null;
        }
        return repos;
    }

    /**
     * Method untuk membangun url untuk melakukan pencarian user.
     * @param user nama user.
     * @param searchIn pilihan tipe pencarian (username, email, atau fullname).
     * @param isFollower boolean apakah filter follower diaktifkan.
     * @param followMin minimum follower yang dikehendaki.
     * @param isRepo boolean apakah filter repository diaktifkan.
     * @param repoMin minimum repository yang dikehendaki.
     * @return url target pencarian dengan opsi dari parameter input.
     */
    public String urlUserBuilder(String user, int searchIn, boolean isFollower, int followMin, boolean isRepo, int repoMin){
        String result = "https://api.github.com/search/users?";
        result += "q=" + user;
        if (searchIn == 0){
            result += "+in:login";
        } else if (searchIn == 1) {
            result += "+in:email";
        } else if (searchIn == 2){
            result += "+in:fullname";
        }
        if (isFollower) {
            result += "+followers:>" + Integer.toString(followMin - 1);
        }
        if (isRepo) {
            result += "+repos:>" + Integer.toString(repoMin - 1);
        }

        return result;
    }

    /**
     * Method untuk mencari repository dari suatu user.
     * @param username username yang akan dicari repo nya.
     * @return list repository dari user tersebut.
     */
    public String urlRepoBuilder(String username) {
        String result = "https://api.github.com/users/";
        result += username + "/repos";
        return result;
    }
}
