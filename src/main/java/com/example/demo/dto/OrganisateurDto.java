package com.example.demo.dto;


import com.example.demo.dao.entities.Action;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrganisateurDto {
    private Integer id;
    private String nom;
    private String email;
    private List<ActionDto> actions=new ArrayList<>();
}
