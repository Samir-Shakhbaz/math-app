package org.example.controllers;

import org.example.AnswerCheck;
import org.example.GameResult;
import org.example.Question;
import org.example.repositories.GameResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/math-game")
public class MathGameController {

    @Autowired
    private GameResultRepository gameResultRepository;

    private Random random = new Random();

    @GetMapping("/generate-question")
    public Question generateQuestion(@RequestParam String operation, HttpSession session) {
        int num1 = new Random().nextInt(10) + 1;
        int num2 = new Random().nextInt(10) + 1;
        int correctAnswer = calculateAnswer(num1, num2, operation);

        session.setAttribute("correctAnswer", correctAnswer);

        return new Question(num1, num2, operation, correctAnswer);
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

    // calculate grade and save result to MongoDB
    @PostMapping("/complete-test")
    public void completeTest(@RequestParam(required = false) String playerName, @RequestParam int correctAnswers) {
        String grade = calculateGrade(correctAnswers);

        if (playerName == null || playerName.trim().isEmpty()) {
            playerName = "Anonymous";
        }

        // save the result to MongoDB
        GameResult gameResult = new GameResult(
                playerName,
                correctAnswers,
                grade,
                "test",
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
        );
        // log to check if repository is saving correctly
        System.out.println("Saving to MongoDB: " + gameResult);
        gameResultRepository.save(gameResult);
    }


    private String calculateGrade(int correctAnswers) {
        int score = (correctAnswers * 100) / 10;
        if (score >= 90) {
            return "A";
        } else if (score >= 80) {
            return "B";
        } else if (score >= 70) {
            return "C";
        } else if (score >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    @GetMapping("/players")
    public List<GameResult> getAllPlayersOrderedByScore() {
        return gameResultRepository.findAllByOrderByCorrectAnswersDesc();
    }

}
