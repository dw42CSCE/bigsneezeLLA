package com.narration;

import java.util.ArrayList;

public class Lesson {
    
    private String subject;
    private String intro;
    private ArrayList<Exercise> exercises;
    private Word[] keyWords;
    private Phrase[] keyPhrases;
    private int progress;

    public Lesson(String subject, String intro, ArrayList<Exercise> exercises,
                    Word[] words, Phrase[] phrases, int progress) {

        this.subject = subject;
        this.intro = intro;
        this.exercises = exercises;
        this.keyWords = words;
        this.keyPhrases = phrases;        
    }

    public Exercise getExercise(int index) {
        return exercises.get(index);
    }

    // Needed?
    private void addExercise(Exercise exercise) {

    }

    private void calcProgress() {

    }

    public String getSubject() {
        return subject;
    }

    public String getIntro() {
        return intro;
    }

    public int getProgress() {
        return progress;
    }

    public String toString() {
        return "";
    }

    public void addProficiencyPoint() {
        
    }

    public void increaseProgress() {
        
    }
}
