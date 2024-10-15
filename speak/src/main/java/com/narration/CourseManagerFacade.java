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

<<<<<<< HEAD
    public Course getCourse(String language) {
        return null;
=======
    public void setCourse(String language) {
        Language l = Language.valueOf(language.trim().toUpperCase());
        course = courses.getCourse(l);
    }

    public Course getCourse() {
        return course;
>>>>>>> 69a4c5e2ffbf5c840e9b2269b41a5208bf232836
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
}
