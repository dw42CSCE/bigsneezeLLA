package com.narration;
import java.util.Scanner;
import java.util.UUID;

public class UserInterface {
    
    //Unfinished
    public void Scenario1(){
        String username="John";
        String email="John@gmail.com";
        String password="Password";

         //New Facade
         CourseManagerFacade facade=new CourseManagerFacade();
         //Sign up
         facade.signUp(username, email, password);
         //Login
         facade.login(username, password);
        
         //Set Course & Get course
         //TODO 
 
         //Pulling Lessons
         facade.setLesson(0);
         facade.getLesson();

         //Logout
         facade.logOut();
 
    }

    public static void run(){
        CourseManagerFacade facade=new CourseManagerFacade();
        Scanner keyboard=new Scanner(System.in);
        String userName=" ";
        String password=" ";
        String firstName=" ";
        String lastName=" ";
        String emailAddress=" ";

        System.out.println("Enter 1 to sign up \nEnter 2 to login");
        int signup=keyboard.nextInt();
        if(signup==1){
            userName.equals(keyboard.nextLine());
            password.equals(keyboard.nextLine());
            firstName.equals(keyboard.nextLine());
            lastName.equals(keyboard.nextLine());
            emailAddress.equals(keyboard.nextLine());
            facade.signUp(userName, password, emailAddress);
        }
        else{
            
        }

        


    }
   
   
   
    public static void main(String[] args) {
    
    
    }



}
