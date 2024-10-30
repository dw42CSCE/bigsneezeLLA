package com.narration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class UserTest {
    public static void main(String[] args) {
        // testUserInitialization();
        // testAddCourse();
        // testUpdateUserSettings();
        // testGettersAndSetters();
        // testIsMatch();
    }

    public static void testUserInitialization() {
        HashMap<Course, Integer> courses = new HashMap<>();

        User user = new User("testUser", "password123", UUID.randomUUID(),
                             "John", "Doe", "john.doe@example.com", courses, 100, 
                             new Settings(true, false));

        System.out.println("User Initialization:");
        System.out.println(user);
        System.out.println("Expected username: testUser");
        System.out.println("Expected first name: John");
        System.out.println("Expected last name: Doe\n");
    }

    public static void testAddCourse() {
        User user = new User("testUser", "password123", "john.doe@example.com");
        CourseList courses = CourseList.getInstance();

        Course course = courses.getCourse(0);

        System.out.println("Adding Course: " + course.getLanguage());
        user.addCourse(course);
        System.out.println("Expected course added: Spanish");
        System.out.println("Actual courses: " + user.getCourses() + "\n");
    }

    public static void testUpdateUserSettings() {
        User user = new User("testUser", "password123", "john.doe@example.com");

        System.out.println("Updating User Settings:");
        user.setSettings(true, true);
        System.out.println("Expected dark mode: true, email notifications: true");
        System.out.println("Actual settings: " + user.getSettings().toString());
    }

    public static void testGettersAndSetters() {
        User user = new User("testUser", "password123", "john.doe@example.com");
        user.setName("Jane", "Smith");
        user.setEmailAddress("jane.smith@example.com");

        System.out.println("Testing Getters and Setters:");
        System.out.println("Expected first name: Jane, last name: Smith, email: jane.smith@example.com");
        System.out.println("Actual first name: " + user.getFirstName());
        System.out.println("Actual last name: " + user.getLastName());
        System.out.println("Actual email: " + user.getEmailAddress() + "\n");
    }

    public static void testIsMatch() {
        User user = new User("testUser", "password123", "john.doe@example.com");

        System.out.println("Testing isMatch:");
        boolean matchResult = user.isMatch("testUser", "password123");
        System.out.println("Expected match result: true");
        System.out.println("Actual match result: " + matchResult + "\n");

        boolean mismatchResult = user.isMatch("testUser", "wrongPassword");
        System.out.println("Expected mismatch result: false");
        System.out.println("Actual mismatch result: " + mismatchResult + "\n");
    }
}
