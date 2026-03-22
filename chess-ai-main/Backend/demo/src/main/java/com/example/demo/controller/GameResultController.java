// package com.example.demo.controller;

// import com.example.demo.entity.GameResult;
// import com.example.demo.repository.GameResultRepository;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/api/game")
// public class GameResultController {

//     private final GameResultRepository repo;

//     public GameResultController(GameResultRepository repo) {
//         this.repo = repo;
//     }

//     @PostMapping("/save")
//     public GameResult saveResult(@RequestBody GameResult result) {
//         return repo.save(result);
//     }

//     @GetMapping("/history/{username}")
//     public List<GameResult> getHistory(@PathVariable String username) {
//         return repo.findByUsername(username);
//     }
// }
