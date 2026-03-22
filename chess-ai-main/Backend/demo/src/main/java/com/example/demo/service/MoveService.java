package com.example.demo.service;

import com.example.demo.entity.Game;
import com.example.demo.entity.Move;
import com.example.demo.repository.MoveRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoveService {

    private final MoveRepository moveRepository;

    public MoveService(MoveRepository moveRepository) {
        this.moveRepository = moveRepository;
    }

    public void saveMove(Game game, int moveNumber, String san, String fen) {

        Move move = new Move();
        move.setGame(game);
        move.setMoveNumber(moveNumber);
        move.setSan(san);
        move.setFenAfter(fen);

        moveRepository.save(move);
    }

    public List<Move> getMovesForGame(Game game) {
        return moveRepository.findByGameOrderByMoveNumberAsc(game);
    }
}
