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
    
        // Sign up a new user
        User user1 = CMF.signUp("Dw", "dw@gmail.com", "pw");
        System.out.println("User signed up with email: " + user1.getEmailAddress());
    
        // Attempt to log in with the correct credentials
        System.out.println("\nAttempting login with correct credentials...");
        CMF.login("Dw", "pw");
        User loggedInUser = CMF.getUsers().getUser("Dw", "pw");
    
        if (loggedInUser != null) {
            System.out.println("Login successful. Welcome " + loggedInUser.getUsername() + "!");
        } else {
            System.out.println("Login failed.");
        }
    
        // Attempt to log in with incorrect credentials
        System.out.println("\nAttempting login with incorrect credentials...");
        CMF.login("Dw", "wrongPassword");
        User incorrectLoginUser = CMF.getUsers().getUser("Dw", "wrongPassword");
    
        if (incorrectLoginUser != null) {
            System.out.println("Login successful. Welcome " + incorrectLoginUser.getUsername() + "!");
        } else {
            System.out.println("Login failed with incorrect credentials.");
        }
    
        // Ensure user data is saved after logging in
        System.out.println("\nCurrent logged-in user data:");
        System.out.println("Username: " + loggedInUser.getUsername());
        System.out.println("Email: " + loggedInUser.getEmailAddress());

        CMF.logOut();
    } 
}
