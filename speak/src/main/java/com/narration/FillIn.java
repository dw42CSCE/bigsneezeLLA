package com.narration;

import java.util.ArrayList;

public class FillIn extends Exercise {
    protected String question;
    protected ArrayList<String> options;
    protected String answer;

    public FillIn(String question, ArrayList<String> options, String answer){
        this.question = question;
        this.options = options;
        this.answer = answer;
    }

    public boolean isCorrect(String userAnswer){
        if (answer.equalsIgnoreCase(userAnswer.replaceAll("\\s+","")))
            return true;
        for (String option : options)  {
            if (option.equalsIgnoreCase(userAnswer.replaceAll("\\s+","")))
                return true;
        }
        return false;
    }

    public String toString(){
        return (this.question);
    }
}
