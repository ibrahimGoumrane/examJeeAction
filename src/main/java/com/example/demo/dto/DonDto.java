package com.example.demo.dto;

import com.example.demo.dao.entities.Action;
import com.example.demo.dao.entities.TypeDon;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DonDto {
    private Integer id;
    private String titre;
    private Long montant;
    private TypeDon type;
    private ActionDto action;
}
