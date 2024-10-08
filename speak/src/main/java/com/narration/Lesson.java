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
        
    }

    public Exercise getExercise(int index) {
        return null;
    }

    private void addExercise(Exercise exercise) {

    }

    private void calcProgress() {

    }

    public String getSubject() {
        return "";
    }

    public String getIntro() {
        return "";
    }

    public int getProgress() {
        return 0;
    }

    public String toString() {
        return "";
    }

    public void addProficiencyPoint() {

    }

    public void increaseProgress() {
        
    }
}
