package com.example.demo.service;

import com.example.demo.entity.Game;
import com.example.demo.entity.User;
import com.example.demo.enums.GameResultType;
import com.example.demo.enums.GameWinner;
import com.example.demo.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class GameService {

    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public Game saveGame(User white, User black,
                         GameWinner winner,
                         GameResultType resultType,
                         Integer difficulty,
                         String finalFen) {

        Game game = new Game();
        game.setWhitePlayer(white);
        game.setBlackPlayer(black);
        game.setWinner(winner);
        game.setResultType(resultType);
        game.setDifficulty(difficulty);
        game.setFinalFen(finalFen);
        game.setStartTime(LocalDateTime.now());
        game.setEndTime(LocalDateTime.now());

        return gameRepository.save(game);
    }
}
