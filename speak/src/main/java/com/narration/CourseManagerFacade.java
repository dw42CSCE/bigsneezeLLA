package com.narration;

public class CourseManagerFacade {
    private User user;
    private Settings settings;
    private UserList users;
    private CourseList courses;

    public CourseManagerFacade() {

    }

    public void login(String username, String password) {
        
    }

    public User signUp(String username, String email, String password) {
        return null;
    }

    public Course getCourse(String language) {
        return null;
    }

    public CourseList getAllCourses() {
        return null;
    }

    public UserList getUsers() {
        return null;    
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

    }

    public Settings getUserSettings() {
        return user.getSettings();
    }

    public void playGame(User user){
        
        this.user = user;

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
                    for (Exercise exercise : lesson.getExercises()){
                            System.out.println( "====================\n" + exercise.toString() + "\n====================\n");
                            String answer = k.nextLine();
                            if (answer.equalsIgnoreCase("quit")){
                                userProgress++;
                                userCourses.put(firstCourse, userProgress);
                                user.setCourseProgress(null);
                                System.out.println(userProgress);
                                return;
                            }
                            if (exercise.isCorrect(answer)){
                                
                                correct++;
                            } 
                        }
                    System.out.println("You got " + correct + "\\" + lesson.getExercises().size());

                    if(correct/lesson.getExercises().size() == 1){
                        userProgress++;
                        userCourses.put(firstCourse, userProgress);
                        user.setCourseProgress(null);
                        System.out.println(userProgress);
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

        cmf.playGame(user);

        cmf.logOut();

    }   
}