package com.narration;
import java.util.ArrayList;

public class UserList {
    private ArrayList<User> users;
    private static UserList userList;

    private UserList() {
      DataReadWriter drt = new DataReadWriter();
      users = drt.getUsers();
    }

    public static UserList getInstance(){
      if(userList==null)
        userList=new UserList();
      return userList;
    }

    public void addUser(String username, String email, String password) {
      boolean isMatch=false;
      for(int i=0; i<users.size();i++){
          User tempUser=users.get(i);
          if(tempUser.getUsername().equals(username)||tempUser.getEmailAddress().equals(email)){
            isMatch=true;
          }
        }
        if(isMatch==false){
        User newUser=new User(username, email, password);
        users.add(newUser);
        }
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
      User notFound = new User("NotFound", "NotFound", "NotFound");
      for (int i = 0; i < users.size(); i++) {  // Fix: iterate through the entire list
          User tempUser = users.get(i);
          if (tempUser.getUsername().equals(username) && tempUser.getPassword().equals(password)) {
              return users.get(i);  // Return the matching user
          }
      }
      return notFound;  // Return the "NotFound" user if no match is found
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
