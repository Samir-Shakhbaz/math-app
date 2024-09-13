package org.example;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "game-results")
public class GameResult {
    @Id
    private String id;
    private String playerName;
    private int correctAnswers;
    private String grade;
    private String mode;  // "test" or "regular"
    private String date;

    public GameResult(String playerName, int correctAnswers, String grade, String mode, String date) {
        this.playerName = playerName;
        this.correctAnswers = correctAnswers;
        this.grade = grade;
        this.mode = mode;
        this.date = date;
    }

}
