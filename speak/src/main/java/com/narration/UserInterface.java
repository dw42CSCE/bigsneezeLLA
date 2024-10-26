package com.narration;
import java.util.Scanner;
import java.util.UUID;

public class UserInterface {

    private static  CourseManagerFacade facade;

    public UserInterface(){
        facade = new CourseManagerFacade();
    }

    public static void main(String[] args) {

        // show that Tim Tomacka is not in the users.json, and Tammy Tomacka is.

        scenario1();
        //scenario2();

    }

    public static void scenario1(){

        CourseManagerFacade facade = new CourseManagerFacade();

        facade.signUp("ttomacka", "ttom@gmail.com", "pw");

        facade.signUp("ttom", "ttom@gmail.com", "pw");

        facade.login("ttom", "pw");

        facade.logOut();

        // Show the users.json -> illustrating that Tom is now in the file.

        Scanner k = new Scanner(System.in);
        String input = "a";

        System.out.println("Type next to move on");
        while (!input.equalsIgnoreCase("next")){
            input = k.nextLine();
        }

        facade.login("ttom", "pw");

        System.out.println(facade.getAllCourses().toString());

        facade.addUserCourse(facade.getAllCourses().getCourse(0));

        facade.playGame();

        facade.displayPosition();

        facade.displayStudyStuff();

        facade.logOut();

        // Show Tammy's entry in the users.json file

        input = "a";
        System.out.println("Type next to move on");
        while (!input.equalsIgnoreCase("next")){
            input = k.nextLine();
        }

        facade.login("ttomacka", "password");

        facade.displayStudyStuff();

        facade.makeStudyFile();

        facade.testStudyStuff();

        facade.displayStudyStuff();

        facade.logOut();

        // Show the updates to Tammy's user.json file with the words / phrases she got correct no longer being listed.

    }

    public static void scenario2(){

        CourseManagerFacade cmf = new CourseManagerFacade();
        
        cmf.signUp("jimmy", "jimmyj@gmail.com", "pw");
        cmf.login("jimmy", "pw");
        cmf.logOut();

        Scanner k = new Scanner(System.in);
        String input = "a";
        System.out.println("Type next to move on");
        input = "a";
        while (!input.equalsIgnoreCase("next")){
            input = k.nextLine();
        }

        cmf = new CourseManagerFacade();
        cmf.login("jimmy", "pw");
        cmf.addUserCourse(cmf.getAllCourses().getCourse(0));
        cmf.playGame();
        cmf.logOut();

        System.out.println("Type next to move on");
        input = "a";
        while (!input.equalsIgnoreCase("next")){
            input = k.nextLine();
        }

        cmf = new CourseManagerFacade();
        cmf.login("jimmy", "pw");
        cmf.playGame();
        cmf.logOut();
    }
}
