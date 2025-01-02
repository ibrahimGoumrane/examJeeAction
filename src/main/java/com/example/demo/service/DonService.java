package com.example.demo.service;


import com.example.demo.dto.DonDto;

import java.util.List;

public interface DonService {
    public DonDto addDon(DonDto donDto);
    public DonDto getDonById(Integer id);
    public List<DonDto> getAllDons();
}
