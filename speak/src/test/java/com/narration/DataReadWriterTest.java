package com.narration;

import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

public class DataReadWriterTest {

    @Test
    public void testGetUsers(){
        ArrayList<User> users = DataReadWriter.getUsers();

        User user = users.get(0);

        assertEquals("Tammy", user.getFirstName());
    }

    @Test
    public void testGetCourses(){
        CourseList courses = CourseList.getInstance();

        Course course = courses.getCourse(0);

        assertEquals("SPANISH", course.getLanguage().toString());
    }

    @Test
    public void testUpdateUsers(){
        UserList userList = UserList.getInstance();

        userList.addUser("test", "test@gmail", "pw");

        DataReadWriter.updateUsers(userList.getUsers());

        ArrayList<User> jsonUsers = DataReadWriter.getUsers();

        assertEquals(userList, jsonUsers);


    } 
}
