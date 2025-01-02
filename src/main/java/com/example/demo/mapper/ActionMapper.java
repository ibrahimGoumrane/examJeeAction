package com.example.demo.mapper;


import com.example.demo.dao.entities.Action;
import com.example.demo.dto.ActionDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ActionMapper {
    ModelMapper mapper = new ModelMapper();
    public ActionDto fromActionToActionDto(Action action){
        return mapper.map(action, ActionDto.class);
    }
    public Action fromActionDtoToAction(ActionDto actionDto){
        return mapper.map(actionDto, Action.class);
    }
}
