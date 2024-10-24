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

    public ArrayList<Exercise> getExercises() {
        return this.exercises;
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
