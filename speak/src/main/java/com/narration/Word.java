package com.narration;

public class Word {
    private String word;
    private String meaning;

    public Word(String word, String meaning){
        this.word = word;
        this.meaning = meaning;
    }

    public String getWord(){
        return this.word;
    }

    public String getMeaning(){
        return this.meaning;
    }

    public void speak(){
        Narrator.playSound(this.word);
    }

    public String toString(){
        return (this.word+":\n"+this.meaning);
    }
}
