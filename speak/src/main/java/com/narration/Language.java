package com.narration;

public enum Language {
    SPANISH("Spanish"),
    FRNECH("French"),
    JAPANESE("Japanese");

    private String label;

    private Language(String label) {
        this.label = label;
    }
}
