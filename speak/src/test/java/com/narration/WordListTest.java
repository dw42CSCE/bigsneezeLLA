package com.narration;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WordListTest {

    private WordList words;
    private Word word;
    private Word testWord;
    @BeforeEach
    public void setUp(){
        words = new WordList();
        word = new Word("Test", "Test");
    }
    
    @Test
    public void testAddWord(){
        this.words.addWord(word);
        testWord = words.getWord("Test");
        assertEquals(word, testWord);
    }

    @Test
    public void testDuplicateWord(){
        this.words.addWord(word);
        this.words.addWord("Test", "Test");
        boolean duplicate=false;
        for(int i=0, j=0; i<words.getWords().size();i++){
            if(word.getWord().equals("Test"))
                j++;
                if(j==2)
                    duplicate=true;
                    break;
        }
        assertTrue(duplicate);
    }
    

    @Test
    public void testRemoveWord(){
        words.addWord(word);
        words.removeWord(word);
        testWord=words.getWord("Test");
        assertNotEquals(word, testWord);
    }

    @Test
 
    


    







}
