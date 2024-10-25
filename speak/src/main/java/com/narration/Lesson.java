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

        this.subject = subject;
        this.intro = intro;
        this.exercises = exercises;
        this.keyWords = words;
        this.keyPhrases = phrases;        
    }

    public Exercise getExercise(int index) {
        return exercises.get(index);
    }

    public ArrayList<Exercise> getExercises() {
        return this.exercises;
    }

    public Exercise generateExercise() {
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
        return subject;
    }

    public String getIntro() {
        return intro;
    }

    public int getProgress() {
        return progress;
    }

    public String toString() {
        return (this.subject + "\n" + this.intro) + getWords(keyWords) + getPhrases(keyPhrases);
    }

    private String getWords(Word[] words){
        String sentence = "\n";
        for (int i = 0; i < words.length; i++){
            sentence += words[i].toString() + "\n";
        }
        return sentence;
    }

    private String getPhrases(Phrase[] phrases){
        String sentence = "\n";
        for (int i = 0; i < phrases.length; i++){
            sentence += phrases[i].toString() + "\n";
        }
        return sentence;
    }

    public void addProficiencyPoint() {
        
    }

    public void increaseProgress() {
        
    }
}
