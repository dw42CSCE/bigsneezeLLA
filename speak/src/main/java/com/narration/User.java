package com.narration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class User {
    private String userName;
    private String password;
    private UUID uuid;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private HashMap<Course, Integer> courses;
    private int proficiencyPointTotal;
    private Settings settings = new Settings(false, false);
    private WordList correctWords;
    private WordList incorrectWords;

    public User(String userName, String password, UUID uuid, String firstName, String lastName, 
                String emailAddress, HashMap<Course, Integer> courses, int proficiencyPointTotal, Settings settings ){
    this.userName=userName;
    this.password=password;
    this.uuid=uuid;
    this.firstName=firstName;
    this.lastName=lastName; 
    this.emailAddress=emailAddress;
    this.courses=courses;
    this.proficiencyPointTotal=proficiencyPointTotal;
    this.settings=settings;      
    correctWords= new WordList(); 
    incorrectWords=new WordList();             
    }

    public User(String userName, String password, String emailAddress){
        this.userName=userName;
        this.password=password;
        this.emailAddress=emailAddress;
        this.uuid = createUUID();
    }

    // //Temporary User Constructor for testing
    // public User(String firstname, String lastname, String username) {
    //     this.firstName = firstname;
    //     this.lastName = lastname;
    //     this.userName = username;
    // }

    public String getUsername(){
        return userName;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getPassword(){
        return password;
    }

    public String getEmailAddress(){
        return emailAddress;
    }

    public Course getCourse(UUID language){
        return null;
    }

    public int getCourseProgress(Course course){
        return courses.get(course);
    }

    public HashMap<Course, Integer> getCourses(){
        return this.courses;
    }

    public UUID getUuid(){
        return this.uuid;
    }

    public int getProfPoints(){
        return this.proficiencyPointTotal;
    }

    public void setName(String firstName, String lastName){
        this.firstName=firstName;
        this.lastName=lastName;
    }

    public void setEmailAddress(String emailAddress){
        this.emailAddress=emailAddress;
    }

    public void setCourseProgress(ArrayList<Integer> lessonProgress){
        
    }

    public void setPassword(String password){
        this.password=password;
    }

    public void addCourseProgress(Course course, int lesson, int lessonProgress){
        int addProgress = 1/courses.size();
        int progress = courses.get(course) + addProgress;
        courses.put(course, progress);
    }

    // public String toString(){
    //     return 
    //         "Username: "+ userName+
    //         "\nName: "+firstName+" "+lastName+
    //         "\nEmail: "+emailAddress+
    //         "\nProficiency Points: "+proficiencyPointTotal;
    // }

    //Temporary toString
    public String toString() {
        return "Username: "+ userName +
        "\nName: " + firstName+" "+lastName;
    }

    public boolean isMatch(String username, String password){
       return this.userName.equals(username) && this.password.equals(password);
    }

    public void setSettings(Boolean darkModeOn, Boolean emailNotifsOn){
       settings.toggleDarkMode(false);
       settings.toggleEmailNotification(false);
    }

    public Settings getSettings(){
        return settings;
    }

    private UUID createUUID(){
        return UUID.randomUUID();
    }
}
