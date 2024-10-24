package com.narration;

import java.util.ArrayList;
import java.util.Random;

public class FillIn extends Exercise{
    // protected String questions;
    // protected String options;
    // protected Word answer;
    // protected String type;
    private Word[] answers;

    //Maybe make it a phrase
    public FillIn(ArrayList<Word> words) {
        super(words);
        Random rand = new Random();
        this.answer = words.get(rand.nextInt(0, words.size()));
    }

    public boolean isCorrect(String useranswer){
        return true;
    }

    public void generateQuestion(ArrayList<Word> words) {
        
    }

    public String toString(){
        return "The spanish translation for " + answer.getMeaning() + " is: _______" +
                "1. " +;
    }
}
