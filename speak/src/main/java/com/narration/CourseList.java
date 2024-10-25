package com.narration;

import java.util.ArrayList;
import java.util.UUID;

public class CourseList {

    private ArrayList<Course> courses;
    private static CourseList courseList;

    private CourseList() {
        DataReadWriter drw = new DataReadWriter();
        courses = DataReadWriter.getCourses();
    }

    public static CourseList getInstance() {
        if (courseList == null){
            courseList = new CourseList();
        }
        return courseList;
    }

    public void addCourse(Language language, ArrayList<Lesson> lessons) {
        Course course = new Course(language, lessons);
        courses.add(course);
    }

    public Course getCourse(UUID uuid) {
        for (Course course : courses){
            if (course.getUuid().equals(uuid)) {
                return course;
            }
        }
    return null;
    }

    public Course getCourse(Language language) {
        for (Course course : courses){
            if (course.getLanguage() == language) {
                return course;
            }
        }
    return null;
    }

    public Course getCourse(int index){
        return courses.get(index);
    }

    public String toString(){
        String display = "Available Courses: \n";
        int i = 0;
        String tempString = "";
        for (Course course : courses){
            tempString += (i+1 + ". " + course.getLanguage().name() + "\n");
        }
        display += tempString;
        return display;
    }
}