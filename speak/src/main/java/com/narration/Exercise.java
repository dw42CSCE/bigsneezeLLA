package com.narration;

public class Exercise {
    protected String question;
    protected String options;
    protected Word answer;
    protected String type;

    public Exercise(String question, String options, String answer){
        this.question = question;
        Word word = new Word(answer, "Translation");
        this.answer = word;
        this.options = options;
    }

    public boolean isCorrect(String userAnswer) {
        return userAnswer.trim().equalsIgnoreCase(answer.getWord().trim());
    }
    

    public String toString(){
        return this.question + "\n" + this.options;
    }
}