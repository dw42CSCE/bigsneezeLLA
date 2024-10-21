package com.narration;

import java.util.ArrayList;

public abstract class Exercise {
    protected String question;
    protected ArrayList<String> options;
    protected String answer;

    public abstract boolean isCorrect(String userAnswer);

    public abstract String toString();
}