package com.narration;

import java.io.IOException;

public class main {
    public static void main(String[] args) {

    String text = "Hello my name is joanna";

    PollyDemo pollyDemo = new PollyDemo();
        try {
            pollyDemo.synthesize(text, "English", "Test");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
