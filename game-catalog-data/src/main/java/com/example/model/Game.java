package com.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "developer_id")
    @JsonManagedReference
    private Developer developer;

    public Game(String title, LocalDate releaseDate, double price, String description, Developer developer) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.price = price;
        this.description = description;
        this.developer = developer;
    }
}
