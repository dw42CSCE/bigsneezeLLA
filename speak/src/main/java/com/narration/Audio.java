package com.narration;
import java.util.ArrayList;
import java.util.Random;

// Audio Exercise Class
public class Audio extends Exercise {
    protected ArrayList<String> options;
    protected String answer;

    /**
     * Constructor for Audio
     * @param options Arraylist of strings to generate question from
     */
    public Audio(ArrayList<String> options) {
        this.options = options;
        Random random = new Random();
        int r = random.nextInt(options.size());
        this.answer = options.get(r);
    }

    /**
     * Checks user answer
     * @param userAnswer string of the users attempt
     * @return True if the user answer is the actual answer, else false
     */
    public boolean isCorrect(String userAnswer) {
            if (answer.equals(userAnswer))
                return true;
        return false;
    }

    /**
     * To String
     * @return String of instructions
     */
    public String toString() {
        Narrator.playSound(answer);
        return ("Listen to the audio and select the word\n"+this.question);
    }
}
