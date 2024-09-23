//package org.example;
//
//import java.util.Random;
//
//public class Multiplication implements Operation {
//    private Random random = new Random();
//
//    @Override
//    public Question generateQuestion() {
//        System.out.println("generateQuestion() method in Division called!");
//        int num1 = random.nextInt(10) + 1;
//        int num2 = random.nextInt(10) + 1;
//        int correctAnswer = num1 * num2;
//        return new Question(num1, num2, "*", correctAnswer);
//    }
//}
