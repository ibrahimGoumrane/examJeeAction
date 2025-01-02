package com.example.demo.mapper;


import com.example.demo.dao.entities.Organisateur;
import com.example.demo.dto.OrganisateurDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class OrganisateurMapper {
    ModelMapper mapper = new ModelMapper();
    public OrganisateurDto fromOrganisateurToOrganisateurDto(Organisateur organisateur){
        return mapper.map(organisateur, OrganisateurDto.class);
    }
    public Organisateur fromOrganisateurDtoToOrganisateur(OrganisateurDto organisateurDto){
        return mapper.map(organisateurDto, Organisateur.class);
    }
}
