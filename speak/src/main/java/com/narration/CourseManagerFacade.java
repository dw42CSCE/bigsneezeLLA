package com.narration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
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

    public void addUserCourse(Course course){
        user.addCourse(course);
    }
    

    public void signUp(String username, String email, String password) {
        users = UserList.getInstance();
        
        for (User existingUser : users.getUsers()) {
            if (existingUser.getUsername().equals(username)) {
                System.out.println("Username already taken.");
                return;
            }
    
            if (existingUser.getEmailAddress().equals(email)) {
                System.out.println("Email already in use.");
                return;
            }
        }
    
        users.addUser(username, email, password);
        System.out.println("User signed up successfully!");
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
        this.user = null;
        DataReadWriter.updateUsers(users.getUsers());
    }

    public Settings getUserSettings() {
        return user.getSettings();
    }

    public void playGame(){
        
        Scanner k = new Scanner(System.in);
        CourseManagerFacade cmf = new CourseManagerFacade();

        HashMap<Course, Integer> userCourses = user.getCourses();

        if (userCourses != null && !userCourses.isEmpty()) {
            Course firstCourse = userCourses.keySet().iterator().next();

            if (firstCourse != null) {
                System.out.println("First course language: " + firstCourse.getLanguage());

                int userProgress = user.getCourseProgress(firstCourse);

                while (userProgress != firstCourse.getLessons().size()){
                    Lesson lesson = firstCourse.getLesson(userProgress);
                    int correct = 0;
                    System.out.println(lesson.toString());
                    Narrator.playSound(lesson.getIntro());
                    for (Exercise exercise : lesson.getExercises()){
<<<<<<< HEAD
                        System.out.println( "====================\n" + exercise.toString() + "\n====================\n");
                        if(exercise.type.equals("Audio")){
                            Narrator.playSound(exercise.answer);
                            System.out.println("Type v to hear it again");
=======
                            System.out.println( "====================\n" + exercise.toString() + "\n====================\n");
                            String answer = k.nextLine();
                            if (answer.equalsIgnoreCase("quit")){
                                userCourses.put(firstCourse, userProgress);
                                user.setCourseProgress(null);
                                System.out.println(userProgress);
                                return;
                            }
                            if (exercise.isCorrect(answer)){
                                
                                correct++;
                            } 
>>>>>>> main
                        }
                        String answer = k.nextLine();

                        while(answer.equalsIgnoreCase("v")){
                            Narrator.playSound(exercise.answer);
                            answer = k.nextLine();
                        }
                        
                        if (answer.equalsIgnoreCase("quit")){
                            userCourses.put(firstCourse, userProgress);
                            return;
                        }
                        if (exercise.isCorrect(answer)){
                            
                            correct++;
                        } 
                    }
                    System.out.println("You got " + correct + "\\" + lesson.getExercises().size());

                    if (correct/lesson.getExercises().size() > .7){
                        userProgress++;
                        userCourses.put(firstCourse, userProgress);
                        user.setCourseProgress(null);
                        System.out.println("You may move on");
                    } else { 
                        System.out.println("YOu did not pass! Try again");
                    }
                }
                
            }

        } else {
            System.out.println("First course is null.");
        }

        }

// TEST FOR SIGNUP, will not write new user to json yet
    // public static void main(String[] args) {
    //     CourseManagerFacade CMF = new CourseManagerFacade();
    
    //     // Sign up a new user
    //     CMF.signUp("Dw", "dw@gmail.com", "pw");
    //     User user1 = CMF.login("Dw", "pw");
    //     System.out.println("User signed up with email: " + user1.getEmailAddress());
    
    //     // Attempt to log in with the correct credentials
    //     System.out.println("\nAttempting login with correct credentials...");
    //     CMF.login("Dw", "pw");
    //     User loggedInUser = CMF.getUsers().getUser("Dw", "pw");
    
    //     if (loggedInUser != null) {
    //         System.out.println("Login successful. Welcome " + loggedInUser.getUsername() + "!");
    //         System.out.println(loggedInUser.getUsername() + "'s email is: " + loggedInUser.getEmailAddress());
    //     } else {
    //         System.out.println("Login failed.");
    //     }

    //     CMF.logOut();

    // } 

// // FULL TEST FOR LOGGING IN, ANSWERING QUESTIONS, DOES NOT ATTEMPT TO SAVE
    public static void main(String[] args) {

        Scanner k = new Scanner(System.in);
        CourseManagerFacade cmf = new CourseManagerFacade();

        User user = cmf.login("asmith", "password");

        System.out.println("Login successful. Welcome " + user.getUsername() + "!");
        System.out.println("User's email is " + user.getEmailAddress());

        cmf.playGame();

        cmf.logOut();

    }   
}