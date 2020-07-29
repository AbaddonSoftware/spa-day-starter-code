package org.launchcode.spaday.controllers;

import org.launchcode.spaday.models.Client;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;





@Controller
public class SpaDayController {
    

    @GetMapping
    public String customerForm () {
        return "index";
    }

    @PostMapping("menu")
    public String spaMenu(@RequestParam String skintype, @RequestParam String manipedi, Model model) {
        Client newClient = new Client(skintype, manipedi);
        newClient.setAppropriateFacials(skintype);
        newClient.setPolishColors();
        model.addAttribute("client" , newClient);
        return "menu";
    }

    
}
