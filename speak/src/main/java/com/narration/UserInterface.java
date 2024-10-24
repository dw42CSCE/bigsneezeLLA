package com.narration;
import java.util.Scanner;
import java.util.UUID;

public class UserInterface {

    private static  CourseManagerFacade facade;

    public UserInterface(){
        facade = new CourseManagerFacade();
    }

    public static void main(String[] args) {
        Scenario1();
    }

    public static void Scenario1(){

        CourseManagerFacade facade = new CourseManagerFacade();

        facade.signUp("ttomacka", "ttom@gmail.com", "pw");

        facade.signUp("ttom", "ttom@gmail.com", "pw");

        User user = facade.login("ttom", "pw");

        facade.logOut();

    }

}
