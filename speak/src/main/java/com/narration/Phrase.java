package com.narration;

import java.util.ArrayList;

// Phrase Class
public class Phrase {

    private String phrase;
    private String translation;
    private ArrayList<String> responses;
    private String phraseWithBlank;
    private String missingWord;
    //private WordList wordList;

    // public Phrase(String phrase, String translation, String meaning, WordList wordList){
    //     this.wordList = wordList;
    //     this.translation = translation;
    //     this.meaning = meaning;
    //     String[] tempArray = phrase.split(" ");
    //     this.phrase = new Word[tempArray.length];
    //     for (int i=0;i<tempArray.length;i++){
    //         this.phrase[i] = wordList.getWord(tempArray[i]);
    //     }
    // }

    /**
     * Parameterized Constructor
     * @param phrase String of the phrase
     * @param translation String of the english translation
     */
    public Phrase(String phrase, String translation) {
        this.phrase = phrase;
        this.translation = translation;
    }

    public Phrase(String phrase, String translation, ArrayList<String> responses, String phraseWithBlank, String missingWord) {
        this.phrase = phrase;
        this.translation = translation;
        this.responses = responses;
        this.phraseWithBlank = phraseWithBlank;
        this.missingWord = missingWord;
    }


    /**
     * Gets the string phrase
     * @return String of the phrase
     */
    public String getPhrase(){
        return this.phrase;
    }

    /**
     * Gets english translation
     * @return String english translation
     */
    public String getTranslation(){
        return this.translation;
    }

    public ArrayList<String> getResponses() {
        return responses;
    }

    public String getPhraseWithBlank(){
        return this.phraseWithBlank;
    }

    public String getMissingWord(){
        return this.missingWord;
    }

    public String toString(){
        return (this.phrase + " : " + this.translation);
    }
}
