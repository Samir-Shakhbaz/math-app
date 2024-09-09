package org.example;

public class OperationFactory {

    // Factory method to get the correct operation class based on the operator
    public static Operation getOperation(String operator) {
        switch (operator) {
            case "+":
                return new Addition();
            case "-":
                return new Subtraction();
            case "*":
                return new Multiplication();
            case "/":
                return new Division();
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }
}
