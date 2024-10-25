package com.narration;

import java.util.ArrayList;
import java.util.Random;

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

    public void generateExercise() {
        Random rand = new Random();
        int choice = rand.nextInt(0,4);
        switch (choice) {
            case 0: //Fill In
                break;
            case 1: //Matching
                break;
            case 2:
                break;
            case 3:
                break;
            default:
                break;
        }
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
