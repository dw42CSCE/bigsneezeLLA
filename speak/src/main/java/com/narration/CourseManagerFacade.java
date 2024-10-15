package com.narration;

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

    public static void main(String[] args) {
        CourseManagerFacade CMF = new CourseManagerFacade();
        User user = CMF.signUp("Dw", "dw@gmail.com", "pw");
        System.out.println(user.getEmailAddress());
    }
}
