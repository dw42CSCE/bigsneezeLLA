package com.narration;

public class Phrase {

    private String phrase;
    private String translation;
    //private Dictionary dictionary;

    // public Phrase(String phrase, String translation, String meaning, WordList wordList){
    //     this.wordList = wordList;
    //     this.translation = translation;
    //     this.meaning = meaning;
    //     String[] tempArray = phrase.split(" ");
    //     this.phrase = new Word[tempArray.length];
    //     for (int i=0;i<tempArray.length;i++){
    //         this.phrase[i] = dictionary.getWord(tempArray[i]);
    //     }
    // }

    public Phrase(String phrase, String translation) {
        this.phrase = phrase;
        this.translation = translation;
    }

    public String getPhrase(){
        return this.phrase;
    }

    public String Translation(){
        return this.translation;
    }

    public String toString(){
        return (this.getPhrase()+"("+this.translation+")");
    }
}
