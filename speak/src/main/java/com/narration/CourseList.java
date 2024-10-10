package com.narration;

import java.util.ArrayList;
import java.util.UUID;

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

    public Course getCourse(UUID uuid) {
        for (Course course : courses){
            if (course.getUuid() == uuid) {
                return course;
            }
        }
    return null;
    }
}