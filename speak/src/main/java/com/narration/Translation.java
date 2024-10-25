package com.narration;

public class Translation extends Exercise{

    protected Word answer;


    public Translation(Word word) {
        this.answer = word;
    }

    public boolean isCorrect(String useranswer){
        return useranswer.trim().equalsIgnoreCase(answer.getWord());
    }

    public String toString(){
        return "The spanish translation for " + answer.getMeaning() + " is:";
    }
}
