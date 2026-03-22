package com.example.demo.service;

import com.example.demo.entity.PlayerStats;
import com.example.demo.entity.User;
import com.example.demo.repository.PlayerStatsRepository;
import org.springframework.stereotype.Service;

@Service
public class PlayerStatsService {

    private final PlayerStatsRepository statsRepository;

    public PlayerStatsService(PlayerStatsRepository statsRepository) {
        this.statsRepository = statsRepository;
    }

    public PlayerStats initializeStats(User user) {
        PlayerStats stats = new PlayerStats();
        stats.setUser(user);
        stats.setTotalGames(0);
        stats.setWins(0);
        stats.setLosses(0);
        stats.setDraws(0);
        stats.setWinPercentage(0.0);

        return statsRepository.save(stats);
    }
}
