package com.example.demo.dto;

import com.example.demo.dao.entities.Don;
import com.example.demo.dao.entities.EtatAction;
import com.example.demo.dao.entities.Organisateur;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ActionDto {
    private Integer id;
    private String titre;
    private String description;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateCreation;
    private Long montantObjectif;
    private Double currentMontant;
    private EtatAction etat;
    private OrganisateurDto organisateur;
    private List<DonDto> dons=new ArrayList<>();
}
