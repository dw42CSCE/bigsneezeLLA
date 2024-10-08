package com.narration;

import java.util.ArrayList;
import java.util.Map;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileReader;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

@SuppressWarnings("unused")

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

    private Settings parseSettings(JSONObject settings) {
        if (settings == null) {
            return null;
        }
        return null;
    }

    /**
     * Updates user JSON File from arraylist of Users
     * @param users Array of current Users kept in UserList class
     */
    public static void updateUsers(ArrayList<User> users) {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("[\n");

        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            jsonBuilder.append("  {\n");
            jsonBuilder.append("    \"uuid\": \"").append(user.getUuid()).append("\",\n");
            jsonBuilder.append("    \"firstname\": \"").append(user.getFirstName()).append("\",\n");
            jsonBuilder.append("    \"lastname\": \"").append(user.getLastName()).append("\",\n");
            jsonBuilder.append("    \"username\": \"").append(user.getUsername()).append("\",\n");
            jsonBuilder.append("    \"email\": \"").append(user.getEmailAddress()).append("\",\n");
            jsonBuilder.append("    \"password\": \"").append(user.getPassword()).append("\",\n");
            jsonBuilder.append("    \"ProfPoints\": ").append(user.getProfPoints()).append(",\n");

            // Settings
            jsonBuilder.append("    \"settings\": {\n");
            jsonBuilder.append("      \"emailNotifications\": \"").append(user.getSettings().getEmailNotifications()).append("\",\n");
            jsonBuilder.append("      \"darkMode\": \"").append(user.getSettings().getDarkMode()).append("\"\n");
            jsonBuilder.append("    },\n");

            // Courses
            jsonBuilder.append("    \"courses\": [\n");
            for (Map.Entry<Course, Integer> entry : user.getCourses().entrySet()) {
                Course course = entry.getKey();
                int progress = entry.getValue();

                jsonBuilder.append("      {\n");
                jsonBuilder.append("        \"language\": \"").append(course.getLanguage()).append("\",\n");
                jsonBuilder.append("        \"uuid\": \"").append(course.getUuid()).append("\",\n");
                jsonBuilder.append("        \"progress\": ").append(progress).append("\n");
                jsonBuilder.append("      }");

                // Add comma if not the last entry
                if (!entry.equals(user.getCourses().entrySet().toArray()[user.getCourses().size() - 1])) {
                    jsonBuilder.append(",");
                }
                jsonBuilder.append("\n");
            }
            
            jsonBuilder.append("    ]\n");

            jsonBuilder.append("    ]\n");

            jsonBuilder.append("  }");

            if (i < users.size() - 1) {
                jsonBuilder.append(",");
            }
            jsonBuilder.append("\n");
        }

        jsonBuilder.append("]");

        // Write the JSON string to the file
        try (FileWriter writer = new FileWriter("users.json")) {
            writer.write(jsonBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Course> getCourses() {
        return null;
    }

// TEST FOR SIMPLE READWRITER
//     public static void main(String[] args) {
//         ArrayList<User> users = getUsers();
//         for (User user : users) {
//             System.out.println(user);
//         }
//     }
// }

// TEST FOR UPDATE METHOD

}