package com.narration;
import java.util.Scanner;
import java.util.UUID;

public class UserInterface {

    private static  CourseManagerFacade facade;

    public UserInterface(){
        facade = new CourseManagerFacade();
    }

    public static void main(String[] args) {
        scenario1p1();
    }

    public static void scenario1p1(){

        CourseManagerFacade facade = new CourseManagerFacade();

        facade.signUp("ttomacka", "ttom@gmail.com", "pw");

        facade.signUp("ttom", "ttom@gmail.com", "pw");

        User user = facade.login("ttom", "pw");

        facade.logOut();

        Scanner k = new Scanner(System.in);
        String input = "a";

        System.out.println("Type next to move on");
        while (!input.equalsIgnoreCase("next")){
            input = k.nextLine();
        }

        user = facade.login("ttom", "pw");

        System.out.println(facade.getAllCourses().toString());

        // User says 1

        user.addCourse(facade.getAllCourses().getCourse(0));

        facade.playGame(user);

        // THIS METHOD NEEDS TO GET MADE
        //System.out.println(user.getWordProgress());

        facade.logOut();

    }
}
