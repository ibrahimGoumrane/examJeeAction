package com.example.demo.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Action {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titre;
    private String description;
    private Date dateCreation;
    private Long montantObjectif;
    private EtatAction etat;
    @ManyToOne
    private Organisateur organisateur;
    @OneToMany(mappedBy = "action", cascade = CascadeType.ALL ,orphanRemoval = true)
    private List<Don> dons=new ArrayList<>();
}
