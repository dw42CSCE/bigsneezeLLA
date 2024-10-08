package com.narration;

import java.util.ArrayList;
import java.util.UUID;

public class Course {
    
    private Language language;
    private ArrayList<Lesson> lessons;
    private int proficiencyPts;
    private UUID uuid;

    public Course(Language language, ArrayList<Lesson> lessons) {
        this.language = language;
        this.lessons = lessons;
    }

    public Lesson getLesson(int index) {
        return lessons.get(index);
    }

    public UUID getUuid(){
        return this.uuid;
    }

    private void addLesson(Lesson lesson) {
        lessons.add(lesson);
    }

    public Language getLanguage() {
        return this.language;
    }

    public int getProgress() {
        return 0;
    }

    public String toString() {
        return "";
    }
}
