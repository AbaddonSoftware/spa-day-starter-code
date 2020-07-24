package org.launchcode.spaday.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@Controller
public class SpaDayController {

    private static Map<String, List<String>> facialOptions = createMap();

    private static Map<String, List<String>> createMap() {
        Map<String, List<String>> facialOptions = new HashMap<>();
        facialOptions.put("oily", Arrays.asList("Microdermabrasion", "Rejuvenating"));
        facialOptions.put("combination", Arrays.asList("Microdermabrasion", "Rejuvenating", "Enzyme Peel"));
        facialOptions.put("normal", Arrays.asList("Microdermabrasion", "Hydrofacial", "Rejuvenating", "Enzyme Peel"));
        facialOptions.put("dry", Arrays.asList("Hydrofacial", "Rejuvenating"));
        return facialOptions;
    }

    public boolean checkSkinType(String skinType, String facialType) {   // This function is not needed or used but is here for posterity currently
        return facialOptions.get(skinType).contains(facialType);
    }
//        switch (skinType) {
//            case "oily":
//                return facialType.equals("Microdermabrasion") || facialType.equals("Rejuvenating");
//            case "combination":
//                return facialType.equals("Microdermabrasion") || facialType.equals("Rejuvenating") || facialType.equals("Enzyme Peel");
//            case "normal":
//                return true;
//            case "dry":
//                return facialType.equals("Rejuvenating") || facialType.equals("Hydrofacial");
//        }
//        return true;
//    }
//        if (skinType.equals("oily")) {
//            if (facialType.equals("Microdermabrasion") || facialType.equals("Rejuvenating")) {
//                return true;
//            }
//            else {
//                return false;
//            }
//        }
//        else if (skinType.equals("combination")) {
//            if (facialType.equals("Microdermabrasion") || facialType.equals("Rejuvenating") || facialType.equals("Enzyme Peel")) {
//                return true;
//            }
//            else {
//                return false;
//            }
//        }
//        else if (skinType.equals("normal")) {
//            return true;
//        }
//        else if (skinType.equals("dry")) {
//            if (facialType.equals("Rejuvenating") || facialType.equals("Hydrofacial")) {
//                return true;
//            }
//            else {
//                return false;
//            }
//        }
//        else {
//            return true;
//        }
//    }

    @GetMapping(value="")
    @ResponseBody
    public String customerForm () {
        String html = "<form method = 'post'>" +
                "Name: <br>" +
                "<input type = 'text' name = 'name'>" +
                "<br>Skin type: <br>" +
                "<select name = 'skintype'>" +
                "<option value = 'oily'>Oily</option>" +
                "<option value = 'combination'>Combination</option>" +
                "<option value = 'normal'>Normal</option>" +
                "<option value = 'dry'>Dry</option>" +
                "</select><br>" +
                "Manicure and/or Pedicure? <br>" +
                "<select name = 'manipedi'>" +
                "<option value = 'manicure'>Manicure</option>" +
                "<option value = 'pedicure'>Pedicure</option>" +
//                "<option value = 'both'>Both/ManiPedi</option>" +
                "</select><br>" +
                "<input type = 'submit' value = 'Submit'>" +
                "</form>";
        return html;
    }

    @PostMapping()
    public String spaMenu(@RequestParam String name, @RequestParam String skintype, @RequestParam String manipedi, Model model) {

//        List<String> facials = Arrays.asList("Microdermabrasion", "Hydrofacial", "Rejuvenating", "Enzyme Peel");
//        List<String> appropriateFacials = new ArrayList<String>();
//        for (int i = 0; i < facials.size(); i ++) {
//            if (checkSkinType(skintype,facials.get(i))) {
//                appropriateFacials.add(facials.get(i));
//            }
//        }
        model.addAttribute("name", name);
        model.addAttribute("skintype", skintype);
        model.addAttribute("manipedi", manipedi);
        model.addAttribute("appropriateFacials", facialOptions.get(skintype));
        return "menu";
    }
}
