package com.narration;

public class Matching {
    protected String question;
    protected String options;
    protected Word answer;
    protected String type;

    public Matching(String question, String options, String answer){
        
    }

    public boolean isCorrect(Word userAnswer){
        if(answer.getWord().equalsIgnoreCase(userAnswer.getWord())) {
            return true;
        }
        return false;
    }

    public String toString(){
        return "ToDo";
    }
}
