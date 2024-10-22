package com.narration;
import java.util.ArrayList;
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
        /*
        users = UserList.getInstance();

        User newUser = new User(username, password, email);

        ArrayList<User> curUsers = users.getUsers();
        for (int i = 0; i < curUsers.size(); i++){
            if (users.getUser(username, password) == newUser){
                return users.getUser(username, password);
            }
        }
        users.addUser(username, email, password);
        return newUser; */
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

        System.out.println("Alice's email: " + user.getEmailAddress());

        cmf.logOut();
    }
}
