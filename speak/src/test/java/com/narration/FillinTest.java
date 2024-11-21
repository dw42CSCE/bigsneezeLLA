package com.narration;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class FillinTest {
    
    FillIn fillIn;

    @BeforeEach
    public void setUp(){

        fillIn = new FillIn(new Phrase("Test", "Test1", new ArrayList<String>(), "___", "Test2"));

    }

    @Test
    public void testIsCorrect() {

        assertTrue(fillIn.isCorrect("Test2"));
        assertFalse(fillIn.isCorrect("Test"));
        assertFalse(fillIn.isCorrect("Test1"));
        assertFalse(fillIn.isCorrect(""));

    }

    @Test
    public void testGetWord() {

        assertEquals("test", fillIn.getWord().getWord());
        assertEquals("test1", fillIn.getWord().getMeaning());

    }

}
