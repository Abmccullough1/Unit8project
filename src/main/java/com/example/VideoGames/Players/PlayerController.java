package com.example.VideoGames.Players;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path ="/players")
public class PlayerController {

    @Autowired
    PlayerRepository playerRepository;

    @GetMapping
    List<Player> getPlayers() {
        return playerRepository.findAll();
    }

    @PostMapping
    Player createPlayer(@RequestBody Player player) {
        return playerRepository.save(player);
    }
}
