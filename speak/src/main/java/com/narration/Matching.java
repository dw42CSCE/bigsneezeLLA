package com.narration;

import java.util.ArrayList;
import java.util.Random;

public class Matching extends Exercise{
    protected Word answer;
    protected ArrayList<Word> answers;
    private ArrayList<String> choices;

    public Matching(ArrayList<Word> words){
        super(words);
        Random rand = new Random();
        this.answer = words.get(rand.nextInt(0, words.size()));
        choices = new ArrayList<String>(4);
        int answerIndex = rand.nextInt(0, 4);
        for(int i = 0; i < choices.size(); i++) {
            if(i == answerIndex) {
                choices.add(answer.getWord());
            }
            // Randomly choose a similar word
        }
    }

    public boolean isCorrect(String userAnswer){
        return answer.getWord().equalsIgnoreCase(userAnswer.trim());
    }

    public String toString(){
        return "Which of the following words is the Spanish equivalent of " + answer + "?" +
        "\n 1. ";
    }
}
