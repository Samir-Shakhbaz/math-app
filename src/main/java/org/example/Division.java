package org.example;

import java.util.Random;

public class Division implements Operation {
    private Random random = new Random();

    @Override
    public int[] generateQuestion() {
        int num1 = random.nextInt(10) + 1;
        int num2 = random.nextInt(1) + 1;  // Avoid division by zero
        int correctAnswer = num1 / num2;
        return new int[]{num1, num2, correctAnswer};
    }
}

