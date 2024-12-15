package com.example.service;

import com.example.model.Developer;
import com.example.model.Game;
import com.example.repository.GameRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class GameService {
    private final GameRepository gameRepository;

    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @PostConstruct
    public void init() {
        if (this.gameRepository.count() == 0) {
            this.gameRepository.save(new Game("The Witcher 3: Wild Hunt",
                    LocalDate.parse("2015-05-18"),
                    99.99,
                    "You are Geralt of Rivia, mercenary monster slayer. Before you stands a war-torn, monster-infested continent you can explore at will. Your current contract? Tracking down Ciri — the Child of Prophecy, a living weapon that can alter the shape of the world.",
                    new Developer("CD Project Red", "Poland")));
            this.gameRepository.save(new Game("Ghost of Tsushima",
                    LocalDate.parse("2024-05-16"),
                    259.00,
                    "A storm is coming. Venture into the complete Ghost of Tsushima DIRECTOR’S CUT on PC; forge your own path through this open-world action adventure and uncover its hidden wonders.",
                    new Developer("Sucker Punch Productions", "USA")));
            this.gameRepository.save(new Game("God of War Ragnarok",
                    LocalDate.parse("2024-10-19"),
                    259.00,
                    "Kratos and Atreus embark on a mythic journey for answers before Ragnarök arrives – now on PC.",
                    new Developer("Santa Monika Studio", "USA")));
        }
    }

    public void addNewGame(Game game) {
        this.gameRepository.save(game);
    }

    public void removeGame(Long id) {
        this.gameRepository.deleteById(id);
    }

    public void updateGameInfo(Long id, Game game) {
        Game updatedGame = this.gameRepository.findById(id).orElseThrow(NullPointerException::new);

        updatedGame.setTitle(game.getTitle());
        updatedGame.setReleaseDate(game.getReleaseDate());
        updatedGame.setPrice(game.getPrice());
        updatedGame.setDescription(game.getDescription());

        this.gameRepository.save(updatedGame);
    }

    public Iterable<Game> getAllGames() {
        List<Game> games = (List<Game>) this.gameRepository.findAll();
        return games;
    }

    public Game getGameById(Long id) {
        Optional<Game> optionalGame = this.gameRepository.findById(id);
        if (optionalGame.isPresent()) {
            Game game = optionalGame.get();
            return game;
        }
            else {
                return null;
        }
    }
}
