package com.narration;

import java.util.ArrayList;
import java.util.Random;

public class FillIn extends Exercise{

    public FillIn(ArrayList<Word> words) {
        super(words);
        Random rand = new Random();
        this.answer = words.get(rand.nextInt(0, words.size()));
    }

    public boolean isCorrect(String useranswer){
        return useranswer.trim().equalsIgnoreCase(answer.getWord());
    }

    public String toString(){
        return "The spanish translation for " + answer.getMeaning() + " is: _______";
    }
}
