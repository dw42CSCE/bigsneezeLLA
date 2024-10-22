package com.narration;

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
   
   
   
    public static void main(String[] args) {
        
    
    }



}
