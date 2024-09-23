package org.example;

public class Question {
    private int num1;
    private int num2;
    private String operation;

    private int correctAnswer;
    private int dividend;

    public Question(int num1, int num2, String operation, int correctAnswer, int dividend) {
        this.num1 = num1;
        this.num2 = num2;
        this.operation = operation;
        this.correctAnswer = correctAnswer;
        this.dividend = dividend;
    }

    public int getNum1() { return num1; }
    public int getNum2() { return num2; }
    public String getOperation() { return operation; }

    public int getCorrectAnswer() { return correctAnswer; }
    public int getDividend() { return dividend; }
}
