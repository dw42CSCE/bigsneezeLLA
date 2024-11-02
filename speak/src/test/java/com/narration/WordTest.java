package com.narration;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class WordTest {

    @Test
    public void testWord(){
        Word word = new Word("Hola", "Hello");
        assertEquals(word.getMeaning(), "Hello");
        assertEquals(word.getWord(), "Hola");
    }

    @Test
    public void testNullWord(){
        Word word1 = new Word(null, "Hello");
        Word word2 = new Word("Hola", null);
        assertEquals(word1.getMeaning(), "Hello");
        assertEquals(word1.getWord(), "Default");
        assertEquals(word2.getMeaning(), "Default");
        assertEquals(word2.getWord(), "Hola");
    }

    @Test
    public void testToString(){
        Word word = new Word("Hola", "Hello");
        assertEquals(word.toString(), "Hola : Hello");
    }
}
