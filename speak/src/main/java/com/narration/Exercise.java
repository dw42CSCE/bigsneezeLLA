package com.narration;

public class Exercise {
    protected String question;
    //protected String options;
    protected Word answer;
    //protected String type;

    public Exercise(String question, Word answer){
        this.question = question;
        this.answer = answer;
    }

    public boolean isCorrect(String userAnswer){
        return true;
    }

    public String toString(){
        return "ToDo";
    }
}