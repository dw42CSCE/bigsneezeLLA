package com.narration;
import java.util.Scanner;
import java.util.UUID;

public class UserInterface {

    private static  CourseManagerFacade facade;

    public UserInterface(){
        facade= new CourseManagerFacade();
    }
    
    public static void run(){
        Scenario1();
    }
    //Unfinished
    public static void Scenario1(){

         facade.signUp("pacman83", "pacman83@gmail.com", "123password");
         facade.login("pacman83", "123password");

         facade.getCourse(b1303bf7-6575-41ea-93fb-4bb8da658eda);
 
         //Pulling Lessons
         facade.setLesson(0);
         facade.getLesson();
         facade.setExercise(0);
         facade.getExercise();

         //Logout
         facade.logOut();
 
    }

}
