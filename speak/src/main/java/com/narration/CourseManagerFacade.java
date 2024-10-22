package com.narration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class CourseManagerFacade {
    private User user;
    private UserList users;
    private CourseList courses;
    private Course course;
    private Lesson lesson;
    private Exercise exercise;

    public CourseManagerFacade() {
        courses = CourseList.getInstance();
        users = UserList.getInstance(); 
    }

    public User login(String username, String password) {
        users = UserList.getInstance();
        user = users.getUser(username, password);
        return user;
    }
    

    public void signUp(String username, String email, String password) {
        users.addUser(username, email, password);
    }
    

    public Course getCourse(UUID language) {
        course = user.getCourse(language);
        return course;
    }

    public CourseList getAllCourses() {
        return courses;
    }

    public UserList getUsers() {
        return users;  
    }

    public void toggleDarkMode(boolean isDarkMode) {
        user.getSettings().toggleDarkMode(isDarkMode);
    }

    public void toggleEmailNotification(boolean emailNotification) {
        user.getSettings().toggleEmailNotification(emailNotification);
    }

    public void setLesson(int index) {
        lesson = course.getLesson(index);
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setExercise(int index) {
        exercise = lesson.getExercise(index);
    }

    public Exercise getExercise() {
        return exercise;
    }

    public boolean isCorrect(String userAnswer) {
        return exercise.isCorrect(userAnswer);
    }

    public void logOut() {
        DataReadWriter.updateUsers(users.getUsers());
    }

    public Settings getUserSettings() {
        return user.getSettings();
    }

// TEST FOR SIGNUP, will not write new user to json yet
//     public static void main(String[] args) {
//         CourseManagerFacade CMF = new CourseManagerFacade();
    
//         // Sign up a new user
//         User user1 = CMF.signUp("Dw", "dw@gmail.com", "pw");
//         System.out.println("User signed up with email: " + user1.getEmailAddress());
    
//         // Attempt to log in with the correct credentials
//         System.out.println("\nAttempting login with correct credentials...");
//         CMF.login("Dw", "pw");
//         User loggedInUser = CMF.getUsers().getUser("Dw", "pw");
    
//         if (loggedInUser != null) {
//             System.out.println("Login successful. Welcome " + loggedInUser.getUsername() + "!");
//         } else {
//             System.out.println("Login failed.");
//         }

//     } 

// TEST FOR LOGIN
    public static void main(String[] args) {
        CourseManagerFacade cmf = new CourseManagerFacade();

        User user = cmf.login("asmith", "password");

        System.out.println("Login successful. Welcome " + user.getUsername() + "!");
        System.out.println("User's email is " + user.getEmailAddress());

        HashMap<Course, Integer> userCourses = user.getCourses();

        if (userCourses != null && !userCourses.isEmpty()) {
            Course firstCourse = userCourses.keySet().iterator().next();

            if (firstCourse != null) {
                System.out.println("First course language: " + firstCourse.getLanguage());
                System.out.println("First Lesson: " + firstCourse.getLesson(0).getIntro() + "\n" + firstCourse.getLesson(0).getExercise(0).toString());
            } else {
                System.out.println("First course is null.");
            }
        } else {
            System.out.println("User has no courses or course list is null.");
        }

    }   
}