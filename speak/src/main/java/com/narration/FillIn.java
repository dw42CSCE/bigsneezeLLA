package com.narration;

public class FillIn extends Exercise{
    // protected String questions;
    // protected String options;
    // protected Word answer;
    // protected String type;
    private Word[] answers;

    public FillIn(String question, String answer){
      //question=DataReadWriter.getExercises();
    }

    public boolean isCorrect(String useranswer){
        return true;
    }

    public String toString(){
        return "ToDo";
    }
}
