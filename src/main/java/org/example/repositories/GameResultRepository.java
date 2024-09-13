package org.example.repositories;

import org.example.GameResult;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface GameResultRepository extends MongoRepository<GameResult, String> {
    List<GameResult> findAllByOrderByCorrectAnswersDesc();
}

