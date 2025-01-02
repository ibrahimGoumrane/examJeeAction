package com.example.demo.service;

import com.example.demo.dao.repositories.OrganisateurRepository;
import com.example.demo.dto.OrganisateurDto;
import com.example.demo.mapper.OrganisateurMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganisateurManager implements OrganisateurService {
    @Autowired
    private OrganisateurMapper organisateurMapper;
    @Autowired
    private OrganisateurRepository organisateurRepository;
    public OrganisateurDto addOrganisateur(OrganisateurDto organisateurDto) {
        return organisateurMapper.fromOrganisateurToOrganisateurDto(organisateurRepository.save(organisateurMapper.fromOrganisateurDtoToOrganisateur(organisateurDto)));
    }

    public OrganisateurDto getOrganisateurById(Integer id) {
        return organisateurMapper.fromOrganisateurToOrganisateurDto(organisateurRepository.findById(id).get());
    }

    @Override
    public List<OrganisateurDto> getAllOrganisateurs() {
        return organisateurRepository.findAll().stream().map(organisateurMapper::fromOrganisateurToOrganisateurDto).toList();
    }

    @Override
    public boolean deleteOrganisateur(Integer id) {
        try{
            organisateurRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public OrganisateurDto updateOrganisateur(OrganisateurDto organisateurDto, Integer id) {
        if(organisateurRepository.findById(id).isPresent()){
            organisateurDto.setId(id);
            return organisateurMapper.fromOrganisateurToOrganisateurDto(organisateurRepository.save(organisateurMapper.fromOrganisateurDtoToOrganisateur(organisateurDto)));
        }
        return  null;
    }


}
