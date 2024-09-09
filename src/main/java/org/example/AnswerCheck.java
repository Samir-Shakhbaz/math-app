package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AnswerCheck {
    @JsonProperty("isCorrect")
    private boolean isCorrect;
    private int correctAnswer;

    public AnswerCheck(boolean isCorrect, int correctAnswer) {
        this.isCorrect = isCorrect;
        this.correctAnswer = correctAnswer;
    }

    // Add these getters to allow Spring to serialize the response properly
    public boolean isCorrect() {
        return isCorrect;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }
}

