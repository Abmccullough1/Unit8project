package com.example.VideoGames.Games;

import com.example.VideoGames.Devs.Devopler;
import com.example.VideoGames.Players.Player;
import jakarta.persistence.*;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table

public class Game {
    @Id
    @SequenceGenerator(
            name = "game_sequence",
            sequenceName = "game_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "game_sequence"
    )
    private Long id;

    private String gameTitle;

    public Long getId() {
        return id;
    }

    public String getGameTitle() {
        return gameTitle;
    }

    public Devopler getDevopler() {
        return devopler;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="devopler_id", referencedColumnName = "id")
    private Devopler devopler;


    @ManyToMany
    @JoinTable(
            name = "playersPlaying",
            joinColumns = @JoinColumn(name=" game_id"),
            inverseJoinColumns =  @JoinColumn(name="player_id")
    )
    private Set<Player> playersPlaying = new HashSet<>();
    public Set<Player> getPlayersPlaying() {
        return playersPlaying;
    }


    public void enrolldevopler(Devopler devopler) {
        this.devopler = devopler;
    }

    public void assignplayers(Player player) {
        playersPlaying.add(player);
    }


}
