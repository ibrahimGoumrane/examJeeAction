package com.example.demo.service;

import com.example.demo.dto.OrganisateurDto;

import java.util.List;

public interface OrganisateurService {
    public OrganisateurDto addOrganisateur(OrganisateurDto organisateurDto);
    public OrganisateurDto getOrganisateurById(Integer id);
    public List<OrganisateurDto> getAllOrganisateurs();
    public boolean deleteOrganisateur(Integer id);
    public OrganisateurDto updateOrganisateur(OrganisateurDto organisateurDto , Integer id);

}
