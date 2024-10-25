package com.narration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

// Matching Exercise Class
public class Matching extends Exercise {
    protected String question;
    protected String options;
    protected String answer;

    /**
     * CLASS AUTHOR WRITE THIS
     * @param answers
     */
    public Matching(Word[] words) {
        this.question = "";
        this.options = "";
        this.answer = "";
        int i = 1;

        ArrayList<Word> answers = new ArrayList<Word>();
        for (Word word : words) {
            answers.add(word);
        }

        int[] list = new int[answers.size()];

        Random rand = new Random();
		
        Collections.shuffle(answers);
        for (Word word : answers) {
            this.question += (i+". "+word.getWord()+"\n");
            i++;
        }

        for (int f = 0; f < list.length; f++) {
			int randomIndexToSwap = rand.nextInt(list.length);
			int temp = list[randomIndexToSwap];
			list[randomIndexToSwap] = list[f];
			list[f] = temp;
		}

        for (int f = 0; f < list.length; f++) {
            this.answer += list[f]+",";
        }
        this.answer = this.answer.substring(0,(this.options.length()-1));

        Character j = 'A';
        i = 1;
        for (Word word : answers) {
            this.options += (j+". "+word.getMeaning()+"\n");
            this.answer.replace(((char)(i + '0')), j);
            i++;
            j++;
        }
        
    }

    /**
     * Checks if userAnswer is correct
     * @param userAnswer String userAnswer to be checked against
     * @return True if userAnswer is correct, else false
     */
    public boolean isCorrect(String userAnswer) {
        return (this.answer.trim().equalsIgnoreCase(userAnswer.trim()));
    }

    public String toString() {
        return ("Match the words to the translations. \n(Answer Format: \"B,C,D,A\")\n"+question+"\n"+options);
    }


}

/*
package com.narration;

import java.util.ArrayList;
import java.util.Random;

public class Matching extends Exercise1{
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
*/