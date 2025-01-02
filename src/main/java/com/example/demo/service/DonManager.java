package com.example.demo.service;

import com.example.demo.dao.repositories.DonRepository;
import com.example.demo.dto.DonDto;
import com.example.demo.mapper.DonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonManager implements DonService {
    @Autowired
    private DonMapper donMapper;
    @Autowired
    private DonRepository donRepository;
    public DonDto addDon(DonDto donDto) {
        return donMapper.fromDonToDonDto(donRepository.save(donMapper.fromDonDtoToDon(donDto)));
    }

    public DonDto getDonById(Integer id) {
        return donMapper.fromDonToDonDto(donRepository.findById(id).get());
    }

    @Override
    public List<DonDto> getAllDons() {
        return donRepository.findAll().stream().map(donMapper::fromDonToDonDto).toList();
    }
}
