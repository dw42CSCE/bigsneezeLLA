package com.narration;
import java.util.ArrayList;

public class FillIn extends Exercise {
    protected String question;
    protected Word answer;
    protected ArrayList<Word> options;

    public FillIn(Phrase question, Word answer, ArrayList<Word> options) {
        this.question = question.getPhrase();
        this.answer = answer;
        this.options = options;
    }

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
