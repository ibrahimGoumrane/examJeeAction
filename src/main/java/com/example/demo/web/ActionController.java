package com.example.demo.web;

import com.example.demo.dao.entities.EtatAction;
import com.example.demo.dao.entities.TypeDon;
import com.example.demo.dto.ActionDto;
import com.example.demo.dto.DonDto;
import com.example.demo.dto.OrganisateurDto;
import com.example.demo.service.ActionService;
import com.example.demo.service.DonService;
import com.example.demo.service.OrganisateurService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Controller
@AllArgsConstructor
public class ActionController {
    private final ActionService actionService;
    private final DonService donService;
    private final OrganisateurService organisateurService;
    private static final Logger logger = LoggerFactory.getLogger(ActionController.class);
    @GetMapping("/")
    public String index(){
        return "index";
    }
    @GetMapping("/organisateurs")
    public String organisateurs(Model model){
        model.addAttribute("organisateurs",organisateurService.getAllOrganisateurs());
        return "organisateurs";
    }
    @GetMapping("/actions")
    public String actions(Model model){
        List<ActionDto> actions = actionService.getAllActions();
        actions.forEach(action -> {
            action.setCurrentMontant(actionService.getCurrentMontant(action.getId()));
        });
        model.addAttribute("actions", actions);
        return "actions";
    }
    @GetMapping("addOrganisateur")
    public String addOrganisateur(Model model){
        model.addAttribute("organisateurDto",new OrganisateurDto());
        return "addorganisateur";
    }
    @GetMapping("/addDon")
    public String addDon(Model model , @RequestParam(required = false) Integer actionId){
        model.addAttribute("donDto",new DonDto());
        if(actionId != null){
            model.addAttribute("action",actionService.getActionById(actionId));
        }
        model.addAttribute("actions",actionService.getAllActions());
        model.addAttribute("type", TypeDon.values());
        return "adddon";
    }

    @GetMapping("/addaction")
    public String addAction(Model model){
        model.addAttribute("actionDto",new ActionDto());
        model.addAttribute("organisateurs",organisateurService.getAllOrganisateurs());
        model.addAttribute("etats", EtatAction.values());
        return "addaction";
    }
    @GetMapping("/editOrganisateur")
    public String editOrganisateur(@RequestParam Integer id, Model model) {
        OrganisateurDto organisateurDto = organisateurService.getOrganisateurById(id);
        model.addAttribute("organisateurDto", organisateurDto);
        return "editorganisateur"; // Points to the edit form page for Organisateur
    }
    @GetMapping("/editAction")
    public String editAction(@RequestParam Integer id, Model model) {
        ActionDto actionDto = actionService.getActionById(id);
        model.addAttribute("actionDto", actionDto);
        model.addAttribute("organisateurs", organisateurService.getAllOrganisateurs());
        model.addAttribute("etats", EtatAction.values());
        return "editaction"; // Points to the edit form page for Action
    }
    @PostMapping("/addDon")
    public String addDon(Model model, DonDto donDto , @RequestParam Integer actionId ){
        donDto.setAction(actionService.getActionById(actionId));
        donService.addDon(donDto);
        return "redirect:/actions";
    }
    @PostMapping("/addOrganisateur")
    public String addOrganisateur(Model model, OrganisateurDto organisateurDto){
        organisateurService.addOrganisateur(organisateurDto);
        return "redirect:/organisateurs";
    }
    @PostMapping("/addaction")
    public String addAction(Model model, ActionDto actionDto , @RequestParam Integer organisateurId ){
        actionDto.setOrganisateur(organisateurService.getOrganisateurById(organisateurId));
        actionDto.setCurrentMontant(0.0);
        actionService.addAction(actionDto); // Add this line to save the action
        return "redirect:/actions";
    }
    @PostMapping("/updateOrganisateur")
    public String updateOrganisateur(Model model, OrganisateurDto organisateurDto) {
        organisateurService.updateOrganisateur(organisateurDto,organisateurDto.getId()); // Call service to update
        return "redirect:/organisateurs";
    }
    @PostMapping("/updateAction")
    public String updateAction(Model model, ActionDto actionDto) {
        actionService.updateAction(actionDto,actionDto.getId()); // Call service to update
        return "redirect:/actions";
    }
    @GetMapping("/deleteOrganisateur")
    public String deleteOrganisateur(@RequestParam Integer id) {
        organisateurService.deleteOrganisateur(id); // Call service to delete by ID
        return "redirect:/organisateurs";
    }

    @GetMapping("/deleteAction")
    public String deleteAction(@RequestParam Integer id) {
        logger.info("Request to delete Action with ID: {}", id);
        boolean isDeleted =actionService.deleteAction(id); // Call service to delete by ID
        if (isDeleted) {
            logger.info("Action with ID: {} successfully deleted.", id); // Log successful deletion
        } else {
            logger.warn("Action with ID: {} could not be deleted. Possible reasons: Action not found or constraint violations.", id); // Log failure
        }
        return "redirect:/actions";
    }
}

