package com.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class Developer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private long id;

    private String name;
    private String country;

    @OneToMany(mappedBy = "developer")
    @JsonBackReference
    private List<Game> games;

    public Developer(String name, String country) {
        this.name = name;
        this.country = country;
    }
}
