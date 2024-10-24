package com.narration;

public class Matching extends Exercise{
    // protected String questions;
    // protected String options;
    // protected Word answer;
    // protected String type;
    private Word[] matchingArray;

    public Matching(String question, Word answer, Word[] matchingArray){
        super(question, answer);
        this.matchingArray = matchingArray;
    }

    public boolean isCorrect(String username){
        return true;
    }

    public String toString(){
        return "ToDo";
    }
}
