package org.example;

import java.util.Random;

public class QuestionGenerator {
    private Random random = new Random();

    public int[] generateQuestion(String operator) {
        int num1 = random.nextInt(10) + 1;
        int num2 = random.nextInt(10) + 1;
        int correctAnswer = calculateAnswer(num1, num2, operator);

        return new int[] { num1, num2, correctAnswer };
    }

    private int calculateAnswer(int num1, int num2, String operator) {
        switch (operator) {
            case "+": return num1 + num2;
            case "-": return num1 - num2;
            case "*": return num1 * num2;
            case "/": return num1 / num2;
            default: return 0;
        }
    }
}

