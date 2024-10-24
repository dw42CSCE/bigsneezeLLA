package com.narration;
import java.util.ArrayList;

public class UserList {
    private ArrayList<User> users;
    private static UserList userList;

    private UserList() {
      //DataReadWriter drt = new DataReadWriter();
      users = DataReadWriter.getUsers();
      if (users == null) {
          users = new ArrayList<>();  // Initialize with an empty list if null
      }
  }
  
    public static UserList getInstance(){
      if(userList==null)
        userList=new UserList();
      return userList;
    }

    public void addUser(String username, String email, String password) {
      for (User tempUser : users) {
          if (tempUser.getUsername().equals(username)) {
              System.out.println("Username already exists.");
              return;
          }
          if (tempUser.getEmailAddress().equals(email)) {
              System.out.println("Email already exists.");
              return;
          }
      }
      User newUser = new User(username, password, email);
      users.add(newUser);
      System.out.println("User added successfully.");
  }
  

    public void editUser(String firstName, String lastName, String email, String password) {
      for(int i=0;i<users.size()-1;i++){
        User tempUser=users.get(i);
        if(tempUser.getEmailAddress().equals(email) && tempUser.getPassword().equals(password)){
                tempUser.setName(firstName, lastName);
                tempUser.setEmailAddress(email);
                tempUser.setPassword(password);
                users.remove(i);
                users.add(i,tempUser);   
        }
      }
    }

    public User getUser(String username, String password) {
      for (int i = 0; i < users.size(); i++) {  // Fix: iterate through the entire list
          User tempUser = users.get(i);
          if (tempUser.getUsername().equals(username) && tempUser.getPassword().equals(password)) {
              return users.get(i);  // Return the matching user
          }
      }
      return null;  // Return the "NotFound" user if no match is found
  }
  

    public ArrayList<User> getUsers(){
      return users;
    }

    public void removeUser(String username, String password) {
      for(int i=0;i<users.size()-1;i++){
        User tempUser=users.get(i);
        if(tempUser.getUsername().equals(username) && tempUser.getPassword().equals(password)){
                users.remove(i);   
        }
      }
    }

}   
