package com.narration;

public class Phrase {

    private Word[] phrase;
    private String translation;
    private String meaning;
    private WordList wordList;

    public Phrase(String phrase, String translation, String meaning, WordList wordList){
        this.wordList = wordList;
        this.translation = translation;
        this.meaning = meaning;
        String[] tempArray = phrase.split(" ");
        this.phrase = new Word[tempArray.length];
        for (int i=0;i<tempArray.length;i++){
            this.phrase[i] = wordList.getWord(tempArray[i]);
        }
    }

    public String getPhrase(){
        String outPhrase = "";
        for (Word currentWord : this.phrase){
            outPhrase += (currentWord+" ");
        }
        return outPhrase.stripTrailing();
    }

    public String Translation(){
        return this.translation;
    }

    public String getMeaning(){
        return this.meaning;
    }

    public String toString(){
        return (this.getPhrase()+"("+this.translation+")"+":\n"+this.meaning);
    }
}
