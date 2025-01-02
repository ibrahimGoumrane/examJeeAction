package com.example.demo.service;

import com.example.demo.dao.repositories.ActionRepository;
import com.example.demo.dao.repositories.DonRepository;
import com.example.demo.dto.ActionDto;
import com.example.demo.dto.DonDto;
import com.example.demo.mapper.ActionMapper;
import com.example.demo.mapper.DonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class ActionManager implements ActionService {
    @Autowired
    private ActionRepository actionRepository;
    @Autowired
    private DonRepository donRepository;
    @Autowired
    private ActionMapper actionMapper;
    @Autowired
    private DonMapper donMapper;
    public ActionDto addAction(ActionDto actionDto) {
        return actionMapper.fromActionToActionDto(actionRepository.save(actionMapper.fromActionDtoToAction(actionDto)));
    }

    public List<DonDto> getDonsByActionId(Integer id) {
        ActionDto actionDto = actionMapper.fromActionToActionDto(actionRepository.findById(id).get());
        return actionDto.getDons();
    }

    @Override
    public List<ActionDto> getAllActions() {
        return actionRepository.findAll().stream().map(actionMapper::fromActionToActionDto).toList();
    }

    @Override
    public ActionDto getActionById(Integer id) {
        return actionMapper.fromActionToActionDto(actionRepository.findById(id).get());
    }

    @Override
    public Double getCurrentMontant(Integer id) {
        ActionDto actionDto = actionMapper.fromActionToActionDto(actionRepository.findById(id).get());
        return actionDto.getDons().stream().mapToDouble(DonDto::getMontant).sum();
    }

    @Override
    public boolean deleteAction(Integer id) {
        try{
            actionRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public ActionDto updateAction(ActionDto actionDto, Integer id) {
        if(actionRepository.findById(id).isPresent()){
            actionDto.setId(id);
            return actionMapper.fromActionToActionDto(actionRepository.save(actionMapper.fromActionDtoToAction(actionDto)));
            
        }
        return null;
    }
}
