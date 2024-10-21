package com.narration;

import java.util.ArrayList;

public class Matching extends Exercise {
    protected String question;
    protected ArrayList<String> options;
    protected String answer;

    public Matching(String question, ArrayList<String> options, String answer){
        this.question = question;
        this.options = options;
        this.answer = answer;
    }

    public boolean isCorrect(String userAnswer){
        return (this.answer.equalsIgnoreCase(userAnswer.replaceAll("\\s+","")));
    }

    public String toString(){
        return (this.question+"\n"+this.options);
    }


}
