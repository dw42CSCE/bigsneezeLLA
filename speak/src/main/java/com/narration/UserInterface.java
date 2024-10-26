package com.narration;
import java.util.Scanner;
import java.util.UUID;

public class UserInterface {

    private static  CourseManagerFacade facade;

    public UserInterface(){
        facade = new CourseManagerFacade();
    }

    public static void main(String[] args) {
        // scenario1();
        scenario2();

    }

    public static void scenario1(){

        CourseManagerFacade facade = new CourseManagerFacade();

        facade.signUp("ttomacka", "ttom@gmail.com", "pw");

        facade.signUp("ttom", "ttom@gmail.com", "pw");

        facade.login("ttom", "pw");

        facade.logOut();

        Scanner k = new Scanner(System.in);
        String input = "a";

        System.out.println("Type next to move on");
        while (!input.equalsIgnoreCase("next")){
            input = k.nextLine();
        }

        facade.login("ttom", "pw");

        System.out.println(facade.getAllCourses().toString());

        // User says 1

        facade.addUserCourse(facade.getAllCourses().getCourse(0));

        facade.playGame();

        // THIS METHOD NEEDS TO GET MADE
        //System.out.println(user.getWordProgress());

        facade.logOut();

    }

    //WONT WORK IN THIS BRANCH
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
