package com.narration;

import java.util.ArrayList;
import java.util.UUID;

public class Course {
    
    private Language language;
    private ArrayList<Lesson> lessons;
    private int proficiencyPts;
    private UUID uuid;

    public Course(Language language) {
        this.language = language;
    }

    public Lesson getLesson(int index) {
        return null;
    }

    private void addLesson(Lesson lesson) {

    }

    public Language getLanguage() {
        return null;
    }

    public int getProgress() {
        return 0;
    }

    public String toString() {
        return "";
    }
}
