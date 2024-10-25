package com.narration;

import java.util.ArrayList;

// Conversation Exercise Class
public class Conversation extends Exercise {
    protected String question;
    protected ArrayList<String> options;

    /**
     * Parameterized Constructor for Conversation
     * @param question UNSURE, AUTHOR OF CLASS WRITE
     * @param options UNSURE, AUTHOR OF CLASS WRITE
     */
    public Conversation(String question, ArrayList<String> options) {
        this.question = question;
        this.options = options;
    }

    /**
     * Checkes user answer
     * @param userAnswer String of the users input
     * @return True if the equal to actual answer, else false
     */
    public boolean isCorrect(String userAnswer) {
        for (String option : options)  {
            if (option.equalsIgnoreCase(userAnswer.trim()))
                return true;
        }
        return false;
    }

    /**
     * To String
     * @return String of instructions
     */
    public String toString() {
        return ("Conversation: Respond to the following phrase.\n"+this.question);
    }
}