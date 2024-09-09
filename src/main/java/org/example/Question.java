package org.example;

public class Question {
    private int num1;
    private int num2;
    private String operation;

    public Question(int num1, int num2, String operation) {
        this.num1 = num1;
        this.num2 = num2;
        this.operation = operation;
    }

    public int getNum1() { return num1; }
    public int getNum2() { return num2; }
    public String getOperation() { return operation; }
}
