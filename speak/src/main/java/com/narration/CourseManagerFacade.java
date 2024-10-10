package com.narration;

public class CourseManagerFacade {
    private User user;
    private Settings settings;
    private UserList users;
    private CourseList courses;

    public CourseManagerFacade() {
        courses = CourseList.getInstance();
        // users = UserList.getInstance();
    }

    public void login(String username, String password) {
        user = users.getUser(username, password);
        if(user == null) {
            System.out.println("Account with provided credentials does not exist. Try different credentials or sign up.");
        }
    }

    public User signUp(String username, String email, String password) {
        if(users.getUser(username, password) == null) {
            users.addUser(username, email, password);
        }
        user = users.getUser(username, password);
        return user;
    }

    public Course getCourse(String language) {
        return null;
    }

    public CourseList getAllCourses() {
        return courses;
    }

    public UserList getUsers() {
        return users;  
    }

    public void toggleDarkMode(boolean isDarkMode) {
        
    }

    public void toggleEmailNotification(boolean emailNotification) {

    }

    public Lesson getLesson(int index) {
        return null;
    }

    public Exercise getExercise(int index) {
        return null;
    }

    public boolean isCorrect(String userAnswer) {
        return true;
    }

    public void logOut() {
        DataReadWriter.updateUsers(users.getUserList());
    }

    public Settings getUserSettings() {
        return user.getSettings();
    }
}
