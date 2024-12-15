package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    private LocalDate releaseDate;
    private double price;
    private String description;

    public Game(String title, LocalDate releaseDate, double price, String description) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.price = price;
        this.description = description;
    }
}
