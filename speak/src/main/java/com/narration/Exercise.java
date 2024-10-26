package com.narration;

public abstract class Exercise {
    
    public abstract boolean isCorrect(String userAnswer);

    public abstract String toString();

}

/*
package com.narration;

import java.util.ArrayList;
import java.util.Random;

public class Exercise {
    protected String question;
    protected String options;
    protected String answer;
    protected String type;

    public Exercise(String question, String type, String options, String answer) {
        this.question = question;
        this.options = options;
        this.answer = answer;
        this.type = type;
    }

    public abstract boolean isCorrect(String userInput);

    public abstract String toString();
}
*/