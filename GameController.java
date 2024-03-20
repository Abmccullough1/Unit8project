package com.example.VideoGames.Games;

import com.example.VideoGames.Devs.DeveloperRepository;
import com.example.VideoGames.Devs.Devopler;
import com.example.VideoGames.Players.Player;
import com.example.VideoGames.Players.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path ="/games")
public class GameController {



    @Autowired
    GameRepository gameRepository;

    @Autowired
    DeveloperRepository devoplerRepository;

    @Autowired
    PlayerRepository playersRepository;

    @GetMapping
    List<Game> getGames() {
        return gameRepository.findAll();
    }

    @PostMapping
    Game createGame(@RequestBody Game game) {
        return gameRepository.save(game);
    }
    @PutMapping("/{gameId}/devs/{devoplerId}")
    Game setDevoplerToGame(
            @PathVariable Long gameId,

            @PathVariable Long devoplerId) {
        Game game = gameRepository.findById(gameId).get();
        Devopler devopler = devoplerRepository.findById(devoplerId).get();
        game.enrolldevopler(devopler);
        return gameRepository.save(game);

    }
    @PutMapping("/{gameId}/players/{playersId}")
    Game setPlayersToGame(
            @PathVariable Long gameId,

            @PathVariable Long playersId){
        Game game = gameRepository.findById(gameId).get();
        Player player = playersRepository.findById(playersId).get();
        game.assignplayers(player);
        return  gameRepository.save(game);
    }

    @GetMapping("games/{gameId}")
    Game getOneGame(
            @PathVariable Long gameId) {
        Game game = gameRepository.findById(gameId).get();
        return game;
    }

    @DeleteMapping("delete/game/{gameId}")
    void deleteGame(@PathVariable Long gameId){
        Game game = gameRepository.findById(gameId).get();
        gameRepository.delete(game);
    }

}
