package org.example;

import java.util.Random;

//public class Division implements Operation {
//    private Random random = new Random();
//
//    @Override
//    public int[] generateQuestion() {
//        int num1 = random.nextInt(10) + 1;
//        int num2 = random.nextInt(1) + 1;  // avoiding division by zero
//        int correctAnswer = num1 / num2;
//        return new int[]{num1, num2, correctAnswer};
//    }
//}

//public class Division implements Operation {
//    private Random random = new Random();
//
//    @Override
//    public Question generateQuestion() {
//        System.out.println("generateQuestion() method in Division called!");
//
//        int num1 = random.nextInt(10) + 1;
//        int num2 = random.nextInt(10) + 1;
//
//        int dividend = num1 * num2;
//        int correctAnswer = num1;
//
//        System.out.println("Generated division: " + dividend + " ÷ " + num2 + " = " + correctAnswer);
//
//        return new Question(dividend, num2, "/", correctAnswer);
//    }
//}