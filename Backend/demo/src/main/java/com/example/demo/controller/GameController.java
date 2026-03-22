package com.example.demo.controller;

import com.example.demo.entity.Game;
import com.example.demo.entity.User;
// import com.example.demo.enums.GameResultType;
// import com.example.demo.enums.GameWinner;
import com.example.demo.repository.GameRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/game")
@CrossOrigin("*")
public class GameController {

    private final GameRepository gameRepository;
    private final UserRepository userRepository;

    public GameController(GameRepository gameRepository, UserRepository userRepository) {
        this.gameRepository = gameRepository;
        this.userRepository = userRepository;
    }

    // ✅ Save game result
    @PostMapping("/save")
    public Game saveGame(@RequestBody Game game) {
        return gameRepository.save(game);
    }

    // ✅ Get game history of a user
    @GetMapping("/history/{username}")
    public List<Game> getGameHistory(@PathVariable String username) {

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return gameRepository.findByWhitePlayerOrBlackPlayer(user, user);
    }
}
