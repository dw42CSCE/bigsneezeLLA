package com.narration;

import java.util.ArrayList;

public class CourseList {

    private ArrayList<Course> courses;
    private static CourseList courseList;

    private CourseList() {
        courses = new ArrayList<Course>();
    }

    public static CourseList getInstance() {
        if (courseList != null){
            courseList = new CourseList();
        }
        return courseList;
    }

    public void addCourse(Language language, ArrayList<Lesson> lessons) {
        Course course = new Course(language, lessons);
        courses.add(course);
    }

    public Course getCourse(String language) {
        if(language.toLowerCase() == "spanish"){
            return courses.
        } else if (language.toLowerCase() == "french"){
            return courses.
        } else if (language.toLowerCase() == "japanese"){
            return courses.
        } else {return null;}
    }
}