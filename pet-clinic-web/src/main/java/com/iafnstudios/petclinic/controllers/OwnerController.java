package com.iafnstudios.petclinic.controllers;

import com.iafnstudios.petclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/owners")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"","/","/index","/index.html"})
    public String getOwnerIndex(Model model){

        model.addAttribute("owners",ownerService.findAll());

        return "owners/index.html";
    }

    @RequestMapping("find")
    public String getFindOwners(){

        return "notimplemented";
    }
}
