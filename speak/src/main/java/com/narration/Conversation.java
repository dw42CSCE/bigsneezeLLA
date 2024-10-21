package com.narration;

import java.util.ArrayList;

public class Conversation extends Exercise {
    protected String question;
    protected ArrayList<String> options;
    protected String answer;

    public Conversation(String question, ArrayList<String> options, String answer){
        this.question = question;
        this.options = options;
        this.answer = answer;
    }

    public boolean isCorrect(String userAnswer){
        if (answer.equalsIgnoreCase(userAnswer.trim()))
            return true;
        for (String option : options)  {
            if (option.equalsIgnoreCase(userAnswer.trim()))
                return true;
        }
        return false;
    }

    public String toString(){
        return (this.question);
    }
}