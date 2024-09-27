package com.narration;

import java.io.IOException;

public class main {
    public static void main(String[] args) {

    String text = "Hello! My name is Joanna!";

    PollyDemo pollyDemo = new PollyDemo();
        try {
            pollyDemo.synthesize(text, "french", "Test2");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
