package com.example.demo.mapper;


import com.example.demo.dao.entities.Don;
import com.example.demo.dto.DonDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DonMapper {
    ModelMapper mapper = new ModelMapper();
    public DonDto fromDonToDonDto(Don don){
        return mapper.map(don, DonDto.class);
    }
    public Don fromDonDtoToDon(DonDto donDto){
        return mapper.map(donDto, Don.class);
    }
}
