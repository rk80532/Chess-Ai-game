package com.example.demo.controller;

import com.example.demo.entity.Game;
import com.example.demo.entity.Move;
import com.example.demo.repository.GameRepository;
import com.example.demo.service.MoveService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/move")
@CrossOrigin(origins = "*")
public class MoveController {

    private final MoveService moveService;
    private final GameRepository gameRepository;

    public MoveController(MoveService moveService, GameRepository gameRepository) {
        this.moveService = moveService;
        this.gameRepository = gameRepository;
    }

    // ✅ 1. SAVE A MOVE
    @PostMapping("/save")
    public String saveMove(
            @RequestParam Long gameId,
            @RequestParam int moveNumber,
            @RequestParam String san,
            @RequestParam String fen
    ) {
        Game game = gameRepository.findById(gameId)
                .orElseThrow(() -> new RuntimeException("Game not found"));

        moveService.saveMove(game, moveNumber, san, fen);
        return "Move saved successfully";
    }

    // ✅ 2. GET MOVES FOR REPLAY
    @GetMapping("/game/{gameId}")
    public List<Move> getMoves(@PathVariable Long gameId) {
        Game game = gameRepository.findById(gameId)
                .orElseThrow(() -> new RuntimeException("Game not found"));

        return moveService.getMovesForGame(game);
    }
}
