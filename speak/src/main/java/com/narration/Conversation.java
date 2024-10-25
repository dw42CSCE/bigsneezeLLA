package com.narration;

import java.util.ArrayList;

public class Conversation extends Exercise {
    protected String question;
    protected ArrayList<String> options;

    public Conversation(String question, ArrayList<String> options) {
        this.question = question;
        this.options = options;
    }

    public boolean isCorrect(String userAnswer) {
        for (String option : options)  {
            if (option.equalsIgnoreCase(userAnswer.trim()))
                return true;
        }
        return false;
    }

    public String toString() {
        return ("Conversation: Respond to the following phrase.\n"+this.question);
    }
}