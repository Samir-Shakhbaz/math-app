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

        session.setAttribute("correctAnswer", correctAnswer);

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
                return num2 != 0 ? num1 / num2 : 0; //avoiding division by zero
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }


    @PostMapping("/check-answer")
    public AnswerCheck checkAnswer(@RequestParam int userAnswer, HttpSession session) {
        // retrieving correct answer from the session
        Integer correctAnswer = (Integer) session.getAttribute("correctAnswer");

        System.out.println("User Answer: " + userAnswer);
        System.out.println("Correct Answer: " + correctAnswer);

        if (correctAnswer == null) {
            throw new IllegalStateException("No correct answer found in session.");
        }

        boolean isCorrect = userAnswer == correctAnswer;

        System.out.println("Is Correct: " + isCorrect);

        return new AnswerCheck(isCorrect, correctAnswer);
    }


}
