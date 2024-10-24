package com.narration;

import java.util.ArrayList;
import java.util.Random;

public class Matching extends Exercise{
    protected Word answer;
    protected ArrayList<Word> answers;
    private ArrayList<String> choices;
    private int answerIndex;

    public Matching(ArrayList<Word> words){
        super(words);
        Random rand = new Random();
        this.answer = words.get(rand.nextInt(0, words.size()));
        choices = new ArrayList<String>(4);
        answerIndex = rand.nextInt(0, 4);
        for(int i = 0; i < choices.size(); i++) {
            if(i == answerIndex) {
                choices.add(answer.getWord());
            }
            choices.add(answer.getSimilarWords().get(i).getWord());
        }
    }

    public boolean isCorrect(String userAnswer){
        return answerIndex + 1 == Integer.parseInt(userAnswer);
    }

    public String toString(){
        return "Which of the following words is the Spanish equivalent of " + answer.getMeaning() + "?" +
        "\n 1. " + choices.get(0) +
        "\n 2. " + choices.get(1) +
        "\n 3. " + choices.get(2) +
        "\n 4. " + choices.get(3);
    }
}
