package com.narration;

import java.util.ArrayList;
import java.util.Random;

public abstract class Exercise {
    //protected String question;
    //protected String options;
    // protected String options;
    protected Word answer;
    protected ArrayList<Word> words;
    //protected String type;

    public Exercise(ArrayList<Word> words) {
        this.words = words;
    }

    public abstract boolean isCorrect(String userInput);

    public abstract String toString();
}