package com.narration;
import java.util.ArrayList;

// FillIn Exercise Class
public class FillIn extends Exercise {
    protected String question;
    protected Word answer;
    protected ArrayList<Word> options;

    /**
     * CLASS AUTHOR FILL THIS IN
     * @param question
     * @param answer
     * @param options
     */
    public FillIn(Phrase question, Word answer, ArrayList<Word> options) {
        this.question = question.getPhrase();
        this.answer = answer;
        this.options = options;
    }

    /**
     * CLASS AUTHOR FILL THIS IN
     */
    public boolean isCorrect(String userAnswer) {
        if (answer.getWord().equalsIgnoreCase(userAnswer.trim()))
            return true;
        for (Word option : options)  {
            if (option.getWord().equalsIgnoreCase(userAnswer.trim()))
                return true;
        }
        return false;
    }

    public String toString() {
        return ("Fillin: Fill in the missing word in the following phrase:\n"+this.question);
    }
}


/*
package com.narration;

import java.util.ArrayList;
import java.util.Random;

public class FillIn extends Exercise1{

    public FillIn(ArrayList<Word> words) {
        super(words);
        Random rand = new Random();
        this.answer = words.get(rand.nextInt(0, words.size()));
    }

    public boolean isCorrect(String useranswer){
        return useranswer.trim().equalsIgnoreCase(answer.getWord());
    }

    public String toString(){
        return "The spanish translation for " + answer.getMeaning() + " is: _______";
    }
}
*/