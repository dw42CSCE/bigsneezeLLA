package com.narration;

public abstract class Exercise {
    protected String question;

    public abstract boolean isCorrect(String userAnswer);

    public abstract String toString();

}