package com.example.controller;

import com.example.model.Game;
import com.example.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GameCatalogRestController {
    private final GameService gameService;

    @Autowired
    public GameCatalogRestController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("all")
    public ResponseEntity<Iterable<Game>> getAllGames() {
        return new ResponseEntity<>(this.gameService.getAllGames(), HttpStatus.OK);
    }

    @GetMapping("game/{id}")
    public ResponseEntity<Game> getGameById(@PathVariable long id) {
        return new ResponseEntity<>(this.gameService.getGameById(id), HttpStatus.OK);
    }

    @PostMapping("add")
    public ResponseEntity<Void> addNewGame(@RequestBody Game game) {
        this.gameService.addNewGame(game);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteGameById(@PathVariable long id) {
        this.gameService.removeGame(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("update/{id}")
    public ResponseEntity<Void> updateGameById(@PathVariable long id, @RequestBody Game game) {
        this.gameService.updateGameInfo(id, game);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}