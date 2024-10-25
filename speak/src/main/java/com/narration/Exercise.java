package com.narration;

import java.util.ArrayList;
import java.util.Random;

public class Exercise {
    protected String question;
    protected String options;
    protected String answer;
    protected String type;

    public Exercise(String question, String type, String options, String answer) {
        this.question = question;
        this.options = options;
        this.answer = answer;
        this.type = type;
    }

    public boolean isCorrect(String userInput){
        if(userInput.equals(answer)){
            return true;
        }
        return false;
    }

    public String toString(){
        if(type.equals("Audio")){
            Narrator.playSound(answer);
            return (question + "\n" + options);
        };
        return (question + "\n" + options);
    }
}