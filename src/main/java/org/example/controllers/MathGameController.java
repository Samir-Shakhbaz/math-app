package org.example.controllers;

import org.example.AnswerCheck;
import org.example.Question;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;
import java.util.Random;

@RestController
@RequestMapping("/math-game")
public class MathGameController {

    private Random random = new Random();

    @GetMapping("/generate-question")
    public Question generateQuestion(@RequestParam String operation, HttpSession session) {
        int num1 = new Random().nextInt(10) + 1;
        int num2 = new Random().nextInt(10) + 1;
        int correctAnswer = calculateAnswer(num1, num2, operation);

        // Save the correct answer in the session
        session.setAttribute("correctAnswer", correctAnswer);

        // Return the generated question
        return new Question(num1, num2, operation);
    }

    private int calculateAnswer(int num1, int num2, String operator) {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                return num2 != 0 ? num1 / num2 : 0;  // Avoid division by zero
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);  // Handle invalid operators
        }
    }


    @PostMapping("/check-answer")
    public AnswerCheck checkAnswer(@RequestParam int userAnswer, HttpSession session) {
        // Retrieve correct answer from the session
        Integer correctAnswer = (Integer) session.getAttribute("correctAnswer");

        // Log the userAnswer and correctAnswer for debugging
        System.out.println("User Answer: " + userAnswer);
        System.out.println("Correct Answer: " + correctAnswer);

        // If the correct answer is not found, throw an error
        if (correctAnswer == null) {
            throw new IllegalStateException("No correct answer found in session.");
        }

        // Compare the user's answer with the correct answer
        boolean isCorrect = userAnswer == correctAnswer;  // Use equals for object comparison

        // Log if the comparison was correct or not
        System.out.println("Is Correct: " + isCorrect);

        // Return the result (JSON)
        return new AnswerCheck(isCorrect, correctAnswer);
    }


}
