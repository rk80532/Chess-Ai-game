package com.example.demo.repository;

import com.example.demo.entity.Move;
import com.example.demo.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MoveRepository extends JpaRepository<Move, Long> {

    List<Move> findByGameOrderByMoveNumberAsc(Game game);
}
