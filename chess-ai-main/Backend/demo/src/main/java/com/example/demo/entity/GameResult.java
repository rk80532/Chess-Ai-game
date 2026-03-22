package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class GameResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String opponent;
    private String winner;
    private String result; // win, loss, draw

    private LocalDateTime playedAt = LocalDateTime.now();
}
