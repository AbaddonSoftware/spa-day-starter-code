package org.launchcode.spaday.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@Controller
public class SpaDayController {
    private static final List<String> polishColors = Arrays.asList("Red", "Purple", "Pink", "Blue", "Turquoise");
    private static final Map<String, List<String>> facialOptions = createMap();

    private static Map<String, List<String>> createMap() {
        Map<String, List<String>> facialOptions = new HashMap<>();
        facialOptions.put("oily", Arrays.asList("Microdermabrasion", "Rejuvenating"));
        facialOptions.put("combination", Arrays.asList("Microdermabrasion", "Rejuvenating", "Enzyme Peel"));
        facialOptions.put("normal", Arrays.asList("Microdermabrasion", "Hydrofacial", "Rejuvenating", "Enzyme Peel"));
        facialOptions.put("dry", Arrays.asList("Hydrofacial", "Rejuvenating"));
        return facialOptions;
    }

    private boolean checkSkinType(String skinType, String facialType) {   // This function is not needed or used but is here for posterity currently
        return facialOptions.get(skinType).contains(facialType);
    }
    
    @GetMapping
    public String customerForm () {
        return "spa-day";
    }

    @PostMapping("menu")
    public String spaMenu(@RequestParam String name, @RequestParam String skintype, @RequestParam String manipedi, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("skintype", skintype);
        model.addAttribute("manipedi", manipedi);
        model.addAttribute("polishes", polishColors);
        model.addAttribute("appropriateFacials", facialOptions.get(skintype));
        return "menu";
    }
}
