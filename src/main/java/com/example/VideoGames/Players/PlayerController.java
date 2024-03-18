package com.example.VideoGames.Players;

import com.example.VideoGames.Devs.Devopler;
import com.example.VideoGames.Games.Game;
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

    @DeleteMapping("delete/player/{playerId}")
    void deleteGame(@PathVariable Long playerId){
       Player player = playerRepository.findById(playerId).get();
        playerRepository.delete(player);
    }
    @GetMapping("player/{gameId}")
    Player getOneGame(
            @PathVariable Long gameId) {
        Player game = playerRepository.findById(gameId).get();
        return game;
    }
    @PutMapping(path= "{devId}")
    public Player updatePerson(@PathVariable Long devId, @RequestBody Player player){
      Player dev = playerRepository.findById(devId).get();
        dev.playerName = player.playerName;
        return playerRepository.save(dev);
    }
}
