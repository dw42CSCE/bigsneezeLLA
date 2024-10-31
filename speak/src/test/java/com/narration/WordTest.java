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
    public void testToString(){
        Word word = new Word("Hola", "Hello");
        assertEquals(word.toString(), "Hola : Hello");
    }
}
