package com.example.VideoGames.Players;

import com.example.VideoGames.Games.Game;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Player {
    @Id
    @SequenceGenerator(
            name = "player_sequence",
            sequenceName = "player_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "player_sequence"
    )

    private Long id;

    public Long getId() {
        return id;
    }

    public String getPlayerName() {
        return playerName;
    }

    private String playerName;
    @JsonIgnore
    @ManyToMany(mappedBy = "playersPlaying")
    private Set<Game> getSubjects = new HashSet<>();






}
