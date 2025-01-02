package com.example.demo.service;


import com.example.demo.dto.ActionDto;
import com.example.demo.dto.DonDto;

import java.util.List;

public interface ActionService {
    public ActionDto addAction(ActionDto actionDto);
    public List<DonDto> getDonsByActionId(Integer id);
    public List<ActionDto> getAllActions();
    public ActionDto getActionById(Integer id);
    public Double getCurrentMontant(Integer id);
    public boolean deleteAction(Integer id);
    public ActionDto updateAction(ActionDto actionDto , Integer id);
}
