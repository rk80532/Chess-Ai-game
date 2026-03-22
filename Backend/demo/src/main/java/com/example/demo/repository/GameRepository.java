package com.example.demo.repository;

import com.example.demo.entity.Game;
import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {

    List<Game> findByWhitePlayerOrBlackPlayer(User white, User black);

    List<Game> findByWinner(String winner);
}

