package com.example.VideoGames.Devs;

import com.example.VideoGames.Games.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;
@RestController
@RequestMapping(path ="/devs")
public class DeveloperController {

    @Autowired
    DeveloperRepository devRepository;

    @GetMapping
    List<Devopler> getDevs() {
        return devRepository.findAll();
    }
    @PostMapping
    Devopler createStudent(@RequestBody Devopler dev) {
        return devRepository.save(dev);
    }

    @DeleteMapping("delete/dev/{devId}")
    void deleteDev(@PathVariable Long devId){
        Devopler dev = devRepository.findById(devId).get();
        devRepository.delete(dev);
    }
//    Matthews code goes here


    }




