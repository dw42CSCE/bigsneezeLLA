package com.narration;

import java.util.ArrayList;
import java.util.UUID;

public class Word {
    private String word;
    private String meaning;
    private ArrayList<Word> similarWords;
    private UUID uuid;

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
        return (this.word+" : "+this.meaning);
    }

    public UUID setUUID(){
        return this.uuid;
    }

    public ArrayList<Word> getSimilarWords(){
        
        return similarWords;
    }
        
}
