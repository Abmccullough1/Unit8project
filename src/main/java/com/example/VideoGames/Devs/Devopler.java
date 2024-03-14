package com.example.VideoGames.Devs;

import com.example.VideoGames.Games.Game;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
@Entity
@Table
public class Devopler {
    @Id
    @SequenceGenerator(
            name = "dev_sequence",
            sequenceName = "dev_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "dev_sequence"
    )
    private Long id;
    private String devName;

    public Long getId() {
        return id;
    }

    public String getDevName() {
        return devName;
    }

    public Set<Game> getGame() {
        return game;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "devopler")
    private Set<Game> game = new HashSet<>();


}
