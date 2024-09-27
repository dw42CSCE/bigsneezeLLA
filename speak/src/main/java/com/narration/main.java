package com.narration;

import java.io.IOException;

public class main {
    public static void main(String[] args) {

    String text = "Hola, como estas?";

    PollyDemo pollyDemo = new PollyDemo();
        try {
            pollyDemo.synthesize(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
