package com.narration;

import java.util.ArrayList;
import java.util.Map;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileReader;
import java.util.UUID;
import java.util.concurrent.atomic.LongAdder;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

@SuppressWarnings("unused")

public class DataReadWriter extends DataConstants{
    
    public static ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<User>();

        try {
            FileReader reader = new FileReader(USER_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray peopleJSON = (JSONArray)parser.parse(reader);
            
            for (int i = 0; i < peopleJSON.size(); i++) {
                JSONObject personJSON = (JSONObject)peopleJSON.get(i);
                UUID uuid = UUID.fromString((String)personJSON.get(USER_UUID));
                String firstname = (String)personJSON.get(USER_FIRST_NAME);
                String lastname = (String)personJSON.get(USER_LAST_NAME);
                String username = (String)personJSON.get(USER_USER_NAME);
                String email = (String)personJSON.get(USER_EMAIL);
                String password = (String)personJSON.get(USER_PASSWORD);
                int profPts = ((Long)personJSON.get(USER_PROFICIENCY_PTS)).intValue();
                
                JSONObject settingsObj = (JSONObject)personJSON.get(SETTINGS);
                Settings settings = parseSettings(settingsObj);

                JSONObject courseObj = (JSONObject)personJSON.get(USER_COURSES);

                users.add(new User(firstname,lastname,username));
            }
            return users;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Settings parseSettings(JSONObject settings) {
        if (settings == null) {
            return null;
        }
        boolean emailNotif = (Boolean)settings.get(EMAIL_NOTIF);
        boolean darkMode = (Boolean)settings.get(DARK_MODE);
        return new Settings(emailNotif,darkMode);
    }

    private static Course parseCourse(JSONObject course) {
        if (course == null) {
            return null;
        }
        UUID uuid = UUID.fromString((String)course.get(USER_UUID));
        int progress = ((Long)course.get(COURSE_PROGRESS)).intValue();
        return null;
        // new Course(uuid, progress);
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

            jsonBuilder.append("  }");

            if (i < users.size() - 1) {
                jsonBuilder.append(",");
            }
            jsonBuilder.append("\n");
        }

        jsonBuilder.append("]");

        // Write the JSON string to the file CHANGE FILE NAME
        try (FileWriter writer = new FileWriter("JSON\\tempusers.json")) {
            writer.write(jsonBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Course> getCourses() {
        ArrayList<Course> courses = new ArrayList<>();
    
        try {
            FileReader reader = new FileReader(COURSE_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONObject data = (JSONObject) parser.parse(reader); // Parse the root JSON object
            JSONArray coursesJSON = (JSONArray) data.get("courses"); // Get the array of courses
    
            for (int i = 0; i < coursesJSON.size(); i++) {
                JSONObject courseJSON = (JSONObject) coursesJSON.get(i);
    
                // Extract course details
                UUID uuid = UUID.fromString((String) courseJSON.get("uuid"));
                Language language = Language.valueOf(((String) courseJSON.get("language")).toUpperCase());
    
                // Assuming getLessons() is a method that retrieves lessons for each course
                ArrayList<Lesson> lessons = getLessons((JSONArray) courseJSON.get(LESSONS));
    
                // Create the course and add it to the list
                courses.add(new Course(language, uuid, lessons));
            }
    
            return courses;
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        return null;
    }

    private static ArrayList<Lesson> getLessons(JSONArray lessonsJSON){

        ArrayList<Lesson> lessons = new ArrayList<>();

        for (int i = 0; i < lessonsJSON.size(); i++){

            JSONObject lessonJSON = (JSONObject) lessonsJSON.get(i);

            String subject = (String)lessonJSON.get(SUBJECT);
            String intro = (String)lessonJSON.get(INTRO);
            ArrayList<Exercise> exercises = getExercises((JSONArray) lessonJSON.get(EXERCISES));
            Word[] words = getKeyWords((JSONArray) lessonJSON.get(KEYWORDS));
            Phrase[] phrases = getKeyPhrases((JSONArray) lessonJSON.get(KEYPHRASES));


            lessons.add(new Lesson(subject, intro, exercises, words, phrases));
        }
        return lessons;
    }

    private static ArrayList<Exercise> getExercises(JSONArray exercisesJSON){
        return null;
    }

    private static Word[] getKeyWords(JSONArray keywordsJSON){
        return null;
    }

    private static Phrase[] getKeyPhrases(JSONArray keyphrasesJSON){
        return null;
    }

// TEST FOR SIMPLE READWRITER
    // public static void main(String[] args) {
    //     ArrayList<User> users = getUsers();
    //     for (User user : users) {
    //         System.out.println(user);
    //     }
    // }

// TEST FOR GETCOURSES, Exercises, Words, and Phrases NOT IMPLEMENTED
    // public static void main(String[] args) {
    //     ArrayList<Course> courses = getCourses();

    //     // Print the courses to verify the data
    //     for (Course course : courses) {
    //         System.out.println("Course Language: " + course.getLanguage());
    //         System.out.println("Course UUID: " + course.getUuid());
    //         for(int i = 0; i < course.getLessons().size(); i++){
    //             System.out.println("Lesson " + (i+1) + "\nSubject: \n" + course.getLesson(i).getSubject());
    //             System.out.println("Intro: \n" + course.getLesson(i).getIntro());
    //         }
    //     }
    // }

// TEST FOR updateUsers
    public static void main(String[] args){
        ArrayList<User> users = new ArrayList<>();
        HashMap<Course, Integer> courses = new HashMap();

        Settings settings = new Settings(false, false);

        Course course = getCourses().get(0);

        courses.put(course, 1);

        users.add(new User("DWade", "Password", UUID.randomUUID() , "Dallas" , "Wade" , "dw@email.com", courses, 2, settings));

        updateUsers(users);
    }
}