package com.narration;
import java.util.ArrayList;

public class WordList {

    private ArrayList<Word> words = new ArrayList<>();
    private WordList wordList;

    public WordList(){
        words=new ArrayList<Word>();
    }

    public Word addWord(String word, String meaning){
        Word newWord = (new Word(word, meaning));
        words.add(newWord);
        return newWord;
    }
    
    public void removeWord(Word word){
        this.words.remove(word);
    }

    public void editWord(String oldWord, String newWord, String newDefinition){
        for (Word word : words)  {
            if (word.getWord().equalsIgnoreCase(oldWord)) {
                words.remove(word);
                this.addWord(newWord, newDefinition);
            }
        }

    }

    public Word getWord(String searchWord){
        for (Word word : words)  {
            if (word.getWord().equalsIgnoreCase(searchWord))
                return word;
        }
        return this.addWord(searchWord, "[No Definition Listed]");
    }
    public ArrayList<Word> getWords() {
        return words;
    }

}
