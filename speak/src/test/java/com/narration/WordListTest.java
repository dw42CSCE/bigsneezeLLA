package com.narration;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;


public class WordListTest {

    private WordList words;
    private Word word;
    private Word testWord;

    @BeforeEach
    public void setUp(){
        words = new WordList();
        word = new Word("Test", "Test");
    }
    

    //AddWord Tests
    @Test
    public void testAddWord(){
        this.words.addWord(word);
        testWord = words.getWord("Test");
        assertEquals(word, testWord);
    }

    @Test
    public void testAddDuplicateWord(){
        this.words.addWord(word);
        this.words.addWord("Test", "Test");
        int j=0;
        for(int i=0; i<words.getWords().size();i++){
            if(word==words.getWord("Test")){
                j++;
            }
        }
        assertEquals(1,j);
    }

    @Test
    public void testNullWord(){
        Word test = words.addWord(null, "Test");
        assertNotNull(test.getWord());
    }

    @Test
    public void testNullMeaning(){
        Word test = words.addWord("Test", null);
        assertNotNull(test.getMeaning());
    }

    @Test
    public void testSameWordDiffMeaning(){
        words.addWord(new Word("Test", "First Meaning"));
        words.addWord(new Word("Test", "Different Meaning"));
        assertEquals(words.getWords().get(0).getMeaning(), words.getWords().get(1).getMeaning());
    }

    
    //Remove Word Tests
    @Test
    public void testRemoveWord(){
        words.addWord(word);
        words.removeWord(word);
        testWord=words.getWord("Test");
        assertNotEquals(word, testWord);
    }

 
 
    


    







}
