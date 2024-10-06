package com.narration;

import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import java.io.FileReader;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DataReadWriter extends DataConstants{
    
    public static ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<User>();

        //change later
        try {
            FileReader reader = new FileReader(USER_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray peopleJSON = (JSONArray)parser.parse(reader);
            
            for (int i = 0; i < peopleJSON.size(); i++) {
                JSONObject personJSON = (JSONObject)peopleJSON.get(i);
                String firstname = (String)personJSON.get(USER_FIRST_NAME);
                String lastname = (String)personJSON.get(USER_LAST_NAME);
                String username = (String)personJSON.get(USER_USER_NAME);

                users.add(new User(firstname,lastname,username));
            }
            return users;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void updateUsers(ArrayList<User> users) {

    }

    public static ArrayList<Course> getCourse() {
        return null;
    }

    public static void main(String[] args) {
        ArrayList<User> users = getUsers();
        for (User user : users) {
            System.out.println(user);
        }
    }
}
