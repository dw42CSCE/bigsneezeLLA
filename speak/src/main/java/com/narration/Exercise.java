package com.narration;

import java.util.ArrayList;
import java.util.Random;

public class Exercise {
    protected String question;
    protected String options;
    protected String answer;

    public Exercise(String question, String options, String answer) {
        this.question = question;
        this.options = options;
        this.answer = answer;
    }

    public boolean isCorrect(String userInput){
        if(userInput.equals(answer)){
            return true;
        }
        return false;
    }

    public String toString(){
        return (question + "\n" + options);
    }
}